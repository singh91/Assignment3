/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Connection.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author c0655613
 */
@WebServlet("/products")
public class newServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Content-Type", "text/plain-text");

        try (PrintWriter out = response.getWriter()) {

            if (!request.getParameterNames().hasMoreElements()) {
                out.println(getResult("SELECT * FROM product"));
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("hello");
                out.println(getResult("SELECT * FROM product WHERE productID = ?", String.valueOf(id)));
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());

        }
    }

}

}
