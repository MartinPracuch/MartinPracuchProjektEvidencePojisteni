package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.dto.PojisteniDto;
import org.example.entity.Pojistenec;
import org.example.entity.Pojisteni;
import org.example.repository.PojistenecRepository;
import org.example.repository.PojisteniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PojisteniService {

    private final PojisteniRepository pojisteniRepository;
    private final PojistenecRepository pojistenecRepository;

    @Autowired
    public PojisteniService(PojisteniRepository pojisteniRepository, PojistenecRepository pojistenecRepository) {
        this.pojisteniRepository = pojisteniRepository;
        this.pojistenecRepository = pojistenecRepository;
    }

    //naplňuje se instance pojištění věcmi z DTO
    //pro tohle je lepší udělat samostatný balíček Mappers, kde bude třeba PojistenecMapper, PojisteniMapper atd., ať se to neplete tady
    public void ulozPojisteni(PojisteniDto pojisteniDto, Long pojistenci_id) {
        Pojisteni pojisteni = new Pojisteni();
        pojisteni.setCastka(pojisteniDto.getCastka());
        pojisteni.setPojisteni_id(pojisteniDto.getPojisteni_id());
        pojisteni.setPlatnost_do(pojisteniDto.getPlatnost_do());
        pojisteni.setPlatnost_od(pojisteniDto.getPlatnost_od());
        pojisteni.setTypPojisteni(pojisteniDto.getTypPojisteni());
        //získám idPojistence z DTO
        Long idPojistence = pojisteniDto.getPojistenci_id();

        if (idPojistence == null) {
            throw new IllegalArgumentException("ID pojištěnce nesmí být null");
        }

        //najde to pojištěnce podle id
        Pojistenec pojistenec = pojistenecRepository.findById(idPojistence)
                .orElseThrow(() -> new EntityNotFoundException("Pojistenec not found" + "ID pojištěnce: " + pojistenci_id));
        //přiřadí nalezeného pojištěnce k pojištění
        pojisteni.setPojistenec(pojistenec);

        pojisteniRepository.save(pojisteni);
    }

    //volá metodu
    public PojisteniDto ziskejPojisteniProUpravu(Long pojisteni_id) {
        Pojisteni pojisteni = najdiPodleId(pojisteni_id);
        return mapovaciMetodaProPojisteniDto(pojisteni);
    }

    //naplní pojisteniDto věcmi z instance pojisteni
    private PojisteniDto mapovaciMetodaProPojisteniDto(Pojisteni pojisteni) {
        PojisteniDto pojisteniDto = new PojisteniDto();
        pojisteniDto.setCastka(pojisteni.getCastka());
        pojisteniDto.setPlatnost_od(pojisteni.getPlatnost_od());
        pojisteniDto.setPlatnost_do(pojisteni.getPlatnost_do());
        pojisteniDto.setTypPojisteni(pojisteni.getTypPojisteni());
        pojisteniDto.setPojisteni_id(pojisteni.getPojisteni_id());
        pojisteniDto.setPojistenci_id(pojisteni.getPojistenec().getPojistenci_id());
        return pojisteniDto;
    }

    public void smazPojisteni(Long pojisteni_id) {
        pojisteniRepository.deleteById(pojisteni_id);
    }

    public List<Pojisteni> najdiVsechnaPojisteni() {
        return pojisteniRepository.findAll();
    }

    public Pojisteni najdiPodleId(Long id) {
        return pojisteniRepository.findById(id).orElse(null);
    }
}
