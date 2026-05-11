# Automated Tests — SauceDemo

## Opis projektu

Projekt automatycznych testów aplikacji SauceDemo napisany w Java z użyciem Selenium WebDriver oraz TestNG.

Framework testowy został przygotowany zgodnie z wzorcem Page Object Model (POM).

Projekt obejmuje automatyzację:
- logowania,
- dodawania produktów do koszyka,
- procesu checkout,
- walidacji formularzy,
- finalizacji zamówienia.

---

## Technologie

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

---

## Struktura projektu

```bash
src
 ├── main
 └── test
      ├── base
      ├── pages
      └── tests
```

---

## Zakres testów

### Logowanie

- poprawne logowanie,
- logowanie błędnymi danymi,
- walidacja błędów.

### Koszyk

- dodawanie produktów,
- usuwanie produktów,
- sprawdzanie licznika produktów.

### Checkout

- checkout z jednym produktem,
- checkout z wieloma produktami,
- finalizacja zakupu.

### Testy negatywne

- brak imienia,
- brak nazwiska,
- brak kodu pocztowego,
- pusty formularz.

---

## Uruchamianie projektu

### Klonowanie repozytorium

```bash
git clone <repo-url>
```

### Instalacja zależności

```bash
mvn clean install
```

### Uruchomienie testów

```bash
mvn test
```

---

## Przykładowe scenariusze testowe

| Test Case | Opis |
|---|---|
| shouldFinishCheckoutSuccessfully | Checkout z 1 produktem |
| shouldFinishCheckoutSuccessfullyWithTwoProducts | Checkout z 2 produktami |
| shouldCheckoutWithoutUserName | Walidacja pustego imienia |
| shouldCheckoutWithoutSurname | Walidacja pustego nazwiska |
| shouldCheckoutWithoutPostalCode | Walidacja pustego kodu pocztowego |

---

## Dobre praktyki

Projekt wykorzystuje:
- Page Object Model,
- explicit waits,
- reusable methods,
- czytelne asercje,
- separację warstwy testowej od logiki UI.

---



Projekt wykonany w celach edukacyjnych i rozwoju umiejętności QA Automation.
