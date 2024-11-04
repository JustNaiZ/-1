package Laba1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Коллекция Студентов
        List<Student> students = new ArrayList<>();

        // Добавление объектов в коллекцию
        students.add(new Student("Artem", "IS-B22", 1, List.of(4, 5, 4)));
        students.add(new Student("Nastya", "IS-B22", 2, List.of(5, 5, 3)));
        students.add(new Student("Andrey", "IVT-B22", 1, List.of(4, 3, 3)));
        students.add(new Student("Vika", "IVT-B22", 3, List.of(2, 3, 4)));
        students.add(new Student("Egor", "M-B22", 2, List.of(3, 3, 2)));
        students.add(new Student("Timofey", "M-B22", 3, List.of(2, 2, 3)));

        // Для ввода с клавиатуры
        Scanner scanner = new Scanner(System.in); // создаем объект scanner, который будет считывать данные из стандартного ввода (консоли)
        System.out.print("Введите номер курса для отображения студентов: ");
        int courseNumber = scanner.nextInt();

        EraseStudents(students);

        // Среди студентов смотрим тех, кто перешёл на такой-то курс
        printStudents(students, courseNumber);

    }

    // Для каждого студента в списке будет выполняться код в фигурных скобках
    public static void EraseStudents(List<Student> students) {
        students.removeIf(student -> {
            double averageGrade = student.getAverageGrade();
                if (averageGrade < 3) {
                    return true; // студент будет удален
                } else {
                    student.TransferToNextCourse();
                    return false; // иначе перейдёт на next курс
                }
            }
        );
    }

    public static void printStudents(List<Student> students, int course) {
        for(Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("Имя: " + student.getName() + "  Курс: " + student.getCourse());
            }
        }
    }

}