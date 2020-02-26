package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.KeywordTrendResearchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface KeywordTrendResearchInfoRepository extends JpaRepository<KeywordTrendResearchInfo, Long> {

    @Query(value = "SELECT m FROM KeywordTrendResearchInfo m WHERE m.membershipSeq=:target_seq")
    Optional<KeywordTrendResearchInfo> findKeywordTrendSearchInfo (@Param("target_seq") Long target_seq);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE KeywordTrendResearchInfo m SET " +
            "m.keyword_group_1=:keyword_group_1," +
            "m.keywords_1=:keywords_1," +
            "m.keyword_group_2=:keyword_group_2," +
            "m.keywords_2=:keywords_2," +
            "m.keyword_group_3=:keyword_group_3," +
            "m.keywords_3=:keywords_3," +
            "m.keyword_group_4=:keyword_group_4," +
            "m.keywords_4=:keywords_4," +
            "m.keyword_group_5=:keyword_group_5," +
            "m.keywords_5=:keywords_5," +
            "m.period=:peiod," +
            "m.timeUnit=:timeUnit," +
            "m.device=:device," +
            "m.gender=:gender," +
            "m.age=:age," +
            "m.keyword_trend_crawling_stat=:keyword_trend_crawling_stat" +
            " WHERE m.idx=:idx")
    void update (
            @Param("idx") Long idx,
            @Param("keyword_group_1") String keyword_group_1,
            @Param("keywords_1") String keywords_1,
            @Param("keyword_group_2") String keyword_group_2,
            @Param("keywords_2") String keywords_2,
            @Param("keyword_group_3") String keyword_group_3,
            @Param("keywords_3") String keywords_3,
            @Param("keyword_group_4") String keyword_group_4,
            @Param("keywords_4") String keywords_4,
            @Param("keyword_group_5") String keyword_group_5,
            @Param("keywords_5") String keywords_5,
            @Param("peiod") int peiod,
            @Param("timeUnit")KeywordTrendResearchInfo.TimeUnit timeUnit,
            @Param("device")KeywordTrendResearchInfo.Device device,
            @Param("gender")KeywordTrendResearchInfo.Gender gender,
            @Param("age") String age,
            @Param("keyword_trend_crawling_stat") int keyword_trend_crawling_stat
    );

}
