package localizations;

import java.util.ListResourceBundle;

public class GUILabels_ru extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"failed to login", "Не удалось войти"},
                    {"failed to register", "Не удалось зарегистрироваться"},
                    {"welcome to music band", "Добро пожаловать в музыкальную группу"},
                    {"Log to account", "Войдите в свой аккаунт"},
                    {"Register", "Зарегистрируйтесь"},
                    {"name", "имя пользователя"},
                    {"password", "пароль"},
                    {"loginButton", "Войти"},
                    {"registerButton", "Создать"},
                    {"language:", "Язык:"},
                    {"have account", "Уже есть аккаунт?"},
                    {"not have account", "Нет аккаунта?"},
                    {"toLoginButton", "Войдите"},
                    {"toRegisterButton", "Создайте"},
                    {"alb", "Албанский"},
                    {"en", "Английский"},
                    {"ru", "Русский"},
                    {"ge", "Немецкий"},
                    {"dataFormat", "dd.MM.yyyy"},
                    {"info about help", "О командах"},
                    {"help command", "info: выводит информацию о коллекции\n" +
                            "show: выводит элементы коллекции\n" +
                            "add: добавляет элемент в коллекцию\n" +
                            "update: обновляет музыкальную группу по id на основе заданной музыкальной группу\n" +
                            "remove_by_id: удаляет музыкальную группу по id из коллекции\n" +
                            "clear: очищает коллекцию\n" +
                            "head: выводит первый элемент коллекции\n" +
                            "remove_greater: удаляет музыкальную группу, которые больше заданного\n" +
                            "history: выводит последние 11 команд\n" +
                            "filter_by_number_of_participants: выводит музыкальную группу с заданным номером выступления\n" +
                            "print_descending: выводит элементы коллекции в порядке убывания\n" +
                            "print_field_descending_genre: выводит значения поля genre всех элементов в порядке убывания\n" +
                            "auth: производит вход пользователя\n" +
                            "register: производит регистрацию пользователя\n" +
                            "logout: выходит из аккаунта\n" +
                            "user_info: выводит информацию о текущем пользователе\n" +
                            "help: выводит полную информацию о командах\n" +
                            "exit: завершает программу\n" +
                            "execute_script: выполняет команды из файла\n"},
                    {"info about commands", "О коллекции"},
                    {"info", "Тип данных: java.util.LinkedList\n" +
                            "Дата инициализации: "},
                    {"count elements", "Количество элементов: "},
                    {"ok", "ОК"},
                    {"choose script", "Выберите скрипт"},
                    {"not empty", "Поля не могут быть пустыми"},
                    {"not numbers", "Все поля, кроме имени и жанра должны быть целыми числами"},
                    {"not update", "Нельзя обновить данный объект"},
                    {"not this user", "Вы не можете обновлять значения объектов, которые создали не вы"},
                    {"invalid enter coordinates", "Неправильно введены координаты"},
                    {"write coordinates", "Пишите координаты через точку с запятой(;)"},
                    {"field need number", "Данное поле должно быть целым числом"},
                    {"null", "Пустое значение"},
                    {"not null", "Данное поле не может быть пустым"},
                    {"exit", "Выйти"},
                    {"map", "Карта"},
                    {"help", "Помощь"},
                    {"information", "Информация"},
                    {"add", "Добавить"},
                    {"script", "Выполнить скрипт"},
                    {"remove greater", "Удалить большее"},
                    {"clear", "Очистить"},
                    {"searchLabel", "Поиск:"},
                    {"searchField", "введите текст"},
                    {"name", "Имя"},
                    {"creation date", "Дата создания"},
                    {"count fans", "Количество фанатов"},
                    {"single count", "Количество синглов"},
                    {"genre", "Жанр"},
                    {"labels", "Лейбл (продажи)"},
                    {"table", "Таблица"},
                    {"delete", "Удалить"},
                    {"add", "Добавить"},
                    {"coord x", "Координата x"},
                    {"coord y", "Координата y"},
                    {"input text", "Введите текст"}












            };
    public Object[][] getContents() {
        return contents;
    }
}
