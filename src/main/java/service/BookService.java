package service;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.BookRepository;
import repository.LanguageRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;
    private final LanguageRepository languageRepository;
private final LanguageService languageService;
@Autowired
    public BookService(BookRepository bookRepository, AddressRepository addressRepository,
                       LanguageRepository languageRepository, LanguageService languageService) {
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
        this.languageRepository = languageRepository;
        this.languageService = languageService;
    }

    public void addBook(){
        Language language=languageService.addLAnguage();
        Author author=new Author("Fatma","Şah",26);
        Address address= new Address("MuratPaşa",324345);
        author.setAddress(address);
        Category category= new Category("Classic");
        Publisher publisher=new Publisher("Ata");
        Book book=new Book("Book","344",author,category,language,publisher);
        bookRepository.save(book);
    }
    public Book findBook(Long id){

    return bookRepository.findById(id).get();
    }
    public void deleteBook(Long id){
        Optional<Book> deleteItem =bookRepository.findById(id);
        bookRepository.delete(deleteItem.orElseThrow(()->new RuntimeException("SİLİNECEK BOOK BULUNAMADI!!")));
    }

    public Set<Book> findByNameLike(String name) {
   return bookRepository.findBynameLike(name);
    }
}
