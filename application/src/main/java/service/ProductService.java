package service;

import com.google.inject.Inject;
import dao.CompanyDAO;
import dao.ProductDAO;
import entity.Company;
import entity.Product;

import java.util.List;

public final class ProductService {
    private final ProductDAO productDAO;
    private final CompanyDAO companyDAO;

    @Inject
    public ProductService(ProductDAO productDAO, CompanyDAO companyDAO) {
        this.productDAO = productDAO;
        this.companyDAO = companyDAO;
    }
    public List<Product> getProductsByCompany(String companyName){
        return productDAO.getProductsByCompany(companyName);
    }

    public void save(Product product){
        Company company = companyDAO.getByName(product.getCompanyName());
        if (company == null)
            companyDAO.save(new Company(product.getCompanyName()));
        productDAO.save(product);
    }
    public boolean delete(String productName){
        return productDAO.delete(productName);
    }
    public List<Product> getAllProducts(){
        return productDAO.getAll();
    }
}
