package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShip;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Getter
public class MemberShipResponseDto {

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
    private MemberShip.MembershipType type;
    private String reg_id;
    private String mod_id;
    private LocalDateTime reg_dt;
    private LocalDateTime mod_dt;
    private int is_vip;
    private String key_16;
    private String key_32;
    private List<MemberShipExternalAccountsResponseDto> extAccountsDtos;


    public MemberShipResponseDto(MemberShip entity) {
        this.membershipSeq = entity.getMembershipSeq();
        this.membership_nm = entity.getMembership_nm();
        this.sid = entity.getSid();
        this.comp_nm = entity.getComp_nm();
        this.ceo_nm = entity.getCeo_nm();
        this.shop_url = entity.getShop_url();
        this.tax_id = entity.getTax_id();
        this.post = entity.getPost();
        this.address = entity.getAddress();
        this.address_detail = entity.getAddress_detail();
        this.address_number = entity.getAddress_number();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
        this.type = entity.getType();
        this.reg_id = entity.getReg_id();
        this.mod_id = entity.getMod_id();
        this.reg_dt = entity.getReg_dt();
        this.mod_dt = entity.getMod_dt();
        this.is_vip = entity.getIs_vip();
        this.key_16 = entity.getKey_16();
        this.key_32 = entity.getKey_32();
    }

    /** 연동되는 외부계정 리스트
     *
     */
    public void setExternalAccountsDtos (List<MemberShipExternalAccountsResponseDto> dto) {
        extAccountsDtos = dto;
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }


}

