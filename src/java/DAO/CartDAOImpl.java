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
import model.Cart;
import model.ProductDtls;

/**
 *
 * @author Admin
 */
public class CartDAOImpl implements CartDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    Statement stm;
    ResultSet rs = null;

    public boolean addCart(Cart c) {
        boolean f = false;
        String sql = "INSERT INTO [dbo].[cart]\n"
                + "           ([pid]\n"
                + "           ,[uid]\n"
                + "           ,[productName]\n"
                + "           ,[madeIn]\n"
                + "           ,[price]\n"
                + "           ,[total_price])\n"
                + "     VALUES(?,?,?,?,?,?,?)";
        try {
            conn=new DBConnect().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, c.getPid());
            ps.setInt(2, c.getUid());
            ps.setString(3, c.getProductName());
            ps.setString(4, c.getMadeIn());
            ps.setDouble(5, c.getPrice());
            ps.setDouble(6, c.getTotalPrice());
            
            int i=ps.executeUpdate();
            if(i==1){
                f=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

   
    public List<Cart> getProductByUser(int userId) {
        List<Cart> list=new ArrayList<Cart>();
        Cart c=null;
        double totalPrice = 0;
        String sql="select*from [cart] where uid=?";
        try {
            conn=new DBConnect().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs=ps.executeQuery();
            while(rs.next()){
                c=new Cart();
                c.setCid(rs.getInt(1));
                c.setPid(rs.getInt(2));
                c.setUid(rs.getInt(3));
                c.setProductName(rs.getString(4));
                c.setMadeIn(rs.getString(5));
                c.setPrice(rs.getDouble(6));
                
                totalPrice=totalPrice+rs.getDouble(7);
                c.setTotalPrice(totalPrice);
                
                list.add(c);
            }
            
        } catch (Exception e) {
        }
        return list;
    }

   
    public boolean deleteProduct(int pid,int uid,int cid) {
      boolean f=false;
      String sql="delete from [cart] where pid=? and uid=? and cid=?";
        try {
            conn=new DBConnect().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, uid);
            ps.setInt(3, cid);
            int i=ps.executeUpdate();
            if(i==1){
                f=true;
            }
        } catch (Exception e) {
        }
        
        return f;
    }

    

}
