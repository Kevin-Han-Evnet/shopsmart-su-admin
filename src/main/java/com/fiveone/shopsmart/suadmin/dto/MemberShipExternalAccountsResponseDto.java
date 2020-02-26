package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShipExternalAccounts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberShipExternalAccountsResponseDto {

    private Long idx;
    private Long membershipSeq;
    private String platformNm;
    private String platformType;
    private String accId;
    private String accPwd;
    private String accKey;


    public MemberShipExternalAccountsResponseDto (MemberShipExternalAccounts entity) {
        this.idx = entity.getIdx();
        this.membershipSeq = entity.getMembershipSeq();
        this.platformType = entity.getPlatformType().name();
        this.platformNm = entity.getPlatformNm();
        this.accId = entity.getAccId();
        this.accPwd = entity.getAccPwd();
        this.accKey = entity.getAccKey();
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

}

