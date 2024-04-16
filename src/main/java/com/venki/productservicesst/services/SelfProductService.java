package com.venki.productservicesst.services;

import com.venki.productservicesst.exceptions.ProductNotFoundException;
import com.venki.productservicesst.models.Category;
import com.venki.productservicesst.models.Product;
import com.venki.productservicesst.repositories.CategoryRepository;
import com.venki.productservicesst.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private  ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) throw new ProductNotFoundException(id,"Product Not Found!!");
        return optionalProduct.get();
    }

    @Override
    public List<Product> getALlProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        // save category first
        Category category = product.getCategory();
        if (category.getId() == null) product.setCategory(categoryRepository.save(category));
        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        product1.setCategory(optionalCategory.get());
        return product1;
    }
}
