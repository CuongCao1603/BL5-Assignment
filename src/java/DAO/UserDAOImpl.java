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
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAOImpl {

    Connection conn = null;
    PreparedStatement ps = null;
    Statement stm;
    ResultSet rs = null;
//
//    public UserDAOImpl(Connection conn) {
//        super();
//        this.conn = conn;
//    }

//   
    public void userRegister(String name, String email, String phno, String password) {
        String sql = "insert into [user] ([name]\n" +
"           ,[email]\n" +
"           ,[phno]\n" +
"           ,[password])"
                + " values(?,?,?,?)";
//        boolean f = false;
        try {

            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phno);
            ps.setString(4, password);
//            ps.setString(5, "NULL");
//            ps.setString(6, "NULL");
//            ps.setString(7, "NULL");
//            ps.setString(8, "NULL");
//            ps.setString(9, "NULL");

            ps.executeUpdate();
            System.err.println("tai len data");
        } catch (Exception e) {
        }

    }

    public User login(String email, String password) {
        User us=null;
        String sql = "select * from [user] \n"
                + "where [email] = ?\n"
                + "and [password] = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs=ps.executeQuery();
            
            while(rs.next()){
//                us=new User();
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
        }
        return null;
    }

}
