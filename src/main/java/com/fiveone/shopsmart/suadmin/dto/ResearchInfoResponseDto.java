package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.ResearchInfo;
import lombok.Getter;
import lombok.Setter;
import org.hsqldb.lib.StringUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@Setter
public class ResearchInfoResponseDto {

    private Long idx;
    private String target_name;
    private String target_base_url;
    private String np_list_page;
    private String np_tag_selector;
    private String np_sub_tag_selector;
    private String np_img_tag_selector;
    private String np_code_name;
    private String np_not_nessesary_strings;
    private int np_crawling_stat;
    private String np_comment;
    private Long np_count;

    private String event_list_page;
    private String event_tag_selector;
    private String event_sub_tag_selector;
    private String event_img_tag_selector;
    private String event_code_name;
    private String event_not_nessesary_strings;
    private int event_crawling_stat;
    private String event_comment;
    private Long event_count;
    private ResearchInfo.CrawlingEngineType crawling_engine;

    public ResearchInfoResponseDto(ResearchInfo entity) {
        idx = entity.getIdx();
        target_name = entity.getTarget_name();
        target_base_url = entity.getTarget_base_url();
        np_list_page = entity.getNp_list_page();
        np_tag_selector = entity.getNp_tag_selector();
        np_sub_tag_selector = entity.getNp_sub_tag_selector();
        np_img_tag_selector = entity.getNp_img_tag_selector();
        np_code_name = entity.getNp_code_name();
        np_not_nessesary_strings = entity.getNp_not_nessesary_strings();
        np_crawling_stat = entity.getNp_crawling_stat();
        np_comment = entity.getNp_comment();
        np_count = entity.getNp_count();
        event_list_page = entity.getEvent_list_page();
        event_tag_selector = entity.getEvent_tag_selector();
        event_sub_tag_selector = entity.getEvent_sub_tag_selector();
        event_img_tag_selector = entity.getEvent_img_tag_selector();
        event_code_name = entity.getEvent_code_name();
        event_not_nessesary_strings = entity.getEvent_not_nessesary_strings();
        event_crawling_stat = entity.getEvent_crawling_stat();
        event_comment = entity.getEvent_comment();
        event_count = entity.getEvent_count();
        crawling_engine = entity.getCrawling_engine();
    }

    public ResearchInfoResponseDto (Long idx) {
        this.idx = idx;
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


    /**
     * UI체크상태 --- 이게 thymeleaf에서 정상동작하지 않음. 어쩔수 없이 여기다.
     * @return
     */
    public boolean isChecked (String target_id) {
        return (!StringUtil.isEmpty(target_id) && Long.valueOf(target_id) == idx);
    }

}

