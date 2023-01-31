package com.market.application.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.market.application.dto.CategoryDTO;
import com.market.application.dto.UserDTO;
import com.market.application.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.application.entities.Category;
import com.market.application.services.CategoryService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public  ResponseEntity<List<CategoryDTO>> findAll(){
		List<Category> ctg = categoryService.findAll();
		List<CategoryDTO> listDTO = ctg.stream().map( x -> new CategoryDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id){
		Category ctg = categoryService.findById(id);
		return ResponseEntity.ok().body(new CategoryDTO(ctg));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CategoryDTO categoryDTO){
		Category ctg = categoryService.fromDTO(categoryDTO);
		ctg = categoryService.insert(ctg);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ctg.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody CategoryDTO categoryDTO, @PathVariable Integer id){
		Category ctgAtt = categoryService.fromDTO(categoryDTO);
		ctgAtt.setId(id);
		ctgAtt = categoryService.update(ctgAtt);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{categoryId}/prds/add")
	public ResponseEntity<Void> addProducts(@PathVariable Integer categoryId, @RequestBody List<Product> products){
		categoryService.populateRelationAttributes(categoryId, products);
		return ResponseEntity.noContent().build();
	}
}