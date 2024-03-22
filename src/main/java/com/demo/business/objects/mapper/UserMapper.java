package com.demo.business.objects.mapper;

import com.demo.business.objects.domain.UserEntity;
import com.demo.business.objects.in.rest.bo.User;

public class UserMapper {

    public static User fromEntityToBO(UserEntity userEntity) {
        return new User(userEntity.id(), userEntity.firstName(), userEntity.lastName(),
                        userEntity.status(), userEntity.lastModifiedTs(), userEntity.insertTs());

    }

    public static UserEntity fromBOToEntity(User user) {
        return UserEntity.of(user.firstName(), user.lastName(), user.status());
    }
}
