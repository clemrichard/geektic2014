package com.ninja_squad.geektic.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "interet")
public class Interet {
	
	@SequenceGenerator(name="SEQ", sequenceName="interet_seq")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
	private Long id;
	
	@Column(name = "nom")
	private String  nom;
	@Column(name = "denomination")
	private String denomination;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	public Interet(String nom, String denomination) {
		super();
		this.nom = nom;
		this.denomination = denomination;
	}
	
	protected Interet()
	{
	
	}


}
