using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ATM
{

    class Strings
    {
        Lang language;
        string[] messagesSK = { "Zadaj pin kód",
                                "Počet pokusov",
                                "Karta je blokovaná",
                                "Výber v hotovosti",
                                "Zostatok na účte",
                                "Zmena pin",
                                "Odhlásenie",
                                "Späť",
                                "Nový pin",
                                "Potvrďte nový pin",
                                "Pin bol zmenený",
                                "Pin nebol zmenený: pin kódy nie su rovnaké!",
                                "Váš aktuálny stav účtu je",
                                "iná suma",
                                "Potvrdenie",
                                "Áno",
                                "Nie",
                                "Zadajte sumu:",
                                "Suma musí byť delitelná desiatkou!",
                                "Nedostatok penazí na účte!"};
        string[] messagesEN = { "Enter pin",
                                "Number of attempts",
                                "Card is blocked",
                                "Withdraw money",
                                "Account balance",
                                "Change pin",
                                "Log out",
                                "Back",
                                "New pin",
                                "Confirm new pin",
                                "Pin was chaged",
                                "Pin was not chaged: pin codes are not same!",
                                "Your account balance is",
                                "other",
                                "Confirmation",
                                "Yes",
                                "No",
                                "Set value:",
                                "Value must be divisible by ten!",
                                "Lack of funds on the account!"};
        public Strings(Lang language)
        {
            this.language = language;
        }
        public string[] getMessages()
        {
            if(language == Lang.ENGLISH)
            {
                return messagesEN;
            }
            else if((language == Lang.SLOVAK))
            {
                return messagesSK;
            }
            return null;
        }
    }
}
