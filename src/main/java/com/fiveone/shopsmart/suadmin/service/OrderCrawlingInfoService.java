package com.fiveone.shopsmart.suadmin.service;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.OrderCrawlingInfo;
import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.OrderCrawlingInfoRepository;
import com.fiveone.shopsmart.suadmin.dto.OrderCrawlingInfoRequestDto;
import com.fiveone.shopsmart.suadmin.dto.OrderCrawlingInfoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderCrawlingInfoService {

    private OrderCrawlingInfoRepository orderCrawlingInfoRepository;

    @Transactional
    public long getCount () {
        return orderCrawlingInfoRepository.count();
    }

    @Transactional
    public long getCountByTargetId (Long target_id) {
        return orderCrawlingInfoRepository.countByTargetId(target_id);
    }

    @Transactional
    public List<OrderCrawlingInfoResponseDto> findAllByPageRequest(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("idx").descending());
        return orderCrawlingInfoRepository.findAll(pageRequest)
                .map(OrderCrawlingInfoResponseDto::new)
                .getContent();
    }

    @Transactional
    public List<OrderCrawlingInfoResponseDto> findAllByTargetId(Integer page, Integer size, Long target_seq) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("idx").descending());
        return orderCrawlingInfoRepository.findAllByTargetId(pageRequest, target_seq)
                .map(OrderCrawlingInfoResponseDto::new)
                .getContent();
    }

    //저장
    @Transactional
    public Long save (OrderCrawlingInfoRequestDto dto){
        return orderCrawlingInfoRepository.save(dto.toEntity()).getMembershipSeq();
    }

    //수정
    @Transactional
    public void update (OrderCrawlingInfoRequestDto dto) {
        orderCrawlingInfoRepository.update(
                dto.getIdx(),
                OrderCrawlingInfo.PlatformType.valueOf(dto.getPlatform_type()),
                dto.getAccount_type(),
                dto.getPlatform_id(),
                dto.getLogin_url(),
                dto.getUser_id_k(),
                dto.getUser_pwd(),
                dto.getDisabled()
        );
    }

    //수정 -- 스탯
    @Transactional
    public void update_stat (Long target_idx, int disabled) {
        orderCrawlingInfoRepository.update_stat (target_idx, disabled);
    }

    //삭제
    @Transactional
    public void delete (Long target_idx) {
        orderCrawlingInfoRepository.deleteById(target_idx);
    }

}
