# Границы приложения
		целевая аудитория (ЦА) - мед. персонал хосписа (взято из Googleplay.com)
		платформы - смартфоны и планшеты под Android
		ОС - Android версий от 9 до 14 beta
		устройства - зависит от ЦА - взрослые, в основном женщины, со средним достатком - samsung, xiaomi, 😀️...
		
# Реализованный функционал
		ЗАЯВКИ: создание заявки, изменение заголовка заявки, комментирование заявки, ....
		НОВОСТИ: создание новости, фильтр новостей по категориям, дате публ, дате создания, активности, ...
		ЦИТАТЫ: чтение цитат по теме приложения.
		вход только зарегистрированным (на сервере приложения?) мед. работникам
		
# Инструменты
		Android Studio
		Espresso
		UI Automator
		Git
		Allure
	
# Автоматизируемые сценарии
| № сценария | Описание сценария | Причина автоматизации сценария |
| ---------- | ----------------- | ------------------------------ |
| 2-7     | Авторизация   | Много раз повторяются на разных устройствах |
|11-17| Создание заявки | Много раз повторяются на разных устройствах
|19-21| Работа с комментариями | Много раз повторяются на разных устройствах
|22-27|Изменения статуса заявки | Много раз повторяются на разных устройствах
|10|Нахождение заявки|Ручной поиск долгий и неудобный
|35|Попытка удаления описания при Редактировании заявки| Основной функционал
|45|Создание новости| Основной функционал
|51|Разворачивание карточки цитаты| Основной функционал
|53-56|Отображение версии ПО, политики конфиденциальности и пользовательского соглашения и авторских прав| Критично для бизнеса		 

# Тестируемые устройства
   
## Физическое:
смартфон Xiaomi Redmi Note 5, Android 9, API level 28, разрешение экрана 1080х2160
## Эмуляторы:
   - смартфон Nexus 5 , API level 29, разрешение экрана 480х800
   - планшет 7 WSVGA, API level 29, разрешение экрана 1080х1920
   