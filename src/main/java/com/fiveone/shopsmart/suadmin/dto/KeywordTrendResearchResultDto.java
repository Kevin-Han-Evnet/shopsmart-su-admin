package com.fiveone.shopsmart.suadmin.dto;

import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new.KeywordTrendResearchResult;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class KeywordTrendResearchResultDto {

    private Long idx;
    private Long crawling_info_idx;
    private String target_name;
    private String json_request;
    private String json_response;

    public KeywordTrendResearchResultDto(KeywordTrendResearchResult entity) {
        idx = entity.getIdx();
        crawling_info_idx = entity.getCrawling_info_idx();
        target_name = entity.getTarget_name();
        json_request = entity.getJson_request();
        json_response = entity.getJson_response();
    }
    
    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }


    /**
     * 챠트용 데이타 리턴
     * @return
     */
    public KeywordTrendDto getChartData () {
        JSONObject json_response_obj = null;
        try {
            json_response_obj = new JSONObject(new String(Base64.decode(json_response.substring(2, json_response.length() - 2)),"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        KeywordTrendDto result = new KeywordTrendDto ();

        result.startDate = json_response_obj.optString("startDate");
        result.endDate = json_response_obj.optString("endDate");

        JSONArray t = json_response_obj.optJSONArray("results");
        for (int i = 0; i < t.length(); i++) {

            KeywordTrendDto.KeywordTrendItem tmp = new KeywordTrendDto.KeywordTrendItem();
            tmp.label = t.optJSONObject(i).optJSONArray("keywords").optString(0);

            for (int j = 1; j < t.optJSONObject(i).optJSONArray("keywords").length(); j++) {
                tmp.label += (j > 1) ? ", " : " - ";
                tmp.label += t.optJSONObject(i).optJSONArray("keywords").optString(j);
            }

            for (int j = 0; j < t.optJSONObject(i).optJSONArray("data").length(); j++) {
                //LogUtil.info("염병 땀병 ----> " + t.optJSONObject(i).optJSONArray("data").optJSONObject(i).optString("period"));

                SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dt = null;
                try {
                    dt = transFormat.parse(t.optJSONObject(i).optJSONArray("data").optJSONObject(j).optString("period"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String tk = t.optJSONObject(i).optJSONArray("data").optJSONObject(j).optString("ratio");
                String[] tkk = new String[]{
                        String.valueOf(dt.getTime()),
                        tk
                };
                tmp.data.add(tkk);
            }

            //LogUtil.info("존나 ----> " + tmp.label);
            result.results.add(tmp);
        }

        return result;
    }

}

