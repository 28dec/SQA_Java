
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.json.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author longnh
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private Database db;

    public Controller() {
        db = new Database();
        System.out.println("database initiated!");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            String cmd = req.getParameter("command");
            out = res.getWriter();
            switch (cmd) {
                case "system_report":
                    system_report(req, res);
                    break;
                case "create_new_rule":
                    create_new_rule(req, res);
                    break;
                case "load_rule":
                    load_rule(req, res);
                    break;
                case "xuatbaocao_person":
                    xuatbaocao_person(req, res);
                    break;
                case "search_customer_by_name":
                    search_customer_by_name(req, res);
                    break;
                case "search_customer_by_code":
                    search_customer_by_code(req, res);
                    break;
                case "search_customer_by_code_0":
                    search_customer_by_code_0(req, res);
                    break;
                default:
                    out.println("UNKNOWN INPUT COMMAND -> " + cmd);
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public void search_customer_by_code_0(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        try {
            out = res.getWriter();
            JSONArray result_1045 = db.search_customer_by_code0(req.getParameter("code"));
            out.print(result_1045.toString());
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public void search_customer_by_code(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        try {
            out = res.getWriter();
            String result_0030 = db.search_customer_by_code(req.getParameter("code"));
            out.print(result_0030);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public void search_customer_by_name(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        try {
            out = res.getWriter();
            JSONArray result_2349 = db.search_customer_by_name(req.getParameter("name"));
            out.print(result_2349.toString());
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public void xuatbaocao_person(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        try {
            out = res.getWriter();
            JSONArray result = db.report_person(req.getParameter("customer_code"), req.getParameter("from_date"), req.getParameter("to_date"));
            if (result.length() == 0) {
                out.print("<h4 style='color:red;'>Không có dữ liệu nào với mã khách hàng -> [" + req.getParameter("customer_code") + "] trong khoảng thời gian từ " + req.getParameter("from_date") + " đến " + req.getParameter("to_date") + "</h4>");
                return;
            }
            out.print("<table>");
            out.print("<thead>");
            out.print("<th>STT</th>");
            out.print("<th>Mã BHXH</th>");
            out.print("<th>Tên khách hàng</th>");
            out.print("<th>Giới tính</th>");
            out.print("<th>Loại bảo hiểm</th>");
            out.print("<th>Thời gian bảo hiểm</th>");
            out.print("<th>Số tiền</th>");
            out.print("</thead>");
            out.print("<tbody>");
            for (int i = 0; i < result.length(); i++) {
                out.print("<tr>");
                out.print("<td>" + (i + 1) + "</td>");
                out.print("<td>" + result.getJSONObject(i).getString("customer_code") + "</td>");
                out.print("<td>" + result.getJSONObject(i).getString("full_name") + "</td>");
                String gender = "";
                if (result.getJSONObject(i).getString("gender").equals("MALE")) {
                    gender = "NAM";
                } else if (result.getJSONObject(i).getString("gender").equals("FEMALE")) {
                    gender = "NỮ";
                }
                out.print("<td>" + gender + "</td>");
                String type_of_insurance = "";
                if (result.getJSONObject(i).getString("type_of_insurance").equals("COMPULSORY")) {
                    type_of_insurance = "BẮT BUỘC";
                } else if (result.getJSONObject(i).getString("type_of_insurance").equals("VOLUNTARY")) {
                    type_of_insurance = "TỰ NGUYỆN";
                }
                out.print("<td>" + type_of_insurance + "</td>");
                out.print("<td>" + result.getJSONObject(i).getString("pay_date") + "</td>");
                out.print("<td>" + result.getJSONObject(i).getString("money") + "</td>");
                out.print("</tr>");
            }
            out.print("</tbody>");
            out.print("</table>");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public void load_rule(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        try {
            out = res.getWriter();
            JSONObject j = db.load_rule();
            out.print(j.toString());
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public void create_new_rule(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        try {
            out = res.getWriter();
            out.print(db.create_new_rule(req.getParameter("min_age_to_participant_VSI"), req.getParameter("company_CSI_percentage"), req.getParameter("labor_CSI_percentage"), req.getParameter("labor_VSI_percentage"), req.getParameter("1st_area_min_salary"), req.getParameter("2nd_area_min_salary"), req.getParameter("3rd_area_min_salary"), req.getParameter("4th_area_min_salary")));
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public void system_report(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        try {
            out = res.getWriter();
            if (req.getParameter("type").equals("voluntary")) {
                String total_voluntary_customer_paid = (String) db.get_total_voluntary_customer_paid(req.getParameter("from_date"), req.getParameter("to_date"));
                String total_voluntary_customer_unpaid = (String) (db.get_total_voluntary_customer_unpaid(req.getParameter("from_date"), req.getParameter("to_date")));
                String total_voluntary_paid_money = (String) db.get_total_voluntary_paid_money(req.getParameter("from_date"), req.getParameter("to_date"));
                String total_voluntary_unpaid_money = (String) db.get_total_voluntary_unpaid_money(req.getParameter("from_date"), req.getParameter("to_date"));
                String total_voluntary_customer = (String) db.get_total_voluntary_customer(req.getParameter("from_date"), req.getParameter("to_date"));
                System.out.println("get all data done");
                if (total_voluntary_customer_paid == null || total_voluntary_customer_unpaid == null || total_voluntary_paid_money == null || total_voluntary_unpaid_money == null || total_voluntary_customer == null) {
                    out.print("<h3 style='color:red'>Không có dữ liệu nào</h3>");
                    return;
                }
                out.print("<table>");
                out.print("<thead>");
                out.print("<th>");
                out.print("Nội dung");
                out.print("</th>");
                out.print("<th>");
                out.print("Số lượng");
                out.print("</th>");
                out.print("<th>");
                out.print("Đơn vị");
                out.print("</th>");
                out.print("</thead>");
                out.print("<tbody>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Số khách hàng đã đóng đủ");
                out.print("</td>");
                out.print("<td>");
                out.print(total_voluntary_customer_paid);
                out.print("</td>");
                out.print("<td>");
                out.print("Người");
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Tổng số tiền đã thu");
                out.print("</td>");
                out.print("<td>");
                out.print(total_voluntary_paid_money);
                out.print("</td>");
                out.print("<td>");
                out.print("Đồng");
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Số khách hàng chưa đóng đủ");
                out.print("</td>");
                out.print("<td>");
                out.print(total_voluntary_customer_unpaid);
                out.print("</td>");
                out.print("<td>");
                out.print("Người");
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Tổng số tiền chưa thu");
                out.print("</td>");
                out.print("<td>");
                out.print(total_voluntary_unpaid_money);
                out.print("</td>");
                out.print("<td>");
                out.print("Đồng");
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Tổng số khách hàng");
                out.print("</td>");
                out.print("<td>");
                out.print(total_voluntary_customer);
                out.print("</td>");
                out.print("<td>");
                out.print("Người");
                out.print("</td>");
                out.print("</tr>");
                out.print("</tbody>");
                out.print("</table>");
            } else if (req.getParameter("type").equals("compulsory")) {
                String total_company = (String) db.get_total_company(req.getParameter("from_date"), req.getParameter("to_date"));
                String total_compulsory_paid_money = (String) db.get_total_compulsory_paid_money(req.getParameter("from_date"), req.getParameter("to_date"));
                String total_paid_company = String.valueOf(db.get_total_paid_company(req.getParameter("from_date"), req.getParameter("to_date")));
                String total_unpaid_company = String.valueOf(db.get_total_unpaid_company(req.getParameter("from_date"), req.getParameter("to_date")));
                String total_compulsory_customer = (String) db.get_total_compulsory_customer(req.getParameter("from_date"), req.getParameter("to_date"));
                if (total_company == null || total_compulsory_paid_money == null || total_paid_company == null || total_unpaid_company == null || total_compulsory_customer == null) {
                    out.print("<h3 style='color:red'>Không có dữ liệu nào</h3>");
                    return;
                }
                out.print("<table>");
                out.print("<thead>");
                out.print("<th>");
                out.print("Nội dung");
                out.print("</th>");
                out.print("<th>");
                out.print("Số lượng");
                out.print("</th>");
                out.print("<th>");
                out.print("Đơn vị");
                out.print("</th>");
                out.print("</thead>");
                out.print("<tbody>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Số doanh nghiệp tham gia");
                out.print("</td>");
                out.print("<td>");
                out.print(total_company);
                out.print("</td>");
                out.print("<td>");
                out.print("Người");
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Tổng số tiền đã thu");
                out.print("</td>");
                out.print("<td>");
                out.print(total_compulsory_paid_money);
                out.print("</td>");
                out.print("<td>");
                out.print("Đồng");
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Số doanh nghiệp đã đóng");
                out.print("</td>");
                out.print("<td>");
                out.print(total_paid_company);
                out.print("</td>");
                out.print("<td>");
                out.print("Người");
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Số doanh nghiệp chưa đóng");
                out.print("</td>");
                out.print("<td>");
                out.print(total_unpaid_company);
                out.print("</td>");
                out.print("<td>");
                out.print("Đồng");
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Tổng số khách hàng");
                out.print("</td>");
                out.print("<td>");
                out.print(total_compulsory_customer);
                out.print("</td>");
                out.print("<td>");
                out.print("Người");
                out.print("</td>");
                out.print("</tr>");
                out.print("</tbody>");
                out.print("</table>");
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
}
