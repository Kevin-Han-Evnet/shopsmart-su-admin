package com.fiveone.shopsmart.suadmin.service;

import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.NewProductResearchInfoRepository;
import com.fiveone.shopsmart.suadmin.dto.NewProductResearchInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class NewProductResearchInfoService {

    private NewProductResearchInfoRepository newProductResearchInfoRepository;

    @Transactional
    public long getCount () {
        return newProductResearchInfoRepository.count();
    }

    @Transactional
    public long getCountByTargetId (Long target_id) {
        return newProductResearchInfoRepository.countByTargetId(target_id);
    }

    @Transactional
    public List<NewProductResearchInfoDto> findAllByPageRequest(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("idx").descending());
        return newProductResearchInfoRepository.findAll(pageRequest)
                .map(NewProductResearchInfoDto::new)
                .getContent();
    }

    @Transactional
    public List<NewProductResearchInfoDto> findAllByTargetId(Integer page, Integer size, Long target_id) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("idx").descending());
        return newProductResearchInfoRepository.findAllByTargetId(pageRequest, target_id)
                .map(NewProductResearchInfoDto::new)
                .getContent();
    }

}