package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.ResearchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

public interface ResearchInfoRepository extends JpaRepository<ResearchInfo, Long> {

    /** 신상품 크롤링 가능한 녀석만 */
    @Query (value = "SELECT m FROM ResearchInfo m WHERE m.np_crawling_stat=1")
    Stream<ResearchInfo> findKNPesearch ();

    /** 신상품 크롤링 가능한 녀석만 */
    @Query (value = "SELECT m FROM ResearchInfo m WHERE m.event_crawling_stat=1")
    Stream<ResearchInfo> findEventResearch ();

    /** url로 서치 */
    @Query(value = "SELECT m FROM ResearchInfo m WHERE m.target_base_url=:base_url")
    Optional<ResearchInfo> findIfExist (@Param("base_url") String base_url);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query (value = "UPDATE ResearchInfo m SET " +
            "m.target_name=:target_name, " +
            "m.target_base_url=:target_base_url, " +
            "m.np_list_page=:np_list_page, " +
            "m.np_tag_selector=:np_tag_selector, " +
            "m.np_sub_tag_selector=:np_sub_tag_selector, " +
            "m.np_img_tag_selector=:np_img_tag_selector, " +
            "m.np_not_nessesary_strings=:np_not_nessesary_strings, " +
            "m.np_code_name=:np_code_name, " +
            "m.np_crawling_stat=:np_crawling_stat, " +
            "m.np_comment=:np_comment, " +
            "m.event_list_page=:event_list_page, " +
            "m.event_tag_selector=:event_tag_selector, " +
            "m.event_sub_tag_selector=:event_sub_tag_selector, " +
            "m.event_img_tag_selector=:event_img_tag_selector, " +
            "m.event_code_name=:event_code_name, " +
            "m.event_not_nessesary_strings=:event_not_nessesary_strings, " +
            "m.event_crawling_stat=:event_crawling_stat, " +
            "m.event_comment=:event_comment, " +
            "m.crawling_engine=:crawling_engine" +
            " WHERE m.idx=:idx")
    void update (@Param("idx") Long idx,
                 @Param("target_name") String target_name,
                 @Param("target_base_url") String target_base_url,
                 @Param("np_list_page") String np_list_page,
                 @Param("np_tag_selector") String np_tag_selector,
                 @Param("np_sub_tag_selector") String np_sub_tag_selector,
                 @Param("np_img_tag_selector") String np_img_tag_selector,
                 @Param("np_not_nessesary_strings") String np_not_nessesary_strings,
                 @Param("np_code_name") String np_code_name,
                 @Param("np_crawling_stat") int np_crawling_stat,
                 @Param("np_comment") String np_comment,
                 @Param("event_list_page") String event_list_page,
                 @Param("event_tag_selector") String event_tag_selector,
                 @Param("event_sub_tag_selector") String event_sub_tag_selector,
                 @Param("event_img_tag_selector") String event_img_tag_selector,
                 @Param("event_code_name") String event_code_name,
                 @Param("event_not_nessesary_strings") String event_not_nessesary_strings,
                 @Param("event_crawling_stat") int event_crawling_stat,
                 @Param("event_comment") String event_comment,
                 @Param("crawling_engine")ResearchInfo.CrawlingEngineType crawling_engine
                 );
}
