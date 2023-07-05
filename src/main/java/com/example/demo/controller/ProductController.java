package com.example.demo.controller;

import com.example.demo.middleware.ResponseHandler;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping(path = "api/vi/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProductById(@PathVariable() int id) {
        try {
            System.out.println(id);
            Product productFound = productService.getProductById(id);
            return ResponseHandler.generateResponse("product get successfully", HttpStatus.OK, productFound);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.OK, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> postProduct(@RequestBody Product product) {
        try {
            System.out.println(product);
            Product ProductSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Data retrieved successfully",
                    HttpStatus.OK,
                    ProductSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> updateProductById(@PathVariable("id") int id, @RequestBody Product product) {
        try {
            System.out.println("Antes de entrar al servicio" + product);
            String mensaje = productService.updateProductById(product, id);
            return ResponseHandler.generateResponse(
                    "the product with the id " + id + " was modified successfully ",
                    HttpStatus.OK,
                    mensaje
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }


    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable() int id) {
        try {
            System.out.println(id);
            String mensaje = productService.deleteProductById(id);
            return ResponseHandler.generateResponse(
                    "the product with the id " + id + " was deleted successfully ",
                    HttpStatus.OK,
                    mensaje
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

    @GetMapping
    public ResponseEntity<Object> getProductList() throws ParseException {
        try {
            //  System.out.println(id);
            List<Product> list = new ArrayList<>();
            list = productService.getProductList();
            return ResponseHandler.generateResponse(
                    "Client get successfully",
                    HttpStatus.OK,
                    list
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }


}
