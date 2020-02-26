package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MemberShipRepository extends JpaRepository<MemberShip, Long> {


    /** 타입별로 카운팅 **/
    @Transactional
    @Query (value = "SELECT COUNT(m) FROM MemberShip m WHERE m.type=:type")
    Long count (@Param("type") MemberShip.MembershipType type);


    /** 타입별로 찾아봅시당 */
    @Transactional
    @Query (value = "SELECT m FROM MemberShip m WHERE m.type=:type ORDER BY m.membershipSeq DESC")
    Page<MemberShip> findAllByType(
            @Param("pageable") Pageable pageable,
            @Param("type") MemberShip.MembershipType type
    );


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE MemberShip m SET m.comp_nm=:comp_nm, m.ceo_nm=:ceo_nm, m.shop_url=:shop_url, m.tax_id=:tax_id, m.post=:post, m.address=:address, " +
            "m.address_detail=:address_detail, m.address_number=:address_number, m.phone=:phone, m.email=:email, m.type=:type, m.mod_id=:mod_id, m.is_vip=:is_vip" +
            " WHERE m.membershipSeq=:membershipSeq")
    void update (@Param("membershipSeq") Long membershipSeq,
                 @Param("comp_nm") String comp_nm,
                 @Param("ceo_nm") String ceo_nm,
                 @Param("shop_url") String shop_url,
                 @Param("tax_id") String tax_id,
                 @Param("post") String post,
                 @Param("address") String address,
                 @Param("address_detail") String address_detail,
                 @Param("address_number") String address_number,
                 @Param("phone") String phone,
                 @Param("email") String email,
                 @Param("type") MemberShip.MembershipType type,
                 @Param("mod_id") String mod_id,
                 @Param("is_vip") int is_vip
    );

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE MemberShip m SET m.key_32=:key_32, m.key_16=:key_16 WHERE m.membershipSeq=:membershipSeq")
    void update_hash (@Param("membershipSeq") Long membershipSeq,
                      @Param("key_32") String key_32,
                      @Param("key_16") String key_16
    );


}
