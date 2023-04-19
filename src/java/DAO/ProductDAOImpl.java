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
import model.ProductDtls;

/**
 *
 * @author Admin
 */
public class ProductDAOImpl implements ProductDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    Statement stm;
    ResultSet rs = null;

    @Override
    public boolean addProduct(ProductDtls p) {
        boolean f = false;
        try {
            String sql = "INSERT INTO [dbo].[product_dtls]\n"
                    + "           ([productName]\n"
                    + "           ,[madeIn]\n"
                    + "           ,[price]\n"
                    + "           ,[productCategory]\n"
                    + "           ,[status]\n"
                    + "           ,[photo]\n"
                    + "           ,[email])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?)";
            conn=new DBConnect().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, p.getPhotoName());
            ps.setString(2, p.getMadeIn());
            ps.setString(3, p.getPrice());
            ps.setString(4, p.getProductCategory());
            ps.setString(5, p.getStatus());
            ps.setString(6, p.getPhotoName());
            ps.setString(7, p.getEmail());
            
            int i=ps.executeUpdate();
            if(i==1){
                f=true;
            }

        } catch (Exception e) {
        }
        return f;
    }

}
