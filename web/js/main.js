$(document).on("click", "#submit_btn_theodoidanhsach", function () {
    console.log("button submit clicked");
    if(parseInt($("#from_date_year_theodoidanhsach").val()) > parseInt($("#to_date_year_theodoidanhsach").val())) {alert("Năm từ lớn hơn năm đến");return;}
    if(parseInt($("#from_date_month_theodoidanhsach").val()) > parseInt($("#to_date_month_theodoidanhsach").val()) && parseInt($("#from_date_year_theodoidanhsach").val()) == parseInt($("#to_date_year_theodoidanhsach").val())) {alert("Tháng từ lớn hơn tháng đến"); return;}
    
    if($("#from_date_month_theodoidanhsach").val() == "..." && $("#from_date_year_theodoidanhsach").val() == "..." && $("#to_date_month_theodoidanhsach").val() == "..." && $("#to_date_year_theodoidanhsach").val() == "..."){
        alert("Bạn chưa chọn trường thời gian!");
        return;
    }

    if($("#from_date_month_theodoidanhsach").val() == "..." || $("#from_date_year_theodoidanhsach").val() == "..." || $("#to_date_month_theodoidanhsach").val() == "..." || $("#to_date_year_theodoidanhsach").val() == "..."){
        alert("Bạn chưa chọn đủ trường thời gian!");
        return;
    }
    var payload_voluntary = {'command': 'system_report', 'type': 'voluntary', 'from_date': $("#from_date_month_theodoidanhsach").val() + "/" + $("#from_date_year_theodoidanhsach").val(), 'to_date': $("#to_date_month_theodoidanhsach").val() + "/" + $("#to_date_year_theodoidanhsach").val()};
    var payload_compulsory = {'command': 'system_report', 'type': 'compulsory', 'from_date': $("#from_date_month_theodoidanhsach").val() + "/" + $("#from_date_year_theodoidanhsach").val(), 'to_date': $("#to_date_month_theodoidanhsach").val() + "/" + $("#to_date_year_theodoidanhsach").val()};
    console.log(payload_voluntary)
    console.log(payload_compulsory)
    $('#div_result_theodoidanhsach_voluntary').load("Controller", payload_voluntary);
    $('#div_result_theodoidanhsach_compulsory').load("Controller", payload_compulsory);
    $('#result_xuatbaocao').hide();
    $('#result_theodoidanhsach').show();
});
$(document).on("click", "#submit_btn_xuatbaocao", function () {
    if($("#search_type_sel").val() == '...'){
        alert("Bạn chưa chọn phương thức tìm kiếm khách hàng!")
        return;
    }
    if($("#search_type_sel").val() == "by_name" && $("#customer_name_xuatbaocao").val() ==""){
        alert("Bạn chưa nhập tên khách hàng!")
        return;
    }

    if($("#search_type_sel").val() == "by_name" && $("#customer_name_xuatbaocao").val() !="" && $("#customer_code_xuatbaocao").val() ==""){
        alert("Bạn đã nhập tên khách hàng nhưng chưa chọn đích danh khách hàng!")
        return;
    }
    if($("#search_type_sel").val() == "by_code" && $("#customer_code_xuatbaocao").val() == ""){
        alert("Bạn chưa nhập mã khách hàng!")
        return;
    }
    var customer_code = $('#customer_code_xuatbaocao').val();
    if(customer_code == ""){
        alert("Bạn chưa nhập mã khách hàng");
        return;
    }    var customer_code_pattern = new RegExp("^[a-zA-Z]{2}[0-9]{4}$");
    var res = customer_code_pattern.test(customer_code);
    console.log(res);
    if( res == false) {
        alert("Mã khách hàng [" + customer_code + "] không hợp lệ! Một mã khách hàng hợp lệ là mã có độ dài bằng 6, 2 ký tự đầu tiên là chữ cái, 4 ký tự tiếp theo là chữ số!");
        return;
    }
    if(parseInt($("#from_date_year_xuatbaocao").val()) > parseInt($("#to_date_year_xuatbaocao").val())) {alert("Năm từ lớn hơn năm đến");return;}
    if(parseInt($("#from_date_month_xuatbaocao").val()) > parseInt($("#to_date_month_xuatbaocao").val()) && parseInt($("#from_date_year_xuatbaocao").val()) == parseInt($("#to_date_year_xuatbaocao").val())) {alert("Tháng từ lớn hơn tháng đến"); return;}
    if($("#from_date_month_xuatbaocao").val() == "..." && $("#from_date_year_xuatbaocao").val() == "..." && $("#to_date_month_xuatbaocao").val() == "..." && $("#to_date_year_xuatbaocao").val() == "..."){
        alert("Bạn chưa chọn trường thời gian!");
        return;
    }
    if($("#from_date_month_xuatbaocao").val() == "..." || $("#from_date_year_xuatbaocao").val() == "..." || $("#to_date_month_xuatbaocao").val() == "..." || $("#to_date_year_xuatbaocao").val() == "..."){
        alert("Bạn chưa chọn đủ trường thời gian!");
        return;
    }
    var payload_person = {'command': 'xuatbaocao_person', 'customer_code': customer_code, 'from_date': $("#from_date_month_xuatbaocao").val() + "/" + $("#from_date_year_xuatbaocao").val(), 'to_date': $("#to_date_month_xuatbaocao").val() + "/" + $("#to_date_year_xuatbaocao").val()}
    console.log(payload_person)
    $('#xuatbaocao_person').load('Controller', payload_person)
    $('#result_xuatbaocao').show()
    $('#result_theodoidanhsach').hide()
})

$(document).on("click", "#btn_cauhinh", function () {
    console.log("#btn_cauhinh clicked")
    $(".input_in_setting_popup").map(function () {
        $(this).prop('disabled', true)
    })
    $("#btn_save_setting").prop('disabled', true)
    var payload = {'command': 'load_rule'}
    $.post(url = 'Controller', payload, function (rps) {
        // console.log(rps)
        json = JSON.parse(rps)
        if (json.hasOwnProperty('error')) {
            console.log("co loi :((")
            alert("Error 1056 occurred! can't load current Rule, contact m.me/bachvkhoa")
        } else {
            $('#input_min_age_to_participant_VSI').val(json['min_age_to_participant_VSI'])
            $('#input_company_CSI_percentage').val(json['company_CSI_percentage'])
            $('#input_labor_VSI_percentage').val(json['labor_VSI_percentage'])
            $('#input_labor_CSI_percentage').val(json['labor_CSI_percentage'])
            $('#input_1st_area_min_salary').val(json['1st_area_min_salary'])
            $('#input_2nd_area_min_salary').val(json['2nd_area_min_salary'])
            $('#input_3rd_area_min_salary').val(json['3rd_area_min_salary'])
            $('#input_4th_area_min_salary').val(json['4th_area_min_salary'])
        }
    })
}
)
$(document).on("click", ".btn_in_setting_popup", function () {
    console.log($(this).val() + " clicked!")
    var positive_number_pattern = new RegExp("^[1-9][0-9]*$")
    if(!$('#input_min_age_to_participant_VSI').val().match(positive_number_pattern)){
        alert('Dữ liệu cho "Tuổi tối thiểu tham gia bảo hiểm tự nguyện" phải là một số nguyên dương lớn hơn 0')
        return;
    }
    if(!$('#input_company_CSI_percentage').val().match(positive_number_pattern)){
        alert('Dữ liệu cho "% lương doanh nghiệp đóng BHBB" phải là một số nguyên dương lớn hơn 0')
        return;
    }
    if(!$('#input_labor_CSI_percentage').val().match(positive_number_pattern)){
        alert('Dữ liệu cho "% lương người lao động đóng BHBB" phải là một số nguyên dương lớn hơn 0')
        return;
    }
    if(!$('#input_labor_VSI_percentage').val().match(positive_number_pattern)){
        alert('Dữ liệu cho "% lương người lao động đóng BHTN" phải là một số nguyên dương lớn hơn 0')
        return;
    }
    if(!$('#input_1st_area_min_salary').val().match(positive_number_pattern)){
        alert('Dữ liệu cho "Mức lương tối thiểu vùng 1" phải là một số nguyên dương lớn hơn 0')
        return;
    }
    if(!$('#input_2nd_area_min_salary').val().match(positive_number_pattern)){
        alert('Dữ liệu cho "Mức lương tối thiểu vùng 2" phải là một số nguyên dương lớn hơn 0')
        return;
    }
    if(!$('#input_3rd_area_min_salary').val().match(positive_number_pattern)){
        alert('Dữ liệu cho "Mức lương tối thiểu vùng 3" phải là một số nguyên dương lớn hơn 0')
        return;
    }
    if(!$('#input_4th_area_min_salary').val().match(positive_number_pattern)){
        alert('Dữ liệu cho "Mức lương tối thiểu vùng 4" phải là một số nguyên dương lớn hơn 0')
        return;
    }
    if ($(this).html() == 'SỬA') {
        $(this).html('XONG')
        $('#' + $(this).val()).prop('disabled', false)
    } else if ($(this).html() == 'XONG') {
        $(this).html('SỬA')
        $("#btn_save_setting").prop('disabled', false)
        $('#' + $(this).val()).prop('disabled', true)
    } else {
        alert("Error code 903 occurred!\n please contact admin -> m.me/bachvkhoa")
    }
})
$(document).on("click", ".btn_in_setting_popup", function () {
    console.log("#btn_save_setting clicked");
    
    
})

$(document).on("click", "#btn_save_setting", function(){
    var payload = {'command': 'create_new_rule', 'min_age_to_participant_VSI': $('#input_min_age_to_participant_VSI').val(), 'company_CSI_percentage': $('#input_company_CSI_percentage').val(), 'labor_CSI_percentage': $('#input_labor_CSI_percentage').val(), 'labor_VSI_percentage': $('#input_labor_VSI_percentage').val(), '1st_area_min_salary': $('#input_1st_area_min_salary').val(), '2nd_area_min_salary': $('#input_2nd_area_min_salary').val(), '3rd_area_min_salary': $('#input_3rd_area_min_salary').val(), '4th_area_min_salary': $('#input_4th_area_min_salary').val()}
    console.log(payload)
    $.post(url = "Controller", payload, function (result) {
        alert(result)
    })
})

$(document).on("change", "#search_type_sel", function(){
    if($(this).val() == "by_name"){
        $("#customer_name_xuatbaocao").prop('disabled', false);
        $("#customer_code_xuatbaocao").prop('disabled', true);
        $("#customers_sel").prop('disabled', false);
        $("#customer_code_xuatbaocao").val("");
        $("#customer_name_xuatbaocao").val("");
        $("#customers_sel").empty();
    } else if ($(this).val() == "by_code") {
        $("#customer_code_xuatbaocao").prop('disabled', false);
        $("#customer_name_xuatbaocao").prop('disabled', true);
        $("#customers_sel").prop('disabled', false);
        $("#customer_code_xuatbaocao").val("");
        $("#customer_name_xuatbaocao").val("");
        $("#customers_sel").empty();
    }
})

$(document).on("keyup", "#customer_name_xuatbaocao", function(){
    var payload_2332 = {'command':'search_customer_by_name', 'name':$("#customer_name_xuatbaocao").val()}
    console.log(payload_2332);
    $("#customers_sel").empty();
    $.post(url = "Controller", payload_2332, function(result){
        console.log(result);
        json = JSON.parse(result);
        if(json.length > 0) $("#customers_sel").append("<option>ĐÃ TÌM THẤY!</option>");
        else $("#customers_sel").append("<option>KHÔNG CÓ KẾT QUẢ!</option>");
        for (var i = json.length - 1; i >= 0; i--) {
            $("#customers_sel").append("<option value = '" + json[i]['customer_code'] + "|" + json[i]['customer_name']+ "'>" + json[i]['customer_name'] + "(" + json[i]['customer_id'] + " - " + json[i]['customer_dob'] + ")</option>");
        }
    })
})

$(document).on("keyup", "#customer_code_xuatbaocao", function(){
    var payload_0027 = {'command':'search_customer_by_code_0', 'code':$("#customer_code_xuatbaocao").val()}
    console.log(payload_0027);
    $("#customers_sel").empty();
    $.post(url = "Controller", payload_0027, function(result){
        console.log(result);
        json = JSON.parse(result);
        if(json.length > 0) $("#customers_sel").append("<option>ĐÃ TÌM THẤY!</option>");
        else $("#customers_sel").append("<option>KHÔNG CÓ KẾT QUẢ!</option>");
        for (var i = json.length - 1; i >= 0; i--) {
            $("#customers_sel").append("<option value = '" + json[i]['customer_code'] + "|" + json[i]['customer_name'] + "'>" + json[i]['customer_name'] + "(" + json[i]['customer_id'] + " - " + json[i]['customer_dob'] + ")</option>");
        }
    })
})

$(document).on("change", "#customers_sel", function(){
    $("#customer_code_xuatbaocao").val($(this).val().split('|')[0]);
    $("#customer_name_xuatbaocao").val($(this).val().split('|')[1]);
})

$(document).on("click", "#btn_xuatbaocao", function(){
    $("#customer_name_xuatbaocao").prop('disabled', true)
    $("#customer_code_xuatbaocao").prop('disabled', true)
    $("#customers_sel").prop('disabled', true)
    $("#customer_name_xuatbaocao").val("")
    $("#customer_code_xuatbaocao").val("")
    $("#customers_sel").val("")
    $("#search_type_sel").val("...")
})
