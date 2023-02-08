package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="book")
@Data
@Table(name = "book")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
@Column(name = "name",length = 100, nullable = false,unique = false)
 private String name;
@Column(name="pages",nullable = false)
private String pages;

@ManyToOne(cascade ={CascadeType.ALL})
    private Author author;
@ManyToOne(cascade = CascadeType.ALL)
private Category category;
@OneToOne(cascade = CascadeType.ALL)
private Language language;
@ManyToOne(cascade = CascadeType.ALL)
private Publisher publisher;

    public Book(String name,String pages,Author author,Category category,Language language,Publisher publisher){
        this.name=name;
        this.pages=pages;
        this.author=author;
        this.category=category;
        this.language=language;
        this.publisher=publisher;
    }
}
