package jp.ac.tsuda;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 
 */
//@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String[] strVals = request.getParameterValues("shohinid");
        int numChecks = 0;
        if (strVals != null) {
            numChecks = strVals.length;
        } else {
            numChecks = 0;
        }
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/shohin";
            Connection con = DriverManager.getConnection(driverURL, "db", "db");
            Statement stmt = con.createStatement();
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            int total = 0;

            for (int i = 0; i < numChecks; i++) {
                int idFromCB = Integer.parseInt(strVals[i]);
                String sql = "select * from T_SHOHIN where SHOHIN_ID ="
                        + idFromCB;
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    Map<String, Object> record = new HashMap<String, Object>();
                    record.put("id", new Integer(rs.getInt("SHOHIN_ID")));
                    record.put("name", rs.getString("SHOHIN_NAME"));
                    record.put("price", new Integer(rs.getInt("PRICE")));
                    total = total + rs.getInt("PRICE");
                    list.add(record);
                }
                rs.close();
            }
            stmt.close();
            con.close();

            request.setAttribute("count", numChecks);
            request.setAttribute("data", list);
            request.setAttribute("total", total+600);

            RequestDispatcher rd = request.getRequestDispatcher("/CartCheckBox.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}