package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.OrderCrawlingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.stream.Stream;

public interface OrderCrawlingResultRepository extends JpaRepository<OrderCrawlingResult, Long> {

    /** 크롤링 타겟 아이디별 토탈 카운트 */
    @Query(value = "SELECT COUNT(m) FROM OrderCrawlingResult m WHERE m.crawling_info_idx=:target_id")
    Long countByTargetId (@Param("target_id") Long target_id);

    /** 주문건, 수량 카운트 */
    @Query(value = "SELECT COUNT(m) AS order_count, SUM(m.order_count) AS order_amount FROM OrderCrawlingResult m WHERE m.crawling_info_idx=:target_id")
    Stream<Map<String, Object>> getOrderInfoByTargetId (@Param("target_id") Long target_id);

}
