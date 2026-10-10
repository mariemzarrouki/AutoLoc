package tn.esprit.zarroukimariemcce11.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.zarroukimariemcce11.domain.*;
import tn.esprit.zarroukimariemcce11.repository.IContratRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class CascadeTestRunner {

    @Bean
    CommandLineRunner cascadeTest(IContratRepository contratRepo) {
        return args -> {
            System.out.println("\n===== TEST CASCADE =====");

            Contrat contrat = new Contrat();
            contrat.setDateSignature(LocalDate.now());
            contrat.setMontantTotal(new BigDecimal("500.00"));
            contrat.setValide(true);

            Paiement p1 = new Paiement(null, new BigDecimal("250.00"),
                    LocalDate.now(), ModePaiement.CARTE, contrat);
            Paiement p2 = new Paiement(null, new BigDecimal("250.00"),
                    LocalDate.now(), ModePaiement.ESPECES, contrat);

            contrat.getPaiements().add(p1);
            contrat.getPaiements().add(p2);

            Contrat saved = contratRepo.save(contrat);
            System.out.println("✅ Contrat id=" + saved.getIdContrat()
                    + " avec " + saved.getPaiements().size() + " paiements");

            System.out.println("===== FIN TEST =====\n");
        };
    }
}