/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author drging
 */
public class test extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
        try {
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Cookie ck = new Cookie("ttt2", "444");
        ck.setMaxAge(24*60*60);
        response.addCookie(ck);
       
        Cookie[] c = request.getCookies();
        String v="";
        for (int i = 0; i < c.length; i++) {
            System.out.println(""+c[i].getValue());
        }
        
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("cf") != null)
        {
            
     
        String fname,lname,amount,pay,ncard,ccard,ecard,cvv;
        
        fname = request.getParameter("fname");
        lname = request.getParameter("lname");
        amount = request.getParameter("amount");
        pay = request.getParameter("pay");
        ncard = request.getParameter("ncard");
        ccard = request.getParameter("ccard");
        ecard = request.getParameter("ecard");
        cvv = request.getParameter("cvv");
        if(fname == null || lname == null || amount == null|| pay == null|| ncard == null|| ccard == null|| ecard == null|| cvv == null)
        {
            response.sendRedirect("erreur.html");
        }else
        {
            HttpSession session = request.getSession();
            session.setAttribute("fname",fname);
            session.setAttribute("lname",lname);
            session.setAttribute("amount",amount);
            request.getRequestDispatcher("info.jsp").forward(request, response);
        }
        
        }
        else
        {
            request.getRequestDispatcher("fin.jsp").forward(request, response);
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
