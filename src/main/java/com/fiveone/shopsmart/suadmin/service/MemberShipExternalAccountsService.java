package com.fiveone.shopsmart.suadmin.service;


import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.MemberShipExternalAccountsRepository;
import com.fiveone.shopsmart.suadmin.dto.MemberShipExternalAccountsResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MemberShipExternalAccountsService {

    private MemberShipExternalAccountsRepository memberShipExternalAccountsRepository;

    @Transactional
    public List<MemberShipExternalAccountsResponseDto> findAllBySeq (Long membershipSeq) {
        return memberShipExternalAccountsRepository.findAllBySeq (membershipSeq)
                .map(MemberShipExternalAccountsResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long findIdBySeq (Long membershipSeq) {
        return memberShipExternalAccountsRepository.findIdBySeq(membershipSeq);
    }

    /*
    //저장
    @Transactional
    public Long save (MemberShipOptionsRequestDto dto){
        return memberShipExternalAccountsRepository.save(dto.toEntity()).getMembershipSeq();
    }

    //수정
    @Transactional
    public void update (MemberShipOptionsRequestDto dto) {
        memberShipOptionsRepository.update(
                dto.getMembershipSeq(),
                dto.getIs_vip()
        );
    }
    */

    //삭제
    @Transactional
    public void deleteAll (Long target_seq) {
        memberShipExternalAccountsRepository.deleteAll(memberShipExternalAccountsRepository.findIdBySeq2(target_seq));
    }
}