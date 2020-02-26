package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.BaseTimeEntityForCommon;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="tb_membership")
public class MemberShip extends BaseTimeEntityForCommon {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "membership_seq", columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long membershipSeq;

    @Column(columnDefinition = "VARCHAR(50)")
    private String membership_nm;

    /* 회원사아이디(이름) */
    @Column(columnDefinition = "VARCHAR(20)")
    private String sid;

    /* 상호 */
    @Column(columnDefinition = "VARCHAR(50)")
    private String comp_nm;

    /* 댜표자이름 */
    @Column(columnDefinition = "VARCHAR(20)")
    private String ceo_nm;

    /* url */
    @Column(columnDefinition = "VARCHAR(255)")
    private String shop_url;

    /* 사업자등록번호 */
    @Column (columnDefinition = "VARCHAR(50)")
    private String tax_id;

    /* 우편번호 */
    @Column (columnDefinition = "VARCHAR(5)")
    private String post;

    /* 주소(상가) */
    @Column (columnDefinition = "VARCHAR(100)")
    private String address;

    /* 상세주소(층수) */
    @Column(columnDefinition = "VARCHAR(100)")
    private String address_detail;

    /* 호수 */
    @Column(columnDefinition = "VARCHAR(20)")
    private String address_number;

    /* 핸드폰번호 */
    @Column(columnDefinition = "VARCHAR(20)")
    private String phone;

    /* 이메일 */
    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    /* 그룹웨어,도매,소매,프로모션 */
    @Enumerated (EnumType.STRING)
    @Column (columnDefinition = "ENUM('SMART', 'VENDOR', 'RETAIL', 'AGENCY', 'PURCHASE')")
    private MembershipType type;
    public enum MembershipType {
        SMART,
        VENDOR,
        RETAIL,
        AGENCY,
        PURCHASE
    }

    /* 등록자 */
    @Column(columnDefinition = "VARCHAR(20)")
    private String reg_id;

    /* 수정자 */
    @Column(columnDefinition = "VARCHAR(20)")
    private String mod_id;

    /** 아래는 내가 집어넣은 컬럼 */
    @Column(columnDefinition = "INT(1) UNSIGNED", nullable = false)
    @ColumnDefault("0")
    private int is_vip;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String key_32;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String key_16;


    @Builder
    public MemberShip (
            Long membershipSeq,
            String membership_nm,
            String sid,
            String comp_nm,
            String ceo_nm,
            String shop_url,
            String tax_id,
            String post,
            String address,
            String address_detail,
            String address_number,
            String phone,
            String email,
            MembershipType type,
            String reg_id,
            String mod_id,
            int is_vip,
            String key_16,
            String key_32
    ) {
        this.membershipSeq = membershipSeq;
        this.membership_nm = membership_nm;
        this.sid = sid;
        this.comp_nm = comp_nm;
        this.ceo_nm = ceo_nm;
        this.shop_url = shop_url;
        this.tax_id = tax_id;
        this.post = post;
        this.address = address;
        this.address_detail = address_detail;
        this.address_number = address_number;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.reg_id = reg_id;
        this.mod_id = mod_id;
        this.is_vip = is_vip;
        this.key_16 = key_16;
        this.key_32 = key_32;
    }
}
