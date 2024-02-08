package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Pohlavi;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="pojistenci")
public class Pojistenec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pojistenci_id;

    private String jmeno;

    private String email;

    private String telefon;

    private String ulice;

    private String mesto;

    private String cislopopisne;

    private String psc;

    private String prijmeni;

    @Enumerated(EnumType.STRING)
    @Column(name = "pohlavi")
    private Pohlavi pohlavi;

    //jeden pojištěnec může mít více pojištění
    @OneToMany(mappedBy = "pojistenec")
    private List<Pojisteni> pojisteniList;

    @OneToMany(mappedBy = "pojistenec")
    private List<PojistnaUdalost> pojistna_udalostList;





}
