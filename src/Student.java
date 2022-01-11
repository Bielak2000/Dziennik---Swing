import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String numberOfAlbum;
    private String name;
    private String surname;
    private StudentCondition condition;
    private int yearOfBirth;
    private double points;

    Student() {}

    Student(String nr, String n, String s, StudentCondition c, int y, double p) {
        numberOfAlbum = nr;
        name = n;
        surname = s;
        condition = c;
        yearOfBirth = y;
        points = p;
    }
    Student(String n, String s, String p) {
        name = n;
        surname = s;
        points = Double.parseDouble(p);
    }

    Student(String n){
        this.surname = n;
    }

    @Override
    public int compareTo(Student s) {
        return this.surname.compareTo(s.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    void addPoints(double p){
        this.points += p;
    }

    void removePoints(double p){
        this.points -= p;
    }

    void setCondition(StudentCondition c){
        this.condition = c;
    }

    double getPoints(){
        return this.points;
    }

    String getName(){
        return this.name;
    }

    String getSurname(){
        return this.surname;
    }

    StudentCondition getCondition(){
        return this.condition;
    }

    void setPoints(double x) { this.points=x;}

    void print() {
        System.out.println("Student data:");
        System.out.println("Number of album: " + this.numberOfAlbum);
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.println("Student condition: " + this.condition);
        System.out.println("Year of bith: " + this.yearOfBirth);
        System.out.println("Points: " + this.points);
    }
}
