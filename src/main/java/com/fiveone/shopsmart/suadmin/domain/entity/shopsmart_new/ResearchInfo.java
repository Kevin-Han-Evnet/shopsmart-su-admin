package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_crl_research_info")
public class ResearchInfo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    @ColumnDefault("UNTITLED")
    private String target_name;

    @Column(columnDefinition = "VARCHAR(255)")
    private String target_base_url;

    @Column(columnDefinition = "TEXT")
    private String np_list_page;

    @Column(columnDefinition = "TEXT")
    private String np_tag_selector;

    @Column(columnDefinition = "TEXT")
    private String np_sub_tag_selector;

    @Column(columnDefinition = "TEXT")
    private String np_img_tag_selector;

    @Column(columnDefinition = "VARCHAR(255)")
    private String np_code_name;

    @Column(columnDefinition = "TEXT")
    private String np_not_nessesary_strings;

    @Column(columnDefinition = "INT(1) UNSIGNED", nullable = false)
    @ColumnDefault("0")
    private int np_crawling_stat;

    @Column(columnDefinition = "TEXT")
    private String np_comment;

    @Column(columnDefinition = "BIGINT UNSIGNED", nullable =  false)
    @ColumnDefault("0")
    private Long np_count;

    @Column(columnDefinition = "TEXT")
    private String event_list_page;

    @Column(columnDefinition = "TEXT")
    private String event_tag_selector;

    @Column(columnDefinition = "TEXT")
    private String event_sub_tag_selector;

    @Column(columnDefinition = "TEXT")
    private String event_img_tag_selector;

    @Column(columnDefinition = "VARCHAR(255)")
    private String event_code_name;

    @Column(columnDefinition = "TEXT")
    private String event_not_nessesary_strings;

    @Column(columnDefinition = "INT(1) UNSIGNED", nullable = false)
    @ColumnDefault("0")
    private int event_crawling_stat;

    @Column(columnDefinition = "TEXT")
    private String event_comment;

    @Column(columnDefinition = "BIGINT UNSIGNED", nullable =  false)
    @ColumnDefault("0")
    private Long event_count;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM(URLLIB,WEBDRIVER)")
    private CrawlingEngineType crawling_engine;
    public enum CrawlingEngineType {
        URLLIB,
        WEBDRIVER
    }

    @Builder
    public ResearchInfo(Long idx, String target_name, String target_base_url, String np_list_page, String np_tag_selector, String np__sub_tag_selector, String np_img_tag_selector,
                        String np_code_name, String np_not_nessesary_strings, int np_crawling_stat, String np_comment, Long np_count, String event_list_page, String event_tag_selector, String event_sub_tag_selector,
                        String event_img_tag_selector, String event_code_name, String event_not_nessesary_strings, int event_crawling_stat, String event_comment, Long event_count, CrawlingEngineType crawling_engine) {
        this.idx = idx;
        this.target_name = target_name;
        this.target_base_url = target_base_url;
        this.np_list_page = np_list_page;
        this.np_tag_selector = np_tag_selector;
        this.np_sub_tag_selector = np__sub_tag_selector;
        this.np_img_tag_selector = np_img_tag_selector;
        this.np_code_name = np_code_name;
        this.np_not_nessesary_strings = np_not_nessesary_strings;
        this.np_crawling_stat = np_crawling_stat;
        this.np_comment = np_comment;
        this.np_count = np_count;
        this.event_list_page = event_list_page;
        this.event_tag_selector = event_tag_selector;
        this.event_sub_tag_selector = event_sub_tag_selector;
        this.event_img_tag_selector = event_img_tag_selector;
        this.event_code_name = event_code_name;
        this.event_not_nessesary_strings = event_not_nessesary_strings;
        this.event_crawling_stat = event_crawling_stat;
        this.event_comment = event_comment;
        this.event_count = event_count;
        this.crawling_engine = crawling_engine;
    }
}
