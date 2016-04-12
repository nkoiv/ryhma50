import ryhma50.*
import viittaukset.*

description 'Käyttäjä voi lisätä viitteen'

scenario "käyttäjä voi lisätä viitteen", {
    given 'ohjelma käynnistetään ja valitaan viitetyyppi'
    when 'viitteen tiedot annetaan'
    then 'ohjelma ei kaadu'
}