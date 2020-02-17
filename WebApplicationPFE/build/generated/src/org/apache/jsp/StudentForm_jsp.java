package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pfe.Student;
import pfe.StudentDao;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;

public final class StudentForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Admin page</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/admin.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap-3.3.7-dist/css/bootstrap.min.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body style=\"background-image: url('img/proj.jpg'); background-attachment: fixed; \">\n");
      out.write("\n");
      out.write("<header>\n");
      out.write(" <div class=\"jumbotron\">\n");
      out.write("    <center><h1>Gestionnaire platforme</h1>\n");
      out.write("    <p>Gestion des etudiants,des cours,des simulations .</p> </center>\n");
      out.write("  </div> \n");
      out.write("</header>\n");
      out.write("\n");
      out.write("\n");
      out.write("<section>\n");
      out.write("    <ul>\n");
      out.write("\t <li><a href=\"StudentForm.jsp\">Gestion des Etudiants</a></li>\n");
      out.write("\t <li><a href=\"#\">Gestion des Cours</a></li>\n");
      out.write("\t <li><a href=\"#\">Gestion des Simulations</a></li>\n");
      out.write("\t <li><center><a href=\"AdminAcceuil.html\">Quitter</a></center></li>\n");
      out.write("\t</ul>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<div id=\"section1\">\n");
      out.write("<center><h2>Ajouter Etudiant :</h2></center> <br><br>\n");
      out.write(" <form action=\"addStudent.jsp\" method=\"POST\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n");
      out.write("      <input   type=\"text\" class=\"form-control\" name=\"nom\" placeholder=\"Nom\" required>\n");
      out.write("    </div><br>\n");
      out.write("\n");
      out.write("    <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n");
      out.write("      <input  type=\"text\" class=\"form-control\" name=\"prenom\" placeholder=\"Prenom\" required>\n");
      out.write("    </div><br>\n");
      out.write("\n");
      out.write("    <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-envelope\"></i></span>\n");
      out.write("      <input  type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Adresse Email\" required>\n");
      out.write("    </div><br>\n");
      out.write("\n");
      out.write("    <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n");
      out.write("      <input  type=\"text\" class=\"form-control\" name=\"user\" placeholder=\"Utilisateur\" required>\n");
      out.write("    </div><br>\n");
      out.write("\n");
      out.write("    <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-lock\"></i></span>\n");
      out.write("      <input  type=\"password\" class=\"form-control\" name=\"pass\" placeholder=\"Mot de Passe\" required>\n");
      out.write("    </div><br>\n");
      out.write("\n");
      out.write("    <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-calendar\"></i> <strong> Date de Naissance</strong></span>\n");
      out.write("      <input  type=\"date\" class=\"form-control\" name=\"Date\" required>\n");
      out.write("    </div><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"input-group\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-education\"></i>    <strong>Votre Filiere ?</strong></span>\n");
      out.write("      <select class=\"form-control\" id=\"filiere\" name=\"filiere\">\n");
      out.write("      \t<option >Genie Informatique</option>\n");
      out.write("      \t<option >Genie Industrielle et Maintenance</option>\n");
      out.write("      \t<option >Technique de Management</option>\n");
      out.write("      \t<option >Controle de Qualité</option>\n");
      out.write("      </select>\n");
      out.write("    </div><br><br><br>\n");
      out.write("<center>\n");
      out.write("<button type=\"reset\" class=\"btn btn-info\" >Reset</button>\n");
      out.write("<button type=\"submit\" name=\"envoyer\" class=\"btn btn-success\" >Ajouter</button>\n");
      out.write("</center>\n");
      out.write("</form>\n");
      out.write("\t\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
 
    List<Student> list=StudentDao.getAllstudent();
    request.setAttribute("list", list);
    
      out.write("\n");
      out.write("    \n");
      out.write("<div id=\"section2\">\n");
      out.write("<center><h2>Liste des Etudiant :</h2></center> <br><br>\n");
      out.write("\n");
      out.write("  <table class=\"table table-striped\">\n");
      out.write("    <thead>\n");
      out.write("      <tr>\n");
      out.write("        <th>Id</th>\n");
      out.write("        <th>Nom</th>\n");
      out.write("        <th>Prenom</th>\n");
      out.write("        <th>Adresse</th>\n");
      out.write("        <th>User</th>\n");
      out.write("        <th>Password</th>\n");
      out.write("        <th>Date</th>\n");
      out.write("        <th>Filiere</th>\n");
      out.write("        <th></th>\n");
      out.write("      </tr>\n");
      out.write("    </thead>\n");
      out.write("   \n");
      out.write("    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    \n");
      out.write("  </table>\n");
      out.write("</div>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("<br><br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("s");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("    <tbody>\n");
          out.write("      <tr>\n");
          out.write("        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getNom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getPrenom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getAdresse()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getUser()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getPass()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getDate()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getFiliere()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write(" <td><a href=\"DeleteStudent.jsp?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Supprimer </a><a href=\"EditStudent.jsp?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Editer</a></td>\n");
          out.write("      </tr>\n");
          out.write("    </tbody>\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
