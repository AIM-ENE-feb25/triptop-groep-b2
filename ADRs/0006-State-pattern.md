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
