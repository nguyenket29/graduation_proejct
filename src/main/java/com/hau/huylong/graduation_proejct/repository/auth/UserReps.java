package com.hau.huylong.graduation_proejct.repository.auth;

import com.hau.huylong.graduation_proejct.entity.auth.User;
import com.hau.huylong.graduation_proejct.model.request.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserReps extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameAndStatus(String username, short status);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    @Query("SELECT u FROM User u")
    Page<User> search(UserRequest request, Pageable pageable);

    @Query("SELECT u FROM User u WHERE (COALESCE(:ids, NULL) IS NULL OR u.id IN :ids)")
    List<User> findByIds(List<Integer> ids);
}
