# Payment Options
Datum: 2025-03-21
## Status
Pending

## Context
We maken een reismanager app hiervoor hebben we een API nodig die betaling afhandeld maar welke API is het meest geschikt hiervoor willen we graag weten.

## Considered Options
| Forces                         | Mollie | Knit Pay Pro  | PayPal |
|--------------------------------|--------|---------------|------------|
| Standaard API's beschikbaar    | --     | ?             | ++         |
| Envoudig te gebruiken in java  | 0      | ++            | 0          |

## Descision
Uitendelijk is de keuze gemaakt om KnitPayPro te gebruiken inplaats van Mollie omdat we er later achterkwamen dat Mollie een bussnins acount nodig heeft om een KEY te krijgen dus deze was helaas niet bruikbaar

## Consequences
KintPayPro is gemaakt voor Wordpress dit kan problemen opleveren. eigenlijk is dit een groot probleem.


