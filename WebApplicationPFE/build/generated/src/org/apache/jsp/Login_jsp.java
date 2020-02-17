package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html >\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Animated Background</title>\n");
      out.write("  <link href='https://fonts.googleapis.com/css?family=Raleway:200,400,800' rel='stylesheet' type='text/css'>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"bootstrap-3.3.7-dist/css/bootstrap.min.css\">\n");
      out.write("  <link rel='stylesheet prefetch' href='https://www.marcoguglie.it/Codepen/AnimatedHeaderBg/demo-1/css/demo.css'>\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("  <script src=\"bootstrap-3.3.7-dist/jquery-3.1.0.min.js\"></script>\n");
      out.write("  <script src=\"bootstrap-3.3.7-dist/js/bootstrap.min.js\"></script>\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\n");
      out.write("  .main-title:hover\n");
      out.write("{\n");
      out.write("   text-decoration: underline double brown; \n");
      out.write("   cursor: default;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("  <div id=\"large-header\" class=\"large-header\">\n");
      out.write("  <br><br><br><br>\n");
      out.write("  <center><h1 style=\"color:green;\"><em>Platforme des Lois Optiques<em></h1></marquee></center>\n");
      out.write("  <canvas id=\"demo-canvas\"></canvas>\n");
      out.write("    <h1 data-toggle=\"modal\" data-target=\"#myModal\" class=\"main-title\">Log In</h1>\n");
      out.write("</div>\n");
      out.write("  \n");
      out.write("<script src='https://www.marcoguglie.it/Codepen/AnimatedHeaderBg/demo-1/js/EasePack.min.js'></script>\n");
      out.write("<script src='https://www.marcoguglie.it/Codepen/AnimatedHeaderBg/demo-1/js/rAF.js'></script>\n");
      out.write("<script src='https://www.marcoguglie.it/Codepen/AnimatedHeaderBg/demo-1/js/TweenLite.min.js'></script>\n");
      out.write("<script src=\"js/index.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write(" <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("      <div class=\"modal-content\">\n");
      out.write("        <div class=\"modal-header\" style=\"background-image:url('flou.jpg');\">\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\n");
      out.write("          <center><h4 class=\"modal-title\"><strong style=\"color: black;\">Connection :</strong></h4></center>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-body\" style=\"background-image: url('flou.jpg');\">\n");
      out.write("      <!-------------------------------------------------------------->\n");
      out.write("\n");
      out.write("<form action=\"logincheck.jsp\" method=\"POST\">\n");
      out.write("    \n");
      out.write(" <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n");
      out.write("      <input  type=\"text\" class=\"form-control\" name=\"user\" placeholder=\"Utilisateur\" required>\n");
      out.write("    </div><br>\n");
      out.write("\n");
      out.write("    <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-lock\"></i></span>\n");
      out.write("      <input  type=\"password\" class=\"form-control\" name=\"pass\" placeholder=\"Mot de Passe\" required>\n");
      out.write("    </div><br>\n");
      out.write(" </div>\n");
      out.write(" \n");
      out.write("   <div class=\"modal-footer\" style=\"background-image: url('flou.jpg');\">\n");
      out.write("   <button type=\"reset\" class=\"btn btn-info\" >Reset</button>\n");
      out.write("   <button type=\"submit\" name=\"envoyer\" class=\"btn btn-success\">LogIn</button>\n");
      out.write("   \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</form>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
