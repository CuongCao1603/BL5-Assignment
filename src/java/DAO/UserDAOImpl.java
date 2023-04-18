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
    public void userRegister(String name,String email,String phno,String password) {
        String sql = "insert into [user] values(?,?,?,?,?,?,?,?,?)";
//        boolean f = false;
        try {

            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phno);
            ps.setString(4, password);
            ps.setString(5, "NULL");
            ps.setString(6, "NULL");
            ps.setString(7, "NULL");
            ps.setString(8, "NULL");
            ps.setString(9, "NULL");

            ps.executeUpdate();
            System.err.println("tai len data");
        } catch (Exception e) {
        }
        
    }

}
