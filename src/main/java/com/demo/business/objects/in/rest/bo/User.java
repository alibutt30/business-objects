package com.demo.business.objects.in.rest.bo;

import com.demo.business.objects.domain.UserStatus;
import java.time.LocalDateTime;

public record User(Long id, String firstName, String lastName, UserStatus status, LocalDateTime lastModifiedTs, LocalDateTime insertTs) { }
