# Flights  Options
Datum: 2025-03-21
## Status
Accepted

## Context
We maken een reismanager app hiervoor hebben we een Flights API nodig die Vluchten Opzoekt maar welke API is het meest geschikt hiervoor willen we graag weten.

## Considered Options
| Forces                         | AeroDataBox | FlightsAPI  | AmadeusAPI |
|--------------------------------|--------|---------------|------------|
| Standaard API's beschikbaar    | +      | 0             | 0          |
| Envoudig te gebruiken in java  | ++     | --            | +          |
|RealTime Info vlucht info       | ++     |     -         | 0          |
## Descision
Uitendelijk is de keuze gemaakt om AeroDataBox te gebruiken. omdat FlightsAPI geld kost per maand. Ook is AeroDataBox erg gefocused in vluchten infomatie bijhouden met diepe info zoals flight tracking , flight status en aiport informatie Tenslotten is AeroDataBox veel makkelijker te gebruiken vergelijken AmadeusAPI vanwege de complexe gebruikze weize.

## Consequences
AeroDataBox is ideaal voor realtime tracking en vluchten informatie maar is niet geschikt voor Hotels en booking services hiervoor zouden we een andere API nodig hebben.


