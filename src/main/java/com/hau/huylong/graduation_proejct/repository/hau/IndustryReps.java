package com.hau.huylong.graduation_proejct.repository.hau;

import com.hau.huylong.graduation_proejct.entity.hau.Industries;
import com.hau.huylong.graduation_proejct.model.request.SearchIndustryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndustryReps extends JpaRepository<Industries, Long> {
    @Query("select i from Industries i " +
            " WHERE (:#{#request.code} IS NULL OR i.code LIKE %:#{#request.code}%) " +
            " AND (:#{#request.name} IS NULL OR i.name LIKE %:#{#request.name}%) " +
            " ORDER BY i.id desc ")
    Page<Industries> search(SearchIndustryRequest request, Pageable pageable);

    List<Industries> findByIdIn(List<Long> industryIds);
}
