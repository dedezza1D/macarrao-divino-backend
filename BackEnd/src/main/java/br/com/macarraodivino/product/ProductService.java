package br.com.macarraodivino.product;

import java.util.List;

import br.com.macarraodivino.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.macarraodivino.product.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	@Transactional(readOnly = true)
	public List <Product> findAll(){
		return repository.findAllByOrderByNameAsc();
	}
}
