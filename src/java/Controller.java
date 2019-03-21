
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
                    if (req.getParameter("type").equals("voluntary")) {
                        String total_voluntary_customer_paid = (String) db.get_total_voluntary_customer_paid(req.getParameter("from_date"), req.getParameter("to_date"));
                        String total_voluntary_customer_unpaid = (String) (db.get_total_voluntary_customer_unpaid(req.getParameter("from_date"), req.getParameter("to_date")));
                        String total_voluntary_paid_money = (String) db.get_total_voluntary_paid_money(req.getParameter("from_date"), req.getParameter("to_date"));
                        String total_voluntary_unpaid_money = (String) db.get_total_voluntary_unpaid_money(req.getParameter("from_date"), req.getParameter("to_date"));
                        String total_voluntary_customer = (String) db.get_total_voluntary_customer(req.getParameter("from_date"), req.getParameter("to_date"));
                        System.out.println("get all data done");
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
                        out.println("compulsory");
                        String total_company = (String) db.get_total_company(req.getParameter("from_date"), req.getParameter("to_date"));
                        String total_compulsory_paid_money = (String) db.get_total_compulsory_paid_money(req.getParameter("from_date"), req.getParameter("to_date"));
                        String total_paid_company = String.valueOf(db.get_total_paid_company(req.getParameter("from_date"), req.getParameter("to_date")));
                        String total_unpaid_company = String.valueOf(db.get_total_unpaid_company(req.getParameter("from_date"), req.getParameter("to_date")));
                        String total_compulsory_customer = (String) db.get_total_compulsory_customer(req.getParameter("from_date"), req.getParameter("to_date"));
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
                case "create_new_rule":
                    out.print(db.create_new_rule(req.getParameter("min_age_to_participant_VSI"), req.getParameter("company_CSI_percentage"), req.getParameter("labor_CSI_percentage"), req.getParameter("labor_VSI_percentage"), req.getParameter("1st_area_min_salary"), req.getParameter("2nd_area_min_salary"), req.getParameter("3rd_area_min_salary"), req.getParameter("4th_area_min_salary")));
                    break;
                case "load_rule":
                    JSONObject j = db.load_rule();
                    out.print(j.toString());
                    break;
                case "xuatbaocao_person":
                    JSONArray result = db.report_person(req.getParameter("customer_code"), req.getParameter("from_date"), req.getParameter("to_date"));
                    out.print("<table>");
                    out.print("<thead>");
                    out.print("<th>STT</th>");
                    out.print("<th>Mã BHXH</th>");
                    out.print("<th>Tên khách hàng</th>");
                    out.print("<th>Giới tính</th>");
                    out.print("<th>Loại bảo hiểm</th>");
                    out.print("<th>Pay date</th>");
                    out.print("<th>Số tiền</th>");
                    out.print("</thead>");
                    out.print("<tbody>");
                    for (int i = 0; i < result.length(); i++) {
			out.print("<tr>");
                        out.print("<td>" + (i + 1) + "</td>");
			out.print("<td>" + result.getJSONObject(i).getString("customer_code") + "</td>");
			out.print("<td>" + result.getJSONObject(i).getString("full_name") + "</td>");
			out.print("<td>" + result.getJSONObject(i).getString("gender") + "</td>");
			out.print("<td>" + result.getJSONObject(i).getString("type_of_insurance") + "</td>");
			out.print("<td>" + result.getJSONObject(i).getString("pay_date") + "</td>");
			out.print("<td>" + result.getJSONObject(i).getString("money") + "</td>");
                        out.print("</tr>");
                    }
                    out.print("</tbody>");
                    out.print("</table>");
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
}
