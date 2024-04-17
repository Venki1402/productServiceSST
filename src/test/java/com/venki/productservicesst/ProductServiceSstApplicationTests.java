package com.venki.productservicesst;

import com.venki.productservicesst.models.Category;
import com.venki.productservicesst.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceSstApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testingEagerVSLazyFetch(){
//		Optional<Category> optionalCategory = categoryRepository.findById(1L);
//		System.out.println("Debug!!");
//	}

}
