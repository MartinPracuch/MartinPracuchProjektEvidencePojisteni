package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.TypPojisteni;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PojisteniDto {

    @Min(value = 1, message = "Zadejte číslo vyšší než nula")
    private int castka;

    @NotNull
    private LocalDate platnost_od;

    @NotNull
    private LocalDate platnost_do;

    private Long pojisteni_id;

    private Long pojistenci_id;

    @NotNull(message = "Typ pojištění nesmí být prázdný.")
    @Enumerated(EnumType.STRING)
    @Column(name = "typ_pojisteni", nullable = false)
    private TypPojisteni typPojisteni;

}
