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

#.  Sukuriame turinio katalogą ``contents`` ir nurodome jį naudoti vietoj
    pavyzdžių::

    mkdir content
    echo -e '\chapter{Mano straipsnis}\n' > content/chapters.tex

Šablono atnaujinimas
====================

::

    git pull template master
