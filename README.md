# ClearBnB

SETUP NOTE:

In the Visual Studio Code terminal enter the following npm instructions

The first time opening these files:

    cd frontend
    npm install
    npm run dev

During each new development/test session:

    cd frontend
    npm run dev

Producera och leverera mjukvara: Gruppinlämningsuppgift - ClearBnB

Uppgiften

Företaget ClearBnB är en blivande konkurrent till AirBnB. De vill bygga en webbsajt i vilken deras användare kan hyra ut sina bostäder och hyra bostäder.

Nu behöver de hjälp att bygga en prototyp för en webbsajt, där användarna ska kunna:

    -Få information om vilka bostäder som är tillgängliga på en viss ställe/stad/region vilka perioder.
    -Se om det går att hyra en bostad mellan vissa datum och vad det skulle kosta
    -Genomföra bokningar
    -Lägga upp sina bostäder för uthyrning, med information om när de är tillgängliga, vilket pris de vill ta, en textbeskrivning, en beskrivning av vilka bekvämligheter (badkar, kök, dusch etc. etc.) som finns tillgängliga, samt bilder.
    -ClearBnb ska tjäna 15% ovanpå det pris som de som hyr ut kräver.

ClearBnB vill att prototypen byggs som en single page application i frontend-ramverket Vue, dvs. utan hårda sidomladdningar, men med olika url:er för olika “sidor” och delmängderna konstruerade som komponenter.

Givetvis ska användarregistrering och inloggning ingå i systemet!

Kom igång

    -Vid behov, gör domän-research på t.ex. AirBnB för att få en klar bild på vad ni ska skapa.
    -Välj ut en SCRUM-master för er första sprint.
    -Skriv egna user stories som godkänns av produktägaren. (Skapa ett trello-SCRUM-board för detta och för att sedan bryta ner i task och ha koll på hur långt ni kommit med task - User Stories/Backlog - Todo/Tasks - Doing - Testing - Done)
    -Visa wireframes som godkänns av produktägare. Wireframes ska göras för båda mobil och dator, ev. också för tablet.
    -Bryt ner wireframes till ett komponentträd som godkänns av produktägaren.
    -Specificera komponenternas egenskaper och metoder, samt vad som ska ligga i en global store (vuex). Detta ska också godkännas av produktägaren.
    -Specificera backendroutes och datamodeller för backend/data som ska sparas.
    -Starta en sprint med sprintplanering (planning poker).

Dummy data

Skapa ett antal användare och lägg in dummy data. Minst 20 användare, varav minst 10 ska hyra ut bostäder, varav minst 3 ska hyra ut flera bostäder ska finnas i systemet. Det ska gå att via gränssnittet lägga till nya användare, bostäder etc…

Betygskriterier

Obs! För läraren som ska rätta är det viktigt att förstå vem som har varit med och skrivit vad via att kunna kolla på Git och vem som är author där. En lösning på par-programmering/grupp-programmering är att lägga till de som inte gör commit:en i fråga som co-authors:

https://docs.github.com/en/github/committing-changes-to-your-project/creating-a-commit-with-multiple-authors

FÖR GODKÄNT:

    -Ni ska ha arbetat agilt i grupp.
    -Ni ska ha levererat en fungerande webbapplikation enligt de User Stories ni skrivit och fått godkända av läraren i rollen som produktägare.
    -Ni ska ha fått nedbrytningen till komponenter godkänt av läraren i rollen som produktägare.
    -Ni ska ha fått wirefarmas godkänt av läraren i rollen som produktägare.
    -Ni ska ha använt er av tekniker ni lärt er under delkursen (Vue, Vuex, Java Express).
    -Koden ska så långt som möjligt vara semantisk och fungerande.
    -Gränssnittet och dess vyer ska fungera väl och konsekvent för mobil, tablet & desktop-skärmstorlekar.
    -Ni ska kontinuerligt ha checkat in er kod på git.
    -Ni ska ha använt feature branches i git.
    -Utöver bedömningen för gruppen som helhet, behöver det för varje gruppmedlem framgå att denne uppfyllt kraven för Godkänt. Detta innebär att varje gruppmedlem bör ha checkat in relevant arbete under sitt namn, i git.

FÖR VÄL GODKÄNT:

Utöver ovanstående krav för Godkänt:

    -Funktionalitet och användargränssnitt ska vara tydligt och lätt att förstå.
    -Ni ska ha en hög grad av konsekvens och semantik i er kod.
    -Ni ska ha levererat en välfungerande applikation.
    -Gränssnittet ska fungera på ett genomtänkt och välfungerande sätt.
    -Utöver bedömningen för gruppen som helhet, behöver det för varje gruppmedlem framgå att denne uppfyllt kraven för Väl Godkänt. Detta innebär att varje gruppmedlem bör ha checkat in relevant arbete under sitt namn, i git.
