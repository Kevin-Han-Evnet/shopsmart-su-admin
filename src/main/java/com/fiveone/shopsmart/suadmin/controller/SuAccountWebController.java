package com.fiveone.shopsmart.suadmin.controller;

import com.fiveone.shopsmart.suadmin.config.Config;
import com.fiveone.shopsmart.suadmin.dto.PageNavigationDto;
import com.fiveone.shopsmart.suadmin.dto.SaAccountRequestDto;
import com.fiveone.shopsmart.suadmin.dto.SaAccountResponseDto;
import com.fiveone.shopsmart.suadmin.service.SaAccountService;
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
public class SuAccountWebController {

    private SaAccountService saAccountService;


    // 메인 페이지
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Home | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-home");
        model.addAttribute("active_nav_label", "Home");

        return "index";
    }


    // 로그인 페이지
    @GetMapping("/account/login")
    public String dispLogin(Model model) {
        model.addAttribute("title", "Login | " + Config.TITLE);
        return "login";
    }

    // 로그인 결과 페이지
    @GetMapping("/account/login/result")
    public String dispLoginResult() {
        return "loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/account/logout/result")
    public String dispLogout() {
        return "logout";
    }

    // 접근 거부 페이지
    @GetMapping("/account/denied")
    public String dispDenied(Model model) {
        model.addAttribute("title", "401 | " + Config.TITLE);
        return "401";
    }

    // 내 정보 페이지
    @GetMapping("/account/info")
    public String dispMyInfo() {
        return "myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "admin";
    }


    @GetMapping("/account/account_admin")
    public String accountMemberAdmin (@RequestParam(value = "page_num", required = false, defaultValue = "1") String page_num, Model model) {

        model.addAttribute("title", "Super-User admin | " + Config.TITLE);
        model.addAttribute("active_nav_icon", "elusive icon-person");
        model.addAttribute("active_nav_label", "관리자 목록");
        model.addAttribute("active_nav_link", "#");

        long total_count = saAccountService.getCount();
        int total_page_count = Math.round (total_count / Config.LIST_PAGE_SIZE);

        List<PageNavigationDto> pageInfo = WebControllerUtil.getPageNavigation(Integer.valueOf(page_num), total_page_count);
        List<SaAccountResponseDto> items = saAccountService.findAllByPageRequest (Integer.valueOf(page_num) - 1, Config.LIST_PAGE_SIZE);

        model.addAttribute("page_info", pageInfo);
        model.addAttribute("items", items);

        return "account_admin";
    }

    // 회원가입 처리
    @PostMapping("/account/account_add")
    public String execSignup(SaAccountRequestDto saAccountRequestDto) {
        saAccountService.joinUser(saAccountRequestDto);
        return "redirect:/account/account_admin";
    }

    // 회원가입 처리
    @PostMapping("/account/account_update")
    public String accountMemberUpdate (@RequestParam (value = "page_num", required = false, defaultValue = "1") String page_num,
                                       SaAccountRequestDto saAccountRequestDto, Model model) {
        saAccountService.update(saAccountRequestDto);
        return "redirect:/account/account_admin?page_num=" + page_num;
    }

}