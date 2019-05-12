/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author longnh
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get_total_voluntary_customer_paid method, of class Database.
     */
    @Test
    public void testGet_total_voluntary_customer_paid() {
        System.out.println("get_total_voluntary_customer_paid");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        String expResult = "1";
        String result = instance.get_total_voluntary_customer_paid(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of get_total_voluntary_customer_unpaid method, of class Database.
     */
    @Test
    public void testGet_total_voluntary_customer_unpaid() {
        System.out.println("get_total_voluntary_customer_unpaid");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        String expResult = "2";
        Object result = instance.get_total_voluntary_customer_unpaid(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of get_total_voluntary_paid_money method, of class Database.
     */
    @Test
    public void testGet_total_voluntary_paid_money() {
        System.out.println("get_total_voluntary_paid_money");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        String expResult = "8000000";
        Object result = instance.get_total_voluntary_paid_money(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of get_total_voluntary_unpaid_money method, of class Database.
     */
    @Test
    public void testGet_total_voluntary_unpaid_money() {
        System.out.println("get_total_voluntary_unpaid_money");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        String expResult = "28000000";
        Object result = instance.get_total_voluntary_unpaid_money(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of get_total_voluntary_customer method, of class Database.
     */
    @Test
    public void testGet_total_voluntary_customer() {
        System.out.println("get_total_voluntary_customer");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        Object expResult = "3";
        Object result = instance.get_total_voluntary_customer(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of get_total_compulsory_customer method, of class Database.
     */
    @Test
    public void testGet_total_compulsory_customer() {
        System.out.println("get_total_compulsory_customer");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        Object expResult = "2";
        Object result = instance.get_total_compulsory_customer(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of create_new_rule method, of class Database.
     */
    @Test
    public void testCreate_new_rule() {
        System.out.println("create_new_rule");
        String min_age_to_participant_VSI = "15";
        String company_CSI_percentage = "17.0";
        String labor_CSI_percentage = "8.0";
        String labor_VSI_percentage = "10.0";
        String _1st_area_min_salary = "4700000";
        String _2nd_area_min_salary = "4400000";
        String _3rd_area_min_salary = "4100000";
        String _4th_area_min_salary = "3600000";
        Database instance = new Database();
        Object expResult = "SUCCESS";
        Object result = instance.create_new_rule(min_age_to_participant_VSI, company_CSI_percentage, labor_CSI_percentage, labor_VSI_percentage, _1st_area_min_salary, _2nd_area_min_salary, _3rd_area_min_salary, _4th_area_min_salary);
        assertEquals(expResult, result);
    }


    /**
     * Test of get_total_company method, of class Database.
     */
    @Test
    public void testGet_total_company() {
        System.out.println("get_total_company");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        Object expResult = "2";
        Object result = instance.get_total_company(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of get_total_compulsory_paid_money method, of class Database.
     */
    @Test
    public void testGet_total_compulsory_paid_money() {
        System.out.println("get_total_compulsory_paid_money");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        String expResult = "15000000";
        Object result = instance.get_total_compulsory_paid_money(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of get_total_paid_company method, of class Database.
     */
    @Test
    public void testGet_total_paid_company() {
        System.out.println("get_total_paid_company");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        Object expResult = 2;
        Object result = instance.get_total_paid_company(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of get_total_unpaid_company method, of class Database.
     */
    @Test
    public void testGet_total_unpaid_company() {
        System.out.println("get_total_unpaid_company");
        String from_date = "02/2019";
        String to_date = "02/2019";
        Database instance = new Database();
        Object expResult = 0;
        Object result = instance.get_total_unpaid_company(from_date, to_date);
        assertEquals(expResult, result);
    }

    /**
     * Test of report_person method, of class Database.
     */
    @Test
    public void testReport_person() {
        System.out.println("report_person");
        String customer_code = "dz1102";
        String from_date = "02/2019";
        String to_date = "03/2019";
        Database instance = new Database();
        JSONArray expResult = new JSONArray();
        JSONObject j = new JSONObject();
        j.put("customer_code", "DZ1102");
        j.put("full_name", "Nguyễn Hoàng Long");
        j.put("gender", "MALE");
        j.put("pay_date", "02/2019");
        j.put("money", "10000000");
        j.put("type_of_insurance", "COMPULSORY");
        expResult.put(j);
        JSONArray result = instance.report_person(customer_code, from_date, to_date);
        assertEquals(expResult.toString(), result.toString());
    }



    /**
     * Test of search_customer_by_code method, of class Database.
     */
    @Test
    public void testSearch_customer_by_code() {
        System.out.println("search_customer_by_code");
        String code = "";
        Database instance = new Database();
        String expResult = "NO RESULT!";
        String result = instance.search_customer_by_code(code);
        assertEquals(expResult, result);
    }
    
}
