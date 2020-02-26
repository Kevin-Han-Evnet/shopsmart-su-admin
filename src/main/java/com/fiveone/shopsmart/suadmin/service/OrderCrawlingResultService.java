package com.fiveone.shopsmart.suadmin.service;

import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new.OrderCrawlingResultRepository;
import com.fiveone.shopsmart.suadmin.dto.OrderCountReportDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderCrawlingResultService {

    private OrderCrawlingResultRepository orderCrawlingResultRepository;

    @Transactional
    public long getCount () {
        return orderCrawlingResultRepository.count();
    }


    @Transactional
    public long getCountByTargetId (Long target_id) {
        return orderCrawlingResultRepository.countByTargetId(target_id);
    }

    @Transactional
    public OrderCountReportDto getOrderInfoByTargetId (Long target_id) {
        return orderCrawlingResultRepository.getOrderInfoByTargetId(target_id).map(result -> new OrderCountReportDto(result))
                .collect(Collectors.toList()).get(0);
    }
}
