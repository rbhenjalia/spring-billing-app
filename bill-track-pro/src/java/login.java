/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         if(request.getParameter("table").equals("admin")){
            try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection cn=DriverManager.getConnection("jdbc:derby://localhost:1527/vrinda","vb","vb");
            PreparedStatement pst=cn.prepareStatement("Select * from vrinda.ADMINS where UID=? and PASS=?");
            pst.setString(1,request.getParameter("uid"));
            pst.setString(2,request.getParameter("password"));
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                HttpSession session=request.getSession(true);
                session.setAttribute("name",request.getParameter("uid"));
                session.setAttribute("password",request.getParameter("password"));
                response.sendRedirect("adminpage.jsp");
            }
            else{
            response.getWriter().print("<html><body onload='alert(\"invalid credentials\")'/></html>");
            request.getRequestDispatcher("index.jsp").include(request, response);
            }
            }
            catch(Exception e)
            {
              //response.getWriter().print(e.toString());
            }
        }
        else{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection cn=DriverManager.getConnection("jdbc:derby://localhost:1527/vrinda","vb","vb");
            PreparedStatement pst=cn.prepareStatement("Select *from vrinda.USERS where UID=? and PASS=?");
            pst.setString(1,request.getParameter("uid"));
            pst.setString(2,request.getParameter("password"));
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                HttpSession session=request.getSession();
                session.setAttribute("name",request.getParameter("uid"));
                session.setAttribute("password",request.getParameter("password"));
                request.getRequestDispatcher("userpage.jsp").forward(request, response);
            }
            else{
            response.getWriter().print("<html><body onload='alert(\"invalid credentials\")'/></html>");
            request.getRequestDispatcher("index.jsp").include(request, response);
            }
            }
            catch(Exception e)
            {
              response.getWriter().print(e.toString());  
            }
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
