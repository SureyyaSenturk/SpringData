package service;

import entity.*;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.BookRepository;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;
@Autowired
    public BookService(BookRepository bookRepository, AddressRepository addressRepository) {
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
    }


    public void addBook(){
        Language language=new Language("Turkish");
        Author author=new Author("Fatma","Şah",26);
        Address address= new Address("MuratPaşa",324345);
        author.setAddress(address);
        Category category= new Category("Classic");
        Publisher publisher=new Publisher("Ata");
        Book book=new Book("Book","344",author,category,language,publisher);
        bookRepository.save(book);
    }
    public void findBook(Long id){
    bookRepository.findById(id);
    }
    public void deleteBook(Long id){
        Optional<Book> deleteItem =bookRepository.findById(id);
        bookRepository.delete(deleteItem.orElse(new Book("Book","344",new Author(),new Category(),new Language(),new Publisher())));
    }

    public void findByNameLike(String name){
    bookRepository.findBynameLike(name);
    }
}
