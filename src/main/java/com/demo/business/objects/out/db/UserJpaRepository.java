package com.demo.business.objects.out.db;

import com.demo.business.objects.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    UserEntity getUserById(Long id);
}
