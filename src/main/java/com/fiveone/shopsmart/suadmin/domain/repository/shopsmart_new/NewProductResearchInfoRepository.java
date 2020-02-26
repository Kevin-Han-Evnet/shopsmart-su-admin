package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.NewProductResearchInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NewProductResearchInfoRepository extends JpaRepository<NewProductResearchInfo, Long> {

    /** 크롤링 타겟 아이디별 토탈 카운트 */
    @Query(value = "SELECT COUNT(m) FROM NewProductResearchInfo m WHERE m.crawling_info_idx=:target_id")
    Long countByTargetId (@Param("target_id") Long target_id);


    /** 크롤링 타겟별 고고고 */
    @Query(value = "SELECT m FROM NewProductResearchInfo m WHERE m.crawling_info_idx=:target_id")
    Page<NewProductResearchInfo> findAllByTargetId (
            @Param("pageable") Pageable pageable,
            @Param ("target_id") Long target_id
    );

}
