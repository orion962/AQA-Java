package org.example;

/*
Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

Создать массив из 5 сотрудников.
Пример:
// вначале объявляем массив объектов
Person[] persArray = new Person[5];
// потом для каждой ячейки массива задаем объект
persArray[0] = new Person("Ivanov Ivan", "Engineer",
               "ivivan@mailbox.com", "892312312", 30000, 30);
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);


Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимости.
 */
public class Main {
    public static void main(String[] args) {
        Employee[] arr = new Employee[5];
        arr[0] = new Employee("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        arr[1] = new Employee("Sergey Sergeyev", "Doctor",
                "serserg@mailbox.com", "892212339", 25000, 24);
        arr[2] = new Employee("Vladimirov Vladimir", "Teacher",
                "vladvlad@mailbox.com", "892247312", 15000, 38);
        arr[3] = new Employee("Yuryevich Yuri", "Programmer",
                "yuriyuri@mailbox.com", "892316012", 40000, 25);
        arr[4] = new Employee("Sychov Sych", "Car-mechanic",
                "sychsych@mailbox.com", "892316112", 36000, 43);

        for (int i = 0; i < 5; ++i)
        {
            arr[i].printString();
        }
        System.out.println();
        //////////////////////////////////////////////////////////////////////
        Park.Attractions obj = new Park().new Attractions("roller-coaster", "12:00-14:00", 5);
        obj.printString();
    }

}