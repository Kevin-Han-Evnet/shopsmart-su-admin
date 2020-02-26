package com.fiveone.shopsmart.suadmin.dto;


public class PageNavigationDto {
    public int page_num;
    public String page_label;
    public String class_name;
    public String span_class_name;

    public PageNavigationDto(int page_num, String page_label, String class_name, String span_class_name) {
        this.page_num = page_num;
        this.page_label = page_label;
        this.class_name = class_name;
        this.span_class_name = span_class_name;
    }
}
