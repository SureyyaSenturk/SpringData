package service;

import entity.Address;
import entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class AddressService {

    private final AddressRepository addressRepository; // Dependency Injection
@Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addAddress(){
        Address address= new Address("Yesilyurt",12221);
        Author author= new Author("Süreyya","Şentürk",24);
        author.setAddress(address);
        addressRepository.save(address);
    }

    public void findAddress(Long id){
        System.out.println(addressRepository.findById(id));
    }

    public void deleteAddress(Long id){
     Optional<Address> deleteItem= addressRepository.findById(id);
     addressRepository.delete(deleteItem.orElse(new Address()));
    }

   public void findByStreetOrZipcode(String street,String zipcode){
       Set<Address> addresses=addressRepository.findByStreetOrZipcode(street, zipcode);
       System.out.println(addresses);
   }
}
