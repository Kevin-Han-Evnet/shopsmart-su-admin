package com.fiveone.shopsmart.suadmin.utils;

import com.fiveone.shopsmart.suadmin.config.Config;
import com.fiveone.shopsmart.suadmin.dto.PageNavigationDto;

import java.util.ArrayList;
import java.util.List;

public class WebControllerUtil {

    public static List<PageNavigationDto> getPageNavigation (int page_num, int total_page_count) {
        List<PageNavigationDto> pageInfo = new ArrayList<>();
        String class_name;


        String prev_class_name = (page_num > 1) ? "" : "disabled";
        int prev_page_num = page_num - 1;
        if (prev_page_num < 1) prev_page_num = 1;

        String next_class_name = (page_num <= total_page_count) ? "" : "disabled";
        int next_page_num = page_num + 1;
        if (next_page_num > total_page_count + 1) next_page_num = total_page_count + 1;

        int start = page_num - 3;
        if (start < 0) start = 0;
        int end = start + Config.PAGE_RANGE;
        if (end > total_page_count + 1) {
            end = total_page_count + 1;
            start = (end - Config.PAGE_RANGE >= 0) ? end - Config.PAGE_RANGE : 0;
        }

        //이전 버튼용
        pageInfo.add(new PageNavigationDto(prev_page_num, "", prev_class_name, "elusive icon-arrow-left"));

        for (int i = start; i < end; i++) {
            class_name = (page_num - 1 == i) ? "active" : "";
            pageInfo.add(new PageNavigationDto(i + 1, String.valueOf(i + 1), class_name, ""));
        }
        //다음 버튼용
        pageInfo.add(new PageNavigationDto(next_page_num, "", next_class_name, "elusive icon-arrow-right"));
        pageInfo.add(new PageNavigationDto(0, "", "invisible", "")); /** 이상하게 스타일시트가 깨지는거 방지용 -ㅁ-;; */

        return pageInfo;
    }

}
