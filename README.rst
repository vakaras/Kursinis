===========
MIF Starter
===========

VU MIF dokumentų XeLaTeX šablonas.

Struktūra::

    ├── common          – tai kas bendra visiems;
    ├── config          – konkretaus dokumento individualizavimas;
    ├── dist            – kompiliavimo katalogas;
    └── content         – dokumento turinys.

Naujo projekto sukūrimas
========================


#.  Klonuojame saugyklą::

        git clone git://github.com/vakaras/mif-starter.git ${PROJECT}

    Čia ``${PROJECT}`` yra katalogo, į kurį bus nukopijuota saugykla
    pavadinimas.

#.  Pakeičiame numatytąją saugyklą (daroma prielaida, kad esame
    projekto kataloge)::

        git remote rename origin template
        git remote add origin ${REPOSITORY}
        git push -u origin master

    Čia ``${REPOSITORY}`` yra pagrindinės projekto saugyklos adresas.

#.  Pritaikome ``config`` esančius failus pagal savo poreikius.
#.  Susikuriame naują ``README.md`` failą::

        touch README.md

#.  Sukuriame turinio katalogą ``content`` ir nurodome jį naudoti vietoj
    pavyzdžių::

        mkdir content
        echo -e '\\chapter{Mano straipsnis}\n' > content/chapters.tex

------------------------------
Titulinio puslapio pritaikymas
------------------------------

Pavyzdžiui, jei rašome kursinį darbą, tai į ``config/global.tex``
pridedame::

    \docname{Komponentinis programavimas su Scala}
    \docnameen{Component-based programming with Scala}
    \doctype{Kursinis darbas}
    \authorname{Vytautas Astrauskas}
    \coursenumber{3}
    \groupnumber{2}
    \supervisorname{Darbo Vadovas}

Taip, pat galima nurodyti ir recenzentą::

    \reviewername{Recenzentas}

Taip pat galima apskritai pakeisti autoriaus informacijos rodymą::

    \authorinformation{Autorius: Vytautas Astrauskas}

Jei nenurodysime autoriaus, tai dalis su autoriaus informacija nebus
sukurta iš viso. Pavyzdžiui, taip galėtų atrodyti konspektų nustatymai::

    \docname{Psichologijos įvadas}
    \doctype{Paskaitų konspektas}

Aukštosios mokyklos pavadinimą galime pakeisti su komanda::

    \schooltitle{%
        Vilniaus universitetas\\
        Matematikos ir informatikos fakultetas\\
        Informatikos katedra%
        }

Datą (numatytoji yra metai, kada buvo sukompiliuotas dokumentas) galima
pakeisti su komanda::

    \date{2011}

Šablono atnaujinimas
====================

::

    git pull template master
