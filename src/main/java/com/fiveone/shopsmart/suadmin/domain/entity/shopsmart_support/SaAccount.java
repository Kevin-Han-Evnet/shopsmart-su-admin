package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_support;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "sa_account")
public class SaAccount {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String email;

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @Builder
    public SaAccount(Long idx, String email, String name, String password) {
        this.idx = idx;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
