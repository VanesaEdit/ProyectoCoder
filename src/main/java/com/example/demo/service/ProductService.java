package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.RequestProductDetail;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList() throws Exception{
        if (productRepository.findAll().size() >0){
            return productRepository.findAll();

        }else {
            throw new Exception("There are no products load");

        }
    }

    public List<Product> getProductsById(List<RequestProductDetail> productListId) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (RequestProductDetail requestProduct :
                productListId) {
            Optional<Product> productFound = productRepository.findById(requestProduct.getProductId());
            if (productFound.isEmpty()) {
                throw new Exception("Product with id: " + requestProduct.getProductId() + " not found.");
            }
            productList.add(productFound.get());
        }
        return productList;
    }

    public Product getProductById(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new Exception("Product with id: " + id + " not found.");
        } else {
            return product.get();
        }
    }

    public Product postProduct(Product product) throws Exception {
        List<Product> productList = productRepository.findAll();
        if (productList.size() > 0) {
            for (Product productExist : productList) {
                if (productExist.getCode().equals(product.getCode())) {
                    throw new Exception("The product code already exists");
                }
            }
        }
        if (!product.description(product.getDescription())) {
            throw new Exception("Description Null");
        } else if (!product.code(product.getCode())) {
            throw new Exception("Code Null");
        } else if (!product.stock(product.getStock())) {
            System.out.println("getStock: " + product.getStock());
            throw new Exception("Stock Null");
        } else if (!product.price(product.getPrice())) {
            System.out.println("getPrice: " + product.getPrice());
            throw new Exception("Price Null");
        } else {
            productRepository.save(product);
            return null;
        }
    }

    public String updateProductById(Product product, int id) throws Exception {
        Optional<Product> productExist = productRepository.findById(id);//obtengo el cliente por id

        List<Product> productList = productRepository.findAll();
        if (productList.size() > 0) {
            for (Product productExists : productList) {
                if (productExists.getCode().equals(product.getCode())) {
                    throw new Exception("The product code already exists");
                }
            }
        }

       if (!product.description(product.getDescription())) {
            throw new Exception("Description Null");
        } else if (!product.code(product.getCode())) {
            throw new Exception("Code Null");
        } else if (!product.stock(product.getStock())) {
            System.out.println("getStock: " + product.getStock());
            throw new Exception("Stock Null");
        } else if (!product.price(product.getPrice())) {
            System.out.println("getPrice: " + product.getPrice());
            throw new Exception("Price Null");

        }
        return null;
    }

    public String deleteProductById(int id) throws Exception {
        try {
            Optional<Product> product = productRepository.findById(id);//obtengo el producto por id
            if (product.isEmpty()) {// si el cliente es null devuelvo null
                throw new Exception("Product not exist");
            } else {
                productRepository.delete(product.get());
                return null;
            }
        } catch (Exception e) {
            throw new Exception("This product cannot be deleted as it has invoices loaded");
        }

}
}