package com.hau.huylong.graduation_proejct.service.impl;

import com.hau.huylong.graduation_proejct.common.exception.APIException;
import com.hau.huylong.graduation_proejct.common.util.PageableUtils;
import com.hau.huylong.graduation_proejct.entity.hau.Company;
import com.hau.huylong.graduation_proejct.entity.hau.UserRecruitmentPost;
import com.hau.huylong.graduation_proejct.model.dto.hau.CompanyDTO;
import com.hau.huylong.graduation_proejct.model.request.SearchCompanyRequest;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;
import com.hau.huylong.graduation_proejct.repository.hau.CompanyReps;
import com.hau.huylong.graduation_proejct.repository.hau.UserRecruitmentPostReps;
import com.hau.huylong.graduation_proejct.service.CompanyService;
import com.hau.huylong.graduation_proejct.service.mapper.CompanyMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper companyMapper;
    private final CompanyReps companyReps;
    private final UserRecruitmentPostReps userRecruitmentPostReps;

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        return null;
    }

    @Override
    public CompanyDTO edit(Long id, CompanyDTO companyDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CompanyDTO findById(Long id) {
        Optional<CompanyDTO> companyDTOOptional = companyReps.findById(id).map(companyMapper::to);

        if (companyDTOOptional.isEmpty()) {
            throw APIException.from(HttpStatus.NOT_FOUND).withMessage("Không tìm thấy công ty");
        }

        CompanyDTO companyDTO = companyDTOOptional.get();
        Map<Long, List<Integer>> mapCompanyWithListUserId = numberSubmitRecruitment();
        if (!CollectionUtils.isEmpty(mapCompanyWithListUserId) && mapCompanyWithListUserId.containsKey(companyDTO.getId())) {
            companyDTO.setNumberStudentSubmit(mapCompanyWithListUserId.get(companyDTO.getId()).size());
        }

        return companyDTO;
    }

    @Override
    public PageDataResponse<CompanyDTO> getAll(SearchCompanyRequest request) {
        Pageable pageable = PageableUtils.of(request.getPage(), request.getSize());
        Page<CompanyDTO> companyDTOS = companyReps.search(request, pageable).map(companyMapper::to);

        if (!CollectionUtils.isEmpty(companyDTOS.toList())) {
            Map<Long, List<Integer>> mapCompanyWithListUserId = numberSubmitRecruitment();

            for (CompanyDTO companyDTO : companyDTOS) {
                if (!CollectionUtils.isEmpty(mapCompanyWithListUserId) && mapCompanyWithListUserId.containsKey(companyDTO.getId())) {
                    companyDTO.setNumberStudentSubmit(mapCompanyWithListUserId.get(companyDTO.getId()).size());
                }
            }
        }

        return PageDataResponse.of(companyDTOS);
    }

    private Map<Long, List<Integer>> numberSubmitRecruitment() {
        List<UserRecruitmentPost> userPosts = userRecruitmentPostReps.findAll();

        Map<Long, List<Integer>> mapCompanyWithListUserId = new HashMap<>();
        if (!CollectionUtils.isEmpty(userPosts)) {
            List<Long> companyIds = userPosts.stream().map(UserRecruitmentPost::getCompanyId).distinct().collect(Collectors.toList());

            if (!CollectionUtils.isEmpty(companyIds)) {
                for (Long p : companyIds) {
                    for (UserRecruitmentPost u : userPosts) {
                        List<Integer> userIds = new ArrayList<>();
                        if (Objects.equals(p, u.getPostId())) {
                            userIds.add(u.getUserId());
                        }
                        mapCompanyWithListUserId.put(p, userIds);
                    }
                }
            }
        }
        return mapCompanyWithListUserId;
    }
}
