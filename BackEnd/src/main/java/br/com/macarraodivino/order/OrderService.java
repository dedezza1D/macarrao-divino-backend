package br.com.macarraodivino.order;

import br.com.macarraodivino.product.Product;
import br.com.macarraodivino.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productrepository;
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return repository.findOrdersWithProducts();
    }
    @Transactional
    public Order save(Order dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for (Product p : dto.getProducts()) {
            Product product = productrepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        return repository.save(order);
    }
    @Transactional
    public Order setDelivered(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        return order = repository.save(order);
    }
}

