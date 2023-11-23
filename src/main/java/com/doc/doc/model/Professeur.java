package com.doc.doc.model;

import com.doc.doc.enums.ProfessorGrade;
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
public class Professeur extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Etablissement")
    private String etablissement;
    @Column(name = "Grade")
    private ProfessorGrade grade;
    @Column(name = "Specialite")
    private String speciality;
}
