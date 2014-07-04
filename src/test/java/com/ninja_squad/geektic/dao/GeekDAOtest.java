package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.geektic.metier.Geek;


public class GeekDAOtest extends BaseDaoTest{
	Geek test;
	@Autowired
	GeekDAO geekdao;
	
	@Before
	public void prepare()
	{
	 test = new Geek("RICHARD","CLEMENT","HOMME","25","clemrichard@laposte.net");
	}
	
	@Test
	public void testFindAll()
	{
		List<Geek> maliste = geekdao.findAll();
		assertNotNull(maliste);
	}
	
   @Test
   public void trouverGeeKParNom()
   {
          List<Geek> maliste = geekdao.findByNom("RICHARD");
          assertNotNull(maliste);
          
          for(Geek g: maliste)
          {
                  System.out.println(g);
          }
          
          assertTrue(maliste.contains(test));
   }
   
   

}
 