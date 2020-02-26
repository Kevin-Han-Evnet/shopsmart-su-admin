package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.ResearchTarget;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResearchTargetRequestDto {

    private Long idx;
    private Long research_info_idx;
    private Long membershipSeq;
    private int np_crawling;
    private int event_crawling;
    private String target_base_url;

    public ResearchTargetRequestDto(
            Long idx,
            Long membershipSeq,
            int np_crawling,
            int event_crawling,
            String target_base_url
    ) {

        this.idx = idx;
        this.membershipSeq = membershipSeq;
        this.np_crawling = np_crawling;
        this.event_crawling = event_crawling;
        this.target_base_url = target_base_url;
    }

    public ResearchTarget toEntity () {
        return ResearchTarget.builder()
                .idx(idx)
                .research_info_idx(research_info_idx)
                .membershipSeq(membershipSeq)
                .np_crawling(np_crawling)
                .event_crawling(event_crawling)
                .build();
    }

}

