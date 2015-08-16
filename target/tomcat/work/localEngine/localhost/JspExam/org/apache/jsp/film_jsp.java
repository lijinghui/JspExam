package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hand.Dao.imp.FilmDaoImp;
import com.hand.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;

public final class film_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>电影列表</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<form action=\"\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>film_id</td>\r\n");
      out.write("\t\t\t\t<td>title</td>\r\n");
      out.write("\t\t\t\t<td>description</td>\r\n");
      out.write("\t\t\t\t<td>language</td>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">操作</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				Connection conn = ConnectionFactory.getInstance().makeConnextion();
				FilmDaoImp imp = new FilmDaoImp();
				ResultSet rs = imp.show(conn);
				while (rs.next()) {
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input style=\"width: 50px\" type=\"text\" readonly name=\"id\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(rs.getString(1));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" readonly name=\"title\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(rs.getString(2));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t<td><input style=\"width: 900px\" type=\"text\" name=\"dis\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(rs.getString(3));
      out.write(" readonly\"></td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"lan\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(rs.getString(4));
      out.write(" \"readonly></td>\r\n");
      out.write("\t\t\t\t<td><a href=\"add.jsp\">增加</a></td>\r\n");
      out.write("\t\t\t\t<td><a href=\"del.jsp?id=");
      out.print(rs.getString(1));
      out.write("\">删除</a></td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a href=\"upd.jsp?tit=");
      out.print(rs.getString(2));
      out.write("&dis=");
      out.print(rs.getString(3));
      out.write("&id=");
      out.print(rs.getString(1));
      out.write("\">修改</a>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");

	session.setAttribute("isLogin", " ");
	
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
