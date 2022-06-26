package com.study.springcore.mockobject;

import com.study.springcore.dto.ProductMypriceRequestDto;
import com.study.springcore.dto.ProductRequestDto;
import com.study.springcore.model.Product;
import com.study.springcore.dto.ProductMypriceRequestDto;

import java.util.List;

public class MockProductService {
//  productservice로 테스트 하려면 productrepository를 DI해야 하는데(테스트 시에는 스프링이 기동되는게 아니라 bean생성도 안되고 DI도 할 수 없다) -> (학원에서 했던 것처럼 SpringBootTest어노테이션 붙이면 기동됨)
// 안하고 productservice코드만 카피해서 테스트하는 방법
    private final MockProductRepository mockProductRepository;
    public static final int MIN_MY_PRICE = 100;

    public MockProductService() {
        this.mockProductRepository = new MockProductRepository();
    }

    public Product createProduct(ProductRequestDto requestDto, Long userId ) {
// 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto, userId);

        mockProductRepository.save(product);

        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        int myprice = requestDto.getMyprice();
        if (myprice < MIN_MY_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 관심 가격입니다. 최소 " + MIN_MY_PRICE + " 원 이상으로 설정해 주세요.");
        }

        Product product = mockProductRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        product.setMyprice(myprice);
        mockProductRepository.save(product);

        return product;
    }

    // 회원 ID 로 등록된 상품 조회
    public List<Product> getProducts(Long userId) {
        return mockProductRepository.findAllByUserId(userId);
    }

    // (관리자용) 상품 전체 조회
    public List<Product> getAllProducts() {
        return mockProductRepository.findAll();
    }
}