package com.fiveone.shopsmart.suadmin.service;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.KeywordTrendResearchResult;
import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.KeywordTrendResearchResultRepository;
import com.fiveone.shopsmart.suadmin.dto.KeywordTrendResearchResultDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class KeywordTrendResearchResultService {

    private KeywordTrendResearchResultRepository keywordTrendResearchInfoRepository;

    @Transactional
    public long getCount () {
        return keywordTrendResearchInfoRepository.count();
    }


    @Transactional
    public List<KeywordTrendResearchResultDto> findAllByPageRequest(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("idx").descending());
        return keywordTrendResearchInfoRepository.findAll(pageRequest)
                .map(KeywordTrendResearchResultDto::new).getContent();
    }

    @Transactional
    public KeywordTrendResearchResultDto findOneByIdx (Long crawling_info_idx) {
        KeywordTrendResearchResult tmp = keywordTrendResearchInfoRepository.findOneByIdx (crawling_info_idx);
        if (tmp != null) {
            return new KeywordTrendResearchResultDto(tmp);
        } else {
            return new KeywordTrendResearchResultDto();
        }
    }

}