# Проект по автоматизации mobile тестов для приложения [Wikipedia](https://ru.wikipedia.org/)
<p align="center"><a href="https://www.tinkoff.ru"><img src="images/logo/Wiki.jpg" align="center" width="500" height="300" alt="Wiki"/></a></p>  

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

## <img src="images/logo/Jenkins.svg" width="50" height="50"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/wikipedia_mobile_kpoludnitsyn/)

<p align="center">
<img src="images/screenshots/JenkinsPage.jpg" alt="Jenkins Page" width="1000" height="350">
</p>

---

## :rocket: Команды для запуска

### Локальный запуск (через эмулятор)

```bash
gradle clean local_test -Dhost=local
```

> Для запуска локальных тестов требуются следующие установленные программы на компьютере: Appium Server, Appium и Android Studio

### Удаленный запуск (через browserstack)

```bash
gradle clean browserstack_test -Dhost=browserstack
```

---

## <img src="images/logo/Allure.svg" width="50" height="50"/> [Allure](https://jenkins.autotests.cloud/job/wikipedia_mobile_kpoludnitsyn/allure/) отчет

### Главная страница отчета

<p align="center">
<img src="images/screenshots/AllureReport.jpg" alt="Allure report" width="1000" height="350">
</p>

### Тест-кейсы

<p align="center">
<img src="images/screenshots/AllureTestCases.jpg" alt="Test Case" width="1000" height="350">
</p>

#### Содержание тест-кейсов

- :heavy_check_mark: Подробное описание шагов
- :heavy_check_mark: Тег
- :heavy_check_mark: Эпик
- :heavy_check_mark: Критичность теста
- :heavy_check_mark: Автор
- :heavy_check_mark: Разметка в приложении
- :heavy_check_mark: Видео с прохождением теста

### Графики

<p align="center">
<img src="images/screenshots/AllureGraph.jpg" alt="Allure-graph" width="1000" height="400">
</p>

---

## <img src="images/logo/AllureTestOps.svg" width="50" height="50"/> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3764/dashboards)

### Dashboard

<p align="center">
<img src="images/screenshots/TestOps_dashboard.jpg" alt="TestOps dashboard" width="1000" height="400">
</p>

### Автоматизированные тест-кейсы

<p align="center">
<img src="images/screenshots/TestOps_testCases.jpg" alt="TestOps test cases" width="1000" height="400">
</p>

### Запуск сборки из **Allure TestOps**

<p align="center">
<img src="images/screenshots/TestOps_launches.jpg" alt="TestOps launches">
</p>

---

## <img src="images/logo/Jira.svg" width="50" height="50"/> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-939)

### Задача в Jira

<p align="center">
<img src="images/screenshots/Jira.jpg" alt="Jira" width="1000" height="400">
</p>

#### Содержание задачи

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
<img src="images/gifs/Selenide_video.gif" alt="Selenide video" width="800" height="400">
</p>
