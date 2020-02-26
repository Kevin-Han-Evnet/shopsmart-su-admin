package com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_crl_resultch_target")
public class ResearchTarget {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long idx;

    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long research_info_idx;

    @Column(name = "membership_seq", columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long membershipSeq;

    @Column(columnDefinition = "INT(1)", nullable = false)
    @ColumnDefault("1")
    private int np_crawling;

    @Column(columnDefinition = "INT(1)", nullable = false)
    @ColumnDefault("0")
    private int event_crawling;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "research_info_idx", updatable = false, insertable = false)
    private ResearchInfo researchInfo;

    @Builder
    public ResearchTarget(
            Long idx,
            Long research_info_idx,
            Long membershipSeq,
            int np_crawling,
            int event_crawling
    ) {
        this.idx = idx;
        this.research_info_idx = research_info_idx;
        this.membershipSeq = membershipSeq;
        this.np_crawling = np_crawling;
        this.event_crawling = event_crawling;
    }
}
