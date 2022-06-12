package com.study.springcore.controller;

import com.study.springcore.model.Product;
import com.study.springcore.dto.ProductMypriceRequestDto;
import com.study.springcore.dto.ProductRequestDto;
import com.study.springcore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
/* 이 일을 대신 해줌
public ProductController(ProductService productService){
        this.productService = productService;
        }
 */

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {

    private final ProductService productService;

    // 신규 상품 등록
    @PostMapping("/api/products")//클라이언트로부터 넘어오는 정보가 requestbody부분에 들어옴, 그 내용은 requestDto에다가..
    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
        Product product = productService.createProduct(requestDto);


// 응답 보내기
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productService.updateProduct(id, requestDto);


// 응답 보내기 (업데이트된 상품 id)
        return product.getId();
    }

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() throws SQLException {
        List<Product> products = productService.getProducts();


// 응답 보내기
        return products;
    }
}