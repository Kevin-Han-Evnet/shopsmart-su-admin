package com.fiveone.shopsmart.suadmin.service;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.KeywordTrendResearchInfo;
import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.KeywordTrendResearchInfoRepository;
import com.fiveone.shopsmart.suadmin.dto.KeywordTrendResearchInfoRequestDto;
import com.fiveone.shopsmart.suadmin.dto.KeywordTrendResearchInfoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class KeywordTrendResearchInfoService {

    private KeywordTrendResearchInfoRepository keywordTrendResearchInfoRepository;

    @Transactional
    public KeywordTrendResearchInfoResponseDto findKeywordTrendSearchInfo(Long target_seq) {

        Optional<KeywordTrendResearchInfo> result = keywordTrendResearchInfoRepository.findKeywordTrendSearchInfo(target_seq);

        try {
            return result.map(KeywordTrendResearchInfoResponseDto::new).get();
        } catch (NoSuchElementException e) {
            return new KeywordTrendResearchInfoResponseDto();
        }

    }

    @Transactional
    public Long save (KeywordTrendResearchInfoRequestDto dto) {
        return keywordTrendResearchInfoRepository.save(dto.toEntity()).getIdx();
    }


    @Transactional
    public void update (KeywordTrendResearchInfoRequestDto dto) {
        keywordTrendResearchInfoRepository.update (
                dto.getIdx(),
                dto.getKeyword_group_1(),
                dto.getKeywords_1(),
                dto.getKeyword_group_2(),
                dto.getKeywords_2(),
                dto.getKeyword_group_3(),
                dto.getKeywords_3(),
                dto.getKeyword_group_4(),
                dto.getKeywords_4(),
                dto.getKeyword_group_5(),
                dto.getKeywords_5(),
                dto.getPeriod(),
                KeywordTrendResearchInfo.TimeUnit.valueOf(dto.getTimeUnit()),
                KeywordTrendResearchInfo.Device.valueOf(dto.getDevice()),
                KeywordTrendResearchInfo.Gender.valueOf(dto.getGender()),
                dto.getAge(),
                dto.getKeyword_trend_crawling_stat()
        );
    }
}
