package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.ResearchTarget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ResearchTargetRepository extends JpaRepository<ResearchTarget, Long> {

    @Query (value = "SELECT COUNT(m) FROM ResearchTarget m WHERE m.membershipSeq=:target_seq")
    Long count (@Param("target_seq") Long target_seq);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE ResearchTarget m SET " +
            "m.np_crawling=:stat" +
            " WHERE m.idx=:idx")
    void update_np_carwling_reqeust (
            @Param("idx") Long idx,
            @Param("stat") int stat
    );

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE ResearchTarget m SET " +
            "m.event_crawling=:stat" +
            " WHERE m.idx=:idx")
    void update_event_carwling_reqeust (
            @Param("idx") Long idx,
            @Param("stat") int stat
    );


    /** 타입별로 찾아봅시당 */
    @Transactional
    @Query (value = "SELECT m FROM ResearchTarget m WHERE m.membershipSeq=:target_seq ORDER BY m.idx DESC")
    Page<ResearchTarget> findAllByTargetSeq(
            @Param("pageable") Pageable pageable,
            @Param("target_seq") Long target_seq
    );
}
