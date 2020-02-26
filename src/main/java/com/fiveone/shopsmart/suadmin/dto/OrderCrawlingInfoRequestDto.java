package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.OrderCrawlingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCrawlingInfoRequestDto {

    private Long idx;
    private Long membershipSeq;
    private String platform_type;
    private int account_type;
    private String platform_id;
    private String login_url;
    private String user_id_k;
    private String user_pwd;
    private int disabled;

    public OrderCrawlingInfo toEntity () {
        return OrderCrawlingInfo.builder()
                .idx(idx)
                .membershipSeq(membershipSeq)
                .platform_type(OrderCrawlingInfo.PlatformType.valueOf(platform_type))
                .account_type(account_type)
                .platform_id(platform_id)
                .login_url(login_url)
                .user_id_k(user_id_k)
                .user_pwd(user_pwd)
                .disabled(disabled)
                .build();

    }

}

