/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drging
 */
public class Servlet1 extends HttpServlet {

    
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html");
            response.getWriter().println("<!DOCTYPE html><html><head><title>test page</title></head><body>hello world</body></html>");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Login="admin";
        String Pass="123";
        
        if(request.getParameter("login").equals(Login) && request.getParameter("pass").equals(Pass))
        {
            response.sendRedirect("index2.jsp");
        }
        else
        {
           request.setAttribute("status", "erreur");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
      
    }
 
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
