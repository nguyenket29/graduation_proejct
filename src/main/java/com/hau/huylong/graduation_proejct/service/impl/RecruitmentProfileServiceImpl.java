package com.hau.huylong.graduation_proejct.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hau.huylong.graduation_proejct.common.exception.APIException;
import com.hau.huylong.graduation_proejct.common.util.BeanUtil;
import com.hau.huylong.graduation_proejct.common.util.PageableUtils;
import com.hau.huylong.graduation_proejct.entity.hau.RecruitmentProfile;
import com.hau.huylong.graduation_proejct.model.dto.hau.PostDTO;
import com.hau.huylong.graduation_proejct.model.dto.hau.RecruitmentProfileDTO;
import com.hau.huylong.graduation_proejct.model.request.SearchRecruitmentProfileRequest;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;
import com.hau.huylong.graduation_proejct.repository.hau.RecruitmentProfileReps;
import com.hau.huylong.graduation_proejct.service.RecruitmentProfileService;
import com.hau.huylong.graduation_proejct.service.mapper.RecruitmentProfileMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class RecruitmentProfileServiceImpl implements RecruitmentProfileService {
    private final RecruitmentProfileMapper recruitmentProfileMapper;
    private final RecruitmentProfileReps recruitmentProfileReps;

    @Override
    public RecruitmentProfileDTO save(RecruitmentProfileDTO recruitmentProfileDTO) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        RecruitmentProfile recruitmentProfile = recruitmentProfileMapper.from(recruitmentProfileDTO);

        if (recruitmentProfileDTO.getAcademyInfoDTO() != null) {
            recruitmentProfile.setAcademyInfo(mapper.writeValueAsString(recruitmentProfileDTO.getAcademyInfoDTO()));
        }

        if (recruitmentProfileDTO.getWorkExperienceDTO() != null) {
            recruitmentProfile.setWorkExperience(mapper.writeValueAsString(recruitmentProfileDTO.getWorkExperienceDTO()));
        }

        if (recruitmentProfileDTO.getForeignLanguageDTO() != null) {
            recruitmentProfile.setForeignLanguage(mapper.writeValueAsString(recruitmentProfileDTO.getForeignLanguageDTO()));
        }

        if (recruitmentProfileDTO.getOfficeInfoDTO() != null) {
            recruitmentProfile.setOfficeInfo(mapper.writeValueAsString(recruitmentProfileDTO.getOfficeInfoDTO()));
        }

        return recruitmentProfileMapper.to(recruitmentProfileReps.save(recruitmentProfile));
    }

    @Override
    public RecruitmentProfileDTO edit(Long id, RecruitmentProfileDTO recruitmentProfileDTO) {
        Optional<RecruitmentProfile> recruitmentProfileOptional = recruitmentProfileReps.findById(id);

        if (recruitmentProfileOptional.isEmpty()) {
            throw APIException.from(HttpStatus.NOT_FOUND).withMessage("Không tìm thấy hồ sơ tuyển dụng");
        }

        RecruitmentProfile recruitmentProfile = recruitmentProfileOptional.get();
        BeanUtil.copyNonNullProperties(recruitmentProfileDTO, recruitmentProfile);

        return recruitmentProfileMapper.to(recruitmentProfileReps.save(recruitmentProfile));
    }

    @Override
    public void delete(Long id) {
        Optional<RecruitmentProfile> recruitmentProfileOptional = recruitmentProfileReps.findById(id);

        if (recruitmentProfileOptional.isEmpty()) {
            throw APIException.from(HttpStatus.NOT_FOUND).withMessage("Không tìm thấy hồ sơ tuyển dụng");
        }

        recruitmentProfileReps.delete(recruitmentProfileOptional.get());
    }

    @Override
    public RecruitmentProfileDTO findById(Long id) {
        Optional<RecruitmentProfile> recruitmentProfileOptional = recruitmentProfileReps.findById(id);

        if (recruitmentProfileOptional.isEmpty()) {
            throw APIException.from(HttpStatus.NOT_FOUND).withMessage("Không tìm thấy hồ sơ tuyển dụng");
        }

        return recruitmentProfileMapper.to(recruitmentProfileOptional.get());
    }

    @Override
    public PageDataResponse<RecruitmentProfileDTO> getAll(SearchRecruitmentProfileRequest request) {
        Pageable pageable = PageableUtils.of(request.getPage(), request.getSize());
        Page<RecruitmentProfileDTO> page = recruitmentProfileReps.search(request, pageable).map(recruitmentProfileMapper::to);
        return PageDataResponse.of(page);
    }
}
