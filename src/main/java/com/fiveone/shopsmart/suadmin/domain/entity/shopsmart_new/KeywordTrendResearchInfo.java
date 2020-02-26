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
@Table(name = "tb_crl_keyword_info")
public class KeywordTrendResearchInfo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(name = "membership_seq", columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long membershipSeq;

    @Column(columnDefinition = "VARCHAR(200)")
    private String keyword_group_1;

    @Column(columnDefinition = "TEXT")
    private String keywords_1;

    @Column(columnDefinition = "VARCHAR(200)")
    private String keyword_group_2;

    @Column(columnDefinition = "TEXT")
    private String keywords_2;

    @Column(columnDefinition = "VARCHAR(200)")
    private String keyword_group_3;

    @Column(columnDefinition = "TEXT")
    private String keywords_3;

    @Column(columnDefinition = "VARCHAR(200)")
    private String keyword_group_4;

    @Column(columnDefinition = "TEXT")
    private String keywords_4;

    @Column(columnDefinition = "VARCHAR(200)")
    private String keyword_group_5;

    @Column(columnDefinition = "TEXT")
    private String keywords_5;

    @Column(columnDefinition = "INT(11)")
    private Integer period;

    @Enumerated (EnumType.STRING)
    @Column (columnDefinition = "ENUM('date','week','month')")
    private TimeUnit timeUnit;
    public enum TimeUnit {
        date,
        week,
        month
    }

    @Enumerated (EnumType.STRING)
    @Column(columnDefinition = "ENUM('all', 'pc','mobile')")
    private Device device;
    public enum Device {
        all,
        pc,
        mobile
    }

    @Enumerated (EnumType.STRING)
    @Column (columnDefinition = "ENUM('all','f','m')")
    private Gender gender;
    public enum Gender {
        all,
        f,
        m
    }


    @Column(columnDefinition = "VARCHAR(255)")
    private String age;

    @Column(columnDefinition = "INT(1) UNSIGNED", nullable = false)
    @ColumnDefault("0")
    private int keyword_trend_crawling_stat;

    @Builder
    public KeywordTrendResearchInfo(Long idx, Long membershipSeq, String keyword_group_1,
                                    String keywords_1, String keyword_group_2, String keywords_2,
                                    String keyword_group_3, String keywords_3,
                                    String keyword_group_4, String keywords_4,
                                    String keyword_group_5, String keywords_5, int period, TimeUnit timeUnit, Device device, Gender gender, String age, int keyword_trend_crawling_stat) {
        this.idx = idx;
        this.membershipSeq = membershipSeq;
        this.keyword_group_1 = keyword_group_1;
        this.keywords_1 = keywords_1;
        this.keyword_group_2 = keyword_group_2;
        this.keywords_2 = keywords_2;
        this.keyword_group_3 = keyword_group_3;
        this.keywords_3 = keywords_3;
        this.keyword_group_4 = keyword_group_4;
        this.keywords_4 = keywords_4;
        this.keyword_group_5 = keyword_group_5;
        this.keywords_5 = keywords_5;
        this.period = period;
        this.timeUnit = timeUnit;
        this.device = device;
        this.gender = gender;
        this.age = age;
        this.keyword_trend_crawling_stat = keyword_trend_crawling_stat;
    }
}
