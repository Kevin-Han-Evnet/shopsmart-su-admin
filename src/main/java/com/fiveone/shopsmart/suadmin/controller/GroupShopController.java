package com.fiveone.shopsmart.suadmin.controller;

import com.fiveone.shopsmart.suadmin.config.Config;
import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShip;
import com.fiveone.shopsmart.suadmin.dto.*;
import com.fiveone.shopsmart.suadmin.service.*;
import com.fiveone.shopsmart.suadmin.utils.WebControllerUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class GroupShopController {

    private MemberShipService memberShipService;

    @GetMapping("/group_admin/ss_group_shop_admin")
    public String ssGroupShopAdmin (@RequestParam(value = "page_num", required = false, defaultValue = "1") String page_num, Model model) {

        model.addAttribute("title", "Shop admin | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-group");
        model.addAttribute("active_nav_label", "그룹웨어 업체 관리");
        model.addAttribute("active_nav_link", "#");

        long total_count = memberShipService.getCount(MemberShip.MembershipType.SMART);
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);
        List<MemberShipResponseDto> items = memberShipService.findAllByType (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE, MemberShip.MembershipType.SMART);

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);

        return "ss_group_shop_admin";
    }

    //그룹 - 업체 등록
    @PostMapping("/group_admin/ss_group_shop_add")
    public String ssGroupShopAdd (MemberShipRequestDto dto, Model model) {
        Long result = memberShipService.save (dto);
        return "redirect:/group_admin/ss_group_shop_admin";
    }

    //그룹 - 업체 업데이트
    @PostMapping ("/group_admin/ss_group_shop_update")
    public String ssGroupShopUpdate (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                     MemberShipRequestDto dto, Model model) {
        memberShipService.update (dto);
        return "redirect:/group_admin/ss_group_shop_admin?page_num=" + page_num;
    }

    //그룹 - 업체 삭제
    @PostMapping ("/group_admin/ss_group_shop_delete")
    public String ssGroupShopDelete (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                     @RequestParam (value="target_seq") Long target_seq, Model model) {
        memberShipService.delete(target_seq);
        return "redirect:/group_admin/ss_group_shop_admin?page_num=" + page_num;
    }


    //리서치 - 키워드 트렌드 리서치 결과
    private KeywordTrendResearchInfoService keywordTrendResearchInfoService;
    private KeywordTrendResearchResultService keywordTrendResearchResultService;

    @GetMapping ("/group_admin/ss_kt_crawling_result")
    public String ssKtCrawlingResult (@RequestParam (value = "target_seq") String target_seq, Model model) {

        model.addAttribute("title", "Keyword trend research admin | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-group");
        model.addAttribute("active_nav_label", "그룹웨어 업체 관리");
        model.addAttribute("active_nav_link", "/group_admin/ss_group_shop_admin");

        KeywordTrendResearchInfoResponseDto research_info = keywordTrendResearchInfoService.findKeywordTrendSearchInfo (Long.valueOf(target_seq));
        KeywordTrendResearchResultDto research_result = keywordTrendResearchResultService.findOneByIdx (research_info.getIdx());

        model.addAttribute("research_info", research_info);
        model.addAttribute("research_result", research_result);

        return "ss_kt_chart_view";
    }

    //키워드 트렌드 검색조건 저장
    @PostMapping("/group_admin/ss_kt_crawling_info_add")
    public String ssKtCrawlingInfoAdd (@RequestParam (name = "target_seq") String target_seq,
                                       KeywordTrendResearchInfoRequestDto dto,
                                       Model model) {

        keywordTrendResearchInfoService.save (dto);

        return "redirect:/group_admin/ss_kt_crawling_result?target_seq=" + target_seq;
    }

    //키워드 트렌드 검색조건 업데이트
    @PostMapping("/group_admin/ss_kt_crawling_info_update")
    public String ssKtCrawlingInfoUpdate (@RequestParam (name = "target_seq") String target_seq,
                                          KeywordTrendResearchInfoRequestDto dto,
                                          Model model) {

        keywordTrendResearchInfoService.update (dto);

        return "redirect:/group_admin/ss_kt_crawling_result?target_seq=" + target_seq;
    }


    private ResearchTargetService researchTargetService;
    private ResearchInfoService researchInfoService;

    //리서치 신청 현황
    @GetMapping("/group_admin/ss_shop_research_admin")
    public String ssShopResearchAdmin (@RequestParam (name = "target_seq") String target_seq,
                                       @RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                       Model model) {

        model.addAttribute("title", "Shop research request admin | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-group");
        model.addAttribute("active_nav_label", "그룹웨어 업체 관리");
        model.addAttribute("active_nav_link", "/group_admin/ss_group_shop_admin");

        model.addAttribute("is_vip", memberShipService.findById(Long.valueOf(target_seq)).getIs_vip());

        long total_count = researchTargetService.getCount(Long.valueOf(target_seq));
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);
        List<ResearchTargetResponseDto> items = researchTargetService.findAllByTargetSeq (Long.valueOf(target_seq), Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE);

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);

        return "ss_shop_research_admin";
    }

    //리서치 신청
    @PostMapping("/group_admin/ss_shop_research_add")
    public String ssShopResearchAdd (ResearchTargetRequestDto dto) {


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
        Long savedidx;
        if (existItem.getIdx() > 0) {
            savedidx = existItem.getIdx();
        } else {
            ResearchInfoRequestDto newItem = new ResearchInfoRequestDto ();
            newItem.setTarget_name("UNTITLED");
            newItem.setTarget_base_url(tBaseURL);
            savedidx = researchInfoService.save(newItem);
        }

        dto.setResearch_info_idx(savedidx);
        researchTargetService.save(dto);

        return "redirect:/group_admin/ss_shop_research_admin?target_seq=" + dto.getMembershipSeq();
    }


    //리서치 신청 현황 업데이트
    @GetMapping("/group_admin/ss_shop_research_update")
    public String ssShopResearchUpdate (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                        @RequestParam (value = "target_seq") String target_seq,
                                        @RequestParam (value = "target_idx") String target_idx,
                                        @RequestParam (value = "request") String request,
                                        @RequestParam (value = "stat") String stat,
                                        Model model) {


        if (request.equals("np")) {
            researchTargetService.update_np_carwling_reqeust(Long.valueOf(target_idx), Integer.valueOf(stat));
        } else if (request.equals("event")) {
            researchTargetService.update_event_carwling_reqeust (Long.valueOf(target_idx), Integer.valueOf(stat));
        }

        return "redirect:/group_admin/ss_shop_research_admin?target_seq=" + target_seq + "&page_num=" + page_num;
    }


    //리서치 신청 현황 삭제
    @PostMapping("/group_admin/ss_shop_research_delete")
    public String ssShopResearchDelete (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                        @RequestParam (value="target_seq") Long target_seq,
                                        @RequestParam (value="target_idx") Long target_idx,
                                        Model model) {
        researchTargetService.delete(target_idx);
        return "redirect:/group_admin/ss_shop_research_admin?target_seq=" + target_seq + "&page_num=" + page_num;
    }
}
