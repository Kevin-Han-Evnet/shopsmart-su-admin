package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.BaseTimeEntitySingleDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_crl_order_result")
public class OrderCrawlingResult extends BaseTimeEntitySingleDate {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(name = "membership_seq", columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long membershipSeq;


    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    @ColumnDefault("0")
    private Long crawling_info_idx;

    @Column(columnDefinition = "INT(10) UNSIGNED", nullable = false)
    private int checked;

    @Column(columnDefinition = "INT(1) UNSIGNED", nullable = false)
    private int closed;

    @Column(columnDefinition = "TEXT")
    private String check_dup_code;

    @Column(columnDefinition = "VARCHAR(100", nullable = false)
    private String product_name;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String product_option;

    @Column(columnDefinition = "INT(11) UNSIGNED", nullable = false)
    private int order_count;

    @Column(columnDefinition = "INT(11) UNSIGNED", nullable = false)
    private int stock_count;

    @Column(columnDefinition = "INT(10) UNSIGNED", nullable = false)
    private int coast;

    @Column(columnDefinition = "INT(10) UNSIGNED", nullable = false)
    private int price;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private int vendor_info;

    @Column(columnDefinition = "VARCHAR(45)", nullable = false)
    private int vendor_contact;

    @Enumerated (EnumType.STRING)
    @Column (columnDefinition = "ENUM('CAFE24', 'SELMATE', 'MAKESHOP', 'SMARTSTORE')")
    private OrderCrawlingInfo.PlatformType platform_type;
    private OrderCrawlingInfo.PlatformType platformType;

    @Column(columnDefinition = "INT(11)", nullable = false)
    @ColumnDefault("0")
    private int ws_order_count;

    @Column(columnDefinition = "INT(1) UNSIGNED", nullable = false)
    @ColumnDefault("0")
    private int wr_ordered;

    @Column(columnDefinition = "INT(1)")
    private int ws_order_auto;

    @Column(columnDefinition = "DATETIME", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime ws_order_date;

    @Column(columnDefinition = "TEXT")
    private String product_image;

    @Column(columnDefinition = "TINYTEXT")
    private String nemo;

    @Column(columnDefinition = "VARCHAR(100)")
    private String self_product_code;

    @Column(columnDefinition = "VARCHAR(255)")
    private String self_product_name;


    @Builder
    public OrderCrawlingResult(Long idx, Long membershipSeq) {
        this.idx = idx;
        this.membershipSeq = membershipSeq;
    }
}
