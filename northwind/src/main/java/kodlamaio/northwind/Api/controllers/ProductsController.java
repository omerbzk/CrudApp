package kodlamaio.northwind.Api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.Business.abstracts.ProductService;
import kodlamaio.northwind.Core.utilities.results.DataResult;
import kodlamaio.northwind.Core.utilities.results.Result;
import kodlamaio.northwind.Entities.concretes.Product;
@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
 private ProductService productService;
 
 @Autowired
 public ProductsController(ProductService productService) {
	super();
	this.productService = productService;
}

@GetMapping("/getall")
 public DataResult<List<Product>> getAll(){
	 return this.productService.getAll();
 }

@PostMapping("/add")
public Result add(@RequestBody Product product) {
	return this.productService.add(product);
}

@GetMapping("/getByProductName")
public DataResult<Product> getByProductName(@RequestParam String productName){
	return this.productService.getByProductName(productName);
}

@GetMapping("/getByProductNameAndCategoryId")
public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,
		@RequestParam("categoryId") int categoryId){
	return this.productService.getByProductNameAndCategoryId(productName, categoryId);
}

@GetMapping("/getByCategoryIdIn")
DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories){
	return this.productService.getByCategoryIdIn(categories);
}

@GetMapping("/getByProductNameContains")
public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
	return this.productService.getByProductNameContains(productName);
}

@GetMapping("/getByProductNameStartsWith")
public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
	return this.productService.getByProductNameStartsWith(productName);
}

@GetMapping("/getByNameAndCategory")
DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName,
		@RequestParam("categoryId") int categoryId){
	return this.productService.getByNameAndCategory(productName,categoryId);
}

}





