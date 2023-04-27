/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Product_Order;

/**
 *
 * @author Admin
 */
public interface ProductOrderDAO {
//    public int getOrderNo();
    public boolean  saveOrder(List<Product_Order> p);
    public List<Product_Order> getProduct(String email);
    public List<Product_Order> getAllOrder();
    
    
}
