# Проект по автоматизации mobile тестов для приложения [Wikipedia](https://ru.wikipedia.org/)
<p align="center"><a href="https://www.tinkoff.ru"><img src="images/logo/Wiki.png" align="center" width="600" height="300" alt="Wiki"/></a></p>  

> Википедия - общедоступная многоязычная универсальная интернет-энциклопедия со свободным контентом, реализованная на принципах вики.

## :notebook: Содержание:

- [Стек технологий](#computer-стек-технологий)  
- [Тестовые сценарии](#clipboard-тестовые-сценарии)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Команды для запуска](#rocket-команды-для-запуска)
- [Allure отчет](#-allure-отчет)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram чат с ботом](#-уведомления-в-telegram-чат-с-ботом)
- [Видео запуска тестов в Selenoid](#-видео-запуска-тестов-в-selenoid)  

---

## :computer: Стек технологий
<p align="center">
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"/></a>
<a href="https://www.github.com/"><img src="images/logo/Github.svg" width="50" height="50"/></a>
<a href="https://www.gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"/></a>
<a href="https://www.junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"/></a>
<a href="https://www.selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"/></a>
<a href="https://appium.io/"><img src="images/logo/Appium.svg" width="50" height="50"/></a>
<a href="https://www.browserstack.com/"><img src="images/logo/Browserstack.svg" width="50" height="50"/></a>
<a href="https://www.aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"/></a>
<a href="https://www.qameta.io/"><img src="images/logo/AllureTestOps.svg" width="50" height="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img src="images/logo/Jira.svg" width="50" height="50"/></a>
<a href="https://www.telegram.org/"><img src="images/logo/Telegram.svg" width="50" height="50"/></a>
</p>

---

## :clipboard: Тестовые сценарии

### Для локального запуска
- :white_check_mark: Проверка стартовых страниц wiki
- :white_check_mark: Проверка компонента "Saved"
- :white_check_mark: Проверка добавления статьи в компонент "Saved"
- :white_check_mark: Проверка компонента "More"

### Для удаленного запуска
- :white_check_mark: Проверка отображения подсказок при вводе запроса
- :white_check_mark: Проверка отображения иконки ошибки при переходе в некорректную статью
- :white_check_mark: Проверка заголовка статьи

---

## <img src="images/logo/Jenkins.svg" width="50" height="50"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/tinkoff_autotests_kpoludnitsyn_new/)

<p align="center">
<img src="images/screenshots/JenkinsPage.jpg" alt="Jenkins Page" width="1000" height="350">
</p>

### Параметры сборки проекта

| Параметр        | Назначение                               |
|-----------------|------------------------------------------|
| REMOTE_URL      | Удаленный сервер для запуска тестов      |
| BROWSER         | Браузер для запуска                      |
| BROWSER_VERSION | Версия браузера                          |
| BROWSER_SIZE    | Разрешение экрана                        |
| BASE_URL        | Адрес сайта                              |
| TASK            | Опция выбора запуска определённых тестов |

### Запуск тестов с параметрами в **Jenkins**

<p align="center">
<img src="images/screenshots/JenkinsLaunch.jpg" alt="Jenkins Launch" width="1000" height="400">
</p>

---

## :rocket: Команды для запуска

### Локальный запуск

```bash
gradle clean test
```

### Удаленный запуск
```bash
clean
${TASK}
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserVersion=${BROWSER_VERSION}
-DbaseUrl=${BASE_URL}
-DremoteUrl=${REMOTE_URL}
```

### Варианты запуска тестов

Для запуска можно выбрать один из семи тест-сьютов:

```mermaid
flowchart LR
    A[Test Suite] --> B[Все тесты] --> C[test]
    A --> D[Главная страница] --> E[main_test]
    A --> F[Раздел 'Дебетовые карты'] --> G[debit_test]
    A --> H[Раздел 'Кредиты и ипотека'] --> I[credit_test]
    A --> J[Раздел 'Вклады'] --> K[savings_test]
    A --> L[Раздел 'Аналитика'] --> M[analytics_test]
    A --> N[Раздел 'Помощь'] --> O[help_test]
```

---

## <img src="images/logo/Allure.svg" width="50" height="50"/> [Allure](https://jenkins.autotests.cloud/job/tinkoff_autotests_kpoludnitsyn_new/6/allure/) отчет

### Главная страница отчета

<p align="center">
<img src="images/screenshots/AllureReport.jpg" alt="Allure report" width="1000" height="400">
</p>

### Тест-кейсы

<p align="center">
<img src="images/screenshots/AllureTestCases.jpg" alt="Test Case" width="1000" height="400">
</p>

#### Содержание тест-кейсов

- :heavy_check_mark: Подробное описание шагов
- :heavy_check_mark: Тег
- :heavy_check_mark: Эпик
- :heavy_check_mark: Критичность теста
- :heavy_check_mark: Автор
- :heavy_check_mark: Ссылка на раздел сайта (для каждый тестов свой раздел)
- :heavy_check_mark: Последний скриншот для каждого теста 
- :heavy_check_mark: HTML разметка страницы
- :heavy_check_mark: Логи браузера
- :heavy_check_mark: Видео с прохождением теста

### Графики

<p align="center">
<img src="images/screenshots/AllureGraph.jpg" alt="Allure-graph" width="1000" height="400">
</p>

---

## <img src="images/logo/AllureTestOps.svg" width="50" height="50"/> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3675/dashboards)

### Dashboard

<p align="center">
<img src="images/screenshots/TestOps_dashboard.jpg" alt="TestOps dashboard" width="1000" height="400">
</p>

### Ручные и автоматизированные тест-кейсы

<p align="center">
<img src="images/screenshots/TestOps_testCases.jpg" alt="TestOps test cases" width="1000" height="400">
</p>

### Запуск автоматизированных тестов в **TestOps**

<p align="center">
<img src="images/screenshots/TestOps_launch.jpg" alt="TestOps launch" width="1000" height="400">
</p>

### Запуск сборки из **Allure TestOps**

<p align="center">
<img src="images/screenshots/TestOps_launches.jpg" alt="TestOps launches">
</p>

---

## <img src="images/logo/Jira.svg" width="50" height="50"/> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-929)

### Задача в Jira

<p align="center">
<img src="images/screenshots/Jira.jpg" alt="Jira" width="1000" height="400">
</p>

#### Содержание задачи

- :heavy_check_mark: Цель
- :heavy_check_mark: Задачи для выполнения
- :heavy_check_mark: Тест-кейсы из Allure TestOps
- :heavy_check_mark: Результат прогона тестов в Allure TestOps

---

## <img src="images/logo/Telegram.svg" width="50" height="50"/> Уведомления в Telegram чат с ботом

### Уведомление через чат бот

<p align="center">
<img src="images/screenshots/Telegram.jpg" alt="Telegram" width="500" height="400">
</p>


#### Содержание уведомления в Telegram

- :heavy_check_mark: Окружение
- :heavy_check_mark: Комментарий
- :heavy_check_mark: Длительность прохождения тестов
- :heavy_check_mark: Общее количество сценариев
- :heavy_check_mark: Процент прохождения тестов
- :heavy_check_mark: Ссылка на Allure отчет

---

## <img src="images/logo/Selenoid.svg" width="50" height="50"/> Видео запуска тестов в Selenoid

<p align="center">
<img src="images/gifs/" alt="TestOps launch" width="800" height="400">
</p>
