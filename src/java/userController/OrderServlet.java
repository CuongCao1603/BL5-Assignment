/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package userController;

import DAO.CartDAOImpl;
import DAO.ProductOrderImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Cart;
import model.ProductDtls;
import model.Product_Order;

/**
 *
 * @author Admin
 */
public class OrderServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
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
        try {

            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));

            String name = request.getParameter("username");
            String email = request.getParameter("email");

            String phno = request.getParameter("phno");
            String address = request.getParameter("address");
            String landmark = request.getParameter("landmark");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String pincode = request.getParameter("pincode");
            String paymentType = request.getParameter("payment");

            String fullAdd = address + "," + landmark + "," + city + ","
                    + state + "," + pincode;

            CartDAOImpl dao = new CartDAOImpl();
            List<Cart> plist = dao.getProductByUser(id);
            if (plist.isEmpty()) {
                session.setAttribute("failedMsg", "Add Item");
                response.sendRedirect("checkout.jsp");
            } else {
                ProductOrderImpl dao2 = new ProductOrderImpl();

//            for (Cart cart : plist) {
//                System.out.println(cart.getProductName());
//            }
                Product_Order o = null;

                ArrayList<Product_Order> orderList = new ArrayList<Product_Order>();
                Random r = new Random();

                for (Cart c : plist) {
                    o = new Product_Order();
                    o.setOrderId("PRODUCT-ORD-00" + r.nextInt(1000));
                    o.setUserName(name);
                    o.setEmail(email);
                    o.setFulladd(fullAdd);
                    o.setPhno(phno);
                    o.setProductName(c.getProductName());
                    o.setMadeIn(c.getMadeIn());
                    o.setPrice(c.getPrice() + "");
                    o.setPaymentType(paymentType);

                    orderList.add(o);
                    System.out.println("List: " + o.getPrice());
                }

                if ("noselect".equals(paymentType)) {
                    session.setAttribute("failedMsg", "Choose Payment Method");
                    response.sendRedirect("checkout.jsp");
                } else {
                    boolean f = dao2.saveOrder(orderList);
                    if (f) {
                        response.sendRedirect("order_success.jsp");
                    } else {
                        session.setAttribute("failedMsg", "Your Order Failed");
                        response.sendRedirect("checkout.jsp");
                    }
                }
            }
        } catch (Exception e) {
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
