package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShipExternalAccounts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberShipExternalAccountsRequestDto {

    private Long idx;
    private Long membershipSeq;
    private String platformNm;
    private String platformType;
    private String accId;
    private String accPwd;
    private String accKey;

    public MemberShipExternalAccounts toEntity () {
        return MemberShipExternalAccounts.builder()
                .idx(idx)
                .membershipSeq(membershipSeq)
                .platformType(platformType)
                .platformNm(platformNm)
                .accId(accId)
                .accPwd(accPwd)
                .accKey(accKey)
                .build();
    }

}

