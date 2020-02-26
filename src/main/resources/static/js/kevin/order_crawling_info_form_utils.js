//새 폼 보여줘
$.addOrderCrawlingInfoFormVisible = function (visible, action, membershipSeq) {

    if (visible) {
        jQuery('#new_item_container').show();

        $('#idx').val('');
        $('#membershipSeq').val(membershipSeq);
        $('#platform_type').val('');
        $('#account_type').val(0);
        $('#platform_id').val('');
        $('#user_id_k').val('');
        $('#user_pwd').val('');
        $('#user_pwd_confirm').val('');
        $('#login_url').val('');


        $('#new_item_form').prop('action', action);
        $('#submit_new_item').text('등록');

        //$(document).scrollTop($(document).height());
        $('html,body').animate({scrollTop: $('html,body').height()}, 500);
    } else {
        jQuery('#new_item_container').hide();
    }
}


//수정폼 보여줘봐
$.modifyOrderCrawlingInfoFormVisible = function (action, idx, membershipSeq, platform_type, account_type, platform_id, user_id_k, user_pwd, login_url) {

    jQuery('#new_item_container').show();

    $('#idx').val(idx);
    $('#membershipSeq').val(membershipSeq);
    $('#platform_type').val(platform_type);
    $.setValidateOptions ($('#platform_type').val());
    $('#account_type').val(account_type);
    $('#platform_id').val(platform_id);
    $('#user_id_k').val(user_id_k);
    $('#user_pwd').val(user_pwd);
    $('#user_pwd_confirm').val(user_pwd);
    $('#login_url').val(login_url);

    $('#new_item_form').prop('action', action);
    $('#submit_new_item').text('수정');

    //$(document).scrollTop($(document).height());
    $('html,body').animate({scrollTop: $('html,body').height()}, 500);
}

$.setValidateOptions = function (selected) {
    if (selected == 'CAFE24') {

        $('#account_type').val(0);
        $('#account_type').prop('disabled', false);

        //$('#platform_id').val('');
        $('#platform_id_asset').show();
        //$('#login_url_asset').val('');
        $('#login_url_asset').hide();

    } else if (selected == 'SELMATE') {

        $('#account_type').val(0);
        $('#account_type').prop('disabled', true);

        //$('#platform_id').val('');
        $('#platform_id_asset').show();
        //$('#login_url_asset').val('');
        $('#login_url_asset').hide();

    } else if (selected == 'MAKESHOP') {

        $('#account_type').val(0);
        $('#account_type').prop('disabled', false);

        //$('#platform_id').val('');
        $('#platform_id_asset').hide();
        //$('#login_url_asset').val('');
        $('#login_url_asset').show();

    } else if (selected == 'SMARTSTORE') {

        $('#account_type').val(0);
        $('#account_type').prop('disabled', true);

        //$('#platform_id').val('');
        $('#platform_id_asset').hide();
        //$('#login_url_asset').val('');
        $('#login_url_asset').hide();

    } else {
        $('#account_type').val(0);
        $('#account_type').prop('disabled', true);

        //$('#platform_id').val('');
        $('#platform_id_asset').hide();
        //$('#login_url_asset').val('');
        $('#login_url_asset').hide();
    }
}


$.confirmAndDeleteForThis = function  (idx, name) {
    if (confirm("[" + name + "] 항목을 삭제 하시겠습니까?\r해당 액션은 돌이킬 수 없습니다.")) {
        $("#target_idx").val(idx);
        $("#deleteForm").submit ();
    }
}

$.updateCrawlingStat = function () {
    alert ('니미 씨부럴.');
}


