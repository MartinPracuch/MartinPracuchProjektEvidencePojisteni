package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.PojisteniDto;
import org.example.entity.Pojisteni;
import org.example.service.PojistenecService;
import org.example.service.PojisteniService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PojisteniController extends PojisteniPojistenecZakladniController {
    public PojisteniController(PojisteniService pojisteniService, PojistenecService pojistenecService) {
        super(pojisteniService, pojistenecService);
    }

    //vykreslení formuláře pro přidání nového pojištění + inicializace Data Transfer Objectu
    @GetMapping("/pridatPojisteni/{pojistenci_id}")
    public String pridatPojisteniFormular(@PathVariable Long pojistenci_id, Model model) {
        PojisteniDto pojisteniDto = new PojisteniDto();
        model.addAttribute("pojisteniDto", pojisteniDto);
        model.addAttribute("pojistenci_id", pojistenci_id);
        return "pridatPojisteni";
    }

    //přidání nového pojištění
    //předává se pojistenci_id pro správné napojení na pojištěnce
  @PostMapping("/pridatPojisteni/ulozit/{pojistenci_id}")
    public String ulozitPojisteni(@ModelAttribute("pojisteniDto") @Valid PojisteniDto pojisteniDto, BindingResult result,
                                  @PathVariable Long pojistenci_id,
                                  Model model) {

        if (result.hasErrors()) {
            // Pokud jsou chyby ve formuláři, vrátíme se zpět na formulář
            return "pridatPojisteni";
        }
        //vložení pojistenci_id pro správné napojení, aby vědělo, ke komu to přidat
        pojisteniDto.setPojistenci_id(pojistenci_id);
        pojisteniService.ulozPojisteni(pojisteniDto, pojistenci_id);
        return "redirect:/pojistenci/" + pojistenci_id;
    }

    //vykreslení šablony pro úpravu pojištění včetně předvyplnění formuláře
    @GetMapping("/upravitPojisteni/{pojisteni_id}")
    public String upravitPojisteniFormular(@PathVariable Long pojisteni_id, Model model) {
        //ta metoda pod tímto komentářem naplní formulář daty
        PojisteniDto pojisteniDto = pojisteniService.ziskejPojisteniProUpravu(pojisteni_id);
        model.addAttribute("pojisteniDto", pojisteniDto);
        return "upravitPojisteni";
    }

    //úprava pojištění, odeslání nových údajů na back-emd
    @PostMapping("/upravitPojisteni/ulozit/{pojisteni_id}")
    public String upravitPojisteniUlozit(@ModelAttribute("pojisteniDto") @Valid PojisteniDto pojisteniDto, BindingResult result,
                                         @PathVariable Long pojisteni_id,
                                         Model model) {
        if (result.hasErrors()) {
            return "upravitPojisteni";
        }

        //pojisteniDto.setPojisteni_id(pojisteni_id); TOTO TAKY NEMUSI BYT XDD
        pojisteniService.ulozPojisteni(pojisteniDto, pojisteni_id);
        return "redirect:/pojisteni/" + pojisteniDto.getPojisteni_id();
    }

    @PostMapping("/smazatPojisteni/{pojisteni_id}")
    public String smazatPojisteni(@PathVariable("pojisteni_id") Long pojisteni_id,
                                  @RequestParam(name = "pojistenci_id", required = false) Long pojistenci_id) {
        pojisteniService.smazPojisteni(pojisteni_id);
        return presmerovatNaPojistenceNeboPojisteni(pojistenci_id);
    }

    /*určí, kam přesměrovat uživatele po provedení smazání pojištění
    pokud se maže pojištění z podstránky seznam pojištění, tak nefunguje návrat na pojistenci/pojistenci_id
    šlo by to předat přes hidden atribute z tlačítka v seznamu pojištění, ale chci, aby když mažu na /pojisteni, aby mě to nechalo na tom pojištění
     */
    private String presmerovatNaPojistenceNeboPojisteni(Long pojistenci_id) {
        if (pojistenci_id != null) {
            return "redirect:/pojistenci/" + pojistenci_id;
        } else {
            return "redirect:/pojisteni";
        }
    }

    //ukáže seznam všech pojištění
    @GetMapping("/pojisteni")
    public String ukazatSeznamPojisteni(Model model) {
        List<Pojisteni> pojisteni = pojisteniService.najdiVsechnaPojisteni();
        model.addAttribute("pojisteni", pojisteni);
        return "pojisteni";
    }

    //ukáže detail konkrétního pojištění
    @GetMapping("pojisteni/{pojisteni_id}")
    public String detailPojisteni(@PathVariable("pojisteni_id") Long pojisteni_id, Model model) {
        Pojisteni pojisteni = pojisteniService.najdiPodleId(pojisteni_id);
        model.addAttribute("pojisteni", pojisteni);
        return "detailPojisteni";
    }
}
