package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_membership_ext_accounts")
public class MemberShipExternalAccounts {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(name = "membership_seq", columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long membershipSeq;

    /* 외부연동계정 타입 */
    @Enumerated (EnumType.STRING)
    @Column (name = "platform_type", columnDefinition = "ENUM('SINSANGMARKET', 'SMARTSTORE', 'INSTAGRAM', 'KAKAOSTORY')", nullable = false)
    private PlatformType platformType;
    public enum PlatformType {
        SINSANGMARKET,
        SMARTSTORE,
        INSTAGRAM,
        KAKAOSTORY
    }

    @Column(name = "platform_nm", columnDefinition = "VARCHAR(20)", nullable = false)
    private String platformNm;

    @Column(name="acc_id", columnDefinition = "VARCHAR(50)")
    private String accId;

    @Column(name="acc_pwd", columnDefinition = "VARCHAR(255)")
    private String accPwd;

    @Column(name="acc_key", columnDefinition = "VARCHAR(255)")
    private String accKey;

    @Builder
    public MemberShipExternalAccounts (Long idx, Long membershipSeq, String platformType, String platformNm, String accId, String accPwd, String accKey) {
        this.idx = idx;
        this.membershipSeq = membershipSeq;
        this.platformNm = platformNm;
        this.platformType = PlatformType.valueOf(platformType);
        this.accId = accId;
        this.accPwd = accPwd;
        this.accKey = accKey;
    }
}

