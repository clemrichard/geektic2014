package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.Interet;

@RestController
@Transactional
@RequestMapping("/sawgeeks")
public class GeekService {
    @Autowired
    private GeekDAO geekDao;

    

    @RequestMapping(method = RequestMethod.GET)
    public List<Geek> afficheGeeks(){

            List<Geek> listeGeeks = geekDao.findAll();

            return listeGeeks;

    }
    

    
    @RequestMapping("/showgeek/{id}")
    public Geek findGeeksById (@PathVariable("id") Long  id){
    	Geek mongeek = geekDao.findById(id);
        return mongeek;
    }
    
    @RequestMapping("/combo")
    public List<Interet>buildComboBox() {  

        return geekDao.findInterets();
    }
    
    @RequestMapping("/seek/{sexe}/{interet}")
    public List<Geek>findGeeksByInterest (@PathVariable("sexe") String  sexe, @PathVariable("interet") String  interet){
    	List<Geek> listeGeeks = geekDao.findGeekByInterest(sexe, interet);
        return listeGeeks;
    }

}
