import ryhma50.*
import ryhma50.Kayttoliittyma
import java.util.Scanner

description 'Käyttäjä voi lisätä viitteen'

scenario "käyttäjä voi lisätä viitteen", {
    given 'ohjelma käynnistetään ja valitaan viitetyyppi', {
        kayttaja = new Scanner("1\nvilma\nnimi\n1234\nsara")
        kayttoliittyma = new Kayttoliittyma(kayttaja)
        
    }
        
    when 'viitteen tiedot annetaan', {
        kayttoliittyma.suorita()
    }

    then 'ohjelma ei kaadu', {
        kayttoliittyma.suoritaKirja().shouldBe true
    }
}