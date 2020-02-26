//삭제 가봅시다.
$.confirmAndDelete = function  (idx, name) {
    if (confirm("[" + name + "] 항목을 삭제 하시겠습니까?\r해당 액션은 돌이킬 수 없습니다.")) {
        $("#target_seq").val(idx);
        $("#deleteForm").submit ();
    }
}


//아이디 중복체크
$.checkShopIdDup = function  () {

    if ($('#sid').val() == "") {
        return;
    }

    $('#btn_check_dup').addClass("btn btn-success");
    $('#btn_check_dup').text("확인완료");
    $('#sid').prop('readonly', true);
}


//UI 제어 -- 슈퍼 리서치 권한
$.setIsVip = function (checked) {
    if (checked) {
        $("#is_vip").next().addClass("checked");
        $('#is_vip').each(function(){ this.checked = true; });
    } else {
        $("#is_vip").next().removeClass("checked");
        $('#is_vip').each(function(){ this.checked = false; });
    }
}


//다음 주소 검색 고고고
$.searchAddress = function () {
    new daum.Postcode({
        oncomplete: function(data) {
            $('#post').val(data.zonecode);
            $('#address').val (data.address);
            $('#address_detail').val (data.buildingName);
        }
    }).open();
}