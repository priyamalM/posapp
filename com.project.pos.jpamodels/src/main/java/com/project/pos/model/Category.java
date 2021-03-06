package com.project.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcategory;

	private String name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="categoryBean")
	private List<Product> products;


	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategoryBean(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategoryBean(null);

		return product;
	}

}