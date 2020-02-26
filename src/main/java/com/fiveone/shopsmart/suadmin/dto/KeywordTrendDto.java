package com.fiveone.shopsmart.suadmin.dto;

import java.util.ArrayList;
import java.util.List;

public class KeywordTrendDto {

    public static class KeywordTrendItem {
        public String label;
        public List<String[]> data = new ArrayList<>();
    }

    public String startDate;
    public String endDate;
    public List<KeywordTrendItem> results = new ArrayList<>();

}
