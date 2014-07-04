package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "geek")

public class Geek {
	@SequenceGenerator(name="SEQ", sequenceName="geek_seq")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
	private Long id;
	
	@Column(name = "nom")
	private String  nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "sexe")
	private String sexe;
	@Column(name = "age")
	private String age;
	@Column(name = "email")
	private String email;
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	protected Geek()
	{
		
	}

	public Geek(String nom, String prenom, String sexe, String age, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
		this.email = email;
	}
	
    @ManyToMany(fetch = FetchType.EAGER)

    @JoinTable(name = "GEEK_INTERET",
               joinColumns = @JoinColumn(name = "ID_GEEK"),
               inverseJoinColumns = @JoinColumn(name = "ID_INTERET"))
    public List <Interet> interets;

}
