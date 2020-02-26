//새 폼 보여줘
$.addResearchInfoFormVisible = function (visible, action) {

    if (visible) {
        jQuery('#new_item_container').show();

        $('#research_info_idx').val('-1');
        $('#target_name').val('')
        $('#target_base_url').val('');
        $('#crawling_engine').val('URLLIB')

        $('#np_list_page').val('');
        $('#np_tag_selector').val('');
        $('#np_sub_tag_selector').val('');
        $('#np_img_tag_selector').val('');
        $('#np_not_nessesary_strings').val('');
        $('#np_code_name').val('');
        $('#np_crawling_stat option:eq(0)').prop('selected', true);
        $('#np_comment').val('');

        $('#event_list_page').val('');
        $('#event_tag_selector').val('');
        $('#event_sub_tag_selector').val('');
        $('#event_img_tag_selector').val('');
        $('#event_not_nessesary_strings').val('');
        $('#event_code_name').val('');
        $('#event_crawling_stat option:eq(0)').prop('selected', true);
        $('#event_comment').val('');

        $('#new_item_form').prop('action', action);
        $('#submit_new_item').text('등록');

        //$(document).scrollTop($(document).height());
        $('html,body').animate({scrollTop: $('html,body').height()}, 500);
    } else {
        jQuery('#new_item_container').hide();
    }

}


//수정폼 보여줘봐
$.showModifyForm = function (action,
                             research_info_idx,
                             target_name,
                             target_base_url,
                             np_list_page,
                             np_tag_selector,
                             np_sub_tag_selector,
                             np_img_tag_selector,
                             np_code_name,
                             np_not_nessesary_strings,
                             np_crawling_stat,
                             np_comment,
                             event_list_page,
                             event_tag_selector,
                             event_sub_tag_selector,
                             event_img_tag_selector,
                             event_code_name,
                             event_not_nessesary_strings,
                             event_crawling_stat,
                             event_comment,
                             crawling_engine) {

    jQuery('#new_item_container').show();

    $('#idx').val(research_info_idx);
    $('#target_name').val(target_name);
    $('#target_base_url').val(target_base_url);
    $('#crawling_engine').val(crawling_engine);

    $('#np_list_page').val(np_list_page);
    $('#np_tag_selector').val(np_tag_selector);
    $('#np_sub_tag_selector').val(np_sub_tag_selector);
    $('#np_img_tag_selector').val(np_img_tag_selector);
    $('#np_not_nessesary_strings').val(np_not_nessesary_strings);
    $('#np_code_name').val(np_code_name);
    $('#np_crawling_stat').val(np_crawling_stat);
    $('#np_comment').val(np_comment);

    $('#event_list_page').val(event_list_page);
    $('#event_tag_selector').val(event_tag_selector);
    $('#event_sub_tag_selector').val(event_sub_tag_selector);
    $('#event_img_tag_selector').val(event_img_tag_selector);
    $('#event_code_name').val(event_code_name);
    $('#event_not_nessesary_strings').val(event_not_nessesary_strings);
    $('#event_crawling_stat').val(event_crawling_stat);
    $('#event_comment').val(event_comment);

    $('#new_item_form').prop('action', action);
    $('#submit_new_item').text('수정');

    //$(document).scrollTop($(document).height());
    $('html,body').animate({scrollTop: $('html,body').height()}, 500);

}






//삭제 가봅시다.
$.confirmAndDelete = function  (idx, name) {
    if (confirm("리서치 정보 [" + name + "] 항목을 삭제 하시겠습니까?\r해당 액션은 돌이킬 수 없습니다.")) {
        $("#target_idx").val(idx);
        $("#deleteForm").submit ();
    }
}

//신상품 리서치 불가
$.setDisableNP = function (selected) {
    if (selected == 2) {
        if ($('#np_list_page').val() == '') $('#np_list_page').val('none');
        if ($('#np_tag_selector').val() == '') $('#np_tag_selector').val('none');
        if ($('#np_img_tag_selector').val() == '') $('#np_img_tag_selector').val('none');
        if ($('#np_code_name').val() == '') $('#np_code_name').val('none');
    }
}


//이벤트 리서치 불가
$.setDisableEvent = function (selected) {
    if (selected == 2) {
        if ($('#event_list_page').val() == '') $('#event_list_page').val('none');
        if ($('#event_tag_selector').val() == '') $('#event_tag_selector').val('none');
        if ($('#event_img_tag_selector').val() == '') $('#event_img_tag_selector').val('none');
        if ($('#event_code_name').val() == '') $('#event_code_name').val('none');
    }
}












