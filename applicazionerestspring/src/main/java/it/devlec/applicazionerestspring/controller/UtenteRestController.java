package it.devlec.applicazionerestspring.controller;

import it.devlec.applicazionerestspring.avviso.UtenteNonTrovato;
import it.devlec.applicazionerestspring.model.Utente;
import it.devlec.applicazionerestspring.persistenza.UtentiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class UtenteRestController {
    private static Logger logger =
            LoggerFactory.getLogger(UtenteRestController.class);
    private UtentiRepository repository;

    UtenteRestController(UtentiRepository repository){
        this.repository = repository;
    }
    @GetMapping("/utenti")
    public List<Utente> leggiTuttiGliUtenti(){
        logger.info("Prendo tutti gli utenti");
        return repository.findAll();
    }
    @GetMapping("/utente/{id}")
    public Utente trovaUtenteConID(@PathVariable Long id){
        return repository.findById(id).orElseThrow(
                () -> new UtenteNonTrovato(id));
    }
    @PostMapping("/utente")
    public Utente inserisciUnNuovoUtente(@RequestBody Utente nuovoUtente){
        return repository.save(nuovoUtente);
    }
    @PutMapping("/utente")
    public Utente aggiornaDatiUtente(@RequestBody Utente utente)
    {
        return repository.save(utente);
/*        return repository.findById(id).map(
                //creare nuovo
                nuovoUtente -> {
                    nuovoUtente.setNome(utente.getNome());
                    nuovoUtente.setCognome(utente.getCognome());
                    return repository.save(nuovoUtente);
                }
        ).orElseGet(
                () -> {
                    //l'utente esiste
                    utente.setId(id);
                    return repository.save(utente);
                }
        );*/

    }
    @DeleteMapping("/utente/{id}")
    void eliminaUtente(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/utente/ricercatradate")
    public List<Utente> ricercaUtenteTraDate(
            @RequestParam(name="datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date dataa
    ){
        return repository.findByDatadinascitaBetween(datada, dataa);
    }
    @GetMapping("/utente/ricercadataregistrazione")
    public List<Utente> ricercaUtenteConDataDiRegistrazione(
            @RequestParam(name="datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date dataa
    ){
        return repository.findByDatadiregistrazioneBetween(datada, dataa);
    }
    @GetMapping("/utente/ranking")
    public List<Utente> ricercaUtenteConRanking(
            @RequestParam(name = "min") float min ,
            @RequestParam(name = "max") float max
    ) {
        return repository.findByRankingBetween(min, max);
    }
    @GetMapping("/utente/rankingmax")
    public List<Utente> ricercaUtenteConRankingMax(
            @RequestParam(name = "max") float max
    ) {
        return repository.findByRankingLessThan(max);
    }
    // Caricamento di file
    @PostMapping("/caricafile")
    public String caricaFile (@RequestParam("file")MultipartFile file){
        String infoFile = file.getOriginalFilename() + " - "+ file.getContentType();
        String conFormat = String.format("%s-%s", file.getOriginalFilename(), file.getContentType());
        logger.info(infoFile);
        logger.warn(conFormat);
        return conFormat;
    }

}