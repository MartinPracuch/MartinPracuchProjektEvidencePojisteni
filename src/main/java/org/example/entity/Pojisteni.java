    package org.example.entity;


    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;
    import org.example.enums.TypPojisteni;

    import java.util.ArrayList;
    import java.time.LocalDate;
    import java.util.List;

    @Getter
    @Setter
    @Entity
    @Table(name="pojisteni")
    public class Pojisteni {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long pojisteni_id;

        private int castka;

        private LocalDate platnost_od;

        private LocalDate platnost_do;


        @Enumerated(EnumType.STRING)
        @Column(name = "typ_pojisteni", nullable = false)
        private TypPojisteni typPojisteni;

        //Eager = při načtení pojištění jsou načtené taky pojistenec objekty
        @ManyToOne(fetch = FetchType.EAGER)
        //pojištění může být vždy vázáno pouze na 1 pojištěnce
        @JoinColumn(name = "pojistenci_id", referencedColumnName = "pojistenci_id")
        private Pojistenec pojistenec;

        @OneToMany(mappedBy = "pojisteni")
        private List<PojistnaUdalost> pojistneUdalosti = new ArrayList<>();

    }
