package com.fiveone.shopsmart.suadmin.service;


import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShip;
import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.MemberShipRepository;
import com.fiveone.shopsmart.suadmin.dto.MemberShipRequestDto;
import com.fiveone.shopsmart.suadmin.dto.MemberShipResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class MemberShipService {

    private MemberShipRepository memberShipRepository;

    @Transactional
    public long getCount (MemberShip.MembershipType type) {
        return memberShipRepository.count(type);
    }

    @Transactional
    public List<MemberShipResponseDto> findAllByPageRequest(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("membershipSeq").descending());
        return memberShipRepository.findAll(pageRequest)
                .map(MemberShipResponseDto::new).getContent();
    }



    @Transactional
    public MemberShipResponseDto findById (Long target_seq) {

        return memberShipRepository.findById(target_seq)
                .map(MemberShipResponseDto::new).get();
    }

    @Transactional
    public List<MemberShipResponseDto> findAllByType (Integer page, Integer size, MemberShip.MembershipType type) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("membershipSeq").descending());
        return memberShipRepository.findAllByType(pageRequest, type)
                .map(MemberShipResponseDto::new).getContent();
    }

    //저장
    @Transactional
    public Long save (MemberShipRequestDto dto){
        return memberShipRepository.save(dto.toEntity()).getMembershipSeq();
    }

    //수정
    @Transactional
    public void update (MemberShipRequestDto dto) {
        memberShipRepository.update(
                dto.getMembershipSeq(),
                dto.getComp_nm(),
                dto.getCeo_nm(),
                dto.getShop_url(),
                dto.getTax_id(),
                dto.getPost(),
                dto.getAddress(),
                dto.getAddress_detail(),
                dto.getAddress_number(),
                dto.getPhone(),
                dto.getEmail(),
                MemberShip.MembershipType.valueOf(dto.getType()),
                dto.getMod_id(),
                dto.getIs_vip()
        );
    }

    //수정
    @Transactional
    public void update_hash (Long target_seq, String key_32, String key_16) {
        memberShipRepository.update_hash (
                target_seq,
                key_32,
                key_16
        );
    }

    //삭제
    @Transactional
    public void delete (Long target_seq) {
        memberShipRepository.deleteById(target_seq);
    }
}