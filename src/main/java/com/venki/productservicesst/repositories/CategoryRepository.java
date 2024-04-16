package com.venki.productservicesst.repositories;

import com.venki.productservicesst.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Override
    Category save(Category category);
}
