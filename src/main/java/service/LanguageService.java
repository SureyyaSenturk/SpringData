 package service;

import entity.Book;
import entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LanguageRepository;
import java.util.Optional;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
@Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language addLAnguage() {
        Language language=new Language("English");
        Book book=new Book();
        book.setLanguage(language);
       return languageRepository.save(language);
}

public Language findyById(long id) {
  return  languageRepository.findById(id).get();
}

public void deleteLanguage(long id){
    Optional<Language> deleteItem= languageRepository.findById(id);
    languageRepository.delete(deleteItem.orElseThrow(()->new RuntimeException("SİLİNECEK LANGUAGE BULUNAMADI!!")));
}

}
