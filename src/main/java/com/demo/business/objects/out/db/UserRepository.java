package com.demo.business.objects.out.db;

import com.demo.business.objects.domain.UserEntity;
import com.demo.business.objects.domain.UserStatus;
import com.demo.business.objects.in.rest.bo.User;
import com.demo.business.objects.in.rest.dto.UserRequestDto;
import com.demo.business.objects.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional // needed to on each 'wrapper' repository to propagate the transaction to the UserJpaRepository
public class UserRepository {

    private final UserJpaRepository userJpaRepository;

    public User createUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = UserEntity.of(userRequestDto.firstName(), userRequestDto.lastName(),
                                              UserStatus.fromValue(userRequestDto.status()));
        return UserMapper.fromEntityToBO(userJpaRepository.save(userEntity));
    }

    public User getUserById(Long userId) {
        return UserMapper.fromEntityToBO(userJpaRepository.getUserById(userId));
    }

}
