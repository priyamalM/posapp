package com.project.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idsupplier;

	private String address;

	private String mob;

	private String name;

	private String tag;

	private String tel;

	//bi-directional many-to-one association to Grn
	@OneToMany(mappedBy="supplier")
	private List<Grn> grns;

	public Grn addGrn(Grn grn) {
		getGrns().add(grn);
		grn.setSupplier(this);

		return grn;
	}

	public Grn removeGrn(Grn grn) {
		getGrns().remove(grn);
		grn.setSupplier(null);

		return grn;
	}

}