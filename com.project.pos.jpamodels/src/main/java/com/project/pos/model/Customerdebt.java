package com.project.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the customerdebt database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customerdebt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcustomerdebt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private double paid;

	private String remaining;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="idcustomers")
	private Customer customer;

}