# Flights Options

**Datum:** 2025-03-21

## Status
**Accepted**

## Context
Voor onze reismanager-app hebben we een Flights API nodig die vluchten kan opzoeken. We willen bepalen welke API hiervoor het meest geschikt is.

## Overwogen opties

| Factoren                     | AeroDataBox | FlightsAPI | AmadeusAPI |
|------------------------------|------------|-----------|------------|
| Informatie beschikbaar       | +          | 0         | 0          |
| Eenvoudig te gebruiken       | ++         | --        | +          |
| Real-time vluchtinformatie   | ++         | -         | 0          |
| Documentatie                 | +          | -         | ++         |

## Besluit
Uiteindelijk hebben we gekozen voor **AeroDataBox**. De belangrijkste redenen hiervoor zijn:
- **Kosten:** FlightsAPI vereist een maandelijkse betaling, terwijl AeroDataBox gratis of goedkoper is.
- **Focus op vluchten:** AeroDataBox biedt uitgebreide informatie over vluchten, waaronder vluchttracking, vluchtstatus en luchthaveninformatie.
- **Gebruiksvriendelijkheid:** Vergeleken met AmadeusAPI is AeroDataBox veel eenvoudiger te gebruiken, omdat AmadeusAPI een complexere implementatie vereist.

## Gevolgen
AeroDataBox is ideaal voor real-time tracking en vluchtinformatie. Echter, het biedt geen ondersteuning voor hotels en boekingsservices. Voor deze functionaliteiten zullen we een aanvullende API moeten zoeken.
