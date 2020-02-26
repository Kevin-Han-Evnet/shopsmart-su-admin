package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_support;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "sa_role")
public class SaRole {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String role_name;

    @Column(columnDefinition = "TEXT")
    private String role_description;

    @Builder
    public SaRole(Long idx, String role_name, String role_description) {
        this.idx = idx;
        this.role_name = role_name;
        this.role_description = role_description;
    }
}
