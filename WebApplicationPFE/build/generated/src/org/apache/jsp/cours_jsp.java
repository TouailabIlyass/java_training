package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cours_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<body>\n");
      out.write("<header>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.html", out, false);
      out.write("</header>\n");
      out.write("<style>\n");
      out.write("    h3{\n");
      out.write("        color:red;\n");
      out.write("      }\n");
      out.write("      p{\n");
      out.write("          color:white;\n");
      out.write("      }\n");
      out.write("</style>\n");
      out.write("<section class=\"box-content box-4 box-style-2\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"box-item\">\n");
      out.write("              <blockquote><h4 style=\"color:white;\">Voici touts les cours en ce qui concerne l'optique géométrique</h4></blockquote>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("</section>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<div class=\"container\" >\n");
      out.write("<center><button type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\"><strong>Voir Tous les Cours</strong></button></center>\n");
      out.write("</marquee><br><br>\n");
      out.write("  <!-- Modal -->\n");
      out.write("  <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("    \n");
      out.write("      <!-- Modal content-->\n");
      out.write("      <div class=\"modal-content\">\n");
      out.write("        <div class=\"modal-header\">\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("          <center><h2 class=\"modal-title\"><em>CHAPITRES :</em></h2></center>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-body\">\n");
      out.write("          <div class=\"list-group\">\n");
      out.write("              <center> <a href=\"#\" class=\"list-group-item active disabled\"><h3>Lentille & Mirroires</h3></a></center>\n");
      out.write("               <a href=\"cours/Lentillesconvergentes.pdf\" target=\"_blanc\" class=\"list-group-item\"><strong>1/- Lentille Convergente</strong></a>\n");
      out.write("               <a href=\"cours/divergente.html\" target=\"_blanc\" class=\"list-group-item\"><strong>2/- Lentille Divergente</strong></a>\n");
      out.write("               <a href=\"cours/miroir.pdf\" target=\"_blanc\" class=\"list-group-item\"><strong>3/- Miroir Concave</strong></a>\n");
      out.write("               <a href=\"cours/miroir.pdf\" target=\"_blanc\" class=\"list-group-item\"><strong>4/- Miroir Convexe</strong></a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-footer\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\"><strong style=\"color :blue;\">Close</strong></button>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<nav>\n");
      out.write("<div class=\"row\">\n");
      out.write("          <div class=\"col-md-4\">\n");
      out.write("            <div class=\"box-item\">\n");
      out.write("              <img src=\"img/l3.png\" class=\"img-responsive\"/>\n");
      out.write("              <div class=\"content\">\n");
      out.write("                  <center><h3>Lentille Convergente</h3></center>\n");
      out.write("<p>Une lentille est constituée par un milieu transparent limité par deux dioptres sphériques de\n");
      out.write("rayons r1 et r2. La droite joignant les centres C1 et C2 de ces calottes est l?axe optique de la\n");
      out.write("lentille. Si les rayons des deux calottes sont égaux, le centre de la lentille est son centre\n");
      out.write("optique O.<br>Si elle est plus mince aux bords qu'au milieu elle est convergente, sinon elle est\n");
      out.write("divergente </p>               \n");
      out.write("<span>MAY 21, 2014 BY VAFPRESS</span><br>\n");
      out.write("                <center><a class=\"btn btn-1\" href=\"cours/Lentillesconvergentes.pdf\">Read More</a></center>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("            <div class=\"box-item\">\n");
      out.write("              <img src=\"img/l2.jpg\" class=\"img-responsive\"/>\n");
      out.write("              <div class=\"content\">\n");
      out.write("                <center><h3>Lentille Divergente</h3></center>\n");
      out.write("<p>Une lentille est constituée par un milieu transparent limité par deux dioptres sphériques de\n");
      out.write("rayons r1 et r2. La droite joignant les centres C1 et C2 de ces calottes est l?axe optique de la\n");
      out.write("lentille. Si les rayons des deux calottes sont égaux, le centre de la lentille est son centre\n");
      out.write("optique O. <br>Si elle est plus mince aux bords qu'au milieu elle est convergente, sinon elle est\n");
      out.write("divergente</p>                \n");
      out.write("<span>MAY 21, 2014 BY VAFPRESS</span><br>\n");
      out.write("<center><a class=\"btn btn-1\" href=\"cours/divergente.html\" >Read More</a></center>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("             <div class=\"col-md-4\">\n");
      out.write("            <div class=\"box-item\">\n");
      out.write("              <img src=\"img/l6.jpg\" class=\"img-responsive\"/>\n");
      out.write("              <div class=\"content\">\n");
      out.write("                  <center><h3>Miroir Convexe</h3></center>\n");
      out.write("                <p>Suspendisse porttitor sapien ac lectus euismod imperdiet. Curabitur nec nibh at massa pellentesque accumsan eu id nibh. Donec accumsan ut mi et tincidunt. Aliquam eget metus nec leo tempor bibendum. Phasellus tincidunt lobortis metus. Duis euismod lorem turpis at diam.</p>\n");
      out.write("                <span>MAY 21, 2014 BY VAFPRESS</span><br>\n");
      out.write("                <center><a class=\"btn btn-1\" href=\"cours/miroir.pdf\">Read More</a></center>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("             </div><br>\n");
      out.write("             \n");
      out.write("          \n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write(" </div>\n");
      out.write("</nav>\n");
      out.write("<br><br><br>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.html", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
