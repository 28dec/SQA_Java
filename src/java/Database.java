
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author longnh
 */
public class Database {

    private String user = "root";
    private String password = "1111";
    private Connection conn = null;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhxh", user, password);
            conn.createStatement().execute("SET NAMES UTF8");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public Object create_company(String name, String province, String district, String ward, String address_detail, String area_insurance_level) {
//        try {
//            CallableStatement stmt = conn.prepareCall("call create_company(?,?,?,?,?,?)");
//            stmt.setString(1, name);
//            stmt.setString(2, province);
//            stmt.setString(3, district);
//            stmt.setString(4, ward);
//            stmt.setString(5, address_detail);
//            stmt.setString(6, area_insurance_level);
//            ResultSet rs = stmt.executeQuery();
//            String rps = $stmt -> fetch();
//            if ($rps) {
//                echo $rps['result'
//              
//                ];
//            } else {
//                print_r($stmt -> errorInfo());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public Object create_customer($id, $code, $full_name, $job, $date_of_birth, $place_of_birth) {
//        $gender = '';
//			CallableStatement stmt = conn.prepareCall("call create_customer(?,?,?,?,?,?,?)");
//        stmt.setString(1, $id);
//        stmt.setString(2, $code);
//        stmt.setString(3, $full_name);
//        stmt.setString(4, $gender);
//        stmt.setString(5, $job);
//        stmt.setString(6, $date_of_birth);
//        stmt.setString(7, $place_of_birth);
//        if ((ResultSet rs =   stmt.executeQuery()) {
//            
//        }
//        
//            ){
//				$rps = $stmt -> fetch();
//            echo $rps['result'
//        ];
//			} else {
//				print_r($stmt->errorInfo());
//			}
//    }
//    public Object add_customer_to_company($customer_id, $company_id, $from_date) {
//        CallableStatement stmt = conn.prepareCall("call customer_workin_company(?,?,?);");
//        stmt.setString(2, $customer_id);
//        stmt.setString(1, $company_id);
//        stmt.setString(3, $from_date);
//        if ((ResultSet rs =   stmt.executeQuery()) {
//            
//        }
//        
//            ){
//				$rps = $stmt -> fetch();
//            echo $rps['result'
//        ];
//			} else {
//				print_r($stmt->errorInfo());
//			}
//    }
//
    public String get_total_voluntary_customer_paid(String from_date, String to_date) {
        String result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_voluntary_customer_paid(?,?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object get_total_voluntary_customer_unpaid(String from_date, String to_date) {
        String result = "";
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("call get_total_voluntary_customer_unpaid(?,?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
        return result;
    }

    public Object get_total_voluntary_paid_money(String from_date, String to_date) {
        String result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_voluntary_paid_money(?,?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object get_total_voluntary_unpaid_money(String from_date, String to_date) {
        String result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_voluntary_unpaid_money(?,?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object get_total_voluntary_customer(String from_date, String to_date) {
        String result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_voluntary_customer(?,?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object get_total_compulsory_customer(String from_date, String to_date) {
        String result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_compulsory_customer(?,?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object create_new_rule(String min_age_to_participant_VSI, String company_CSI_percentage, String labor_CSI_percentage, String labor_VSI_percentage, String _1st_area_min_salary, String _2nd_area_min_salary, String _3rd_area_min_salary, String _4th_area_min_salary) {
        String result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call create_new_rule(?, ?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, min_age_to_participant_VSI);
            stmt.setString(2, company_CSI_percentage);
            stmt.setString(3, labor_CSI_percentage);
            stmt.setString(4, labor_VSI_percentage);
            stmt.setString(5, _1st_area_min_salary);
            stmt.setString(6, _2nd_area_min_salary);
            stmt.setString(7, _3rd_area_min_salary);
            stmt.setString(8, _4th_area_min_salary);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object load_rule() {
        Object result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call load_rule();");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object get_total_company(String from_date, String to_date) {
        String result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_company()");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object get_total_compulsory_paid_money(String from_date, String to_date) {
        String result = null;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_compulsory_paid_money(?, ?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getString("result");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object get_total_paid_company(String from_date, String to_date) {
        int result = 0;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_paid_company(?,?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object get_total_unpaid_company(String from_date, String to_date) {
        int result = 0;
        try {
            CallableStatement stmt = conn.prepareCall("call get_total_unpaid_company(?,?)");
            stmt.setString(1, from_date);
            stmt.setString(2, to_date);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Object report_person(String customer_code, String from_date, String to_date) {
        int result = 0;
        try {
            CallableStatement stmt = conn.prepareCall("call get_insurance_by_customer_code(?,?,?)");
            stmt.setString(1, customer_code);
            stmt.setString(2, from_date);
            stmt.setString(3, to_date);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
