package com.study.springcore.service;

import com.study.springcore.model.Product;
import com.study.springcore.dto.ProductMypriceRequestDto;
import com.study.springcore.repository.ProductRepository;
import com.study.springcore.dto.ProductRequestDto;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(ProductRequestDto requestDto) {
// 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);

        productRepository.save(product);
        // = productRepository.createProduct(product);

        return product;
    }//end createProduct

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        // = Optional <Product> product = productRepository.findById(id);

        // = Product product = productRepository.getProduct(id);

        /*
        if(product == null){
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }
         */
        int myPrice = requestDto.getMyprice();
        product.setMyprice(myPrice);
        productRepository.save(product);
        // = productRepository.updateMyprice(id, requestDto.getMyprice());

        return product;
    }//end updateProduct

    public List<Product> getProducts(){

        List<Product> products = productRepository.findAll();
        // = List<Product> products = productRepository.getProducts();

        return products;

    }
}
