package it.devlec.applicazionerestspring.persistenza;

import it.devlec.applicazionerestspring.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long>
{
    List<Prodotto> findByDatadiproduzione(Date datada, Date dataa);
    List<Prodotto> findByDatadiregistrazioneBetween(Date datada, Date dataa);
    List<Prodotto> findByRankingBetween(float min, float max);
    List<Prodotto> findByRankingLessThan(float max );
}