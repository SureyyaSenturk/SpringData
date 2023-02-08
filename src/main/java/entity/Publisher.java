package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "publisher")
@Data
@Table(name="publisher")
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "publisherName",length = 80)
    private String publisherName;

@OneToMany(mappedBy="publisher")
    public Set<Book> book;

    public Publisher(String publisherName){
        this.publisherName=publisherName;
    }
}
