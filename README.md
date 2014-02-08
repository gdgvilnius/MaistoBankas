MaistoBankas
============

MaistoBankas - skaitliukas maisto banko surinktų produktų statistikos rinkimui

## Mokymų turinys / Užduotys

Sąrašiukas, kaip programėlė buvo tobulinama
### Programavimo aplinkos įdiegimas

Tie kas atėjo pirmą kartą, reikėjo įsidiegti:

* Naujausią [Android Studio](http://developer.android.com/sdk/installing/studio.html)
* [Gradle versiją 1.9](http://services.gradle.org/distributions/gradle-1.9-all.zip)
* [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)

### Susigeneruoti Android programėlę

 Pasinaudoti Android Studio vedliu ir susigeneruoti programėlės struktūrą.

 Pradėti File->New Project... ir sekti vedlio nurodymais.

Kas buvo pridėta ir komentarus galima pažiūrėti GitHub'o įrašuose:
[Pakeitimai](https://github.com/gdgvilnius/MaistoBankas/commit/fe1fe22e80ac50ddc991299c85b8f1f7313570f8)

### Layout komponentai pagrindiniame fragmente

Reikės pridėti:

- Nustatymų mygtuką, atidarantį parduotuvės informacijos suvedimo fragmentą
- Mygtuką "Skenuoti"
- Sąrašą nuskenuotų prekių vaizdavimui (ListView)

[Pakeitimai](https://github.com/gdgvilnius/MaistoBankas/commit/baa82d612e2f96e5e734829597f28922f93c2b88)

## Pridėti nustatymų fragmentą

Paprasta forma, kurioje keletas įvedimo laukelių:

* Miestas
* Adresas
* Parduotuvės vardas
* Savanorio vardas
* ir mygtukas Išsaugoti

Pasikeitimai:
https://github.com/gdgvilnius/MaistoBankas/commit/686d64d19c0bd3889f45cf3eeec488290153dbff

## Pridėti Barcode skenerį

Barkodų skenavimui integravome [ZXing](https://github.com/zxing/zxing)
Skenavimą pasinaudojant Intent'ais.
Žiūrėti instrukcijas, kaip integruoti [čia](https://github.com/zxing/zxing/wiki/Scanning-Via-Intent)

## Pridėti Lifecycle loginimą (2014-02-08)
 Nusprendėm geriau suprasti Activity ir Fragment gyvavimo ciklą (lifecycle).

 Pažiūrėjome lifecycle diagramą [čia](http://developer.android.com/training/basics/activity-lifecycle/starting.html)
 Ir į `BaseActivity` įsidėsime `Log.d()` komandas šiuose metoduose:
 * OnCreate
 * OnStart
 * OnResume
 * OnPause
 * OnStop
 * OnDestroy

 [Pakeitimai]()