package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.metier.Geek;

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
}
