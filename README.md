MaistoBankas
============

MaistoBankas - skaitliukas maisto banko surinktų produktų statistikos rinkimui

## Mokymų turinys / Užduotys

Sąrašiukas, kaip programėlė buvo tobulinama
### Programavimo aplinkos įdiegimas

Tie kas atėjo pirmą kartą, reikėjo įsidiegti:

* Naujausią [Android Studio](http://developer.android.com/sdk/installing/studio.html)
* [Gradle versiją 1.11](http://services.gradle.org/distributions/gradle-1.11-all.zip)
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

[Pasikeitimai]
(https://github.com/gdgvilnius/MaistoBankas/commit/686d64d19c0bd3889f45cf3eeec488290153dbff)

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

 [Pakeitimai](https://github.com/gdgvilnius/MaistoBankas/commit/8a58e205d20fd3556cad6e6f3032397069718879)

 ## Fragmentų gyvavimo ciklo loginimas
 Analogiškai kaip ir su Activity gyvavimo ciklo loginimu,
 pasidarome ir Fragment'ų gyvavimo ciklo loginimą.
 Apie [Android Fragment lifecycle galima pasiskaityti android.com svetainėje]
  (http://developer.android.com/guide/components/fragments.html)

Taigi reikės susikurti `BaseFragment` pagrindinę klasę,
kurioje sudėsime loginimo metodus:
* onAttach
...

[Pasikeitimai](https://github.com/gdgvilnius/MaistoBankas/commit/c6e9e5c208491567eb4879c13d7af52035a81498)

## Integruoti duomenų bazę Barkodų saugojimui
Tam pasinaudosime [ORM lite](http://ormlite.com/sqlite_java_android_orm.shtml).

### Susikurti duomenų modelį

Saugotina informacija

Prekė `Item`:

* barcode - Barkodas
* name - Prekės pavadinimas
* price - Kaina
* weight - Svoris
* image_url - Nuotrauka

Nuskenuota prekė `ScannedItem`:

* id - nuskenavimo id
* barcode - prekės barkodas
* time - Laikas
* place - Vieta
* volunteer - Savanoris

[Pakeitimai](https://github.com/gdgvilnius/MaistoBankas/commit/a3d19b796b8731e38383bde4b664b38107565d5e)

### Išsaugoti naujai nuskenuojamas prekes į DB

Reikės sukurti naują `ScannedItem` objektą ir išsaugoti duomenų bazėje.

Apie tai, kaip susikurti ORM Lite duomenų bazės `Helper` klasę
galima paskaityti/pažiūrėti štai čia:
* [ORM use with Android](http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite_4.html#Use-With-Android)
* [ORM Android pavyzdžiai](http://ormlite.com/android/examples/)
* [ORM Android pavyzdys (GitHub'e)](https://github.com/j256/ormlite-examples/blob/master/android/HelloAndroid/src/com/example/helloandroid/DatabaseHelper.java)

Pasinaudojant `Helper` klase išsaugoti įrašą duomenų bazėje.

[Pasikeitimai](https://github.com/gdgvilnius/MaistoBankas/commit/e8f589d7b588ebb9ab201e62cf5c1d74cddbd89a)

### Rodyti įrašus išsaugotus duomenų bazėje
Nuskenuotų prekių sąrašą vis atnaujinti įrašais duomenų bazėje

* `MainFragment`e `onResume` metode iškviesti `dbHelper.getScannedItemDao().queryForAll();`
* Sąrašo atvaizdavimui sukurti naują adapterį
* Sąrašo eilutės vaizdavimui sukurti layout'ą (pradžiai tik su `TextView` barkodo atvaizdavimui)

[Pasikeitimai](https://github.com/gdgvilnius/MaistoBankas/commit/)

### Rodyti informaciją apie nuskenuotą prekę

* Parsisiųsti prekės informaciją
* Susikurti prekės informacijos duomenų modelį ir išsaugoti informaciją į DB
* Atvaizduoti prekės informaciją sąraše
