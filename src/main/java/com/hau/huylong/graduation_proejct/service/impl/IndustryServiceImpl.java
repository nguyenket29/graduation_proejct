package com.hau.huylong.graduation_proejct.service.impl;

import com.hau.huylong.graduation_proejct.model.dto.hau.IndustryDTO;
import com.hau.huylong.graduation_proejct.model.request.SearchIndustryRequest;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;
import com.hau.huylong.graduation_proejct.repository.hau.IndustryReps;
import com.hau.huylong.graduation_proejct.service.IndustryService;
import com.hau.huylong.graduation_proejct.service.mapper.IndustryMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class IndustryServiceImpl implements IndustryService {
    private final IndustryReps industryReps;
    private final IndustryMapper industryMapper;

    @Override
    public IndustryDTO save(IndustryDTO industryDTO) {
        return null;
    }

    @Override
    public IndustryDTO edit(Long id, IndustryDTO industryDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public IndustryDTO findById(Long id) {
        return null;
    }

    @Override
    public PageDataResponse<IndustryDTO> getAll(SearchIndustryRequest request) {
        return null;
    }
}
