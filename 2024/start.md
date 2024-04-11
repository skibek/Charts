https://roadmap.sh/roadmaps?ref=dailydev
https://roadmap.sh/software-design-architecture
https://roadmap.sh/system-design
https://roadmap.sh/computer-science
https://roadmap.sh/software-architect
https://roadmap.sh/datastructures-and-algorithms


# Architektura
Rewelacyjne podejście: https://wildasoftware.pl/post/jak-opisywac-architekture-oprogramowania
 Celem architektury oprogramowania jest zminimalizowanie liczby ludzi wymaganych do zbudowania i utrzymywania danego systemu.
- Model C4 - Context, Container, Component, Code
- 4+1 Architectural View Model - Perspektywa logiczna (diagramy UML - state), procesowa (sequence diagram, communication diagram, activity diagram), developerska (Package diagram and the Component diagram), fizyczna (Deployment diagram) + Scenariusze (Use cases)
- ATAM - (Architecture Tradeoff Analysis Method) Method for Architecture Evaluation, przeglądania jej i szukania luk. Metoda ATAM polega na przygotowaniu spotkania (lub serii spotkań), podczas których pomysły na poszczególne fragmenty architektury są omawiane i konfrontowane z różnymi osobami - zarówno technicznymi, jak i reprezentującymi stronę biznesową
  https://insights.sei.cmu.edu/documents/629/2000_005_001_13706.pdf
- ADR (Architecture Decision Records) - dlaczego w ogóle przyjęliśmy takie rozwiązanie, skoro alternatywa była łatwiejsza

MDM - Master Data Management

# Specyfikacja wymagań
https://wildasoftware.pl/post/specyfikacja-wymagan-oprogramowania-jak-ja-stworzyc-prosto-skutecznie
podejście HANSA (Historia, Aktorzy i Obiekty, Narysuj!, Specyfikacja funkcji, Aspekty jakości)

Specyfikacja funkcji -
Forma opisowa, user stories, use cases

Aspekty jakości - 

standard ISO 25010
Charakterystyka	- Podcharakterystyki
Funkcjonalność	- Poprawność, Właściwości, Współpraca z innymi systemami, Bezpieczeństwo funkcjonalne
Niezborność	- Zgodność, Interoperacyjność, Przenośność, Dostępność
Użyteczność	- Przystępność, Efektywność, Satysfakcja użytkownika
Zawartość	- Dokładność, Właściwości, Zakres
Zużycie zasobów	- Wykorzystanie pamięci, Wykorzystanie procesora, Wykorzystanie dysku, Wykorzystanie sieci
Utrzymanie	- Możliwość testowania, Czytelność kodu, Łatwość modyfikacji, Stabilność
Przenośność -	Zgodność z normami, Łatwość instalacji, Łatwość konfiguracji
Współpraca	- Zgodność z innymi systemami, Współpraca z innymi użytkownikami, Łatwość integracji

wymagań pozafunkcjonalnych - SMART
S (Specific/Simple) - skonkretyzowane
M (Measurable) - mierzalne
A (Achievable) - osiągalne
R (Relevant) - mające znaczenie
T (Timed) - określone w czasie
