package com.project.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idproduct;

	private String barcode;

	private byte countable;

	private double discount;

	private String englishname;

	private String id;

	private int qty;

	private String reorderqty;

	private String sinhalaname;

	private double sprice;

	private String tag;

	private double wprice;

	//bi-directional many-to-one association to Grnreg
	@OneToMany(mappedBy="product")
	private List<Grnreg> grnregs;

	//bi-directional many-to-one association to Invoicereg
	@OneToMany(mappedBy="productBean")
	private List<Invoicereg> invoiceregs;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category")
	private Category categoryBean;



	public Grnreg addGrnreg(Grnreg grnreg) {
		getGrnregs().add(grnreg);
		grnreg.setProduct(this);

		return grnreg;
	}

	public Grnreg removeGrnreg(Grnreg grnreg) {
		getGrnregs().remove(grnreg);
		grnreg.setProduct(null);

		return grnreg;
	}



	public Invoicereg addInvoicereg(Invoicereg invoicereg) {
		getInvoiceregs().add(invoicereg);
		invoicereg.setProductBean(this);

		return invoicereg;
	}

	public Invoicereg removeInvoicereg(Invoicereg invoicereg) {
		getInvoiceregs().remove(invoicereg);
		invoicereg.setProductBean(null);

		return invoicereg;
	}


}