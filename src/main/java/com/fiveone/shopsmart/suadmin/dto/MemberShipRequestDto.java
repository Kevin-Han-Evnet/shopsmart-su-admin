package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShip;
import com.fiveone.shopsmart.suadmin.hash.KevinHash;
import lombok.Getter;
import org.hsqldb.lib.StringUtil;

import java.time.LocalDateTime;

@Getter
public class MemberShipRequestDto {

    private Long membershipSeq;
    private String membership_nm;
    private String sid;
    private String comp_nm;
    private String ceo_nm;
    private String shop_url;
    private String tax_id;
    private String post;
    private String address;
    private String address_detail;
    private String address_number;
    private String phone;
    private String email;
    private String type;
    private String reg_id;
    private String mod_id;
    private LocalDateTime reg_dt;
    private LocalDateTime mod_dt;
    private int is_vip;
    private String key_16;
    private String key_32;

    public MemberShipRequestDto(Long membershipSeq,
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
                                String type,
                                String reg_id,
                                String mod_id,
                                LocalDateTime reg_dt,
                                LocalDateTime mod_dt,
                                String is_vip) {
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
        this.reg_dt = reg_dt;
        this.mod_dt = mod_dt;
        this.is_vip = StringUtil.isEmpty(is_vip) ? 0 : 1;
    }

    public MemberShip toEntity () {
        return MemberShip.builder()
                .membershipSeq(membershipSeq)
                .membership_nm(membership_nm)
                .sid(sid)
                .comp_nm(comp_nm)
                .ceo_nm(ceo_nm)
                .shop_url(shop_url)
                .tax_id(tax_id)
                .post(post)
                .address(address)
                .address_detail(address_detail)
                .address_number(address_number)
                .phone(phone)
                .email(email)
                .type(MemberShip.MembershipType.valueOf(type))
                .reg_id(reg_id)
                .mod_id(mod_id)
                .is_vip(is_vip)
                .key_32(KevinHash.getKeyString(32))
                .key_16(KevinHash.getKeyString(16))
                .build();
    }

}

