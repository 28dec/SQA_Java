package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<!-- <?php date_default_timezone_set('Asia/Ho_Chi_Minh'); ?> -->\n");
      out.write("<head>\n");
      out.write("    <title>He thong Bao hiem Xa hoi</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/main.js\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container border my-5\">\n");
      out.write("        <div class=\"row my-2 py-2 text-center\">\n");
      out.write("            <div class=\"col-4\">\n");
      out.write("                <button id=\"btn_theodoidanhsach\" data-toggle=\"modal\" data-target=\"#popup_theodoidanhsach\">Theo doi danh sach</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-4\">\n");
      out.write("                <button id=\"btn_xuatbaocao\" data-toggle=\"modal\" data-target=\"#popup_xuatbaocao\">Xuat bao cao</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-4\">\n");
      out.write("                <button id=\"btn_cauhinh\" data-toggle=\"modal\" data-target=\"#popup_cauhinh\">Cau hinh</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\" id=\"result_xuatbaocao\" style=\"display: none\">\n");
      out.write("        <div id=\"xuatbaocao_person\"></div>\n");
      out.write("        <div id=\"xuatbaocao_company\"></div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container my-1 py-1\" id=\"result_theodoidanhsach\" style=\"display: none\">\n");
      out.write("        <div>\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <h4>BÁO CÁO HỆ THỐNG BẢO HIỂM XÃ HỘI</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                 <!-- <h6>Hà Nội, ngày <?php echo date('d', time()) ?> tháng <?php echo date('m', time()) ?> năm <?php echo date('Y', time()) ?> </h6> -->\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"text-left px-5\">\n");
      out.write("                <p>Kính gửi: ...</p>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <h6> Thời gian thống kê: Từ ... đến ...</h6>\n");
      out.write("                <h6>Phạm vi báo cáo: Toàn quốc</h6>\n");
      out.write("                <!-- <h6>Thời gian lập báo cáo: <?php echo date('d/m/Y h:i:s', time()) ?> </h6> -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"result_voluntary my-2 py-2\">\n");
      out.write("            <!-- <div class=\"jumbotron\"> -->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <h3>[*] BẢO HIỂM XÃ HỘI TỰ NGUYỆN</h3>\n");
      out.write("                </div>\n");
      out.write("            <!-- </div> -->\n");
      out.write("            <div id=\"div_result_theodoidanhsach_voluntary\">\n");
      out.write("                <table id=\"table_result_theodoidanhsach_voluntary\"></table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"result_compulsory my-2 py-2\">\n");
      out.write("            <!-- <div class=\"jumbotron\"> -->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <h3>[*] BẢO HIỂM XÃ HỘI BẮT BUỘC</h3>\n");
      out.write("                </div>\n");
      out.write("            <!-- </div> -->\n");
      out.write("            <div id=\"div_result_theodoidanhsach_compulsory\">\n");
      out.write("                <table id=\"table_result_theodoidanhsach_compulsory\"></table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"popup_theodoidanhsach\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <!-- <input type=\"text\" name=\"from_date\" id = \"from_date_theodoidanhsach\">\n");
      out.write("                    <input type=\"text\" name=\"to_date\" id = \"to_date_theodoidanhsach\"> -->\n");
      out.write("                    <select id=\"from_date_theodoidanhsach\">\n");
      out.write("                        <option value=\"01\">1</option>\n");
      out.write("                        <option value=\"02\">2</option>\n");
      out.write("                        <option value=\"03\">3</option>\n");
      out.write("                        <option value=\"04\">4</option>\n");
      out.write("                        <option value=\"05\">5</option>\n");
      out.write("                        <option value=\"06\">6</option>\n");
      out.write("                        <option value=\"07\">7</option>\n");
      out.write("                        <option value=\"08\">8</option>\n");
      out.write("                        <option value=\"09\">9</option>\n");
      out.write("                        <option value=\"10\">10</option>\n");
      out.write("                        <option value=\"11\">11</option>\n");
      out.write("                        <option value=\"12\">12</option>\n");
      out.write("                    </select>\n");
      out.write("                    <select id=\"to_date_theodoidanhsach\">\n");
      out.write("                        <option value=\"01\">1</option>\n");
      out.write("                        <option value=\"02\">2</option>\n");
      out.write("                        <option value=\"03\">3</option>\n");
      out.write("                        <option value=\"04\">4</option>\n");
      out.write("                        <option value=\"05\">5</option>\n");
      out.write("                        <option value=\"06\">6</option>\n");
      out.write("                        <option value=\"07\">7</option>\n");
      out.write("                        <option value=\"08\">8</option>\n");
      out.write("                        <option value=\"09\">9</option>\n");
      out.write("                        <option value=\"10\">10</option>\n");
      out.write("                        <option value=\"11\">11</option>\n");
      out.write("                        <option value=\"12\">12</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"submit\" name=\"submit\" id = \"submit_btn_theodoidanhsach\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"popup_xuatbaocao\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    Mã khách hàng: <input type=\"text\" name=\"customer_code\" id=\"customer_code_xuatbaocao\"><br>\n");
      out.write("                    Từ ngày: <input type=\"text\" name=\"from_date\" id = \"from_date_xuatbaocao\"><br>\n");
      out.write("                    Đến ngày: <input type=\"text\" name=\"to_date\" id = \"to_date_xuatbaocao\"><br>\n");
      out.write("                    <button id=\"submit_btn_xuatbaocao\">VIEW</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"popup_cauhinh\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h1>Cấu hình</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    Tuổi tối thiểu tham gia BHTN: <input type=\"text\" name=\"min_age_to_participant_VSI\" class=\"input_in_setting_popup\" id=\"input_min_age_to_participant_VSI\"> <button class=\"btn_in_setting_popup\" value=\"input_min_age_to_participant_VSI\">EDIT</button><br>\n");
      out.write("                    % lương doanh nghiệp đóng BHBB: <input type=\"text\" name=\"company_CSI_percentage\" class=\"input_in_setting_popup\" id=\"input_company_CSI_percentage\"> <button class=\"btn_in_setting_popup\" value=\"input_company_CSI_percentage\">EDIT</button><br>\n");
      out.write("                    % lương người lao động đóng BHBB<input type=\"text\" name=\"labor_CSI_percentage\" class=\"input_in_setting_popup\" id=\"input_labor_VSI_percentage\"> <button class=\"btn_in_setting_popup\" value=\"input_labor_VSI_percentage\">EDIT</button><br>\n");
      out.write("                    % lương người lao động đóng BHTN<input type=\"text\" name=\"labor_VSI_percentage\" class=\"input_in_setting_popup\" id=\"input_labor_CSI_percentage\"> <button class=\"btn_in_setting_popup\" value=\"input_labor_CSI_percentage\">EDIT</button><br>\n");
      out.write("                    Mức lương tối thiểu vùng 1: <input type=\"text\" name=\"1st_area_min_salary\" class=\"input_in_setting_popup\" id=\"input_1st_area_min_salary\"> <button class=\"btn_in_setting_popup\" value=\"input_1st_area_min_salary\">EDIT</button><br>\n");
      out.write("                    Mức lương tối thiểu vùng 2: <input type=\"text\" name=\"2nd_area_min_salary\" class=\"input_in_setting_popup\" id=\"input_2nd_area_min_salary\"> <button class=\"btn_in_setting_popup\" value=\"input_2nd_area_min_salary\">EDIT</button><br>\n");
      out.write("                    Mức lương tối thiểu vùng 3: <input type=\"text\" name=\"3rd_area_min_salary\" class=\"input_in_setting_popup\" id=\"input_3rd_area_min_salary\"> <button class=\"btn_in_setting_popup\" value=\"input_3rd_area_min_salary\">EDIT</button><br>\n");
      out.write("                    Mức lương tối thiểu vùng 4: <input type=\"text\" name=\"4th_area_min_salary\" class=\"input_in_setting_popup\" id=\"input_4th_area_min_salary\"> <button class=\"btn_in_setting_popup\" value=\"input_4th_area_min_salary\">EDIT</button><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button id=\"btn_save_setting\">SAVE</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
