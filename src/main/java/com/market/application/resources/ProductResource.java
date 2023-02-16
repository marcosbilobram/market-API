package com.market.application.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.market.application.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.market.application.entities.Product;
import com.market.application.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public  ResponseEntity<List<ProductDTO>> findAll(){
		List<Product> prod = productService.findAll();
		List<ProductDTO> listDTO = prod.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Integer id){
		Product prod = productService.findById(id);
		return ResponseEntity.ok().body(new ProductDTO(prod));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ProductDTO productDTO) {
		Product prd = productService.fromDTO(productDTO);
		prd = productService.insert(prd);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prd.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ProductDTO productDTO, @PathVariable Integer id){
		Product prd = productService.fromDTO(productDTO);
		prd.setId(id);
		prd = productService.update(prd);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/filter")
	public ResponseEntity<List<ProductDTO>> findByName(@RequestParam("name") String name){
		List<Product> list = productService.findByName(name);
		List<ProductDTO> listDTO = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/ctgs")
	public ResponseEntity<List<ProductDTO>> findProductsByCategoryName(@RequestParam("name") String categoryName){
		List<Product> list = productService.findProductsByCategoryName(categoryName);
		List<ProductDTO> listDTO = list.stream().map(x -> new ProductDTO(x.getId(), x.getName(), x.getDescription(), x.getPricePerUnit(), x.getQuantity())).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}