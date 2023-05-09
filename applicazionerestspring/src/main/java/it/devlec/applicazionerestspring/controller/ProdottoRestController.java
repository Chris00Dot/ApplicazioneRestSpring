package it.devlec.applicazionerestspring.controller;

import it.devlec.applicazionerestspring.avviso.ProdottoNonTrovato;
import it.devlec.applicazionerestspring.model.Prodotto;
import it.devlec.applicazionerestspring.persistenza.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class ProdottoRestController
{
    private static Logger logger = LoggerFactory.getLogger(ProdottoRestController.class);
    private ProdottiRepository repository;

    ProdottoRestController(ProdottiRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/prodotti")
    public List<Prodotto> leggiTuttiiProdotti()
    {
        logger.info("Prendo tutti i Prodotti");
        return repository.findAll();
    }

    @GetMapping("/prodotto/{id}")
    public Prodotto trovaProdottoConID(@PathVariable Long id)
    {
        return repository.findById(id).orElseThrow(
                () -> new ProdottoNonTrovato(id));
    }

    @PostMapping("/prodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto)
    {
        return repository.save(nuovoProdotto);
    }

    @PutMapping("/prodotto")
    public Prodotto aggiornaDatiProdotto(@RequestBody Prodotto prodotto)
    {
        return repository.save(prodotto);
/*        return repository.findById(id).map(
                //creare nuovo
                nuovoProdotto -> {
                    nuovoProdotto.setNome(prodotto.getNome());
                    nuovoProdotto.setMarca(prodotto.getMarca());
                    return repository.save(nuovoProdotto);
                }
        ).orElseGet(
                () -> {
                    //il prodotto esiste
                    prodotto.setId(id);
                    return repository.save(prodotto);
                }
        );*/
    }

    @DeleteMapping("/prodotto/{id}")
    void eliminaProdotto(@PathVariable Long id)
    {
        repository.deleteById(id);
    }

    @GetMapping("/prodotto/ricercatradate")
    public List<Prodotto> ricercaProdottoTraDatediProduzione(
            @RequestParam(name = "da") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date da,
            @RequestParam(name = "a") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date a
    )
    {
        return repository.findByDataDiProduzioneBetween(da, a);
    }

    @GetMapping("/prodotto/ricercadatadiscadenza")
    public List<Prodotto> ricercaProdottoConDatadiscadenza(
            @RequestParam(name = "da") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date da,
            @RequestParam(name = "a") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date a
    )
    {
        return repository.findByDataDiScadenzaBetween(da, a);
    }

    @GetMapping("/prodotto/costo")
    public List<Prodotto> ricercaProdottoConCosto(
            @RequestParam(name = "min") float min,
            @RequestParam(name = "max") float max
    )
    {
        return repository.findByCostoBetween(min, max);
    }

    @GetMapping("/prodotto/costomax")
    public List<Prodotto> ricercaProdottoConCostoMax(
            @RequestParam(name = "max") float max
    )
    {
        return repository.findByCostoGreaterThan(max);
    }

    // Caricamento di file
    @PostMapping("/prodotto/caricafile")
    public String caricaFile(@RequestParam("file") MultipartFile file)
    {
        String infoFile = file.getOriginalFilename() + " - " + file.getContentType();
        String conFormat = String.format("%s-%s", file.getOriginalFilename(), file.getContentType());
        logger.info(infoFile);
        logger.warn(conFormat);
        return conFormat;
    }
}