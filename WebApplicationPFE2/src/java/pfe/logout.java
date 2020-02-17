/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet{
    
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException 
    {
        HttpSession session=request.getSession();
             session.removeAttribute("user");
             session.removeAttribute("pass");
             session.invalidate();
            
             response.sendRedirect("index.jsp");
        
             
    }

}