
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

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
    public Controller(){
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
                        String total_voluntary_customer_unpaid = (String)(db.get_total_voluntary_customer_unpaid(req.getParameter("from_date"), req.getParameter("to_date")));
                        String total_voluntary_paid_money = (String)db.get_total_voluntary_paid_money(req.getParameter("from_date"), req.getParameter("to_date"));
                        String total_voluntary_unpaid_money = (String)db.get_total_voluntary_unpaid_money(req.getParameter("from_date"), req.getParameter("to_date"));
                        String total_voluntary_customer = (String)db.get_total_voluntary_customer(req.getParameter("from_date"), req.getParameter("to_date"));
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
                    } else {
                        out.print("this page for compulsory");
                    }
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