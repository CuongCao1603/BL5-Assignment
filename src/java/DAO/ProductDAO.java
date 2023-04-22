/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.ProductDtls;
import DAO.ProductDAOImpl;

/**
 *
 * @author Admin
 */
public interface ProductDAO {
    public boolean addProduct(ProductDtls p);
    public List<ProductDtls> getAllProduct();
    public ProductDtls getProductById(int id);
    public boolean updateEditProducts(ProductDtls p);
    public boolean deleteBooks(int id);
    public List<ProductDtls> getNewProducts();
    public List<ProductDtls> getRecentProducts();
    public List<ProductDtls> getOldProducts();
    public List<ProductDtls> getAllRecentProduct();
    public List<ProductDtls> getAllNewProduct();
    public List<ProductDtls> getAllOldProduct();
    
    
}
