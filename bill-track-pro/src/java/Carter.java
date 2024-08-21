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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/Carter"})
public class Carter extends HttpServlet {

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
            out.println("<title>Servlet Carter</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Carter at " + request.getContextPath() + "</h1>");
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
        try{
            model.Cart cart=new model.Cart();
            cart.setId(Integer.parseInt(request.getParameter("items")));
            cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jugal","jugal","jugal");
            PreparedStatement pst=cn.prepareStatement("Select NAME,PRICE from jugal.ITEMS where ID=?");
            pst.setInt(1,Integer.parseInt(request.getParameter("items")));
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            cart.setName(rs.getString(1));
            cart.setPrice(rs.getInt(2));
            }
            HttpSession s=request.getSession(); 
            int i=s.hashCode();
            String n=(String)s.getAttribute("name");
            pst=cn.prepareStatement("insert into jugal.ORDERS values(?,?,?,?,?)");
            pst.setInt(1,i);
           pst.setString(2,n);
           pst.setString(3,cart.getName());
           pst.setInt(4,cart.getQuantity());
           pst.setInt(5,cart.getPrice());
           pst.executeUpdate();
           request.getRequestDispatcher("orders.jsp").include(request, response);
           
           
            
            }
            catch(Exception e)
            {
              //response.getWriter().print(e.toString());  
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
