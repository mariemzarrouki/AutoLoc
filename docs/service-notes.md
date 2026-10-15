# Atelier 4 — Notes Service, IoC et DI

## A. Modes d'injection comparés

| Critère | Constructeur ✅ | Attribut ❌ |
|---|---|---|
| Champ `final` possible | Oui | Non |
| Dépendance visible dans la signature | Oui | Non |
| Utilisable avec `new` hors conteneur | Oui | Non (null) |
| Signalé par SonarQube | Non | Oui (S6813) |

## B. Services créés

| Service | Dépendance injectée | Mode | Justification |
|---|---|---|---|
| ContratServiceImpl | IContratRepository | Constructeur | Montant ≥ 0, cascade paiements |
| AgenceServiceImpl | IAgenceRepository | Constructeur | Nom obligatoire |
| ClientServiceImpl | IClientRepository | Constructeur | Nom + email obligatoires |
| EmployeeServiceImpl | IEmployeeRepository | Constructeur | Nom obligatoire |
| VehiculeServiceImpl | IVehiculeRepository | Constructeur | Tarif ≥ 0 |
| EquipementServiceImpl | IEquipementRepository | Constructeur | Libellé obligatoire |
| ReservationServiceImpl | IReservationRepository | Constructeur | dateFin ≥ dateDebut |
| PaiementServiceImpl | IPaiementRepository | Constructeur | Lecture seule |
| MaintenanceServiceImpl | IMaintenanceRepository | Constructeur | dateFin ≥ dateDebut |

## C. Messages d'erreur du conteneur

### Message 1 — NoSuchBeanDefinitionException
- **Cause** : @Service oublié OU classe hors package scanné
- **Correction** : Ajouter @Service, vérifier le package

### Message 2 — NoUniqueBeanDefinitionException
- **Cause** : 2 beans du même type
- **Correction** : @Primary sur une classe OU @Qualifier("nom") sur le paramètre

### Message 3 — BeanCurrentlyInCreationException
- **Cause** : Dépendance circulaire
- **Correction** : Extraire un 3ᵉ service pour casser le cycle

## D. Anomalies SonarQube

| # | Anomalie | Règle | Correction |
|---|---|---|---|
| 1 | Injection par attribut | S6813 | Injection par constructeur |
| 2 | Exception générique | S112 | ResourceNotFoundException |
| 3 | Import inutilisé | S1128 | Suppression |

## E. Questions de compréhension

**1. Où est le `new` de ContratServiceImpl ?**  
Aucun `new`. Le conteneur Spring instancie le bean via réflexion après détection de `@Service`.

**2. Pourquoi dépendre de IContratService et non de ContratServiceImpl ?**  
Principe d'inversion de dépendance : abstraction > implémentation. Facilite tests (mock) et évolutions.

**3. Pourquoi un service singleton doit-il rester sans état ?**  
Partagé entre threads. Attribut modifiable → collisions. Ex : `private Contrat courant;` → 2 requêtes s'écrasent.

**4. Pourquoi `update` charge-t-il l'existant ?**  
`save()` avec un id fait un `merge` complet. Sans charger, on écrase les colonnes non modifiées → perte de `paiements` (orphanRemoval).

**5. Différences @Component/@Bean et @Primary/@Qualifier ?**
- `@Component` : classe (scan automatique)
- `@Bean` : méthode `@Configuration` (déclaration explicite)
- `@Primary` : classe par défaut
- `@Qualifier` : choix explicite par nom

**Pourquoi IPaiementService est lecture seule ?**  
Un paiement n'existe que rattaché à un contrat. Création/suppression via le Contrat (cascade).