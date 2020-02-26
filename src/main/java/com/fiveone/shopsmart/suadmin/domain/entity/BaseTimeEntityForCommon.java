package com.fiveone.shopsmart.suadmin.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntityForCommon {

    @CreatedDate
    @Column(columnDefinition = "CURRENT_TIMESTAMP")
    private LocalDateTime reg_dt;

    @LastModifiedDate
    @Column(columnDefinition = "CURRENT_TIMESTAMP")
    private LocalDateTime mod_dt;

}
