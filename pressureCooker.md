# Pressure Cooker

## **Onderzoeksvraag**
- Hoe zorg je ervoor dat je makkelijk de ene externe service kan vervangen door een andere die ongeveer hetzelfde doet?

## **Authenticatie**
- **AuthController** – Handelt login- en authenticatieverzoeken af van de frontend.
- **AuthService** – Verwerkt de authenticatielogica en voert validaties uit.
- **AuthRepository** – Beheert gebruikersgegevens in de database.
- **IdentityProviderAdapter** – Biedt een abstractielaag voor externe inlogdiensten zoals Google, Apple en Microsoft.

## **Hotels**
- **HotelController** – Ontvangt hotelverzoeken van de frontend.
- **HotelService** – Verwerkt hotelgegevens en businesslogica.
- **HotelProvider** – Maakt de backend onafhankelijk van een specifieke hotel-API door externe services (bijv. Booking.com) te abstraheren.

## **Betalingen**
- **PaymentController** – Handelt betaalverzoeken van de frontend af.
- **PaymentService** – Voert betaaltransacties uit en verwerkt betaalinformatie.
- **PaymentProvider** – Maakt de backend onafhankelijk van Mollie door een abstractielaag te bieden.

## **Vluchten**
- **FlightController** – Ontvangt vluchtverzoeken van de frontend.
- **FlightService** – Verwerkt vluchtgegevens en businesslogica.
- **FlightProvider** – Abstraheert externe vlucht-API's zoals AeroDataBox om flexibel te blijven.

## **Treinen**
- **TrainController** – Ontvangt treinverzoeken van de frontend.
- **TrainService** – Verwerkt treingegevens en businesslogica.
- **TrainProvider** – Abstraheert externe trein-API’s zoals All Aboard, zodat deze makkelijk vervangbaar zijn.

## **Voedselbestellingen**
- **FoodController** – Ontvangt voedselverzoeken van de frontend.
- **FoodService** – Verwerkt bestellingen en haalt restaurantgegevens op.
- **FoodProvider** – Abstraheert externe voedselservices zoals Grubhub.

## **Database**
- **Database** – Slaat alleen **gebruikersgegevens** op, zoals gebruikersprofielen en inloggegevens.

---

## **Waarom is dit modulair en goed vervangbaar?**
✔ **Abstractielaag voor externe services** → De backend kan makkelijk overstappen naar een andere API zonder dat de hele applicatie verandert.  
✔ **Duidelijke scheiding van verantwoordelijkheden** → Elke component heeft één taak (Single Responsibility Principle).  
✔ **Goede herbruikbaarheid** → Elke service kan eenvoudig worden aangepast of uitgebreid.  
✔ **Database** slaat alleen essentiële gegevens op die nodig zijn voor authenticatie en gebruikersbeheer.  

## **Interfaces**

### 1. **HotelProvider** (Interface)
- **Beschrijving**: Abstraheert de interactie met externe hotel-API's.

    - **Methoden**:
        - `fetchHotelData(location: String, checkin: Date, checkout: Date): HotelDetails[]`
            - **Parameters**:
                - `location`: De locatie van het hotel (String)
                - `checkin`: De incheckdatum (Date)
                - `checkout`: De uitcheckdatum (Date)
            - **Return**: Een array van `HotelDetails` objecten

### 2. **PaymentProvider** (Interface)
- **Beschrijving**: Abstraheert de interactie met externe betalings-API's.

    - **Methoden**:
        - `processPayment(paymentDetails: PaymentDetails): PaymentStatus`
            - **Parameters**:
                - `paymentDetails`: Object dat de betalingsinformatie bevat (PaymentDetails)
            - **Return**: Een `PaymentStatus` object dat de status van de betaling aangeeft

### 3. **FlightProvider** (Interface)
- **Beschrijving**: Abstraheert de interactie met externe vlucht-API's.

    - **Methoden**:
        - `fetchFlightData(origin: String, destination: String, departureDate: Date): FlightDetails[]`
            - **Parameters**:
                - `origin`: De vertreklocatie van de vlucht (String)
                - `destination`: De bestemming van de vlucht (String)
                - `departureDate`: De vertrekdatum (Date)
            - **Return**: Een array van `FlightDetails` objecten

### 4. **TrainProvider** (Interface)
- **Beschrijving**: Abstraheert de interactie met externe trein-API's.

    - **Methoden**:
        - `fetchTrainData(origin: String, destination: String, departureDate: Date): TrainDetails[]`
            - **Parameters**:
                - `origin`: De vertreklocatie van de trein (String)
                - `destination`: De bestemming van de trein (String)
                - `departureDate`: De vertrekdatum (Date)
            - **Return**: Een array van `TrainDetails` objecten

### 5. **FoodProvider** (Interface)
- **Beschrijving**: Abstraheert de interactie met externe voedselbezorg-API's.

    - **Methoden**:
        - `fetchFoodData(location: String): RestaurantDetails[]`
            - **Parameters**:
                - `location`: De locatie waar voedsel bezorgd moet worden (String)
            - **Return**: Een array van `RestaurantDetails` objecten

## **Extra uitleg**
- De sleutel tot het vervangen van externe systemen is het gebruik van interfaces. Door interfaces te definiëren voor externe services, kan de backend eenvoudig van provider wisselen zonder de rest van de applicatie te beïnvloeden.
- De componenten zoals PaymentProvider, HotelProvider, FlightProvider, enzovoort, zijn interfaces die abstractie bieden van de werkelijke implementatie van de externe services.
- Door het gebruik van een PaymentProvider interface, kun je de implementatie van betalingen (bijvoorbeeld Mollie of een andere provider) eenvoudig vervangen zonder de rest van je systeem aan te passen. Als je in de toekomst een andere betalingsgateway wilt gebruiken (bijvoorbeeld een andere provider dan Mollie), hoef je alleen een nieuwe klasse te maken die de PaymentProvider interface implementeert, zonder dat je de logica in de BetaalService of BetaalController hoeft aan te passen.
- In plaats van afhankelijk te zijn van overerving, gebruik je compositie. Dit betekent dat de specifieke implementaties van de externe services (zoals MolliePaymentProvider, Grubhub, enzovoort) als objecten worden geassembleerd in de serviceklassen zoals BetaalService, TreinService, enzovoort.
- Hierdoor kunnen de implementaties van externe services (zoals MolliePaymentProvider of Grubhub) makkelijk vervangen worden zonder dat dit invloed heeft op de rest van je applicatie.