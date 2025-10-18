package org.example.inventoryservice;

import org.example.inventoryservice.Repository.ProductRepository;
import org.example.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Laptop")
                            .price(1200.0)
                            .quantity(3)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Headphone")
                    .price(1200.0)
                    .quantity(8)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Phone")
                    .price(1200.0)
                    .quantity(23)
                    .build());
            productRepository.findAll().forEach(product -> {
                System.out.println(product.getName());
                System.out.println(product.getPrice());
                System.out.println(product.getQuantity());
            });
        };
    }
}
