package com.project.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grnreg database table.
 * 
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grnreg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idgrnreg;

	private double discount;

	private String qty;

	private double total;

	//bi-directional many-to-one association to Grn
	@ManyToOne
	private Grn grn;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idproduct")
	private Product product;
}