/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import model.User;

/**
 *
 * @author Admin
 */
public interface UserDAO {
    public void userRegister(User us);
    public User login(String email,String password);
    public boolean checkPassword(int id, String ps);
    public boolean updateProfile(User us);
}
