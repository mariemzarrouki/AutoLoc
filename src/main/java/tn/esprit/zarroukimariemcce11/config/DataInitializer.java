package tn.esprit.zarroukimariemcce11.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.zarroukimariemcce11.domain.*;
import tn.esprit.zarroukimariemcce11.repository.IVehiculeRepository;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(IVehiculeRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Vehicule(null, "TN-123-AB", "Renault",
                        "Clio", CategorieVehicule.CITADINE,
                        new BigDecimal("80.00"), StatutVehicule.DISPONIBLE,
                        null, null, null, null));

                repo.save(new Vehicule(null, "TN-456-CD", "Peugeot",
                        "3008", CategorieVehicule.SUV,
                        new BigDecimal("150.00"), StatutVehicule.DISPONIBLE,
                        null, null, null, null));

                repo.save(new Vehicule(null, "TN-789-EF", "Dacia",
                        "Duster", CategorieVehicule.SUV,
                        new BigDecimal("120.00"), StatutVehicule.MAINTENANCE,
                        null, null, null, null));

                System.out.println("✅ 3 véhicules insérés !");
            }
        };
    }
}