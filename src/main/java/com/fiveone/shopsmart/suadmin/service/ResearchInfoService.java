package com.fiveone.shopsmart.suadmin.service;

import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.ResearchInfoRepository;
import com.fiveone.shopsmart.suadmin.dto.ResearchInfoRequestDto;
import com.fiveone.shopsmart.suadmin.dto.ResearchInfoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ResearchInfoService {

    private ResearchInfoRepository researchInfoRepository;

    @Transactional
    public long getCount () {
        return researchInfoRepository.count();
    }

    @Transactional
    public List<ResearchInfoResponseDto> findAllByPageRequest(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("idx").descending());
        return researchInfoRepository.findAll(pageRequest)
                .map(ResearchInfoResponseDto::new).getContent();
    }

    @Transactional
    public List<ResearchInfoResponseDto> findNPResearch() {
        return researchInfoRepository.findKNPesearch()
                .map(ResearchInfoResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public ResearchInfoResponseDto findIfExist (String base_url) {
        try {
            return researchInfoRepository.findIfExist(base_url)
                    .map(ResearchInfoResponseDto::new).get();
        } catch (NoSuchElementException e) {
            return new ResearchInfoResponseDto((long) 0);
        }
    }

    @Transactional
    public List<ResearchInfoResponseDto> findEventResearch() {
        return researchInfoRepository.findEventResearch()
                .map(ResearchInfoResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long save (ResearchInfoRequestDto dto) {
        return researchInfoRepository.save(dto.toEntity()).getIdx();
    }


    @Transactional
    public void update (ResearchInfoRequestDto dto) {
        researchInfoRepository.update(
                dto.getIdx(),
                dto.getTarget_name(),
                dto.getTarget_base_url(),
                dto.getNp_list_page(),
                dto.getNp_tag_selector(),
                dto.getNp_sub_tag_selector(),
                dto.getNp_img_tag_selector(),
                dto.getNp_not_nessesary_strings(),
                dto.getNp_code_name(),
                dto.getNp_crawling_stat(),
                dto.getNp_comment(),
                dto.getEvent_list_page(),
                dto.getEvent_tag_selector(),
                dto.getEvent_sub_tag_selector(),
                dto.getEvent_img_tag_selector(),
                dto.getEvent_code_name(),
                dto.getEvent_not_nessesary_strings(),
                dto.getEvent_crawling_stat(),
                dto.getEvent_comment(),
                dto.getCrawling_engine()
        );
    }

    //삭제
    @Transactional
    public void delete (Long target_idx) {
        researchInfoRepository.deleteById(target_idx);
    }
}