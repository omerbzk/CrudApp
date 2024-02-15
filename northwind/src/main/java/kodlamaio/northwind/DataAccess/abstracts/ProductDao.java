package kodlamaio.northwind.DataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.Entities.concretes.Product;

//jpa repository bize Temel CRUD işlemleri yapabilmemiz için generic repository sağlar. Fakat kendi ihtiyaçlarımıza göre
//özelleştirilmiş metodlarımızı da yazabiliriz.
public interface ProductDao extends JpaRepository<Product,Integer>{
	// select * from products where product_name = "herhangi bir isim"
	Product getByProductName(String productName);
	
	// select * from products where product_name = "herhangi bir isim" and category_id="herhandi bir kategori id'si"
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	// select * from products where product_name = "herhangi bir isim" or category_id="herhangi bir kategori id'si"
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	// select * from products where category_id in(1,2,3)
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
}
