package com.demo.business.objects.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name = "USER_DATA")
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode(of = "id")
public class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 10)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "LAST_MODIFIED_TS")
    @LastModifiedDate
    private LocalDateTime lastModifiedTs;

    @Column(name = "INSERT_TS", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime insertTs;

    public static UserEntity of(String firstName, String lastName, UserStatus status) {
        return new UserEntity(firstName, lastName, status);
    }

    private UserEntity(String firstName, String lastName, UserStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }
}
