package com.example.controller;

/**
 * Created by Juan Tenorio on 5/4/2016.
 */
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.model.Club;
import com.example.repository.ClubRepository;

/**
 * Created by Sebastian on 03-Apr-16.
 */

@RestController
@RequestMapping("api/")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @RequestMapping("/")
    public String prueba() {
        return "Hola, esto es una prueba";
    }

    @RequestMapping(value = "clubs", method = RequestMethod.GET)
    public List<Club> list() {
        return clubRepository.findAll();
    }

    @RequestMapping(value = "clubs", method = RequestMethod.POST)
    public Club create(@RequestBody Club club) {
        return clubRepository.saveAndFlush(club);
    }

    @RequestMapping(value = "clubs/{id}", method = RequestMethod.GET)
    public Club get(@PathVariable Long id) {
        return clubRepository.findOne(id);
    }

    @RequestMapping(value = "clubs/{id}", method = RequestMethod.PUT)
    public Club update(@PathVariable Long id, @RequestBody Club club) {
        Club clubExistente = clubRepository.findOne(id);
        BeanUtils.copyProperties(club, clubExistente); //(source, target)
        return clubRepository.saveAndFlush(clubExistente);
    }

    @RequestMapping(value = "clubs/{id}", method = RequestMethod.DELETE)
    public Club delete(@PathVariable Long id) {
        Club clubExistente = clubRepository.findOne(id);
        clubRepository.delete(clubExistente);
        return clubExistente;
    }
}
