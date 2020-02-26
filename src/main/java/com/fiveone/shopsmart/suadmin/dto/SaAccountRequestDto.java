package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_support.SaAccount;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SaAccountRequestDto {
    private Long idx;
    private String email;
    private String name;
    private String password;

    public SaAccount toEntity(){
        return SaAccount.builder()
                .idx(idx)
                .email(email)
                .name (name)
                .password(password)
                .build();
    }

    @Builder
    public SaAccountRequestDto(Long idx, String email, String name, String password) {
        this.idx = idx;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
