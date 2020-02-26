package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShipExternalAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface MemberShipExternalAccountsRepository extends JpaRepository<MemberShipExternalAccounts, Long> {

    @Query(value = "SELECT m FROM MemberShipExternalAccounts m WHERE m.membershipSeq=:membershipSeq")
    Stream<MemberShipExternalAccounts> findAllBySeq (@Param("membershipSeq") Long membershipSeq);

    @Query(value = "SELECT m.idx FROM MemberShipExternalAccounts m WHERE m.membershipSeq=:membershipSeq")
    Long findIdBySeq (@Param("membershipSeq") Long membershipSeq);

    @Query(value = "SELECT m FROM MemberShipExternalAccounts m WHERE m.membershipSeq=:membershipSeq")
    Iterable<MemberShipExternalAccounts> findIdBySeq2 (@Param("membershipSeq") Long membershipSeq);

}
