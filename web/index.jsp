<%-- 
    Document   : index
    Created on : Mar 20, 2019, 5:11:46 PM
    Author     : longnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- <?php date_default_timezone_set('Asia/Ho_Chi_Minh'); ?> -->
<head>
    <title>Hệ thống Bảo hiểm Xã hội</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script src="js/main.js" type="text/javascript"></script>
</head>
<body>
    <div class="container border my-5">
        <div class="row my-2 py-2 text-center">
            <div class="col-4">
                <button id="btn_theodoidanhsach" data-toggle="modal" data-target="#popup_theodoidanhsach">XUẤT BÁO CÁO</button>
            </div>
            <div class="col-4">
                <button id="btn_xuatbaocao" data-toggle="modal" data-target="#popup_xuatbaocao">THEO DÕI DANH SÁCH</button>
            </div>
            <div class="col-4">
                <button id="btn_cauhinh" data-toggle="modal" data-target="#popup_cauhinh">CẤU HÌNH</button>
            </div>
        </div>
    </div>
    <div class="container" id="result_xuatbaocao" style="display: none">
        <div id="xuatbaocao_person"></div>
        <div id="xuatbaocao_company"></div>
    </div>
    <div class="container my-1 py-1" id="result_theodoidanhsach" style="display: none">
        <div>
            <div class="text-center">
                <h4>BÁO CÁO HỆ THỐNG BẢO HIỂM XÃ HỘI</h4>
            </div>
            <div class="text-center">
                 <!-- <h6>Hà Nội, ngày <?php echo date('d', time()) ?> tháng <?php echo date('m', time()) ?> năm <?php echo date('Y', time()) ?> </h6> -->
            </div>
            <br>
            <div class="text-left px-5">
                <p>Kính gửi: ...</p>
                <br>
                <br>
                <h6> Thời gian thống kê: Từ ... đến ...</h6>
                <h6>Phạm vi báo cáo: Toàn quốc</h6>
                <!-- <h6>Thời gian lập báo cáo: <?php echo date('d/m/Y h:i:s', time()) ?> </h6> -->
            </div>
        </div>
        <div class="result_voluntary my-2 py-2">
            <!-- <div class="jumbotron"> -->
                <div class="row">
                    <h3>[*] BẢO HIỂM XÃ HỘI TỰ NGUYỆN</h3>
                </div>
            <!-- </div> -->
            <div id="div_result_theodoidanhsach_voluntary">
                <table id="table_result_theodoidanhsach_voluntary"></table>
            </div>
        </div>
        <div class="result_compulsory my-2 py-2">
            <!-- <div class="jumbotron"> -->
                <div class="row">
                    <h3>[*] BẢO HIỂM XÃ HỘI BẮT BUỘC</h3>
                </div>
            <!-- </div> -->
            <div id="div_result_theodoidanhsach_compulsory">
                <table id="table_result_theodoidanhsach_compulsory"></table>
            </div>
        </div>
    </div>
    <div id="popup_theodoidanhsach" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    
                </div>
                <div class="modal-body">
                    <!-- <input type="text" name="from_date" id = "from_date_theodoidanhsach">
                    <input type="text" name="to_date" id = "to_date_theodoidanhsach"> -->
                    Từ <select id="from_date_month_theodoidanhsach">
                        <option value="...">...</option>
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <select id="from_date_year_theodoidanhsach">
                        <option value="...">...</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                        <option value="2017">2017</option>
                        <option value="2016">2016</option>
                        <option value="2015">2015</option>
                    </select>
                    đến 
                    <select id="to_date_month_theodoidanhsach">
                        <option value="...">...</option>
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <select id="to_date_year_theodoidanhsach">
                        <option value="...">...</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                        <option value="2017">2017</option>
                        <option value="2016">2016</option>
                        <option value="2015">2015</option>
                    </select>
                    <input type="submit" name="submit" id = "submit_btn_theodoidanhsach" value="XEM!">
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
    <div id="popup_xuatbaocao" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    
                </div>
                <div class="modal-body">
                    Kiểu tìm kiếm: <select id="search_type_sel">
                    	<option>...</option>
                    	<option value="by_name">Tìm theo tên khách hàng</option>
                    	<option value="by_code">Tìm theo mã khách hàng</option>
                    </select>
                    <br>
                    Mã khách hàng: <input type="text" name="customer_code" id="customer_code_xuatbaocao"><br>
                    Tên khách hàng: <input type="text" name="customer_code" id="customer_name_xuatbaocao">
                    <select id="customers_sel"></select>
                    <br>
                    Từ <select id="from_date_month_xuatbaocao">
                        <option value="...">...</option>
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <select id="from_date_year_xuatbaocao">
                        <option value="...">...</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                        <option value="2017">2017</option>
                        <option value="2016">2016</option>
                        <option value="2015">2015</option>
                    </select>
                    <br>
                    đến 
                    <select id="to_date_month_xuatbaocao">
                        <option value="...">...</option>
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <select id="to_date_year_xuatbaocao">
                        <option value="...">...</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                        <option value="2017">2017</option>
                        <option value="2016">2016</option>
                        <option value="2015">2015</option>
                    </select>
                    <button id="submit_btn_xuatbaocao">XEM</button>
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
    <div id="popup_cauhinh" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1>Cấu hình</h1>
                </div>
                <div class="modal-body">
                    Tuổi tối thiểu tham gia BHTN: <input type="text" name="min_age_to_participant_VSI" class="input_in_setting_popup" id="input_min_age_to_participant_VSI"> <button class="btn_in_setting_popup" value="input_min_age_to_participant_VSI">SỬA</button><br>
                    % lương doanh nghiệp đóng BHBB: <input type="text" name="company_CSI_percentage" class="input_in_setting_popup" id="input_company_CSI_percentage"> <button class="btn_in_setting_popup" value="input_company_CSI_percentage">SỬA</button><br>
                    % lương người lao động đóng BHBB<input type="text" name="labor_CSI_percentage" class="input_in_setting_popup" id="input_labor_CSI_percentage"> <button class="btn_in_setting_popup" value="input_labor_CSI_percentage">SỬA</button><br>
                    % lương người lao động đóng BHTN<input type="text" name="labor_VSI_percentage" class="input_in_setting_popup" id="input_labor_VSI_percentage"> <button class="btn_in_setting_popup" value="input_labor_VSI_percentage">SỬA</button><br>
                    Mức lương tối thiểu vùng 1: <input type="text" name="1st_area_min_salary" class="input_in_setting_popup" id="input_1st_area_min_salary"> <button class="btn_in_setting_popup" value="input_1st_area_min_salary">SỬA</button><br>
                    Mức lương tối thiểu vùng 2: <input type="text" name="2nd_area_min_salary" class="input_in_setting_popup" id="input_2nd_area_min_salary"> <button class="btn_in_setting_popup" value="input_2nd_area_min_salary">SỬA</button><br>
                    Mức lương tối thiểu vùng 3: <input type="text" name="3rd_area_min_salary" class="input_in_setting_popup" id="input_3rd_area_min_salary"> <button class="btn_in_setting_popup" value="input_3rd_area_min_salary">SỬA</button><br>
                    Mức lương tối thiểu vùng 4: <input type="text" name="4th_area_min_salary" class="input_in_setting_popup" id="input_4th_area_min_salary"> <button class="btn_in_setting_popup" value="input_4th_area_min_salary">SỬA</button><br>
                </div>
                <div class="modal-footer">
                    <button id="btn_save_setting">LƯU</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>