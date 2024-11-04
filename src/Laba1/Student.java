package Laba1;

import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    // Конструктор Student
    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    // Перевод на следующий курс
    public void TransferToNextCourse() {
        course++;
    }

    // Подсчёт средней оценки студента
    public double getAverageGrade() {
        int sum = 0;
        for(int grade : grades) {
            sum += grade;
        }
        // Параметр пустой? -> равен 0, иначе (с int -> double) Cумма Оценок / Кол-во Оценок
        return grades.isEmpty() ? 0 : (double) sum / grades.size();
    }

    // @Override помогает компилятору проверить, что мы корректно переопределили метод toString() из Object
    // Взято из "Generate..."
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }

}
