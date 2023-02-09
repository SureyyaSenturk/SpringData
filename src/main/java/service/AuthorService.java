package service;

import entity.Address;
import entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AuthorRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
@Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public void addAuthor() {
        Author author = new Author("Ahmet", "Çağlayan", 32);
        Address address = new Address("Güzel", 234543);
        author.setAddress(address);
        authorRepository.save(author);
    }
        public void deleteAuthor(long id){
            Optional<Author> deleteItem= authorRepository.findById(id);
            authorRepository.delete(deleteItem.orElseThrow(()->new RuntimeException("SİLİNECEK AUTHOR BULUNAMADI!")));
        }

        public Author findAuthor(long id){
        return authorRepository.findById(id).get();

        }
        public Set<Author> findByAge(int age){
   return  (authorRepository.findByAgeGreaterThan(age));
        }

        public Set<Author> findByNameLike(String name){
         return authorRepository.findBynameLike(name);
        }

        }



