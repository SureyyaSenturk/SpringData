package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "address")
@Data
@Table(name = "address")
@NoArgsConstructor
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", nullable = false)
    private Long id;
@Column(name="street",length=100,nullable = false)
   private String street;
@Column(name = "zipcode")
private int zipcode;

@OneToOne(mappedBy ="address")
    private Author author;

    public Address(String street,int zipcode){
        this.street=street;
        this.zipcode=zipcode;
    }
}
