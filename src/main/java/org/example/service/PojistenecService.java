package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.dto.PojistenecDto;
import org.example.entity.Pojistenec;
import org.example.entity.Pojisteni;
import org.example.repository.PojistenecRepository;
import org.example.repository.PojisteniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;


import java.util.List;

@Service
public class PojistenecService {


    private final PojistenecRepository pojistenecRepository;

    private final PojisteniRepository pojisteniRepository;

    @Autowired
    public PojistenecService(PojistenecRepository pojistenecRepository, PojisteniRepository pojisteniRepository) {
        this.pojistenecRepository = pojistenecRepository;
        this.pojisteniRepository = pojisteniRepository;
    }

    public void save(Pojistenec pojistenec) {
        pojistenecRepository.save(pojistenec);
    }

    //vytvoří DTO a uloží do něj atributy pojištěnce
    public PojistenecDto naplneniDtoAtributyPojistence(Pojistenec pojistenec) {
        PojistenecDto pojistenecDto = new PojistenecDto();
        BeanUtils.copyProperties(pojistenec, pojistenecDto);
        return pojistenecDto;
    }

    //vytvoří pojištěnce nebo ho uloží
    //předá to pojistenci_id -> pokud není (tvoří se nový) - tvoří se nový pojištěnec
    public void ulozUpravPojistence(PojistenecDto pojistenecDto, Long pojistenci_id) {
        //překopíruje atributy z DTO do existujícího nebo nového pojištěnce
        if (pojistenci_id == null) {
            Pojistenec novyPojistenec = new Pojistenec();
            BeanUtils.copyProperties(pojistenecDto, novyPojistenec);
            pojistenecRepository.save(novyPojistenec);
        } else {
            // Získání existujícího pojištěnce podle ID, ten se pak editne
            Pojistenec existujiciPojistenec = pojistenecRepository.findById(pojistenci_id)
                    .orElseThrow(() -> new EntityNotFoundException("Pojistenec not found with ID: " + pojistenci_id));

            // Kopírování vlastností z DTO do existujícího pojištěnce
            BeanUtils.copyProperties(pojistenecDto, existujiciPojistenec);

            // Uložení aktualizovaného pojištěnce
            pojistenecRepository.save(existujiciPojistenec);
        }
    }

    //smazání pojištěnce
    public void smazPojistence(Long pojistenci_id) {
        Pojistenec pojistenec = najdiPojistencePodleId(pojistenci_id);
         List<Pojisteni> pojisteniPojistence = pojistenec.getPojisteniList();

         //projede seznam pojištění u pojištěnce a smaže každé pojištění
        for (Pojisteni pojisteni : pojisteniPojistence) {
            pojisteniRepository.deleteById(pojisteni.getPojisteni_id());
        }
        pojistenecRepository.deleteById(pojistenci_id);
    }

    public PojistenecDto ziskejPojistenceProUpravu(Long pojistenci_id) {
        //najde to pojistence podle id
        //vrátí to vyplněné dto
        Pojistenec pojistenec = najdiPojistencePodleId(pojistenci_id);
        return naplneniDtoAtributyPojistence(pojistenec);
    }

    //ukáže všechny pojištěnce
    public List<Pojistenec> ukazVsechnyPojistence() {
        return pojistenecRepository.findAll();
    }


    public Pojistenec najdiPojistencePodleId(Long id) {
        return pojistenecRepository.findById(id).orElse(null);
    }
}

