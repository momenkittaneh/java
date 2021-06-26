package com.example.Languages.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.Languages.models.language;
import com.example.Languages.repositories.LanguageRepository;

@Service
public class languageservice {
    // adding the language repository as a dependency
    private final LanguageRepository languagerepository;	
	public languageservice(LanguageRepository languageRepository) {
        this.languagerepository = languageRepository;
    }
	
    // returns all the languages
    public List<language> alllanguages() {
        return languagerepository.findAll();
    }
    // creates a language
    public language createlanguage(String name,String creator,Double version) {
        language la = new language();
        la.setName(name);
        la.setCreator(creator);
        la.setVersion(version);
    	return languagerepository.save(la);
    }
    // retrieves a language
    public language findlanguage(Long id) {
        Optional<language> optionallanguage = languagerepository.findById(id);
        if(optionallanguage.isPresent()) {
            return optionallanguage.get();
        } else {
            return null;
        }
    }
    public void updatelanguage(language lang) {

		languagerepository.save(lang);
        
    }
        

        public void deletelanguage(Long id) {
            Optional<language> optionallanguage = languagerepository.findById(id);
            language y =optionallanguage.get();
            languagerepository.delete(y);
        }
        
    }
    
