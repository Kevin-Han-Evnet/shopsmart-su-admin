package com.fiveone.shopsmart.suadmin.controller;

import com.fiveone.shopsmart.suadmin.config.Config;
import com.fiveone.shopsmart.suadmin.dto.*;
import com.fiveone.shopsmart.suadmin.service.EventResearchInfoService;
import com.fiveone.shopsmart.suadmin.service.NewProductResearchInfoService;
import com.fiveone.shopsmart.suadmin.service.ResearchInfoService;
import com.fiveone.shopsmart.suadmin.utils.WebControllerUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@AllArgsConstructor
@Controller
public class ResearchController {

    //리서치 - 리서치 타겟 정보
    private ResearchInfoService researchInfoService;

    @GetMapping("/research_admin/ss_research_info")
    public String ssResearchInfo (@RequestParam(value = "page_num", required = false, defaultValue = "1") String page_num, Model model) {

        model.addAttribute("title", "Research info admin | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-graph");
        model.addAttribute("active_nav_label", "리서치 정보 관리");
        model.addAttribute("active_nav_link", "#");


        long total_count = researchInfoService.getCount();
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);
        List<ResearchInfoResponseDto> items = researchInfoService.findAllByPageRequest (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE);

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);

        return "ss_research_info";
    }


    //리서치 - 리서치 타겟 등록
    @PostMapping("/research_admin/ss_research_info_add")
    public String ssResearchInfoAdd (ResearchInfoRequestDto dto, Model model) {

        String tBaseURL = (dto.getTarget_base_url().startsWith("http://")) ? dto.getTarget_base_url().substring(7)
                : (dto.getTarget_base_url().startsWith("https://")) ? dto.getTarget_base_url().substring(8)
                : dto.getTarget_base_url();

        String[] tmp = tBaseURL.split(".");
        if (tmp.length >= 2) {
            if (dto.getTarget_base_url().contains("co.kr") == true) {
                tBaseURL = tmp[tmp.length -3] + "." + tmp[tmp.length - 2] + "." + tmp[tmp.length - 1];
            } else {
                tBaseURL = tmp[tmp.length - 2] + "." + tmp[tmp.length - 1];
            }
        } else {
            //이럼 안됨...
        }

        //www도 빼자..
        if (tBaseURL.startsWith("www")) {
            tBaseURL = tBaseURL.substring(4);
        }

        ResearchInfoResponseDto existItem = researchInfoService.findIfExist(tBaseURL);

        if (existItem.getIdx() > 0) {
            //경고 ㅋㅋㅋ
        } else {
            dto.setTarget_base_url(tBaseURL);
            Long result = researchInfoService.save(dto);
        }
        return "redirect:/research_admin/ss_research_info";
    }

    //리서치 - 리서치 타겟 업데이트
    @PostMapping ("/research_admin/ss_research_info_update")
    public String ssResearchInfoUpdate (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                        ResearchInfoRequestDto dto, Model model) {
        researchInfoService.update (dto);
        return "redirect:/research_admin/ss_research_info?page_num=" + page_num;
    }

    //리서치 - 리서치 타겟 삭제
    @PostMapping ("/research_admin/ss_research_info_delete")
    public String ssResearchInfoDelete (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                        @RequestParam (value="target_idx") Long target_idx, Model model) {
        researchInfoService.delete(target_idx);
        return "redirect:/research_admin/ss_research_info?page_num=" + page_num;
    }


    //리서치 - 신상 리서치 결과
    private NewProductResearchInfoService newProductResearchInfoService;

    @GetMapping ("/research_admin/ss_np_crawling_result")
    public String ssNpCrawlingResult (
            @RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
            @RequestParam (value = "target_id", required = false, defaultValue = "0") String target_id,
            Model model) {

        model.addAttribute("active_nav_icon", "elusive icon-graph");
        model.addAttribute("active_nav_label", "신상 리서치 결과");
        model.addAttribute("active_nav_link", "#");

        model.addAttribute("cloud_front_url", Config.CLOUDE_FRONT_URL);

        Long tId = Long.valueOf(target_id);
        long total_count = 0;
        if (tId > 0) {
            total_count = newProductResearchInfoService.getCountByTargetId(tId);
        } else {
            total_count = newProductResearchInfoService.getCount();
        }
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);

        List<NewProductResearchInfoDto> items;
        if (tId > 0) {
            items = newProductResearchInfoService.findAllByTargetId (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE, tId);
        } else {
            items = newProductResearchInfoService.findAllByPageRequest (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE);
        }

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);
        model.addAttribute("target_list", researchInfoService.findNPResearch ());

        return "ss_np_crawling_result";
    }


    //리서치 - 이벤트 리서치 결과
    private EventResearchInfoService eventResearchInfoService;

    @GetMapping ("/research_admin/ss_event_crawling_result")
    public String ssEventCrawlingResult (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                         @RequestParam (value = "target_id", required = false, defaultValue = "0") String target_id,
                                         Model model) {

        model.addAttribute("active_nav_icon", "elusive icon-graph");
        model.addAttribute("active_nav_label", "이벤트 리서치 결과");
        model.addAttribute("active_nav_link", "#");

        model.addAttribute("cloud_front_url", Config.CLOUDE_FRONT_URL);

        Long tId = Long.valueOf(target_id);
        long total_count = 0;
        if (tId > 0) {
            total_count = eventResearchInfoService.getCountByTargetId(tId);
        } else {
            total_count = eventResearchInfoService.getCount();
        }
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);

        List<EventResearchInfoDto> items;
        if (tId > 0) {
            items = eventResearchInfoService.findAllByTargetId (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE, tId);
        } else {
            items = eventResearchInfoService.findAllByPageRequest (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE);
        }

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);
        model.addAttribute("target_list", researchInfoService.findNPResearch ());

        return "ss_event_crawling_result";
    }

}
