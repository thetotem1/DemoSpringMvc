package be.storm.demo_spring_mvc.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(nullable = false)
    String name;
    @ManyToOne(fetch = FetchType.EAGER)
    Director director;

}
