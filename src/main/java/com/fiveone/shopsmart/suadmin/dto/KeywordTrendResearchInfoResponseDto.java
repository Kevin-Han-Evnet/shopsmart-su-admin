package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.KeywordTrendResearchInfo;
import lombok.Getter;
import org.hsqldb.lib.StringUtil;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


@Getter
public class KeywordTrendResearchInfoResponseDto {

    /** 기간 */
    public static final String[] kt_periods = {"전체", "1개월", "3개월", "1년"};

    /** 연령 */
    public static final String[] ages = {"전체", "12세 이하", "13세 ~ 18세", "19세 ~ 24세", "25세 ~ 29세", "30세 ~ 34세", "35세 ~ 39세", "40세 ~ 44세"
            , "45세 ~ 49세", "50세 ~ 54세", "55세 ~ 60세", "60세 이상"};

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
    private KeywordTrendResearchInfo.TimeUnit timeUnit;
    private KeywordTrendResearchInfo.Device device;
    private KeywordTrendResearchInfo.Gender gender;
    private String age;
    private int keyword_trend_crawling_stat;

    private String[] age_arr;

    public KeywordTrendResearchInfoResponseDto(KeywordTrendResearchInfo entity) {
        idx = entity.getIdx();
        membershipSeq = entity.getMembershipSeq();
        keyword_group_1 = entity.getKeyword_group_1();
        keywords_1 = entity.getKeywords_1();
        keyword_group_2 = entity.getKeyword_group_2();
        keywords_2 = entity.getKeywords_2();
        keyword_group_3 = entity.getKeyword_group_3();
        keywords_3 = entity.getKeywords_3();
        keyword_group_4 = entity.getKeyword_group_4();
        keywords_4 = entity.getKeywords_4();
        keyword_group_5 = entity.getKeyword_group_5();
        keywords_5 = entity.getKeywords_5();
        period = entity.getPeriod();
        timeUnit = entity.getTimeUnit();
        device = entity.getDevice();
        gender = entity.getGender();
        age = entity.getAge();
        keyword_trend_crawling_stat = entity.getKeyword_trend_crawling_stat();

        age_arr = StringUtil.isEmpty(age) ? new String[]{}: age.split(",");
    }

    public KeywordTrendResearchInfoResponseDto () {
        this.idx = (long) -1;
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
     * 키워드 조합
     * @return
     */
    public String getKeywords () {
        /** 키워드 그룹및 키워드 뷰잉 편집 */
        String result = "";
        if (!StringUtils.isEmpty(keyword_group_1)) {
            result += keyword_group_1;
            if (!StringUtils.isEmpty(keywords_1)) result += " - " + keywords_1;
        }

        if (!StringUtils.isEmpty(keyword_group_2)) {
            if (!StringUtils.isEmpty(result)) result += "<br>";
            result += keyword_group_2;
            if (!StringUtils.isEmpty(keywords_2)) result += " - " + keywords_2;
        }

        if (!StringUtils.isEmpty(keyword_group_3)) {
            if (!StringUtils.isEmpty(result)) result += "<br>";
            result += keyword_group_3;
            if (!StringUtils.isEmpty(keywords_3)) result += " - " + keywords_3;
        }

        if (!StringUtils.isEmpty(keyword_group_4)) {
            if (!StringUtils.isEmpty(result)) result += "<br>";
            result += keyword_group_4;
            if (!StringUtils.isEmpty(keywords_4)) result += " - " + keywords_4;
        }

        if (!StringUtils.isEmpty(keyword_group_5)) {
            if (!StringUtils.isEmpty(result)) result += "<br>";
            result += keyword_group_5;
            if (!StringUtils.isEmpty(keywords_5)) result += " - " + keywords_5;
        }

        return result;
    }

    /**
     * 뷰잉용 period 리턴
     * @return
     */
    public String getTargetPeriod () {
        return kt_periods[period];
    }


    /**
     * 측정 연령
     * @return
     */
    public String getTargetAges () {
        String result = "";

        if (age_arr.length > 0) {
            for (String t : age_arr) {
                if (!StringUtils.isEmpty(result)) result += ", <br>";
                result += ages[Integer.valueOf(t.substring(4))];
            }
        } else {
            result = ages[0];
        }

        return result;
    }

    /**
     * UI체크상태 --- 이게 thymeleaf에서 정상동작하지 않음. 어쩔수 없이 여기다.
     * @return
     */
    public boolean isChecked (String target_id) {
        return (!StringUtil.isEmpty(target_id) && Long.valueOf(target_id) == idx);
    }

}

