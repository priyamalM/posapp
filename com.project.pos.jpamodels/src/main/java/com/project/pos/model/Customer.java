package com.project.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcustomers;

	private String address;

	private double debt;

	private String mobno;

	private String mobno2;

	private String name;

	private String tag;

	//bi-directional many-to-one association to Customerdebt
	@OneToMany(mappedBy="customer")
	private List<Customerdebt> customerdebts;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="customer")
	private List<Invoice> invoices;

	public Customerdebt addCustomerdebt(Customerdebt customerdebt) {
		getCustomerdebts().add(customerdebt);
		customerdebt.setCustomer(this);

		return customerdebt;
	}

	public Customerdebt removeCustomerdebt(Customerdebt customerdebt) {
		getCustomerdebts().remove(customerdebt);
		customerdebt.setCustomer(null);

		return customerdebt;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setCustomer(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setCustomer(null);

		return invoice;
	}

}