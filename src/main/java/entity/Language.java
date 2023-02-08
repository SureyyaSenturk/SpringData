package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "language")
@Data
@Table(name = "language")
@NoArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
@Column(name="languageName",length = 50)
    private String languageName;
@OneToOne(mappedBy = "language")
private Book book;

    public Language(String languageName){
        this.languageName=languageName;
    }
}
