package com.hakankaynar.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSave() {

        Product product = new Product();

        try{
            product.setName("ProductRepositoryTest");
            product.setUuid(UUID.randomUUID().toString());

            productRepository.save(product);

            Assert.notNull(product.getId(), "Id should not be null");
        }
        finally {
            productRepository.delete(product);
        }

    }

    @Test
    public void testGetById() {

        Product product = new Product();

        try{
            product.setName("ProductRepositoryTest");
            product.setUuid(UUID.randomUUID().toString());

            productRepository.save(product);

            Optional<Product> candidate = productRepository.findById(product.getId());

            Assert.notNull(candidate.get(), "get by id should not return null");
        }
        finally {
            productRepository.delete(product);
        }

    }

    @Test
    public void testGetByUuid() {

        Product product = new Product();

        try{
            product.setName("ProductRepositoryTest");
            product.setUuid(UUID.randomUUID().toString());

            productRepository.save(product);

            Product candidate = productRepository.findByUuid(product.getUuid());

            Assert.notNull(candidate, "get by uuid should not return null");
        }
        finally {
            productRepository.delete(product);
        }

    }


}
