# Kursinis darbas

* Tema: _Komponentinis programavimas su Scala_
* Autorius: _Vytautas Astrauskas_
* Vadovas: _Lektorius Donatas Čiukšys_

# Planas

## Kursinio tikslai

*   Susigaudyti, kas yra komponentinis programavimas.
*   Mokėti kalbėti komponentinio programavimo terminologija.
*   Mokėti paaiškinti kuo koponentas skiriasi nuo klasės / bibliotekos.
*   Kokias savybes turi tenkinti klasė (klasių rinkinys), kad ją galima
    būtų vadinti komponentu?
*   Išsiaiškinti kodėl vis dar neturime komponentinės programavimo kalbos.

## Teoriniai darbai

1.  Objektinės paradigmos apibrėžimas: objekto (klasės) apibrėžimai, 
    rezultate turi gautis objekto skiriamųjų savybių sąrašas
    (būtinųjų ir pasirenkamųjų).

    *   Šaltinis: Knyga „Lean Architecture“, 115 puslapis.

1.  Surinkti komponentų apibrėžimus ir juos išanalizuoti. Rezultate
    turi gautis komponento skiriamųjų savybių sąrašas.

    1.  Paieškoti knygų, technical report, survey apie „component
        oriented programming“, „component oriented approach“, „compontent
        based…“
    1.  Wikipedia: „Component based software engineering“.

1.  Išsiaiškinti kuo skiriasi komponentinis programavimas nuo
    objektinio, kas kieno poaibis, viršaibis ar bent jau netuščia
    sankirta.
1.  Sąvokos „komponentas“ platumas: klasė gali būti komponentas taip pat
    ir posistemė gali būsi komponentas (UML). Ar ne per daug kaip vienai
    sąvokai?

    *   Pasidomėti: „module“ yra „vidutinio dydžio“ komponentas. 
    *   Daugiau gilintis link smulkesnių (technikos, kaip kuriami, rašomi
        komponentai).
    *   Coupling, cohesion.

## Programavimo darbai

1.  Pademonstruoti (minimaliomis sąnaudomis) komponentinio programavimo
    teikiamas galimybes (tai yra, ką duoda daugiau negu objektinis).

    *   Su Java ir / arba Scala.

## Bakalaurinio darbai

1.  Kaip skirtingi bandymai pasiekti komponentinį programavimą tą padarė?
    (JavaBeans, Scala, Enterprice JavaBeans, OSGi, …) 
1.  Ar Scala yra komponentinė programavimo kalba?

    *   Self type, abstract types, mixin composition.

# Pastabos

Panašiausi į reikiamą bibliografijos stilių yra šie: amsalpha, alpha,
annotate, is-alpha, wmaainf

Stilių sąrašą bei info apie jų kūrimą galima rasti čia:
http://amath.colorado.edu/documentation/LaTeX/reference/faq/bibstyles.html

LaTeX vikis:
http://latex.akl.lt/index.php/Pagrindinis _ puslapis

LaTeX VU MIF stilius:
http://ims.mii.lt/~lauras/latexlt/


# TODO

Galima išmesti iš objektinės paradigmos tas kalbas, kurios neturi klasės.
Paminėti objektinio trūkumus, kuriuos sprendžia komponentinis.

Išrinkti pagal UML ką komponentas gali turėti. Pasiaiškinti su
prievadais. Prievadai yra skirti modeliavimui, o ne komponento
apibrėžimui.

Egzempliorius – component instance.

Pasidomėti ką kiti sako apie komponentų būseną.

Išsiaiškinti ar komponentas yra modulio atvejis ar modulis yra
komponento atvejis.

Jokiu būdu nesakyti, kad komponentas ir klasė yra tas pats.

TODO

Iš … framework … išsirinkti komponento apibrėžimą.

Parašyti laišką dėl adaptyvių komponentų.

Pasidomėti komponentų lifecycle, būsenomis pagal komponentų modelį.
Pasižiūrėti pagal realias technologijas. (EJB, OSGi) Paieškoti pagal
„OSGi Lifecycle“.

Padaryti skirtumą tarp embedded komponentinio ir „didelių sistemų“ (verslo
informacinės sistemos), kad eitų atskirti tokius dalykus, kaip
vieno paketo pakeitimas kitu vykdymo metu. Paminėti, kad tikrai
bus komponentų vykdymo aplinka ir kad nesidomima embedded systems.

Pagrįsti, kad objektinis ir komponentinis yra skirtingi dalykai.

Komponentas šneka ne apie realizacinę technologiją, o apie tai, kaip
mes ją naudojame, kad galėtume pasiekti komponentinio savybes.

TODO: Padaryti skyrių: „Objektinio ir Komponentinio palyginimas“.

Komponentinis yra kaip vykdymo metu organizuojame aplinką, o ne kaip
realizuojame. (TODO: Atskirti tuos kurie susirenka kompiliavimo metu nuo
tų, kurie susirenka vykdymo metu.)

TODO: Komponentas išbyra iki virtualios mašinos sąvokų. Yra klausimas
ar yra konteineris, kuris gali suteikti nesubyrėjusio komponento vaizdą?

DEB paketai vs embedded sistemų komponentų: paketai neturi silpno susiejimo
ir konteinerio.

Komponentiškumas yra ne programavimo kalbos dalykai, bet programų
sistemos elementų organizavimo dalykai. (Su akcentu į vykdymo
metą.)

Objektinis yra realizacinė technologija, o komponentinis pasako, kaip
naudoti realizacinę technologiją, kad gautume tam tikras savybes, kurių
negalime gauti belekaip naudodami realizacinę technologiją.

Kodėl reikia objektinį „auginti“: dabar reikia daryti du darbus:
kurti su realizacine technologija komponentus laikantis kažkokių
taisykliu ir su kita technologija atlikti papildomus darbus.
(Ar apsimoka kurti komponentinę programavimo kalbą? Kadangi
komponentinis nėra objektinio praplėtimas, tai naujos programavimo
kalbos kurti neapsimoka.)

TODO: Pasižiūrėti, kada pakanka tik objektinio, o kada reikia
objektinio + komponentinio.

Pasižiūrėti: closed for modification, open for extension.

Panagrinėti dar vieną atvejį: programuojant bet kaip su Java, tai
tikimybė, kad gausis kažkas artimo taisyklingam komponentiniam yra
labai maža. Programuojant bet kaip su Scala turėtų gautis žymiai
mažesnis Delta.

Galutinis tikslas: parodyti probleminę situaciją, kurios gražiai neįmanoma
išspręsti objektiniame, bet kurią galima gražiai išspręsti tik
komponentiniame arba realizacinėje technologijoje pridėjus tokius
dalykus, kuriuos prideda Scala.

1.  Objektinis vs Komponentinis skyrius
2.  Modifikuojamumas.
3.  Kaip pagerinti Java modifikuojamumą.
