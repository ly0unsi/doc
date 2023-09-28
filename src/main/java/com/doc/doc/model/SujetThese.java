package com.doc.doc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SujetThese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SujetTheseId")
    private Long id;

    @Column(name = "Titre")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "MotsCles")
    private String motsCles;
    @OneToOne
    private Doctorant doctorant;

}
