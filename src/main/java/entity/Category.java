package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "category")
@Data
@Table(name="category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
@Column(name = "categoryName",length = 100)
    private String categoryName;

@OneToMany(mappedBy = "category")
private Set<Book> book;

    public Category(String categoryName){
        this.categoryName=categoryName;
    }
}
