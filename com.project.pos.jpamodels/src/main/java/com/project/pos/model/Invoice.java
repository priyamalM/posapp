package com.project.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idinvoice;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String invtype;

	private double paid;

	private String paytype;

	private double remain;

	private double total;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="idcustomers")
	private Customer customer;

	//bi-directional many-to-one association to Invoicereg
	@OneToMany(mappedBy="invoice")
	private List<Invoicereg> invoiceregs;


	public Invoicereg addInvoicereg(Invoicereg invoicereg) {
		getInvoiceregs().add(invoicereg);
		invoicereg.setInvoice(this);

		return invoicereg;
	}

	public Invoicereg removeInvoicereg(Invoicereg invoicereg) {
		getInvoiceregs().remove(invoicereg);
		invoicereg.setInvoice(null);

		return invoicereg;
	}

}