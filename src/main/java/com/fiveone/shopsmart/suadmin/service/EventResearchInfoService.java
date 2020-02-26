package com.fiveone.shopsmart.suadmin.service;

import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.EventResearchInfoRepository;
import com.fiveone.shopsmart.suadmin.dto.EventResearchInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class EventResearchInfoService {

    private EventResearchInfoRepository eventResearchInfoRepository;

    @Transactional
    public long getCount () {
        return eventResearchInfoRepository.count();
    }

    @Transactional
    public long getCountByTargetId (Long target_id) {
        return eventResearchInfoRepository.countByTargetId(target_id);
    }

    @Transactional
    public List<EventResearchInfoDto> findAllByPageRequest(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("idx").descending());
        return eventResearchInfoRepository.findAll(pageRequest)
                .map(EventResearchInfoDto::new).getContent();
    }

    @Transactional
    public List<EventResearchInfoDto> findAllByTargetId(Integer page, Integer size, Long target_id) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("idx").descending());
        return eventResearchInfoRepository.findAllByTargetId(pageRequest, target_id)
                .map(EventResearchInfoDto::new)
                .getContent();
    }

}