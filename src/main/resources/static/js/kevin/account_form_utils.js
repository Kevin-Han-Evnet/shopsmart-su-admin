//새 폼 보여줘
$.addAccountFormVisible = function (visible, action) {

    if (visible) {
        jQuery('#new_item_container').show();

        $('#idx').val('0');
        $('#email').val('');
        $('#name').val('');
        $('#password').val('');
        $('#password_confirm').val('');

        $('#new_item_form').prop('action', action);
        $('#submit_new_item').text('등록');

        //$(document).scrollTop($(document).height());
        $('html,body').animate({scrollTop: $('html,body').height()}, 500);
    } else {
        jQuery('#new_item_container').hide();
    }
}


//수정 폼 보여줘
$.modifyAccountFormVisible = function (
    action,
    idx,
    email,
    name
) {

    jQuery('#new_item_container').show();

    $('#idx').val(idx);
    $('#email').val(email);
    $('#name').val(name);
    $('#password').val('');
    $('#password_confirm').val('');

    $('#new_item_form').prop('action', action);
    $('#submit_new_item').text('수정');

    //$(document).scrollTop($(document).height());
    $('html,body').animate({scrollTop: $('html,body').height()}, 500);
}