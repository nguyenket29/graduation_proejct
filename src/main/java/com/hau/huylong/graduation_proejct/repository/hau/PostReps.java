package com.hau.huylong.graduation_proejct.repository.hau;

import com.hau.huylong.graduation_proejct.entity.hau.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReps extends JpaRepository<Post, Long> {
}