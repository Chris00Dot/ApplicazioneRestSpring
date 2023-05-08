package it.devlec.applicazionerestspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Prodotto
{
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String descrizione;
    private String marca;
    private Date dataDiAcquisto;
    private Date dataDiProduzione;
    private Date dataDiPrenotazione;
    private Date dataDiScadenza;
    private float costo;
    private String valuta;
    private boolean riciclabile;
    private int numeroModello;
    private int numeroDiVersione;
    private int numeroDiSerie;
    private String codiceABarre;

    public Prodotto(Long id, String nome, String descrizione, String marca, Date dataDiAcquisto, Date dataDiProduzione, Date dataDiPrenotazione, Date dataDiScadenza, float costo, String valuta, boolean riciclabile, int numeroModello, int numeroDiVersione, int numeroDiSerie, String codiceABarre)
    {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.marca = marca;
        this.dataDiAcquisto = dataDiAcquisto;
        this.dataDiProduzione = dataDiProduzione;
        this.dataDiPrenotazione = dataDiPrenotazione;
        this.dataDiScadenza = dataDiScadenza;
        this.costo = costo;
        this.valuta = valuta;
        this.riciclabile = riciclabile;
        this.numeroModello = numeroModello;
        this.numeroDiVersione = numeroDiVersione;
        this.numeroDiSerie = numeroDiSerie;
        this.codiceABarre = codiceABarre;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public Date getDataDiAcquisto()
    {
        return dataDiAcquisto;
    }

    public void setDataDiAcquisto(Date dataDiAcquisto)
    {
        this.dataDiAcquisto = dataDiAcquisto;
    }

    public Date getDataDiProduzione() {
        return dataDiProduzione;
    }

    public void setDataDiProduzione(Date dataDiProduzione)
    {
        this.dataDiProduzione = dataDiProduzione;
    }

    public Date getDataDiPrenotazione() {
        return dataDiPrenotazione;
    }

    public void setDataDiPrenotazione(Date dataDiPrenotazione)
    {
        this.dataDiPrenotazione = dataDiPrenotazione;
    }

    public Date getDataDiScadenza() {
        return dataDiScadenza;
    }

    public void setDataDiScadenza(Date dataDiScadenza)
    {
        this.dataDiScadenza = dataDiScadenza;
    }

    public float getCosto()
    {
        return costo;
    }

    public void setCosto(float costo)
    {
        this.costo = costo;
    }

    public String getValuta()
    {
        return valuta;
    }

    public void setValuta(String valuta)
    {
        this.valuta = valuta;
    }

    public boolean isRiciclabile()
    {
        return riciclabile;
    }

    public void setRiciclabile(boolean riciclabile)
    {
        this.riciclabile = riciclabile;
    }

    public int getNumeroModello()
    {
        return numeroModello;
    }

    public void setNumeroModello(int numeroModello)
    {
        this.numeroModello = numeroModello;
    }

    public int getNumeroDiVersione()
    {
        return numeroDiVersione;
    }

    public void setNumeroDiVersione(int numeroDiVersione)
    {
        this.numeroDiVersione = numeroDiVersione;
    }

    public int getNumeroDiSerie()
    {
        return numeroDiSerie;
    }

    public void setNumeroDiSerie(int numeroDiSerie)
    {
        this.numeroDiSerie = numeroDiSerie;
    }

    public String getCodiceABarre()
    {
        return codiceABarre;
    }

    public void setCodiceABarre(String codiceABarre)
    {
        this.codiceABarre = codiceABarre;
    }
}