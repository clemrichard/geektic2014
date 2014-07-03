package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.ninja_squad.geektic.metier.Geek;

public class GeekDAO {

	private EntityManager em;

	public GeekDAO(EntityManager em) {
		this.em = em;
	}

	public List<Geek> findAll() {
		String jpq1 = "select v from Geek as v";
		TypedQuery<Geek> query = em.createQuery(jpq1, Geek.class);
		List<Geek> listeGeek = query.getResultList();
		return listeGeek;
	}

	public Geek findyId(long id) {
		return em.find(Geek.class, id);

	}

	public List<Geek> findByNom(String chaine) {
		String jpql = "select s from Geek s where s.nom = :nom";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("artiste", chaine);
		return query.getResultList();
	}

	public void persist(Geek _spe) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(_spe);
		tx.commit();
	}

}
