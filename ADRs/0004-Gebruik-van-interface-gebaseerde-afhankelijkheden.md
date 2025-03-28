# Gebruik van interface-gebaseerde afhankelijkheden

Date: 26-3-2025

## Status
Accepted

## Context
Het systeem moet flexibel blijven als het gaat om externe services. We willen vermijden dat business logic direct afhankelijk is van specifieke API’s zoals Mollie of AeroDataBox.

## Considered Options

|Forces| Strategy Pattern | Adapter Pattern | Facade Pattern | Factory Method Pattern | State Pattern |  
|---|---|---|---|---|---|  
|Losse koppeling | ++ | ++ | + | + | ++ |  
|Onderhoudbaarheid | ++ | + | ++ | - | ++ |  
|Complexiteit | - | 0 | + | -- | + |  
|Gemak van wisselen van externe services | ++ | + | 0 | - | + |  
|Testbaarheid | ++ | + | - | 0 | ++ |  
|Geschiktheid voor variërende services | ++ | 0 | + | + | ++ |  

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
