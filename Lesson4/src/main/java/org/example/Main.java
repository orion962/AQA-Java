package org.example;

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

        for (Employee obj: arr) {
            obj.printString();
        }
        System.out.println();
        //////////////////////////////////////////////////////////////////////
        Park.Attractions obj = new Park().new Attractions("roller-coaster", "12:00-14:00", 5);
        obj.printString();
    }
}