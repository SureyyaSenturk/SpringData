package service;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
@Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    public void addCategory(){
    Category category= new Category("ABC");
    Book book=new Book();
    book.setCategory(category);
    categoryRepository.save(category);
    }
 public ArrayList<Category> findAllCategory(){
    return (ArrayList<Category>) categoryRepository.findAll();
 }

 public Category findById(Long id){
  return  categoryRepository.findById(id).get();

 }
 public void deleteCategory(Long id){
     Optional<Category> deleteItem=categoryRepository.findById(id);
     categoryRepository.delete(deleteItem.orElseThrow(()->new RuntimeException("SİLİNECEK CATEGORY BULUNAMADI!!")));
 }
}
