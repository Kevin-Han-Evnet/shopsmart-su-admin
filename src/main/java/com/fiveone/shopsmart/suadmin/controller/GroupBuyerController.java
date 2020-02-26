package com.fiveone.shopsmart.suadmin.controller;

import com.fiveone.shopsmart.suadmin.config.Config;
import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShip;
import com.fiveone.shopsmart.suadmin.dto.MemberShipRequestDto;
import com.fiveone.shopsmart.suadmin.dto.MemberShipResponseDto;
import com.fiveone.shopsmart.suadmin.dto.PageNavigationDto;
import com.fiveone.shopsmart.suadmin.service.MemberShipService;
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
public class GroupBuyerController {

    MemberShipService memberShipService;

    //그룹 - 사입자 그룹관리 페이지
    @GetMapping("/group_admin/ss_group_buyer_admin")
    public String ssGroupBuyerAdmin (@RequestParam(value = "page_num", required = false, defaultValue = "1") String page_num, Model model) {

        model.addAttribute("title", "Buyer admin | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-group");
        model.addAttribute("active_nav_label", "사입 업체 관리");
        model.addAttribute("active_nav_link", "#");


        long total_count = memberShipService.getCount(MemberShip.MembershipType.PURCHASE);
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);
        List<MemberShipResponseDto> items = memberShipService.findAllByType (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE, MemberShip.MembershipType.PURCHASE);

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);

        return "ss_group_buyer_admin";
    }

    //그룹 - 사입자 저장
    @PostMapping("/group_admin/ss_group_buyer_add")
    public String ssGroupBuyerAdd (MemberShipRequestDto dto, Model model) {
        memberShipService.save (dto);
        return "redirect:/group_admin/ss_group_buyer_admin";
    }

    //그룹 - 사입자 업데이트
    @PostMapping ("/group_admin/ss_group_buyer_update")
    public String ssGroupBuyerUpdate (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                      MemberShipRequestDto dto, Model model) {
        memberShipService.update (dto);
        return "redirect:/group_admin/ss_group_buyer_admin?page_num=" + page_num;
    }


    //그룹 - 사입자 삭제
    @PostMapping ("/group_admin/ss_group_buyer_delete")
    public String ssGroupBuyerDelete (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                      @RequestParam (value="target_seq") Long target_seq, Model model) {
        memberShipService.delete(target_seq);
        return "redirect:/group_admin/ss_group_buyer_admin?page_num=" + page_num;
    }

}
