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
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setString(2, p.getMadeIn());
            ps.setString(3, p.getPrice());
            ps.setString(4, p.getProductCategory());
            ps.setString(5, p.getStatus());
            ps.setString(6, p.getPhotoName());
            ps.setString(7, p.getEmail());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
        }
        return f;
    }

    public List<ProductDtls> getAllProduct() {
        List<ProductDtls> list = new ArrayList<>();

        String sql = "select * FROM [dbo].[product_dtls]";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }

        return list;
    }

    @Override
    public ProductDtls getProductById(int id) {
//        ProductDtls b=null;
        String sql = "select * FROM [dbo].[product_dtls] where productId=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }

        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean updateEditProducts(ProductDtls p) {
        boolean f = false;
        String sql = "UPDATE [dbo].[product_dtls]\n"
                + "   SET [productName] = ?\n"
                + "      ,[madeIn] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[productCategory] = ?\n"
                + "      ,[status] = ?\n"
                //                + "      ,[photo] = ?\n"
                //                + "      ,[email] = ?\n"
                + " WHERE productID=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setString(2, p.getMadeIn());
            ps.setString(3, p.getPrice());
            ps.setString(4, p.getProductCategory());
            ps.setString(5, p.getStatus());
//            ps.setString(6, p.getPhotoName());
//            ps.setString(7, p.getEmail());
            ps.setInt(6, p.getProductId());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
        }

        return f;
    }

    public boolean deleteBooks(int id) {
        boolean f = false;
        String sql = "DELETE FROM [dbo].[product_dtls]\n"
                + "      WHERE productId=? ";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
        }

        return f;
    }

    public List<ProductDtls> getNewProducts() {

        List<ProductDtls> list = new ArrayList<>();
        ProductDtls b = null;

        String sql = "select * FROM [dbo].[product_dtls] where "
                + "[productCategory] = ? and [status]= ? "
                + "order by productId DESC";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "New");
            ps.setString(2, "Active");
            int i = 1;
            rs = ps.executeQuery();
            while (rs.next() && i <= 4) {
                list.add(new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
                i++;
            }
        } catch (Exception e) {
        }

        return list;
    }

    public List<ProductDtls> getRecentProducts() {
        List<ProductDtls> list = new ArrayList<>();
        ProductDtls b = null;

        String sql = "select * FROM [dbo].[product_dtls] where "
                + "[status]= ? "
                + "order by productId DESC";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "Active");
//            ps.setString(2, "Active");
            int i = 1;
            rs = ps.executeQuery();
            while (rs.next() && i <= 4) {
                list.add(new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
                i++;
            }
        } catch (Exception e) {
        }

        return list;
    }

    public List<ProductDtls> getOldProducts() {
        List<ProductDtls> list = new ArrayList<>();
        ProductDtls b = null;

        String sql = "select * FROM [dbo].[product_dtls] where "
                + "[productCategory] = ? and [status]= ? "
                + "order by productId DESC";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "Old");
            ps.setString(2, "Active");
            int i = 1;
            rs = ps.executeQuery();
            while (rs.next() && i <= 4) {
                list.add(new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
                i++;
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProductDtls> getAllRecentProduct() {

        List<ProductDtls> list = new ArrayList<>();
        ProductDtls b = null;

        String sql = "select * FROM [dbo].[product_dtls] where "
                + "[status]= ? "
                + "order by productId DESC";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
//            ps.setString(1, "New");
            ps.setString(1, "Active");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }

        return list;

    }

    public List<ProductDtls> getAllNewProduct() {
        List<ProductDtls> list = new ArrayList<>();
        ProductDtls b = null;

        String sql = "select * FROM [dbo].[product_dtls] where "
                + "[productCategory] = ? and [status]= ? "
                + "order by productId DESC";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "New");
            ps.setString(2, "Active");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;

    }

    public List<ProductDtls> getAllOldProduct() {
        List<ProductDtls> list = new ArrayList<>();
        ProductDtls b = null;

        String sql = "select * FROM [dbo].[product_dtls] where "
                + "[productCategory] = ? and [status]= ? "
                + "order by productId DESC";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "Old");
            ps.setString(2, "Active");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProductDtls> getProductByOld(String email, String cate) {
        List<ProductDtls> list = new ArrayList<ProductDtls>();
        ProductDtls p = null;
        String sql = "select * from product_dtls where productCategory=? and email=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cate);
            ps.setString(2, email);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductDtls(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }

        } catch (Exception e) {
        }

        return list;

    }

    public boolean oldProductDelete(String email, String cat,int id) {
        boolean f = false;
        String sql = "delete from product_dtls where productCategory=? and email=? and productId=?";
        try {
            conn=new DBConnect().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, cat);
            ps.setString(2, email);
            ps.setInt(3, id);
            
            int i=ps.executeUpdate();
            if(i==1){
                f=true;
            }
        } catch (Exception e) {
        }
        return f;
    }

}
