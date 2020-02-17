
<%@page import='pfe.StudentDao' %>
<jsp:useBean id='s' class='pfe.Cours' ></jsp:useBean>
<jsp:setProperty property='*' name='s' />



<% 
    
     StudentDao st=new StudentDao();
     st.deleteC(s);
     response.sendRedirect("courssupp.jsp");
           
%>


