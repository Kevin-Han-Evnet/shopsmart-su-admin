package com.fiveone.shopsmart.suadmin.controller;

import com.fiveone.shopsmart.suadmin.config.Config;
import com.fiveone.shopsmart.suadmin.dto.MemberShipResponseDto;
import com.fiveone.shopsmart.suadmin.dto.OrderCrawlingInfoRequestDto;
import com.fiveone.shopsmart.suadmin.dto.OrderCrawlingInfoResponseDto;
import com.fiveone.shopsmart.suadmin.dto.PageNavigationDto;
import com.fiveone.shopsmart.suadmin.hash.KevinHash;
import com.fiveone.shopsmart.suadmin.service.MemberShipService;
import com.fiveone.shopsmart.suadmin.service.OrderCrawlingInfoService;
import com.fiveone.shopsmart.suadmin.service.OrderCrawlingResultService;
import com.fiveone.shopsmart.suadmin.utils.WebControllerUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@AllArgsConstructor
@Controller
public class OrderCrawlerContreller {


    private OrderCrawlingInfoService orderCrawlingInfoservice;
    private OrderCrawlingResultService orderCrawlingResultService;
    private MemberShipService memberShipService;


    //업체 주문서 수집정보 관리
    @GetMapping("/group_admin/ss_order_crawling_info_admin")
    public String ssOrderCrawlingInfoAdmin (@RequestParam(value = "page_num", required = false, defaultValue = "1") String page_num,
                                            @RequestParam (value="target_seq") Long target_seq, Model model) {

        model.addAttribute("title", "Order sheet crawler admin | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-group");
        model.addAttribute("active_nav_label", "그룹웨어 업체 관리");
        model.addAttribute("active_nav_link", "/group_admin/ss_group_shop_admin");

        Long tId = Long.valueOf(target_seq);
        long total_count = orderCrawlingInfoservice.getCountByTargetId(tId);
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);

        List<OrderCrawlingInfoResponseDto> items = orderCrawlingInfoservice.findAllByTargetId (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE, tId);

        for (OrderCrawlingInfoResponseDto item: items) {
            item.setOrderCountInfo(orderCrawlingResultService.getOrderInfoByTargetId(item.getIdx()));
        }

        MemberShipResponseDto memberShipResponseDto = memberShipService.findById(target_seq);

        for (OrderCrawlingInfoResponseDto item : items) {
            try {
                item.setUser_pwd(KevinHash.getUnHashedPassword(memberShipResponseDto.getKey_32(), memberShipResponseDto.getKey_16(), item.getUser_pwd()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);

        return "ss_order_crawling_info_admin";

    }

    //업체 주문서 수집정보 저장
    @PostMapping("/group_admin/ss_order_crawling_info_add")
    public String ssOrderCrawlingInfoAdd (OrderCrawlingInfoRequestDto dto, Model model) {

        MemberShipResponseDto memberShipResponseDto = memberShipService.findById(dto.getMembershipSeq());

        //뭥미... ;;;;
        String fuckingPWD = "";
        try {
            fuckingPWD = KevinHash.getHashedPassword(memberShipResponseDto.getKey_32(), memberShipResponseDto.getKey_16(), dto.getUser_pwd());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        dto.setUser_pwd(fuckingPWD);
        Long result = orderCrawlingInfoservice.save (dto);

        return "redirect:/group_admin/ss_order_crawling_info_admin?target_seq=" + dto.getMembershipSeq();
    }

    //그룹 - 주문서 수집정보 업데이트
    @PostMapping ("/group_admin/ss_order_crawling_info_update")
    public String ssOrderCrawlingInfoUpdate (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                     OrderCrawlingInfoRequestDto dto, Model model) {

        MemberShipResponseDto memberShipResponseDto = memberShipService.findById(dto.getMembershipSeq());

        //뭥미... ;;;;
        String fuckingPWD = "";
        try {
            fuckingPWD = KevinHash.getHashedPassword(memberShipResponseDto.getKey_32(), memberShipResponseDto.getKey_16(), dto.getUser_pwd());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        dto.setUser_pwd(fuckingPWD);
        orderCrawlingInfoservice.update (dto);

        return "redirect:/group_admin/ss_order_crawling_info_admin?page_num=" + page_num + "&target_seq=" + dto.getMembershipSeq();
    }

    //그룹 - 주문서 수집정보 업데이트 -- 수집/수집중지 여부
    @GetMapping ("/group_admin/ss_order_crawling_stat_update")
    public String ssOrderCrawlingStatUpdate (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                             @RequestParam (value = "target_idx") String target_idx,
                                             @RequestParam (value = "target_seq") String target_seq,
                                             @RequestParam (value = "disabled") String disabled, Model model) {


        orderCrawlingInfoservice.update_stat (Long.valueOf(target_idx), Integer.valueOf(disabled));

        return "redirect:/group_admin/ss_order_crawling_info_admin?page_num=" + page_num + "&target_seq=" + target_seq;
    }

    //그룹 - 주문서 수집정보 삭제
    @PostMapping ("/group_admin/ss_order_crawling_info_delete")
    public String ssOrderCrawlingInfoDelete (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                     @RequestParam (value="target_idx") Long target_idx,
                                     @RequestParam (value="target_seq") Long target_seq, Model model) {
        orderCrawlingInfoservice.delete(target_idx);
        return "redirect:/group_admin/ss_order_crawling_info_admin?page_num=" + page_num + "&target_seq=" + target_seq;
    }

}
