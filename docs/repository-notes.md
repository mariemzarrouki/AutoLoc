# Atelier 3 — Notes Repository

## Choix d'interface

Pour les 9 entités : **`JpaRepository<Entité, Long>`** car :
- Cumule CRUD + List + Pagination + tri + flush
- Recommandée pour toute application JPA complète

## Comportements clés

- `save()` : INSERT si id null, SELECT+UPDATE sinon
- `deleteById()` : silencieux si id inexistant (Spring Data 3+)
- `deleteAllInBatch()` : ⚠️ contourne cascade et orphanRemoval
- `getReferenceById()` : proxy paresseux, utile pour FK sans chargement

## Anomalies SonarQube corrigées

| # | Anomalie | Règle | Correction |
|---|----------|-------|------------|
| 1 | Import inutilisé | java:S1128 | Suppression |
| 2 | @Data sur entité | Bonnes pratiques JPA | Remplacé par @Getter @Setter |
| 3 | Champ public static | java:S1104 | private static final |

## Conclusion

9 interfaces dans `repository/`, toutes en `JpaRepository<Entité, Long>`.
Spring Data génère les proxies au démarrage : `Found 9 JPA repository interfaces`.