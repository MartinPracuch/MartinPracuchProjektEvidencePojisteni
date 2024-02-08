package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Pohlavi;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PojistenecDto {

    //lepší anotace než NotNull, kontroluje, zda řetězec, pole nebo kolekce nejsou prázdné
    @NotEmpty(message = "Jméno nesmí být prázdné.")
    private String jmeno;

    @Email(message = "Zadejte platný e-mailový formát.")
    private String email;

    @Pattern(regexp = "^(\\+\\d{1,3} )?\\d{1,15}$", message = "Zadejte platné telefonní číslo.")
    private String telefon;

    @NotEmpty(message = "Ulice nesmí být prázdná.")
    private String ulice;

    @NotEmpty(message = "Město nesmí být prázdné.")
    private String mesto;

    @Pattern(regexp = "\\d+(/\\d+)?", message = "Zadejte platné číslo popisné.")
    private String cislopopisne;

    @Pattern(regexp = "\\d+( \\d+)?", message = "Zadejte platné PSČ.")
    private String psc;

    @NotEmpty(message = "Příjmení nesmí být prázdné.")
    private String prijmeni;

    private Long pojistenci_id;

    @NotNull(message = "Vyberte pohlaví.")
    @Enumerated(EnumType.STRING)
    @Column(name = "pohlavi", nullable = true)
    private Pohlavi pohlavi;

}