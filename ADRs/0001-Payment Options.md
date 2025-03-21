# Payment Options
Datum: 2025-03-21
## Status
Accepted

## Context
We maken een reismanager app hiervoor hebben we een Payment API nodig die betaling afhandeld maar welke API is het meest geschikt hiervoor willen we graag weten.

## Considered Options
| Forces                         | Mollie | Knit Pay Pro  | PayPal |
|--------------------------------|--------|---------------|------------|
| Standaard API's beschikbaar    | --     | ?             | ++         |
| Envoudig te gebruiken in java  | 0      | -            | 0          |

## Descision
Uitendelijk is de keuze gemaakt om PayPal te gebruiken inplaats van Mollie omdat we er later achterkwamen dat Mollie een business acount nodig heeft om een KEY te krijgen dus deze was helaas niet bruikbaar hoewell dit een goede keuze had kunnen zijn gaan. We nu PAYPAL gebruiken omdat

## Consequences
Payal is een bekend en betrouwbaar API met goed te vinden documentatie ook is het volgens bronnen makkelijk te Intergregen maar mogelijk kan het problemen opleveren met Security en Netwerk.


