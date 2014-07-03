package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.geektic.metier.Geek;


public class GeekDAOtest extends BaseDaoTest{

	@Autowired
	GeekDAO geekdao;
	
	@Test
	public void testFindAll()
	{
		List<Geek> maliste = geekdao.findAll();
		assertNotNull(maliste);
	}
}
 