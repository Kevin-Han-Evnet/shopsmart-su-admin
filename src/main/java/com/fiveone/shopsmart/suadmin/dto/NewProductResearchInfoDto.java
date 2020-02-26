package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.NewProductResearchInfo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class NewProductResearchInfoDto {

    private Long idx;
    private Long crawling_info_idx;
    private String target_name;
    private String np_url;
    private String np_code;
    private String np_image_url;
    private String np_description;
    private LocalDateTime reg_date;

    public NewProductResearchInfoDto(NewProductResearchInfo entity) {
        idx = entity.getIdx();
        crawling_info_idx = entity.getCrawling_info_idx();
        target_name = entity.getTarget_name();
        np_url = entity.getNp_url();
        np_code = entity.getNp_code();
        np_image_url = entity.getNp_image_url();
        np_description = entity.getNp_description();
        reg_date = entity.getReg_date();

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

