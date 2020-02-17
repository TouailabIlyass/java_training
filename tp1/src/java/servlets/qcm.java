/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drging
 */
public class qcm extends HttpServlet {

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
            out.println("<title>Servlet qcm</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet qcm Result</h1>");
            
            if(request.getParameter("nom") != null && request.getParameter("prenom") != null )
            {
                out.println("<h4>votre nom  :  "+request.getParameter("nom")+" et votre prenom : "+request.getParameter("prenom")+"   </h4>");
            }
            if(request.getParameter("sexe") != null )
            {
                out.println("<h4>sexe :  "+request.getParameter("sexe")+"   </h4>");
            }
            if(request.getParameter("fct") != null )
            {
                out.println("<h4>fonction :  "+request.getParameter("fct")+"   </h4>");
            }
            if(request.getParameter("ls[0]") != null )
            {
                out.println("<h4>loisirs :  "+request.getParameter("ls[0]")+"   </h4>");
            }
            if(request.getParameter("ls[1]") != null )
            {
                out.println("<h4>loisirs :  "+request.getParameter("ls[1]")+"   </h4>");
            }
            if(request.getParameter("ls[2]") != null )
            {
                out.println("<h4>loisirs :  "+request.getParameter("ls[2]")+"   </h4>");
            }
            if(request.getParameter("cmt") != null )
            {
                out.println("<h4>comment :  "+request.getParameter("cmt")+"   </h4>");
            }
            
            
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
        processRequest(request, response);
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
