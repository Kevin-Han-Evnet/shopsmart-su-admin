package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.BaseTimeEntitySingleDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_crl_keyword_result")
public class KeywordTrendResearchResult extends BaseTimeEntitySingleDate {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long crawling_info_idx;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String target_name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String json_request;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String json_response;

    @Builder
    public KeywordTrendResearchResult(Long idx, Long crawling_info_idx, String target_name, String json_request, String json_response) {
        this.idx = idx;
        this.crawling_info_idx = crawling_info_idx;
        this.target_name = target_name;
        this.json_request = json_request;
        this.json_response = json_response;
    }
}
