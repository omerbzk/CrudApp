package kodlamaio.northwind.Entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
    private int id;
	
	//@Column(name="category_id")
    //private int categoryId;
	
	@Column(name="product_name")
    private String productName;
	
	@Column(name="unit_price")
    private double unitPrice;
	
	@Column(name="units_in_stocks")
    private short  unitsInStock;
	
	@Column(name="quantity_per_unit")
    private  String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn("category_id")
	private Category category;
}

