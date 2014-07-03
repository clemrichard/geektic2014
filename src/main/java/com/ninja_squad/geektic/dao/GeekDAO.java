package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.Geek;

@Repository
public class GeekDAO {

	@PersistenceContext
	private EntityManager em;

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
		String jpql = "select s from Geek s where s.nom = :chaine";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("nom", chaine);
		return query.getResultList();
	}

	public void persist(Geek geek) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(geek);
		tx.commit();
	}

}
