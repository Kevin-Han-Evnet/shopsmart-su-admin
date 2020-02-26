package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.OrderCrawlingInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderCrawlingInfoRepository extends JpaRepository<OrderCrawlingInfo, Long> {

    /** 타겟 아이디별 토탈 카운트 */
    @Query(value = "SELECT COUNT(m) FROM OrderCrawlingInfo m WHERE m.membershipSeq=:target_seq")
    Long countByTargetId (@Param("target_seq") Long target_seq);

    /** 타겟별 고고고 */
    @Query(value = "SELECT m FROM OrderCrawlingInfo m WHERE m.membershipSeq=:target_seq")
    Page<OrderCrawlingInfo> findAllByTargetId (
            @Param("pageable") Pageable pageable,
            @Param ("target_seq") Long target_seq
    );

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE OrderCrawlingInfo m SET " +
            "m.platform_type=:platform_type, " +
            "m.account_type=:account_type, " +
            "m.platform_id=:platform_id, " +
            "m.login_url=:login_url, " +
            "m.user_id_k=:user_id_k, " +
            "m.user_pwd=:user_pwd, " +
            "m.disabled=:disabled " +
            "WHERE m.idx=:idx")
    void update (
            @Param("idx") Long idx,
            @Param("platform_type") OrderCrawlingInfo.PlatformType platform_type,
            @Param("account_type") int account_type,
            @Param("platform_id") String platform_id,
            @Param("login_url") String login_url,
            @Param("user_id_k") String user_id_k,
            @Param("user_pwd") String user_pwd,
            @Param("disabled") int disabled
    );

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE OrderCrawlingInfo m SET " +
            "m.disabled=:disabled " +
            "WHERE m.idx=:target_idx")
    void update_stat (
            @Param("target_idx") Long target_idx,
            @Param("disabled") int disabled
    );

}
