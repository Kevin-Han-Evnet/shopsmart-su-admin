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
        name = "tb_crl_np_result",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_np_codes", columnNames = {"crawling_info_idx", "np_code"}),
                @UniqueConstraint(name = "uk_np_link", columnNames = {"crawling_info_idx", "np_url"})
        }
)
public class NewProductResearchInfo extends BaseTimeEntitySingleDate {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long crawling_info_idx;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String target_name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String np_url;

    @Column(columnDefinition = "VARCHAR(255)")
    private String np_code;

    @Column(columnDefinition = "TEXT")
    private String np_image_url;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String np_description;

    @Builder
    public NewProductResearchInfo(Long idx, Long crawling_info_idx, String target_name, String np_url, String np_code, String np_image_url, String np_description) {
        this.idx = idx;
        this.crawling_info_idx = crawling_info_idx;
        this.target_name = target_name;
        this.np_url = np_url;
        this.np_code = np_code;
        this.np_image_url = np_image_url;
        this.np_description = np_description;
    }
}
