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

