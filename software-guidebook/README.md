# Software Guidebook Triptop

## 1. Introduction
Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende:
1. De vereisten, beperkingen en principes.
1. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software.
1. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
1. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd.

## 2. Context

> [!IMPORTANT]
> Werk zelf dit hoofdstuk uit met context diagrammen en een beschrijving van de context van de software.

![System Context Diagram](../opdracht-diagrammen/Context_Diagram_Triptop_Systeem.png)
**Triptop** is een online platform dat reizigers helpt bij het plannen van reizen met meerdere bestemmingen. Het biedt een gebruiksvriendelijke interface waarmee gebruikers hun reizen kunnen organiseren door verschillende elementen zoals vluchten, treinreizen, verblijven en eet- en drinkopties te combineren. Het platform maakt gebruik van verschillende externe API's om gegevens te verkrijgen en biedt gepersonaliseerde reisopties op basis van de voorkeuren van de reiziger.

Functionaliteiten:

**Multi-bestemmingsplanner:** Reizigers kunnen een reis plannen met meerdere bestemmingen, waarbij Triptop helpt bij het organiseren van routes, verblijven en activiteiten.

**Integratie van externe diensten:** Triptop integreert met externe systemen voor boekingen van vluchten, treinen, hotels en restaurants, evenals betalingen en inlogfunctionaliteiten.

**Flexibiliteit:** Triptop is ontworpen om eenvoudig nieuwe externe API's te integreren, zodat de reiziger toegang heeft tot de nieuwste diensten en mogelijkheden.

## Gebruikers
- **Reiziger**: Stelt reizen samen en boekt transport/accommodaties.
- **Administrator**: Beheert het systeem en de gebruikers.

## Externe Systemen
- **Identity Provider API**: Authenticatie via Apple, Google, Microsoft.
- **Demand API (Booking.com)**: Accommodatie- en transportboeking.
- **Mollie API**: Betalingen via iDEAL, Klarna, PayPal.
- **Google Maps API**: Routeplanning en kaarten.
- **All Aboard API**: Treinreizen binnen Europa.
- **AeroDataBox API**: Vluchttijden en -routes.
- **Grubhub API**: Eten en drinken via restaurants.

Toelichting op de context van de software inclusief System Context Diagram:
* Functionaliteit
* Gebruikers
* Externe systemen

## 3. Functional Overview

Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt en een overzicht van het domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit voorbeeld.

### 3.1 User Stories

#### 3.1.1 User Story 1: Reis plannen

Als gebruiker wil ik een zelfstandig op basis van diverse variabelen (bouwstenen) een reis kunnen plannen op basis van mijn reisvoorkeuren (wel/niet duurzaam reizen, budget/prijsklasse, 's nachts reizen of overdag etc.) zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.2 User Story 2: Reis boeken

Als gebruiker wil ik een geplande reis als geheel of per variabele (bouwsteen) boeken en betalen zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.3 User Story 3: Reis cancelen

Als gebruiker wil ik een geboekte reis, of delen daarvan, kunnen annuleren zodat ik mijn geld terug kan krijgen zonder inmenging van een intermediair zoals een reisbureau.

#### 3.1.4 User Story 4: Reisstatus bewaren

Als gebruiker wil ik mijn reisstatus kunnen bewaren zonder dat ik een extra account hoef aan te maken zodat ik mijn reis kan volgen zonder dat ik daarvoor extra handelingen moet verrichten.

#### 3.1.5 User Story 5: Bouwstenen flexibel uitbreiden

Als gebruiker wil ik de bouwstenen van mijn reis flexibel kunnen uitbreiden met een zelf te managen stap (bijv. met providers die niet standaard worden aangeboden zoals een andere reisorganisatie, hotelketen etc.) zodat ik mijn reis helemaal kan aanpassen aan mijn wensen.

### 3.2 Domain Story Reis Boeken (AS IS)

![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Story Reis Boeken (TO BE)

![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.4 Domain Model

![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

## 4. Quality Attributes

Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd als belangrijk:
* Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other products and mutually use the information that has been exchanged)
* Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of hardware or software faults)
* Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such that a change to one component has minimal impact on other components)
* Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified without introducing defects or degrading existing product quality)
* Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data are protected from unauthorized modification or deletion either by malicious action or computer error)
* Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to those authorized to have access)

## 5. Constraints

> [!IMPORTANT]
> Beschrijf zelf de beperkingen die op voorhand bekend zijn die invloed hebben op keuzes die wel of niet gemaakt kunnen of mogen worden.
## 6. Principles

> [!IMPORTANT]
> Beschrijf zelf de belangrijkste architecturele en design principes die zijn toegepast in de software.

### 1. Modulariteit & Scheiding van Verantwoordelijkheden
- De software maakt gebruik van een **Factory Pattern** (`MapServiceFactory`) om de keuze tussen verschillende kaartdiensten (Google Maps en Mapbox) flexibel te houden.
- Elke kaartservice (`GoogleMapsService` en `MapBoxService`) implementeert een gemeenschappelijke interface (`MapService`), wat zorgt voor duidelijke scheiding van verantwoordelijkheden.

### 2. Configuratie via Properties
- API-keys en basis-URL’s worden opgeslagen in een `application.properties` bestand, zodat ze niet hardcoded in de code staan.
- Dit verhoogt de veiligheid en flexibiliteit van de applicatie.

### 3. RESTful API Design
- De applicatie biedt een duidelijke en consistente API (`/maps/route`) waarin de gebruiker dynamisch een provider kan kiezen via query parameters.
- HTTP GET requests worden gebruikt om routes op te vragen, wat past bij RESTful principes.

### 4. Externe API Integratie
- **Google Maps API** wordt aangesproken via **RapidAPI**, waarbij authenticatie gebeurt met de juiste headers (`x-rapidapi-key`).
- **Mapbox API** wordt direct benaderd via een correcte URL-constructie met `RestTemplate`.
- De API-aanroepen worden dynamisch gegenereerd op basis van de opgegeven coördinaten en instellingen.

### 5. Logging & Debugging
- Responses van de API's worden gelogd (`System.out.println`), zodat fouten zoals "Invalid API Key" of "NoSegment" snel gedetecteerd kunnen worden.
- Dit helpt bij het debuggen en optimaliseren van de integratie met externe kaartservices.

## 7. Software Architecture

###     7.1. Containers

> [!IMPORTANT]
> Voeg toe: Container Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

#### Container Diagram
![Container Diagram](../opdracht-diagrammen/Container_Diagram_Triptop_Systeem.png)

Triptop is een reisplatform dat meerdere externe systemen integreert. De Web Applicatie is de interface voor de gebruiker, maar de Backend is verantwoordelijk voor de verwerking van gegevens en interacties met externe systemen. De Database slaat reis- en reserveringsinformatie op, maar de specifieke datamodellen en structuren worden niet gedetailleerd beschreven in het diagram.

**Externe Integraties:**
**Identity Provider API:** Verwerkt authenticatie via externe providers zoals Google, Apple en Microsoft, maar de methodes en technieken van authenticatie zijn niet verder gespecificeerd.

**Demand API**: Dit systeem haalt reisopties op, maar specifieke parameters voor het aanvragen van gegevens of de dataformaten zijn niet beschreven.

**Mollie API:** Betalingen worden verwerkt, maar het is onduidelijk welke specifieke betalingsopties ondersteund worden of hoe transactiebeveiliging wordt afgehandeld.

Kaart- en route-informatie wordt opgehaald via MapBox en Google Maps API, maar hoe deze systemen worden gecombineerd of welke specifieke kaartfunctionaliteiten worden gebruikt, is niet gedetailleerd.

De backend fungeert dus als een tussenpersoon die verzoeken afhandelt, maar de manier waarop de backend schaalbaar is of hoe foutafhandeling wordt uitgevoerd in de communicatie tussen deze systemen, wordt niet weergegeven in het diagram.
#### Dynamic Diagrams
##### Login
![Dynamic Diagram](../opdracht-diagrammen/Dynamic_Container_Login.png)

Dit diagram illustreert het proces van inloggen binnen de **Triptop** applicatie. Het beschrijft de interacties tussen de **Web Applicatie**, de **Backend**, en de **Identity Provider API** die de inloggegevens van de gebruiker verifieert. Het proces verloopt in vier stappen:

1. De **reiziger** voert zijn inloggegevens in via de **Web Applicatie**.
2. De **Backend** verwerkt deze inloggegevens en stuurt ze naar de **Identity Provider API** voor verificatie.
3. De **Identity Provider API** bevestigt of wijst de inlogpoging af.
4. De **Backend** stuurt het resultaat van de inlogpoging (succes of mislukking) terug naar de **Web Applicatie**, die het resultaat aan de gebruiker toont.

##### Booking
![Dynamic Diagram](../opdracht-diagrammen/Dynamic_Container_Booking.png)

Dit diagram toont de flow van het boeken van een reis binnen de **Triptop** applicatie. Het proces bestaat uit meerdere interacties tussen de **Web Applicatie**, de **Backend**, de **Database**, en externe systemen zoals de **Demand API** (voor reisopties) en de **Mollie API** (voor betalingen). Het proces verloopt als volgt:

1. De **reiziger** selecteert reisopties via de **Web Applicatie**.
2. De **Backend** haalt beschikbare reisopties op van de **Demand API**.
3. De **Web Applicatie** toont de opgehaalde reisopties aan de **reiziger**.
4. Wanneer de **reiziger** een boeking bevestigt, slaat de **Backend** de boekingsgegevens op in de **Database**.
5. De **Backend** verwerkt de betaling via de **Mollie API**.
6. Ten slotte toont de **Web Applicatie** een bevestiging van de boeking aan de **reiziger**.

###     7.2. Components
> [!IMPORTANT]
> Voeg toe: Component Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

![Component Backend Diagram](../opdracht-diagrammen/diagramNils.png)
Dit backend componentendiagram toont de architectuur van een uitgavenbeheerapplicatie waarin gebruikers vluchten, hotels, treinen en eten kunnen boeken en betalingen kunnen uitvoeren. De React WebApp communiceert via REST API’s met een Spring Boot backend, die modulair is opgebouwd met gescheiden controllers en services.

Authenticatie verloopt via een externe Identity Provider API, waardoor gebruikers eenvoudig kunnen inloggen via Apple, Google of Microsoft. Gegevens worden opgeslagen in een PostgreSQL-database, terwijl externe API’s zoals AeroDataBox (vluchten), Booking.com (hotels), Mollie (betalingen), All Aboard (treinen) en Grubhub (eten) worden gebruikt voor dataverwerking.

Elke functionele eenheid volgt een vaste structuur met een controller voor verzoeken, een service voor logica en (indien nodig) een repository voor database-interacties. Dit zorgt voor een schaalbare, onderhoudbare en eenvoudig uitbreidbare backend.

| Class::Attribuut                                                | Is input voor API+Endpoint                          | Wordt gevuld door API+Endpoint | Wordt geleverd door eindgebruiker | Moet worden opgeslagen in de applicatie |
|-----------------------------------------------------------------|-----------------------------------------------------|--------------------------------|-----------------------------------|-----------------------------------------|
| MapService::getRoute(start, end)                                | Google Maps API /directions, MapBox API /directions | ✅                              | ✅                                 | ❌                                       |
| MapService::getMap(location, zoomLevel)                         | Google Maps API /staticmap, MapBox API /static      | ✅                              | ✅                                 | ❌                                       |
| GoogleMapsService::someGoogleSpecificMethod()                   | Google Maps API specifieke functionaliteit          | ✅                              | ❌                                 | ❌                                       |
| MapBoxService::someMapBoxSpecificMethod()                       | MapBox API specifieke functionaliteit               | ✅                              | ❌                                 | ❌                                       |
| MapController::handleRequest(request)                           | ❌                                                 | ❌                              | ✅                                 | ❌                                       |
| MapServiceFactory::createService(provider)                      | ❌                                                 | ❌                              | ✅                                 | ❌                                       |
| MapboxController::getDirections(origin, waypoints, destination) | GET /directions                                    | ✅                              | ✅                                 | ❌                                       |
| MapboxController::getRouting()                                  | GET /routing                                       | ✅                              | ❌                                 | ❌                                       |
| MapboxController::nextRouting()                                 | POST /routing                                      | ✅                              | ❌                                 | ❌                                       |
| WebApp::searchFlights(flightQuery)                              | AeroDataBox API /flights/search, FR24 API /flights | ✅                              | ✅                                 | ❌                                       |
| WebApp::getFlightStatus(flightDetails)                          | AeroDataBox API /flights/status, FR24 API /status  | ✅                              | ✅                                 | ❌                                       |
| FlightController::fetchFlightData(flightQuery)                  | AeroDataBox API /flights/search, FR24 API /flights | ✅                              | ✅                                 | ❌                                       |
| FlightService::fetchFlightData(flightQuery)                     | AeroDataBox API /flights/search, FR24 API /flights | ✅                              | ✅                                 | ❌                                       |
| FlightService::setFlightDataStrategy(strategy)                  | ❌                                                 | ❌                              | ✅                                 | ✅                                       |
| StrategyService::setCurrentStrategy(strategy)                   | ❌                                                 | ❌                              | ✅                                 | ✅                                       |
| StrategyService::getCurrentStrategy()                           | ❌                                                 | ✅                              | ❌                                 | ✅                                       |
| AeroDataBoxProvider::fetchFlightData(flightQuery)               | AeroDataBox API /flights/search                    | ✅                              | ✅                                 | ❌                                       |
| AeroDataBoxProvider::fetchNearbyAirports(airport)               | AeroDataBox API /airports/nearby                   | ✅                              | ✅                                 | ❌                                       |
| FlightRadar24Provider::fetchFlightData(flightQuery)             | FlightRadar24 API /flights/search                  | ✅                              | ✅                                 | ❌                                       |
| FlightRadar24Provider::fetchNearbyAirports(airport)             | FlightRadar24 API /airports/nearby                 | ✅                              | ✅                                 | ❌                                       |

![Dyanimc Diagram](../opdracht-diagrammen/diagram-Dynamic.png)
Dit dynamische componentendiagram beschrijft de betalingsverwerking in een webapplicatie voor uitgavenbeheer. De gebruiker initieert een betaling via de WebApp (React), die het verzoek doorstuurt naar de backend (Spring Boot).

De backend bestaat uit drie componenten: BetaalController verwerkt inkomende verzoeken, BetaalService voert de betalingslogica uit, en PaymentProvider handelt de communicatie met externe betalingsdiensten af. De Mollie API wordt hier als externe provider gebruikt.

Door PaymentProvider als tussenlaag te gebruiken, blijft de backend losgekoppeld van een specifieke betalingsaanbieder, waardoor het eenvoudig is om andere providers toe te voegen. De scheiding tussen controller, service en provider maakt de code beter onderhoudbaar en uitbreidbaar.

###     7.3. Design & Code

> [!IMPORTANT]
> Voeg toe: Per ontwerpvraag een Class Diagram plus een Sequence Diagram van een aantal scenario's inclusief begeleidende tekst.

#### 7.3.1
Hoe kunnen we verschillende externe vervoersservices (zoals Google Maps of een veerdienst API) integreren zonder afhankelijk te worden van hun specifieke implementaties?

![Klasse Diagram](../opdracht-diagrammen/KlasseDiagram.png)

Dit C4-klasse diagram toont de architectuur van een kaartsysteem dat zowel Google Maps als MapBox ondersteunt. De kern wordt gevormd door de interface MapService, die methoden biedt voor het ophalen van routes en kaartafbeeldingen. GoogleMapsService en MapBoxService implementeren deze interface en voegen hun eigen specifieke functionaliteiten toe.

MapController handelt verzoeken af en maakt gebruik van MapService en MapServiceFactory, die op basis van een providernaam de juiste kaartservice aanmaakt. Coordinate slaat locaties op met breedte- en lengtegraad, Route bevat een lijst van coördinaten die een route vormen, en MapImage houdt kaartafbeeldingen bij als byte-array.

Route, Coordinate en MapImage staan los van de kaartservices (daarom heb ik ze niet in het plaatje gedaan), omdat ze generieke datamodellen vertegenwoordigen die onafhankelijk zijn van een specifieke provider. Dit zorgt ervoor dat de structuur van routes, coördinaten en afbeeldingen uniform blijft, ongeacht of ze afkomstig zijn van Google Maps of MapBox. Hierdoor wordt de koppeling tussen de services en de data geminimaliseerd, wat het systeem flexibeler en beter uitbreidbaar maakt.

#### 7.3.2
![state pattern](../opdracht-diagrammen/class-diagram-dennis.svg)
In bovenstaand diagram is de architectuur, bijbehorend bij de vraag **"Hoe zorg je voor een zo kort mogelijke reisroute waarbij gebruik gemaakt wordt van alle bouwstenen? Hoe zorg je ervoor dat de reisroute makkelijk aangepast kan worden als reisafstand geen issue is?"**, te zien. Hiervoor hebben we het State Pattern gebruikt, aangezien deze gekozen was als gevolg van een voorgaande opdracht van school (zie [deze ADR](../ADRs/0006-State-pattern.md) voor meer informatie). In `MapboxRoutingManager` is een klein deel weggelaten. Dit deel is verantwoordelijk voor het opstellen van de URL, die gestuurd wordt naar de Mapbox API. `MapboxController#getDirections` heeft de `@GetMapping("/directions")`-annotation erboven staan. Ook zijn alle parameters hiervan annotated met `@RequestParam`, waarbij de `waypoints`'s `@RequestParam` de field `required` op `false` heeft staan. `MapboxController#getRouting` en `MapboxController#nextRouting` hebben de `@GetMapping("/routing")` en `@PostMapping("/routing)"`-annotation erboven staan, respectievelijk.


#### 7.3.3
![Strategy Pattern](../opdracht-diagrammen/class-diagram-nils.png)
Het diagram toont de structuur van de klassen, maar laat bepaalde details weg, zoals de specifieke logica van de FlightDataStrategy providers, de werking van de FlightStatus (bijvoorbeeld hoe en wanneer de status wordt bijgewerkt), en de beveiliging/validatie van login- en autorisatieprocessen. Ook is de relatie tussen FlightStatus en FlightDetails niet expliciet weergegeven, ondanks de mogelijke logische koppeling via het vluchtnummer.

#### 7.3.4
![Samengevoegde diagram](../opdracht-diagrammen/SamenGevoegdeKlassenDiagram.png)
Het diagram toont de architectuur en de interacties tussen verschillende klassen binnen het systeem. De structuur is onderverdeeld in meerdere componenten, elk verantwoordelijk voor specifieke functionaliteiten.

## 8. Architectural Decision Records

### 8.1. ADR-0001-Payment Options

# Payment Options
**Datum**: 2025-03-21

## Status
**Accepted**

## Context
We maken een reismanager-app en hiervoor hebben we een Payment API nodig die betalingen afhandelt. Welke API het meest geschikt is, willen we graag weten.

## Considered Options

| Forces                         | Mollie | Knit Pay Pro  | PayPal |
|---------------------------------|--------|---------------|--------|
| Standaard API's beschikbaar     | --     | ?             | ++     |
| Eenvoudig te gebruiken in Java  | 0      | -             | 0      |
|Documentatie                     | -      | --            | ++     |
|Beveliging                       | +      | 0             | +      |

## Decision
Uiteindelijk is de keuze gemaakt om PayPal te gebruiken in plaats van Mollie, omdat we er later achterkwamen dat Mollie een business account nodig heeft om een API-key te verkrijgen. Helaas was Mollie hierdoor niet bruikbaar, hoewel het een goede optie had kunnen zijn. PayPal is veel kennis over te vinden omdat het bekend is.

## Consequences
PayPal is een bekend en betrouwbaar API met goed gedocumenteerde bronnen. Het is volgens bronnen makkelijk te integreren, maar het kan mogelijk problemen opleveren met beveiliging en netwerkverbindingen.

### 8.2. ADR-0002-Flights-Options

# Flights Options

**Datum:** 2025-03-21

## Status
**Accepted**

## Context
Voor onze reismanager-app hebben we een Flights API nodig die vluchten kan opzoeken. We willen bepalen welke API hiervoor het meest geschikt is.

## Considered Options

| Factoren                     | AeroDataBox | FlightsAPI | AmadeusAPI |
|------------------------------|------------|-----------|------------|
| Informatie beschikbaar       | +          | 0         | 0          |
| Eenvoudig te gebruiken       | ++         | --        | +          |
| Real-time vluchtinformatie   | ++         | -         | 0          |
| Documentatie                 | +          | -         | ++         |

## Decision
Uiteindelijk hebben we gekozen voor **AeroDataBox**. De belangrijkste redenen hiervoor zijn:
- **Kosten:** FlightsAPI vereist een maandelijkse betaling, terwijl AeroDataBox gratis of goedkoper is.
- **Focus op vluchten:** AeroDataBox biedt uitgebreide informatie over vluchten, waaronder vluchttracking, vluchtstatus en luchthaveninformatie.
- **Gebruiksvriendelijkheid:** Vergeleken met AmadeusAPI is AeroDataBox veel eenvoudiger te gebruiken, omdat AmadeusAPI een complexere implementatie vereist.

## Consequences
AeroDataBox is ideaal voor real-time tracking en vluchtinformatie. Echter, het biedt geen ondersteuning voor hotels en boekingsservices. Voor deze functionaliteiten zullen we een aanvullende API moeten zoeken.

### 8.3. ADR-0003-Mapbox

# Mapbox

**Datum:** 21/03/2025

## Status
Accepted

## Context
We hebben een API nodig die routes naar bestemmingen kan berekenen en hierbij richtingen kan aangeven. De API moet eenvoudig te integreren zijn binnen ons bestaande systeem, voldoende documentatie bieden en indien nodig aanpasbaar zijn. Daarnaast is prijs een belangrijke factor, evenals gebruiksvriendelijkheid voor zowel ontwikkelaars als eindgebruikers.

## Considered Options
| Forces | Google Maps | Apple Maps | OpenStreetMap (OSM) | Mapbox |
|---|---|---|---|---|
| Prijs | 0 | ++ | ++ | + |
| Aanpasbaarheid | 0 | - | ++ | ++ |
| Integreerbaarheid | + | - | 0 | ++ |
| Gebruiksvriendelijkheid | ++ | ++ | 0 | ++ |
| Beschikbare documentatie | ++ | - | + | ++ |

### Criteria
- **Prijs**: Google Maps heeft een gratis laag, maar kosten kunnen snel oplopen. Apple Maps is gratis, maar beperkt in gebruik buiten het Apple-ecosysteem. OSM en Mapbox zijn goedkoper en bieden flexibele prijsmodellen.
- **Aanpasbaarheid**: Google Maps biedt beperkte aanpassingsmogelijkheden. Apple Maps is gesloten en moeilijk aanpasbaar. OSM en Mapbox bieden uitgebreide mogelijkheden voor maatwerk.
- **Integreerbaarheid**: Google Maps en Mapbox bieden eenvoudige SDK’s en API’s. Apple Maps heeft beperkte ondersteuning buiten iOS/macOS. OSM vereist meer inspanning voor integratie.
- **Gebruiksvriendelijkheid**: Google Maps en Apple Maps bieden intuïtieve en gebruiksvriendelijke interfaces. OSM vereist meer technische kennis. Mapbox biedt een goede balans tussen flexibiliteit en gebruiksgemak.
- **Documentatie**: Google Maps en Mapbox bieden uitgebreide documentatie. Apple Maps heeft minder documentatie beschikbaar. OSM heeft documentatie, maar deze is soms gefragmenteerd.

## Decision

Na evaluatie van de verschillende opties hebben we besloten om voor **Mapbox** te kiezen. Mapbox scoort hoog op vrijwel alle relevante criteria en biedt een goede balans tussen kosten, flexibiliteit en gebruiksvriendelijkheid. De belangrijkste redenen voor deze keuze zijn de aanpasbaarheid van Mapbox, die uitgebreide mogelijkheden biedt voor het aanpassen van kaarten, routes en styling. Daarnaast zijn de integratie-opties goed, aangezien de SDK’s en API’s goed gedocumenteerd zijn en eenvoudig in bestaande systemen te integreren. Wat betreft betaalbaarheid is Mapbox een kosteneffectief alternatief voor Google Maps, met flexibele prijsmodellen, hoewel het niet gratis is. Bovendien biedt de uitstekende documentatie van Mapbox een belangrijke meerwaarde, aangezien deze uitgebreid en goed gestructureerd is, wat de integratie en het onderhoud vergemakkelijkt.

## Consequences

De keuze voor Mapbox heeft enkele gevolgen die moeten worden meegenomen in de implementatie. De kostenstructuur is een belangrijk punt, aangezien, hoewel Mapbox goedkoper is dan Google Maps, er toch een budget gereserveerd moet worden voor gebruikskosten, vooral bij opschaling. De ondersteuning en community van Mapbox zijn goed, maar deze zijn minder breed dan die van Google Maps. Daarnaast maakt Mapbox deels gebruik van OSM-gegevens, wat invloed kan hebben op de nauwkeurigheid en updates van de kaarten. Ten slotte kunnen mogelijke toekomstige veranderingen in de licentie- en prijsstructuur van Mapbox invloed hebben op de langetermijnstrategie.

Door deze aspecten in acht te nemen, kunnen we een robuuste en schaalbare implementatie realiseren. Mapbox biedt een krachtige oplossing die goed aansluit bij onze behoeften, met minimale nadelen.


### 8.4. ADR-0004-Gebruik-van-interface-gebaseerde-afhankelijkheden
# Gebruik van interface-gebaseerde afhankelijkheden

Date: 26-3-2025

## Status
Accepted

## Context
Het systeem moet flexibel blijven als het gaat om externe services. We willen vermijden dat business logic direct afhankelijk is van specifieke API’s zoals Mollie of AeroDataBox.

## Considered Options

| Forces                                  | Strategy Pattern | Adapter Pattern | Facade Pattern | Factory Method Pattern | State Pattern |
|-----------------------------------------|------------------|-----------------|----------------|------------------------|---------------|
| Losse koppeling                         | ++               | ++              | +              | +                      | ++            |
| Onderhoudbaarheid                       | ++               | +               | ++             | -                      | ++            |
| Complexiteit                            | +                | 0               | -              | ++                     | -             |
| Gemak van wisselen van externe services | ++               | +               | 0              | -                      | +             |
| Testbaarheid                            | ++               | +               | -              | 0                      | ++            |
| Geschiktheid voor variërende services   | ++               | 0               | +              | +                      | ++            |

## Decision
We kiezen voor het **Strategy Pattern**, omdat dit de meest flexibele en modulaire oplossing biedt. Elke externe service wordt geïnjecteerd als een implementatie van een generieke interface, waardoor we eenvoudig kunnen wisselen tussen providers zonder de kernlogica te wijzigen.

## Consequences
**Voordelen:**
- Externe services zijn eenvoudig verwisselbaar.
- Business logic blijft gescheiden van de specifieke service-implementatie.
- Ondersteunt uitbreiding met nieuwe services zonder impact op bestaande code.
- Maakt unit testing eenvoudiger door dependency injection.

**Nadelen:**
- Meer complexiteit dan een hardcoded implementatie.
- Vereist duidelijke interfaces en dependency injection.


### 8.5. ADR-0005-Dynamische-Kaartservices-met-de-FactoryMethod
# Navigating the Right Path: Dynamische Kaartservices met de Factory Method

**Date:** 28-3-2025

## Status
**Accepted**

## Context

In de ontwikkeling van dynamische kaartservices is het belangrijk om externe kaartleveranciers zoals Google Maps en MapBox flexibel te integreren.
Het doel is om de kaartprovider te kunnen wisselen zonder het systeem te herontwerpen.
De Factory Method Pattern wordt gekozen om deze flexibiliteit te bieden, waarbij het systeem dynamisch een kaartprovider selecteert en aanmaakt,
zonder de koppeling tussen componenten te verhogen.
## Considered Options

| Forces                                      | Adapter Pattern | Facade Pattern | Factory Method Pattern | State Pattern | Strategy Pattern |
|---------------------------------------------|-----------------|----------------|------------------------|---------------|------------------|
| **Complexiteit**                            | --              | 0              | +                      | +             | 0                |
| **Losse koppeling**                         | +               | ++             | ++                     | 0             | +                |
| **Gemak van wisselen van externe services** | ++              | +              | +                      | -             | +                |
| **Onderhoudbaarheid**                       | 0               | -              | ++                     | -             | +                |
| **Testbaarheid**                            | -               | --             | +                      | 0             | +                |

## Decision

Na het evalueren van de verschillende ontwerppatronen is besloten om de **Factory Method Pattern** te implementeren voor het dynamisch creëren van kaartservice-objecten. Dit patroon biedt de juiste balans tussen complexiteit,
onderhoudbaarheid en losse koppeling. De keuze is gemaakt om de flexibiliteit te behouden bij het toevoegen van nieuwe kaartservices zonder grote wijzigingen aan de bestaande codebasis. De methoden getRoute en getMap worden gedefinieerd in een abstracte MapService klasse, en de concrete implementaties voor Google Maps en MapBox worden dynamisch gecreëerd door de MapServiceFactory.
Factory methode is de beste keuze ondanks dit waren state en strategy ook opties maar deze waren gekozen door mijn groep en daarom geen optie.
## Consequences

**Voordelen:**
- **Flexibiliteit**: Het systeem kan eenvoudig worden aangepast om nieuwe kaartproviders toe te voegen door alleen de MapServiceFactory aan te passen. Er zijn geen grote wijzigingen nodig in de rest van het systeem.
- **Losse koppeling**: De Factory Method zorgt ervoor dat de MapController geen kennis heeft van de specifieke kaartservice (Google Maps of MapBox), wat zorgt voor een losser gekoppeld ontwerp.
- **Onderhoudbaarheid**: Het systeem is makkelijker te onderhouden omdat de kaartservices geïsoleerd zijn van andere delen van de applicatie. Het toevoegen van nieuwe functionaliteit aan een specifieke provider heeft geen invloed op de rest van de applicatie.

**Nadelen:**
- **Minder dynamische flexibiliteit**: Het systeem is niet zo dynamisch in het wisselen van kaartproviders tijdens runtime. Dit kan een beperking zijn als er behoefte is om op de achtergrond snel van provider te wisselen zonder herstart.
- **Testbaarheid**: Het testen van verschillende kaartservices kan moeilijker zijn zonder een goed mock-systeem voor de Factory Method. Het is minder flexibel dan bij bijvoorbeeld de Facade Pattern, waar mock-services gemakkelijker kunnen worden ingevoegd.

### 8.6. ADR-0006-State-pattern

# Kortste Reisroute en Flexibiliteit

**Datum:** 31/03/2025

## Status
Accepted

## Context
Bij het plannen van een reisroute moet rekening worden gehouden met twee belangrijke factoren: de route moet zo kort mogelijk zijn en alle bouwstenen omvatten en de route moet eenvoudig aanpasbaar zijn wanneer de reisafstand geen beperkende factor is.

## Considered Options
| Forces | Adapter | State | Factory | Strategy | Facade |
|---|---|---|---|---|---|
| Makkelijk uitbreidbaar | + | ++ | + | ++ | 0 |
| Weinig boilerplate | 0 | -- | - | + | ++ |
| Vermindert coupling | + | ++ | 0 | + | - |
| Ondersteunt dynamische aanpassingen | ++ | 0 | + | ++ | - |
| Houdt overzichtelijke structuur | 0 | -- | - | + | ++ |

## Decision
Wegens schoolredenen kunnen de Factory en Strategy Pattern niet meer gekozen worden. Verder zijn de Adapter en Facade Pattern geen goede oplossingen voor dit probleem. Hierom kiezen wij voor het implementeren van de State Pattern, ondanks dat dit niet de beste oplossing is.

## Consequences
Het gevolg van het niet meer mogen gebruiken van de Strategy Pattern is dat de implementatie minder overzichtelijk is en dat er meer boilerplate geschreven moet worden.

## 9. Deployment, Operation and Support

### Stappen voor Deployment
Om de Triptop-applicatie te installeren en uit te voeren, volg je de volgende stappen:

#### 1. **Voorbereiding van de omgeving**
- Zorg ervoor dat **Java 17** en **Spring Boot** zijn geïnstalleerd.
- Installeer een geschikte IDE zoals **IntelliJ IDEA** of **Eclipse**.

#### 2. **Code verkrijgen**
- Clone de repository vanuit GitHub:
- Navigeer naar de backend-map:

#### 3. **Configuratie instellen**
- Voeg een `application.properties` bestand toe met API-sleutels:
  ```properties
  google.maps.api.url=https://google-map-places-new-v2.p.rapidapi.com
  google.maps.api.key=JOUW_RAPIDAPI_KEY

  mapbox.api.url=https://api.mapbox.com/directions/v5/mapbox/driving
  mapbox.api.key=JOUW_MAPBOX_API_KEY
  ```
- Voeg ook een `.env` bestand toe met API-sleutels:
```
  RAPIDAPI_KEY=JOUW_RAPIDAPI_KEY
  RAPIDAPI_HOST=aerodatabox.p.rapidapi.com
  FlightScraper_Host=sky-scanner3.p.rapidapi.com
  AirScraper_Host=sky-scrapper.p.rapidapi.com
```

#### 4. **Start de applicatie**
- Gebruik Maven om de applicatie te starten of start het via the IDE:
  ```sh
  mvn spring-boot:run
  ```

#### 5. **Test de API**
- Gebruik **Postman** of **Insomnia** om de API-endpoints te testen.
- Een voorbeeldverzoek voor het ophalen van informatie via Mapbox:
  ```http
  GET http://localhost:8080/maps/route?provider=mapbox&startLat=52.3676&startLng=4.9041&endLat=51.5074&endLng=-0.1278
  ```
### Onderhoud en Support
- **Logging**: Fouten en waarschuwingen worden gelogd via SLF4J/Logback.
- **Monitoring**: Toekomstige integratie met een monitoring-tool zoals Prometheus/Grafana.
- **Bugfixing**: Issues worden bijgehouden in GitHub Issues en opgelost via pull requests.
