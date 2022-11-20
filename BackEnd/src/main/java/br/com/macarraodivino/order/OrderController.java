package br.com.macarraodivino.order;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		  List <Order> list = service.findAll();
		  return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Order> save(@RequestBody Order order){
		service.save(order);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).body(order);
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<Order> setDelivered(@PathVariable Long id){
		Order order = service.setDelivered(id);
		return ResponseEntity.ok().body(order);
	}
}
