package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_support.SaAccount;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@Setter
public class SaAccountResponseDto {

    private Long idx;
    private String email;
    private String name;
    private String password;

    public SaAccountResponseDto(SaAccount entity) {
        idx = entity.getIdx();
        email = entity.getEmail();
        name = entity.getName();
        password = entity.getPassword();
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

