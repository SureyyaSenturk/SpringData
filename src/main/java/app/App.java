package app;
/**
 * @since 0.0.1
 * @version 0.0.1
 * @author Süreyya
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.*;

@SpringBootApplication
@ComponentScan(basePackages = {"repository","service","entity"})
@EnableJpaRepositories(basePackages = "repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"entity"})

public class App {
   public static void main(String[] args){
       ApplicationContext applicationContext= SpringApplication.run(App.class,args);

       AuthorService authorService=applicationContext.getBean(AuthorService.class);
       authorService.addAuthor();

       AddressService addressService=applicationContext.getBean(AddressService.class,args);
       addressService.addAddress();

       BookService bookService=applicationContext.getBean(BookService.class,args);
       bookService.addBook();

       CategoryService categoryService= applicationContext.getBean(CategoryService.class,args);
      categoryService.addCategory();

       LanguageService languageService=applicationContext.getBean(LanguageService.class,args);
       languageService.addLAnguage();

       PublisherService publisherService=applicationContext.getBean(PublisherService.class,args);
       publisherService.addPublisher();

   }
}
