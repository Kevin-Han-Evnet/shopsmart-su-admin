package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.KeywordTrendResearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KeywordTrendResearchResultRepository extends JpaRepository<KeywordTrendResearchResult, Long> {

    @Query (value = "SELECT m FROM KeywordTrendResearchResult m WHERE m.crawling_info_idx=:#{#crawling_info_idx}")
    KeywordTrendResearchResult findOneByIdx (@Param("crawling_info_idx") Long crawling_info_idx);

}
