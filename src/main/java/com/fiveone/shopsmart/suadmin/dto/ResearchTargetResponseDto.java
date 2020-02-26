package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.ResearchTarget;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class ResearchTargetResponseDto {

    private Long idx;
    private Long research_info_idx;
    private Long membershipSeq;
    private int np_crawling;
    private int event_crawling;
    private ResearchInfoResponseDto researchInfo;

    public ResearchTargetResponseDto(ResearchTarget entity) {
        idx = entity.getIdx();
        research_info_idx = entity.getResearch_info_idx();
        membershipSeq = entity.getMembershipSeq();
        np_crawling = entity.getNp_crawling();
        event_crawling = entity.getEvent_crawling();
        researchInfo = new ResearchInfoResponseDto(entity.getResearchInfo());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

}

