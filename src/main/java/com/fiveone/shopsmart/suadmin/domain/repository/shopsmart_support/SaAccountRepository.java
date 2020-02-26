package com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_support;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_support.SaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SaAccountRepository extends JpaRepository<SaAccount, Long> {


    Optional<SaAccount> findByEmail(String userEmail);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE SaAccount m set " +
            "m.email=:email, " +
            "m.name=:name" +
            " WHERE m.idx=:idx")
    void update (
            @Param("idx") Long idx,
            @Param("email") String email,
            @Param("name") String name
    );

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE SaAccount m set " +
            "m.password=:password" +
            " WHERE m.idx=:idx")
    void update_password (
            @Param("idx") Long idx,
            @Param("password") String password
    );

}
