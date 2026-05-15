# Домашнее задание №11
1. Написать чек-лист для приложения https://www.saucedemo.com и
   разместить его в своем файле README.md в корне проекта
   Руководство по оформлению Markdown файлов
2. Описать как минимум одну дополнительную страницу, используя Page
   ObjectPattern, например, CartPage или CheckoutPage
3. Написать минимум 5 тестов для приложения и создать Pull Request


# Чек-лист проверок:
1. Открыть главную страницу. Ввести логин и пароль. Нажать Авторизоваться. Заголовок страницы Products?
2. Нажать на кнопку с data-test=add-to-cart-sauce-labs-backpack. Кнопка стала с data-test=remove-sauce-labs-backpack?
3. Открыть страницу по кнопке корзины с data-test=shopping-cart-link. Заголовок страницы Your Cart?
4. На странице имеется кнопка Remove с data-test=remove-sauce-labs-backpack?
5. Нажать на ссылку с data-test=inventory-item-name. Открылась страница с товаром, у которого название Sauce Labs Backpack?

# Домашнее задание №13 xUnit

1. Выполнить разметку тестов проекта SauceDemo
2. Реализовать кросс-браузерное тестирование в проекте SauceDemo (минимум 2 браузера)
3. Реализовать подключение Retry через TestNG.xml файл
   https://swtestacademy.com/retry-failed-tests-testng-iretryanalyzer/