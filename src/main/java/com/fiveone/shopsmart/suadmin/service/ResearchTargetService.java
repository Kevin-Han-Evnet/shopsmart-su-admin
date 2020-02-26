package com.fiveone.shopsmart.suadmin.service;

import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.ResearchTargetRepository;
import com.fiveone.shopsmart.suadmin.dto.ResearchTargetRequestDto;
import com.fiveone.shopsmart.suadmin.dto.ResearchTargetResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ResearchTargetService {

    private ResearchTargetRepository researchTargetRepository;

    @Transactional
    public long getCount () {
        return researchTargetRepository.count();
    }

    @Transactional
    public long getCount (Long target_seq) {
        return researchTargetRepository.count(target_seq);
    }


    @Transactional
    public List<ResearchTargetResponseDto> findAllByTargetSeq (Long target_seq, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("idx").descending());
        return researchTargetRepository.findAllByTargetSeq(pageRequest, target_seq)
                .map(ResearchTargetResponseDto::new).getContent();
    }

    //수정
    @Transactional
    public void update_np_carwling_reqeust (Long target_idx, int stat) {
        researchTargetRepository.update_np_carwling_reqeust (
                target_idx,
                stat
        );
    }

    //수정
    @Transactional
    public void update_event_carwling_reqeust (Long target_idx, int stat) {
        researchTargetRepository.update_event_carwling_reqeust (
                target_idx,
                stat
        );
    }


    @Transactional
    public void save (ResearchTargetRequestDto dto) {
        researchTargetRepository.save(dto.toEntity());
    }

    @Transactional
    public void delete (Long target_idx) {
        researchTargetRepository.deleteById(target_idx);
    }
}