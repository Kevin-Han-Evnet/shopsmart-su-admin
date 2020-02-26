package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_crl_order_info")
public class OrderCrawlingInfo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(name = "membership_seq", columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long membershipSeq;

    @Enumerated (EnumType.STRING)
    @Column (columnDefinition = "ENUM('CAFE24', 'SELMATE', 'MAKESHOP', 'SMARTSTORE')")
    private PlatformType platform_type;
    public enum PlatformType {
        CAFE24 {
            @Override
            public String toString() {
                return "카페24";
            }
        },
        SELMATE {
            @Override
            public String toString() {
                return "셀메이트";
            }
        },
        MAKESHOP {
            @Override
            public String toString() {
                return "메이크샵";
            }
        },
        SMARTSTORE {
            @Override
            public String toString() {
                return "스토어팜";
            }
        }
    }

    @Column(columnDefinition = "INT(1) UNSIGNED", nullable = false)
    @ColumnDefault("0")
    private int account_type;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String platform_id;

    @Column(columnDefinition = "TEXT")
    private String login_url;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String user_id_k;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String user_pwd;


    @Column(columnDefinition = "INT(1) UNSIGNED", nullable = false)
    private int disabled;




    @Builder
    public OrderCrawlingInfo (Long idx, Long membershipSeq, PlatformType platform_type, int account_type, String platform_id, String login_url, String user_id_k, String user_pwd, int disabled) {
        this.idx = idx;
        this.membershipSeq = membershipSeq;
        this.platform_type = platform_type;
        this.account_type = account_type;
        this.platform_id = platform_id;
        this.login_url = login_url;
        this.user_id_k = user_id_k;
        this.user_pwd = user_pwd;
        this.disabled = disabled;
    }
}
