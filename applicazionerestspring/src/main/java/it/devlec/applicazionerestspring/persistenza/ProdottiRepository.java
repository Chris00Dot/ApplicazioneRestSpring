package it.devlec.applicazionerestspring.persistenza;

import it.devlec.applicazionerestspring.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long>
{
    List<Prodotto> findByDataDiProduzioneBetween(Date datada, Date dataa);
    List<Prodotto> findByDataDiScadenzaBetween(Date datada, Date dataa);
    List<Prodotto> findByCostoBetween(float min, float max);
    List<Prodotto> findByCostoGreaterThan(float max);
}