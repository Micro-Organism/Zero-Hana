package com.zero.hana.reponsitory;

import com.zero.hana.domain.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUserEntity, Long> {
}
