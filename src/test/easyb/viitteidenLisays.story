import ryhma50.*

description 'Käyttäjä voi lisätä viitteen'

scenario "käyttäjä voi lisätä viitteen", {
    given 'ohjelma käynnistetään ja valitaan viitetyyppi', {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma()
        kayttoliittyma.suorita()
        
    when 'viitteen tiedot annetaan'
    then 'ohjelma ei kaadu'
}