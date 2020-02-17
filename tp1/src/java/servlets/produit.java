/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author drging
 */
public class produit extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet produit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet produit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        
        if(request.getParameter("vl") != null)
        {
        
            PrintWriter out = response.getWriter();
            out.println("votre de demande entrai de traitement !! merci");
            HttpSession session = request.getSession(false);
            if(session.getAttribute("produit") != null)
            {
                session.removeAttribute("produit");
                
            }
        }
        else
        {
            
     
       
        HashMap<String,Integer> produits = new HashMap<String,Integer>();
        String tmp[];
 
        
            if(request.getParameter("p[0]") != null )
            {
                tmp = request.getParameter("p[0]").split(",");
                produits.put(tmp[0], Integer.valueOf(tmp[1]));
                
            }
            if(request.getParameter("p[1]") != null )
            {
                tmp = request.getParameter("p[1]").split(",");
                produits.put(tmp[0], Integer.valueOf(tmp[1]));
                
            }
            if(request.getParameter("p[2]") != null )
            {
                tmp = request.getParameter("p[2]").split(",");
                produits.put(tmp[0], Integer.valueOf(tmp[1]));
            }
            if(request.getParameter("p[3]") != null )
            {
                tmp = request.getParameter("p[3]").split(",");
                produits.put(tmp[0], Integer.valueOf(tmp[1]));
            }
        
        
        HttpSession session = request.getSession();
            session.setAttribute("produit",produits);
            request.getRequestDispatcher("mespro.jsp").forward(request, response);
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
