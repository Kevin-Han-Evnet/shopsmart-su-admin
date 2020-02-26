package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.OrderCrawlingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCrawlingInfoResponseDto {

    private Long idx;
    private Long membershipSeq;
    private OrderCrawlingInfo.PlatformType platform_type;
    private int account_type;
    private String platform_id;
    private String login_url;
    private String user_id_k;
    private String user_pwd;
    private int disabled;

    private OrderCountReportDto orderCountInfo;


    public OrderCrawlingInfoResponseDto (OrderCrawlingInfo entity) {
        this.idx = entity.getIdx();
        this.membershipSeq = entity.getMembershipSeq();
        this.platform_type = entity.getPlatform_type();
        this.account_type = entity.getAccount_type();
        this.platform_id = entity.getPlatform_id();
        this.login_url = entity.getLogin_url();
        this.user_id_k = entity.getUser_id_k();
        this.user_pwd = entity.getUser_pwd();
        this.disabled = entity.getDisabled();
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

