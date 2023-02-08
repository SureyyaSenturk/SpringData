package service;

import entity.Book;
import entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PublisherRepository;

import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
@Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void addPublisher(){
        Publisher publisher=new Publisher();
        Book book=new Book();
        book.setPublisher(publisher);
        publisherRepository.save(publisher);
    }

    public void findById(long id){
    publisherRepository.findById(id);

    }

    public void deletePublisher(long id){
        Optional<Publisher> deleteItem= publisherRepository.findById(id);
        publisherRepository.delete(deleteItem.orElse(new Publisher()));
    }
}
