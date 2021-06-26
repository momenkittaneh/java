package com.example.Languages.controller;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Languages.services.languageservice;
import com.example.Languages.models.language;
//import com.example.Languages.services.languageservice;



@RestController
public class langapi {
	final private languageservice helloworld;

	public langapi(languageservice helloworld) {
		this.helloworld = helloworld;
	}
    @RequestMapping("/api/languages")
    public List<language> index() {
        return helloworld.alllanguages();
    }

    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") Double version) {
        return helloworld.createlanguage(name,creator,version);
    }

    @RequestMapping("/api/languages/{id}")
    public language show(@PathVariable("id") Long id) {
        language language = helloworld.findlanguage(id);
        return language;
    }
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public language update(@PathVariable("id") Long id, @RequestParam(value="name") String name,@RequestParam(value="creator") String creator,@RequestParam(value="version") Double version) {
    	language la = helloworld.findlanguage(id);
    	la.setName(name);
    	la.setCreator(creator);
    	la.setVersion(version);
        helloworld.updatelanguage(la);
        return la;
    }

    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        helloworld.deletelanguage(id);

}
}
