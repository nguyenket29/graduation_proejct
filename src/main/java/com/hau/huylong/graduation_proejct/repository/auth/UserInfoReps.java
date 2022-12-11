package com.hau.huylong.graduation_proejct.repository.auth;

import com.hau.huylong.graduation_proejct.entity.hau.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoReps extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByUserId(Integer userId);
    Optional<UserInfo> findByCompanyId(Long companyId);
    @Query("select ui from UserInfo ui")
    List<UserInfo> getListUserInfo();
    List<UserInfo> findByUserIdIn(List<Integer> userIds);
}
