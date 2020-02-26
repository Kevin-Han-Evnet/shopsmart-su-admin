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
@Table(
        name = "tb_crl_event_result",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_event_codes", columnNames = {"crawling_info_idx", "event_code"}),
                @UniqueConstraint(name = "uk_event_link", columnNames = {"crawling_info_idx", "event_url"})
        }
)
public class EventResearchInfo extends BaseTimeEntitySingleDate {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long crawling_info_idx;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String target_name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String event_url;

    @Column(columnDefinition = "VARCHAR(255)")
    private String event_code;

    @Column(columnDefinition = "TEXT")
    private String event_image_url;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String event_description;

    @Builder
    public EventResearchInfo(Long idx, Long crawling_info_idx, String target_name, String event_url, String event_code, String event_image_url, String event_description) {
        this.idx = idx;
        this.crawling_info_idx = crawling_info_idx;
        this.target_name = target_name;
        this.event_url = event_url;
        this.event_code = event_code;
        this.event_image_url = event_image_url;
        this.event_description = event_description;
    }
}
