package br.com.macarraodivino.product;

import java.util.List;

import br.com.macarraodivino.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllByOrderByNameAsc();
}
