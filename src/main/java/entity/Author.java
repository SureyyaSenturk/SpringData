package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "author")
@Data
@Table(name = "author")
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="name",length = 100,unique = false)
    private String name;
    @Column(name="surname",length=100,unique = false)
    private String surname;
    @Column(name = "age")
    private int age;

    @OneToOne(cascade ={ CascadeType.ALL})
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

   @OneToMany(mappedBy = "author")
    private Set<Book> book;

    public Author(String name,String surname,int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
