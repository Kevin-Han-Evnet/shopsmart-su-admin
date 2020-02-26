package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.KeywordTrendResearchInfo;
import lombok.Getter;
import org.hsqldb.lib.StringUtil;

@Getter
public class KeywordTrendResearchInfoRequestDto {

    private Long idx;
    private Long membershipSeq;
    private String keyword_group_1;
    private String keywords_1;
    private String keyword_group_2;
    private String keywords_2;
    private String keyword_group_3;
    private String keywords_3;
    private String keyword_group_4;
    private String keywords_4;
    private String keyword_group_5;
    private String keywords_5;
    private Integer period;
    private String timeUnit;
    private String device;
    private String gender;
    private String age;
    private int keyword_trend_crawling_stat;

    public KeywordTrendResearchInfoRequestDto(Long idx,
                                              Long membershipSeq,
                                              String keyword_group_1,
                                              String keywords_1,
                                              String keyword_group_2,
                                              String keywords_2,
                                              String keyword_group_3,
                                              String keywords_3,
                                              String keyword_group_4,
                                              String keywords_4,
                                              String keyword_group_5,
                                              String keywords_5,
                                              Integer period,
                                              String timeUnit,
                                              String device,
                                              String gender,
                                              String ages_asset,
                                              int keyword_trend_crawling_stat) {


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
        this.age = ages_asset;
        this.keyword_trend_crawling_stat = keyword_trend_crawling_stat;
    }

    public KeywordTrendResearchInfo toEntity () {
        return KeywordTrendResearchInfo.builder()
                .idx(idx)
                .membershipSeq(membershipSeq)
                .keyword_group_1(keyword_group_1)
                .keywords_1(StringUtil.isEmpty(keywords_1) ? keyword_group_1 : keywords_1)
                .keyword_group_2(keyword_group_2)
                .keywords_2(keywords_2)
                .keyword_group_3(keyword_group_3)
                .keywords_3(keywords_3)
                .keyword_group_4(keyword_group_4)
                .keywords_4(keywords_4)
                .keyword_group_5(keyword_group_5)
                .keywords_5(keywords_5)
                .period(period)
                .timeUnit(KeywordTrendResearchInfo.TimeUnit.valueOf(timeUnit))
                .device(KeywordTrendResearchInfo.Device.valueOf(device))
                .gender(KeywordTrendResearchInfo.Gender.valueOf(gender))
                .age(age)
                .keyword_trend_crawling_stat(keyword_trend_crawling_stat)
                .build();
    }

}

