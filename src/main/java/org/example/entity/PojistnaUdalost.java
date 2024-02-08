package org.example.entity;

import jakarta.persistence.*;


//rozšíření v budoucnu
@Entity
public class PojistnaUdalost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long udalost_id;

    @ManyToOne
    @JoinColumn(name = "pojistenci_id")
    private Pojistenec pojistenec;

    @ManyToOne
    @JoinColumn(name = "pojisteni_id")  // Opravený název sloupce
    private Pojisteni pojisteni;


}
