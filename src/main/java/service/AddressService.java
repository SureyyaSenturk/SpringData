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

    public Address findAddress(Long id){
        return addressRepository.findById(id).get();
    }

    public void deleteAddress(Long id){
     Optional<Address> deleteItem= addressRepository.findById(id);
     addressRepository.delete(deleteItem.orElseThrow(()->new RuntimeException("SİLİNECEK ADDRESS BULUNAMADI!")));
    }

   public void findByStreetOrZipcode(String street,String zipcode){
       Set<Address> addresses=addressRepository.findByStreetOrZipcode(street, zipcode);
       System.out.println(addresses);
   }
}
