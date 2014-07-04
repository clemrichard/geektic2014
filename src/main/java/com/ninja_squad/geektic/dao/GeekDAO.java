package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.Interet;

@Repository
public class GeekDAO {

	@PersistenceContext
	private EntityManager em;

	public List<Geek> findAll() {
		String jpq1 = "select g from Geek as g";
		TypedQuery<Geek> query = em.createQuery(jpq1, Geek.class);
		List<Geek> listeGeek = query.getResultList();
		return listeGeek;
	}

	public Geek findById(long id) {
		return em.find(Geek.class, id);

	}
	

	public List<Geek> findByNom(String chaine) {
		String jpql = "select g from Geek as g where g.nom = :chaine";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("nom", chaine);
		return query.getResultList();
	}
	
	public List<Interet> findInterets() {
		String jpql = "select i from Interet as i";
		TypedQuery<Interet> query = em.createQuery(jpql, Interet.class);
		List<Interet> listeInteret = query.getResultList();
		return query.getResultList();
	}
	
	public List<Geek> findGeekByInterest(String sexe, String interet) {
		String jpql = "select distinct g from Geek as g left join fetch g.interets as gi inner join g.interets as i where g.sexe=:sexe and i.nom=:interet";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe).setParameter("interet", interet);
		List<Geek> listeGeek = query.getResultList();
		return listeGeek;
	}
	

	public void persist(Geek geek) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(geek);
		tx.commit();
	}

}
