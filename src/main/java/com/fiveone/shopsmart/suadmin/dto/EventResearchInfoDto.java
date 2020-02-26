package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.EventResearchInfo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class EventResearchInfoDto {

    private Long idx;
    private Long crawling_info_idx;
    private String target_name;
    private String event_url;
    private String event_code;
    private String event_image_url;
    private String event_description;
    private LocalDateTime reg_date;

    public EventResearchInfoDto(EventResearchInfo entity) {
        idx = entity.getIdx();
        crawling_info_idx = entity.getCrawling_info_idx();
        target_name = entity.getTarget_name();
        event_url = entity.getEvent_url();
        event_code = entity.getEvent_code();
        event_image_url = entity.getEvent_image_url();
        event_description = entity.getEvent_description();
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

