package org.example.controller;

import org.example.service.PojistenecService;
import org.example.service.PojisteniService;

public abstract class PojisteniPojistenecZakladniController {

    /*
    tato třída existuje, abych neměl tolik duplicitního kódu, třeba definice atributů servisů v kontrolerech
     */
    protected PojisteniService pojisteniService;
    protected PojistenecService pojistenecService;

    public PojisteniPojistenecZakladniController(PojisteniService pojisteniService, PojistenecService pojistenecService) {
        this.pojisteniService = pojisteniService;
        this.pojistenecService = pojistenecService;
    }


}
