/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Product_Order;

/**
 *
 * @author Admin
 */
public class ProductOrderImpl implements ProductOrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    Statement stm;
    ResultSet rs = null;

    public boolean saveOrder(List<Product_Order> plist) {
        boolean f = false;
        try {
            String sql = "INSERT INTO [dbo].[product_order]\n"
                    + "           ([order_id]\n"
                    + "           ,[user_name]\n"
                    + "           ,[email]\n"
                    + "           ,[address]\n"
                    + "           ,[phone]\n"
                    + "           ,[product_name]\n"
                    + "           ,[madeIn]\n"
                    + "           ,[price]\n"
                    + "           ,[payment])\n"
                    + "     VALUES(?,?,?,?,?,?,?,?,?)";
            conn = new DBConnect().getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);

            for (Product_Order p : plist) {
                ps.setString(1, p.getOrderId());
                ps.setString(2, p.getUserName());
                ps.setString(3, p.getEmail());
                ps.setString(4, p.getFulladd());
                ps.setString(5, p.getPhno());
                ps.setString(6, p.getProductName());
                ps.setString(7, p.getMadeIn());
                ps.setString(8, p.getPrice());
                ps.setString(9, p.getPaymentType());
                ps.addBatch();

            }
            int[] count = ps.executeBatch();
            conn.commit();
            f = true;
            conn.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Product_Order> getProduct(String email) {
        List<Product_Order> list = new ArrayList<Product_Order>();
        Product_Order o = null;
        try {
            String sql = "select*from [product_order] where email=?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                o = new Product_Order();
                o.setId(rs.getInt(1));
                o.setOrderId(rs.getString(2));
                o.setUserName(rs.getString(3));
                o.setEmail(rs.getString(4));
                o.setFulladd(rs.getString(5));
                o.setPhno(rs.getString(6));
                o.setProductName(rs.getString(7));
                o.setMadeIn(rs.getString(8));
                o.setPrice(rs.getString(9));
                o.setPaymentType(rs.getString(10));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product_Order> getAllOrder() {
        List<Product_Order> list = new ArrayList<Product_Order>();
        Product_Order o = null;
        try {
            String sql = "select*from [product_order]";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                o = new Product_Order();
                o.setId(rs.getInt(1));
                o.setOrderId(rs.getString(2));
                o.setUserName(rs.getString(3));
                o.setEmail(rs.getString(4));
                o.setFulladd(rs.getString(5));
                o.setPhno(rs.getString(6));
                o.setProductName(rs.getString(7));
                o.setMadeIn(rs.getString(8));
                o.setPrice(rs.getString(9));
                o.setPaymentType(rs.getString(10));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
