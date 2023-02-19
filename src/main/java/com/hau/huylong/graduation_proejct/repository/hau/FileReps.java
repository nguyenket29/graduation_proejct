package com.hau.huylong.graduation_proejct.repository.hau;

import com.hau.huylong.graduation_proejct.entity.hau.Files;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileReps extends CrudRepository<Files, Long> {
    List<Files> findByIdIn(List<Long> fileIds);
}
