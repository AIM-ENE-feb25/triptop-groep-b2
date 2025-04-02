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
**Triptop** helpt reizigers bij het plannen van reizen met meerdere bestemmingen. Het platform integreert met externe systemen voor authenticatie, boekingen, betalingen, routeplanning, en meer.
DIT MOET UITGEBREIDER OVER DINGEN DIE JE NIET UIT HET PLAATJE KAN HALEN.

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

## 7. Software Architecture

###     7.1. Containers

> [!IMPORTANT]
> Voeg toe: Container Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

#### Container Diagram
![Container Diagram](../opdracht-diagrammen/Container_Diagram_Triptop_Systeem.png)

Dit **Container Diagram** geeft een overzicht van de **Triptop** applicatie, waarin de belangrijkste containers en hun interacties worden getoond. Het diagram omvat de **Web Applicatie**, de **Backend** en de **Database**, evenals de externe systemen waarmee Triptop communiceert, zoals de **IdentityProvider API**, **DemandAPI**, **Mollie API**, en anderen. De interacties gaan als volgt:

- **Reizigers** en **Beheerders** gebruiken de **Web Applicatie** om toegang te krijgen tot het systeem.
- De **Web Applicatie** stuurt verzoeken naar de **Backend** voor verdere verwerking.
- De **Backend** slaat gegevens op in de **Database** en haalt reisopties op via de **Demand API**.
- Betalingen worden verwerkt via de **Mollie API**, terwijl andere gegevens, zoals kaartinformatie of treinreisinformatie, opgehaald worden via respectievelijk de **Google Maps API** en de **All Aboard API**.

DIT IS NIET GOED OMDAT JE DEZE INFORMATIE UIT HET PLAATJE KAN HALEN ZET WAT NUTTERGERS NEER WAT JE NIET UIT HET PLAATJE KAN HALEN.

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
![Strategy Pattern](../opdracht-diagrammen/classDiagramQuestion.png)
Het diagram toont de structuur van de klassen, maar laat bepaalde details weg, zoals de specifieke logica van de FlightDataStrategy providers, de werking van de FlightStatus (bijvoorbeeld hoe en wanneer de status wordt bijgewerkt), en de beveiliging/validatie van login- en autorisatieprocessen. Ook is de relatie tussen FlightStatus en FlightDetails niet expliciet weergegeven, ondanks de mogelijke logische koppeling via het vluchtnummer.

## 8. Architectural Decision Records

> [!IMPORTANT]
> Voeg toe: 3 tot 5 ADR's die beslissingen beschrijven die zijn genomen tijdens het ontwerpen en bouwen van de software.

### 8.1. ADR-0005-Dynamische-Kaartservices-met-de-FactoryMethod
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

| Forceres                                    | Adapter Pattern | Facade Pattern | Factory Method Pattern | State Pattern | Strategy Pattern |  
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



#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

### 8.2. ADR-002 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

### 8.3. ADR-003 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

### 8.4. ADR-004 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

### 8.5. ADR-005 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

## 9. Deployment, Operation and Support

> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.
