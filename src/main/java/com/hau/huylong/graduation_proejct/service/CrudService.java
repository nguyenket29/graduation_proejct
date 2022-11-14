package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;

public interface CrudService<E, DTO, SRQ> {
    DTO save(DTO dto);

    DTO edit(Long id, DTO dto);

    void delete(Long id);

    DTO findById(Long id);

    PageDataResponse<DTO> findAll(SRQ request);
}
