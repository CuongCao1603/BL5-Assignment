/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Cart;
import model.ProductDtls;

/**
 *
 * @author Admin
 */
public interface CartDAO {
    public boolean addCart(Cart c);
    public List<Cart> getProductByUser(int userId);
            
            
            
            
            
}
