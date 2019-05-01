package com.project.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the grn database table.
 * 
 */
@Entity
@NamedQuery(name="Grn.findAll", query="SELECT g FROM Grn g")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idgrn;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String grntype;

	private double paid;

	private String paytype;

	private double remain;

	private double total;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	private Supplier supplier;

	//bi-directional many-to-one association to Grnreg
	@OneToMany(mappedBy="grn")
	private List<Grnreg> grnregs;


	public Grnreg addGrnreg(Grnreg grnreg) {
		getGrnregs().add(grnreg);
		grnreg.setGrn(this);

		return grnreg;
	}

	public Grnreg removeGrnreg(Grnreg grnreg) {
		getGrnregs().remove(grnreg);
		grnreg.setGrn(null);

		return grnreg;
	}

}