package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sr03p1.sr03_p1.model.User;

public class CreateUser extends HttpServlet {
    private static Hashtable<Integer, User> usersTable= new Hashtable<Integer, User>();
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
        User u = new User(request.getParameter("User mail"),request.getParameter("User name"),request.getParameter("User password"), request.getParameter("User company"),request.getParameter("User phone"), request.getParameter("User creation date"), Integer.parseInt(request.getParameter("User status")), Integer.parseInt(request.getParameter("User Admin")));
        usersTable.put(usersTable.size(), u);

        try{
            Connection connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/sr03","root" , "aptx4969");
            Statement st = connexion.createStatement();
            int result = st.executeUpdate("insert into sr03.USER (mail, password, name, company, phone, creationDate, isAdmin, isActive)" + "values ('"+u.getMail()+"','"+u.getPassword()+"','"+u.getName()+"','"+u.getCompany()+"','"+u.getPhone()+"','"+u.getCreationDate()+"','"+u.getIsAdmin()+"','"+u.getIsActive()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Controller:</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Utilisateur crée " + usersTable.get(usersTable.size()-1).toString() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
			processRequest(request, response);
		}

    @Override
    public String getServletInfo() {
    return "Short description";
    }// </editor-fold>



}

