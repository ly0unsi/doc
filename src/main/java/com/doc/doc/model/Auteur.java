package com.doc.doc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auteur extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Role")
    private String role;
    @Column(name = "DateContribution")
    private Instant dateContribution;
    // @OneToMany(mappedBy = "auteur")
    // private List<AuteurPublication> publications = new ArrayList<>();

}
