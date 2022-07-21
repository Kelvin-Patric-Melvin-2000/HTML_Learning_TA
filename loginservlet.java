import java.io.*;
import javax.servlet.*;
import java.servelt.http.*;
import java.sql.*;

public class  LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest requests, HttpServletResponse response)
    throws IOException, ServletException{

        response.setContentType("text/html");
        PrintWtriter out = response.getWriter();
        Sring fname = request.getParameter("fname";)
        Sring mname = request.getParameter("mname";)
        Sring lname = request.getParameter("lname";)
        Sring psw = request.getParameter("psw";)

        try {

            Class.forName("org.posgersql.Driver");
            Connection con = DriverManager.getConnection("","postgres","root");
            PreparedStatement st = con.prepareStatement("select fname, mname, lname, psw from person where fname=? and mname=? and lname=? and psw=? ")
            st.setString(1, fname);
            st.setString(2, mname);
            st.setString(3, lname);
            st.setString(4, psw);

            Result rs = st.executeQuery();
            if (re.next()) {
                response.sendRedirect(Welcome Dude!);
                response.sendRedirect(Click th elink below to open the portfolio);
                out.println("<br><br><a href='secondpage.html'></a>)';'
            } else {
                out.println("Login failed. Invalid credentials");
                out.println("<br><br><a href='index.html'>Login</a>);
            }

            con.Close();

        }
        catch(SQLException sqlE) {
            out.println(sqlE);
        }
        catch(ClassNotFoundException cnfE) {
            out.println(cnfE);
        }
        finally {

        }
    }

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
            response.sendRedirect ("index.html");
        }
    
    @Override
    public String getServletInfo() {
        return "This is a Login Servlet";
    }
}