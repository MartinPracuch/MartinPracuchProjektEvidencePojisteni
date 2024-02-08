package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.PojistenecDto;
import org.example.entity.Pojistenec;
import org.example.service.PojistenecService;
import org.example.service.PojisteniService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PojistenecController extends PojisteniPojistenecZakladniController {
    public PojistenecController(PojisteniService pojisteniService, PojistenecService pojistenecService) {
        super(pojisteniService, pojistenecService);
    }

    //ukáže všechny pojištěnce
    @GetMapping("/pojistenci")
    public String ukazSeznamPojistencu(Model model) {
        List<Pojistenec> pojistenci = pojistenecService.ukazVsechnyPojistence();
        model.addAttribute("pojistenci", pojistenci);
        return "pojistenci";
    }

    //vykreslení detailu jednoho pojištěnce
    @GetMapping("/pojistenci/{pojistenci_id}")
    public String detailPojistence(@PathVariable("pojistenci_id") Long pojistenci_id, Model model) {
        Pojistenec pojistenec = pojistenecService.najdiPojistencePodleId(pojistenci_id);
        model.addAttribute("pojistenec", pojistenec);
        return "detailPojistence";
    }

    //zobrazení formuláře vytvoření pojištěnce
    //metody jsou v kontrolerech pojmenovány podle url v infinitivu
    @GetMapping("/vytvorit-pojistence")
    public String vytvoritPojistenceFormular(Model model) {
        PojistenecDto pojistenecDto = new PojistenecDto();
        model.addAttribute("pojistenecDto", pojistenecDto);
        return "vytvoritPojistence";
    }

    //odeslání registračních údajů do back-endu a vytvoření pojištěnce
    @PostMapping("/vytvorit-pojistence/ulozit")
    public String vytvoritPojistenceUlozit(@ModelAttribute("pojistenecDto") @Valid PojistenecDto pojistenecDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "vytvoritPojistence";
        }
        pojistenecService.ulozUpravPojistence(pojistenecDto, pojistenecDto.getPojistenci_id());
        return "redirect:/pojistenci";
    }

    //úprava pojištěnce -> zobrazení upravovacího formuláře
    @GetMapping("/upravitPojistence/{pojistenci_id}")
    public String upravitPojistenceFormular(@PathVariable Long pojistenci_id, Model model) {
        PojistenecDto pojistenecDto = pojistenecService.ziskejPojistenceProUpravu(pojistenci_id);
        model.addAttribute("pojistenecDto", pojistenecDto);
        return "upravitPojistence";
    }

    //úprava pojištěnce, odeslání infa na back-end
    @PostMapping("/upravitPojistence/upravit/{pojistenci_id}")
    public String upravitPojistenceUlozit(@ModelAttribute("pojistenecDto") @Valid PojistenecDto pojistenecDto, BindingResult result, @PathVariable Long pojistenci_id, Model model) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "upravitPojistence";
        }
        pojistenecService.ulozUpravPojistence(pojistenecDto, pojistenci_id);
        return "redirect:/pojistenci/" + pojistenecDto.getPojistenci_id();
    }

    @PostMapping("/smazatPojistence/{pojistenci_id}")
    public String smazatPojistence(@PathVariable("pojistenci_id") Long pojistenci_id) {
        pojistenecService.smazPojistence(pojistenci_id);
        return "redirect:/pojistenci";
    }
}