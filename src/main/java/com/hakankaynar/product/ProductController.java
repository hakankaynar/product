package com.hakankaynar.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public ProductDto get() {
        Product product = new Product();
        product.setName("Greetings from Spring Boot");
        product.setUuid(UUID.randomUUID().toString());
        return new ProductDto(product);
    }

    @GetMapping("/{uuid}")
    public ProductDto getByUuid(@PathVariable String uuid) {

        Product product = productRepository.findByUuid(uuid);
        if (product != null) {
            return new ProductDto(product);
        }
        return null;
    }

    @DeleteMapping("/{uuid}")
    public ProductDto deleteByUuid(@PathVariable String uuid) {
        Product product = productRepository.findByUuid(uuid);
        if (product != null) {
            productRepository.delete(product);
            return new ProductDto(product);
        }
        return null;
    }

    @PutMapping("/")
    public ProductDto add(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setUuid(productDto.getUuid());
        product.setName(productDto.getName());
        productRepository.save(product);
        return productDto;
    }

}
