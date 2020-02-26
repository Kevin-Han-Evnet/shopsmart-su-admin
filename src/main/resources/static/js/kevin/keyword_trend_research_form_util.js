//새 폼 보여줘
$.addResearchInfoFormVisible = function (action) {

    $('#keyword_group_1').val('');
    $('#keywords_1').val('');
    $('#keyword_group_2').val('');
    $('#keywords_2').val('');
    $('#keyword_group_3').val('');
    $('#keywords_3').val('');
    $('#keyword_group_4').val('');
    $('#keywords_4').val('');
    $('#keyword_group_5').val('');
    $('#keywords_5').val('');
    $.setRadioUI ('period', 3);
    $('#timeUnit').val('date');
    $.setRadioUI ('device', 'all');
    $.setRadioUI ('gender', 'all');
    $.checkAllAge (false);
    $('#keyword_trend_crawling_stat').val(0)

    $('#new_item_form').prop('action', action);
    $('#submit_new_item').text('등록');

}


//수정폼 보여줘봐
$.showResearchInfoModifyForm = function (action,
                             research_info_idx,
                             keyword_group_1, keywords_1,
                             keyword_group_2, keywords_2,
                             keyword_group_3, keywords_3,
                             keyword_group_4, keywords_4,
                             keyword_group_5, keywords_5,
                             period, timeUnit, device, gender, age,
                             keyword_trend_crawling_stat) {

    jQuery('#new_item_container').show();

    $('#idx').val(research_info_idx);
    $('#keyword_group_1').val(keyword_group_1);
    $('#keywords_1').val(keywords_1);
    $('#keyword_group_2').val(keyword_group_2);
    $('#keywords_2').val(keywords_2);
    $('#keyword_group_3').val(keyword_group_3);
    $('#keywords_3').val(keywords_3);
    $('#keyword_group_4').val(keyword_group_4);
    $('#keywords_4').val(keywords_4);
    $('#keyword_group_5').val(keyword_group_5);
    $('#keywords_5').val(keywords_5);
    $.setRadioUI ('period', period);
    $('#timeUnit').val(timeUnit);
    $.setRadioUI ('device', device);
    $.setRadioUI ('gender', gender);

    let ages = age.split (',')

    if (age == '' || ages.length > 10) {
        $.setCheckBoxUI ($('#age_all'), true);
        $.checkAllAge (true);
    } else {
        $.setCheckBoxUI ($('#age_all'), false);
        $.checkAllAge(false);

        for (let i = 0; i < ages.length; i++) {
            $.setCheckBoxUI($('#' + ages[i]), true);
        }
    }

    $('#keyword_trend_crawling_stat').val(keyword_trend_crawling_stat);

    $('#new_item_form').prop('action', action);
    $('#submit_new_item').text('수정');


    //$(document).scrollTop($(document).height());
    $('html,body').animate({scrollTop: $('html,body').height()}, 500);
}




//UI 제어 -- 레디오
$.setRadioUI = function (tName, selectedIdx) {

    $('[name="' + tName + '"]').each(function () {

        $.rdo_target = $('[name="' + tName + '"][value="' + this.value + '"]');
        if (this.value == selectedIdx) {
            $.rdo_target.next().addClass("checked");
            $.rdo_target.each(function(){ this.checked = true; });
        } else {
            $.rdo_target.next().removeClass("checked");
            $.rdo_target.each(function(){ this.checked = false; });
        }

    });
}

//연령 전체 체크 제어
$.checkAllAge = function (checked) {
    $.setCheckBoxUI ($('#age_1'), checked);
    $.setCheckBoxUI ($('#age_2'), checked);
    $.setCheckBoxUI ($('#age_3'), checked);
    $.setCheckBoxUI ($('#age_4'), checked);
    $.setCheckBoxUI ($('#age_5'), checked);
    $.setCheckBoxUI ($('#age_6'), checked);
    $.setCheckBoxUI ($('#age_7'), checked);
    $.setCheckBoxUI ($('#age_8'), checked);
    $.setCheckBoxUI ($('#age_9'), checked);
    $.setCheckBoxUI ($('#age_10'), checked);
    $.setCheckBoxUI ($('#age_11'), checked);
}


$.checkAgeOptions = function (checked) {
    if (checked) {
        //nothing to do.
    } else {
        $.setCheckBoxUI ($('#age_all'), false);
    }
}


//UI 제어 -- 체크박스
$.setCheckBoxUI = function (target, checked) {
    if (checked) {
        target.next().addClass("checked");
    } else {
        target.next().removeClass("checked");
    }
    target.each(function () {
        this.checked = checked;
    });
}




//삭제 가봅시다.
$.confirmAndDelete = function  (idx, name) {
    if (confirm("리서치 정보 [" + name + "] 항목을 삭제 하시겠습니까?\r해당 액션은 돌이킬 수 없습니다.")) {
        $("#target_idx").val(idx);
        $("#deleteForm").submit ();
    }
}


//서브밋 시 데이타 가공
$.makeJpaData = function () {
    let tmp_agese = [];
    if ($('#age_all').is(":checked")) {
        $('#ages_asset').val("");
    } else {
        $('[name="ages"]').each(function () {
            if (this.checked) {
                tmp_agese.push(this.id);
            }
        });

        $('#ages_asset').val(tmp_agese.join(","));
    }
}