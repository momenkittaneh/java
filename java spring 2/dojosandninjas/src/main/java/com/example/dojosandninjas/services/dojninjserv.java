package com.example.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.repository.dojorepo;
import com.example.dojosandninjas.repository.ninjarepo;

@Service
public class dojninjserv {
final private dojorepo doj;
final private ninjarepo ninj;
public dojninjserv(dojorepo doj, ninjarepo ninj) {
	this.doj = doj;
	this.ninj = ninj;
}
public Ninja createnewninja(Ninja na) {
	return ninj.save(na);
}
public Dojo createnewdojo(Dojo na) {
	return doj.save(na);
}
public Dojo findninjas(Long id) {
    Optional<Dojo> dojo = doj.findById(id);
    if(dojo.isPresent()) {
        return dojo.get();
    } else {
        return null;
    }}
public List<Dojo> findall() {
	return doj.findAll();
}
public List<Ninja> findallninj() {
	return ninj.findAll();
}

}
