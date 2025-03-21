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
