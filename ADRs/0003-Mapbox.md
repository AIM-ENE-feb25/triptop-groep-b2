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
