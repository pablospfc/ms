package academy.digitallab.serviceproduct.repository;

import academy.digitallab.serviceproduct.entity.Category;
import academy.digitallab.serviceproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
