package com.fiveone.shopsmart.suadmin.controller;

import com.fiveone.shopsmart.suadmin.config.Config;
import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.MemberShip;
import com.fiveone.shopsmart.suadmin.dto.MemberShipRequestDto;
import com.fiveone.shopsmart.suadmin.dto.MemberShipResponseDto;
import com.fiveone.shopsmart.suadmin.dto.PageNavigationDto;
import com.fiveone.shopsmart.suadmin.service.MemberShipExternalAccountsService;
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
public class GroupVendorController {

    private MemberShipService memberShipService;
    private MemberShipExternalAccountsService memberShipExternalAccountsService;

    //그룹 - 벤더 그룹관리 페이지
    @GetMapping("/group_admin/ss_group_vendor_admin")
    public String ssGroupVendorAdmin (@RequestParam(value = "page_num", required = false, defaultValue = "1") String page_num, Model model) {

        model.addAttribute("title", "Vendor admin | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-group");
        model.addAttribute("active_nav_label", "도매 업체 관리");
        model.addAttribute("active_nav_link", "#");


        long total_count = memberShipService.getCount(MemberShip.MembershipType.VENDOR);
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);
        List<MemberShipResponseDto> items = memberShipService.findAllByType (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE, MemberShip.MembershipType.VENDOR);

        for (MemberShipResponseDto item : items) {
            item.setExternalAccountsDtos(memberShipExternalAccountsService.findAllBySeq(item.getMembershipSeq()));
        }

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);


        return "ss_group_vendor_admin";
    }

    //그룹 - 벤더 그룹 추가
    @PostMapping("/group_admin/ss_group_vendor_add")
    public String ssGroupVendorAdd (MemberShipRequestDto dto, Model model) {
        memberShipService.save (dto);
        return "redirect:/group_admin/ss_group_vendor_admin";
    }


    //그룹 - 벤더 업데이트
    @PostMapping ("/group_admin/ss_group_vendor_update")
    public String ssGroupVendorUpdate (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                       MemberShipRequestDto dto, Model model) {
        memberShipService.update (dto);
        return "redirect:/group_admin/ss_group_vendor_admin?page_num=" + page_num;
    }


    //그룹 - 벤더 삭제
    @PostMapping ("/group_admin/ss_group_vendor_delete")
    public String ssGroupVendorDelete (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                       @RequestParam (value="target_seq") Long target_seq, Model model) {
        memberShipService.delete(target_seq);
        memberShipExternalAccountsService.deleteAll(target_seq);
        return "redirect:/group_admin/ss_group_vendor_admin?page_num=" + page_num;
    }

}
