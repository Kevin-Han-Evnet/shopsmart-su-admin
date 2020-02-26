//새 폼 보여줘
$.addBuyerFormVisible = function (visible, action) {

    if (visible) {
        jQuery('#new_item_container').show();

        $('#membershipSeq').val('');
        $('#sid').prop('readonly', false);
        $('#sid').val('');
        $('#comp_nm').val('');
        $('#ceo_nm').val('');
        $('#shop_url').val('');
        $('#tax_id').val('');
        $('#post').val('');
        $('#address').val('');
        $('#address_detail').val('');
        $('#address_number').val('');
        $('#phone').val('');
        $('#email').val('');

        $('#new_item_form').prop('action', action);
        $('#submit_new_item').text('등록');

        //$(document).scrollTop($(document).height());
        $('html,body').animate({scrollTop: $('html,body').height()}, 500);
    } else {
        jQuery('#new_item_container').hide();
    }
}


//수정 폼 보여줘
$.modifyBuyerFormVisible = function (action, membershipSeq, sid, comp_nm, ceo_nm, shop_url, tax_id, post,
                                     address, address_detail, address_number, phone, email) {

    jQuery('#new_item_container').show();

    $('#membershipSeq').val(membershipSeq);
    $('#sid').prop('readonly', true);
    $('#sid').val(sid);
    $('#comp_nm').val(comp_nm);
    $('#ceo_nm').val(ceo_nm);
    $('#shop_url').val(shop_url);
    $('#tax_id').val(tax_id);
    $('#post').val(post);
    $('#address').val(address);
    $('#address_detail').val(address_detail);
    $('#address_number').val(address_number);
    $('#phone').val(phone);
    $('#email').val(email); ㅢ

    $('#new_item_form').prop('action', action);
    $('#submit_new_item').text('수정');

    //$(document).scrollTop($(document).height());
    $('html,body').animate({scrollTop: $('html,body').height()}, 500);
}