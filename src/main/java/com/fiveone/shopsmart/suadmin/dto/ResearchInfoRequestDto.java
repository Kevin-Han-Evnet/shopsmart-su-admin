package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.ResearchInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResearchInfoRequestDto {

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
    private String event_list_page;
    private String event_tag_selector;
    private String event_sub_tag_selector;
    private String event_img_tag_selector;
    private String event_code_name;
    private String event_not_nessesary_strings;
    private int event_crawling_stat;
    private String event_comment;
    private ResearchInfo.CrawlingEngineType crawling_engine;

    public ResearchInfoRequestDto(Long idx,
                                  String target_name,
                                  String target_base_url,
                                  String np_list_page,
                                  String np_tag_selector,
                                  String np_sub_tag_selector,
                                  String np_img_tag_selector,
                                  String np_code_name,
                                  String np_not_nessesary_strings,
                                  int np_crawling_stat,
                                  String np_comment,
                                  String event_list_page,
                                  String event_tag_selector,
                                  String event_sub_tag_selector,
                                  String event_img_tag_selector,
                                  String event_code_name,
                                  String event_not_nessesary_strings,
                                  int event_crawling_stat,
                                  String event_comment,
                                  String crawling_engine) {



        this.idx = idx;
        this.target_name = target_name;
        this.target_base_url = target_base_url;
        this.np_list_page = np_list_page;
        this.np_tag_selector = np_tag_selector;
        this.np_sub_tag_selector = np_sub_tag_selector;
        this.np_img_tag_selector = np_img_tag_selector;
        this.np_code_name = np_code_name;
        this.np_not_nessesary_strings = np_not_nessesary_strings;
        this.np_crawling_stat = np_crawling_stat;
        this.np_comment = np_comment;
        this.event_list_page = event_list_page;
        this.event_tag_selector = event_tag_selector;
        this.event_sub_tag_selector = event_sub_tag_selector;
        this.event_img_tag_selector = event_img_tag_selector;
        this.event_code_name = event_code_name;
        this.event_not_nessesary_strings = event_not_nessesary_strings;
        this.event_crawling_stat = event_crawling_stat;
        this.event_comment = event_comment;
        this.crawling_engine = ResearchInfo.CrawlingEngineType.valueOf(crawling_engine);
    }

    public ResearchInfo toEntity () {
        return ResearchInfo.builder()
                .idx(idx)
                .target_name(target_name)
                .target_base_url(target_base_url)
                .np_list_page(np_list_page)
                .np_tag_selector(np_tag_selector)
                .np__sub_tag_selector(np_sub_tag_selector)
                .np_img_tag_selector(np_img_tag_selector)
                .np_code_name(np_code_name)
                .np_not_nessesary_strings(np_not_nessesary_strings)
                .np_crawling_stat(np_crawling_stat)
                .np_comment(np_comment)
                .event_list_page(event_list_page)
                .event_tag_selector(event_tag_selector)
                .event_sub_tag_selector(event_sub_tag_selector)
                .event_img_tag_selector(event_img_tag_selector)
                .event_code_name(event_code_name)
                .event_not_nessesary_strings(event_not_nessesary_strings)
                .event_crawling_stat (event_crawling_stat)
                .event_comment(event_comment)
                .crawling_engine(crawling_engine)
                .build();
    }

}

