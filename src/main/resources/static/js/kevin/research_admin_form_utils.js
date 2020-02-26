//새 폼 보여줘
$.addResearchFormVisible = function (visible, action) {

    if (visible) {
        jQuery('#new_item_container').show();



        $('#new_item_form').prop('action', action);
        $('#submit_new_item').text('등록');

        //$(document).scrollTop($(document).height());
        $('html,body').animate({scrollTop: $('html,body').height()}, 500);
    } else {
        jQuery('#new_item_container').hide();
    }
}


//수정폼 보여줘봐
$.modifyShopFormVisible = function (action, membershipSeq, sid, comp_nm, ceo_nm, shop_url, tax_id, post,
                                    address, address_detail, address_number, phone, email, is_vip) {

    jQuery('#new_item_container').show();



    $('#new_item_form').prop('action', action);
    $('#submit_new_item').text('수정');

    //$(document).scrollTop($(document).height());
    $('html,body').animate({scrollTop: $('html,body').height()}, 500);
}


$.deleteResearchRequest = function (idx, name) {
    if (confirm("[" + name + "] 항목을 삭제 하시겠습니까?\r해당 액션은 돌이킬 수 없습니다.")) {
        $("#target_idx").val(idx);
        $("#deleteForm").submit ();
    }
}