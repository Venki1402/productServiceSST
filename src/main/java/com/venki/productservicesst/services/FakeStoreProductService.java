package com.venki.productservicesst.services;

import com.venki.productservicesst.dtos.FakeStoreProductDto;
import com.venki.productservicesst.exceptions.ProductNotFoundException;
import com.venki.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
//        int x = 1/0; //testing exception
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        if (fakeStoreProductDto == null) throw new ProductNotFoundException(id,"please pass a valid ProductID");
        return mapToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getALlProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(mapToProduct(fakeStoreProductDto));
        }
        return products;
    }

    private Product mapToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
//        Category category = new Category();
//        category.setDescription(fakeStoreProductDto.getCategory().getDescription());
//        product.setCategory(category);
        return product;
    }
}