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

    public Publisher addPublisher(){
        Publisher publisher=new Publisher();
        Book book=new Book();
        book.setPublisher(publisher);
      return  publisherRepository.save(publisher);
    }

    public Publisher findById(long id){
    return publisherRepository.findById(id).get();

    }

    public void deletePublisher(long id){
        Optional<Publisher> deleteItem= publisherRepository.findById(id);
        publisherRepository.delete(deleteItem.orElseThrow(()->new RuntimeException("SİLİNECEK PUBLİSHER BULUNAMADI!!")));
    }
}
