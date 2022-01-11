import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    List<Student> listaS = new ArrayList<>();

    public List<Student> uzupelnijListeStudentow(){
        Student s = new Student("2", "Kacper1", "X", StudentCondition.current, 2000, 2.3);
        Student s1 = new Student("3", "Kacper", "Bielak1", StudentCondition.belated, 2000, 5);
        Student s2 = new Student("3", "Kacper", "X", StudentCondition.current, 2000, 2.3);
        Student s3 = new Student("3", "Kacper3", "X", StudentCondition.current, 2000, 2.3);
        Student s4 = new Student("3", "Kacper4", "X", StudentCondition.current, 2000, 2.3);
        Student s5 = new Student("3", "Kacper5", "X", StudentCondition.current, 2000, 2.3);
        Student s6 = new Student("3", "Kacper6", "X", StudentCondition.current, 2000, 2.3);
        Student s7 = new Student("3", "Kacper7", "X", StudentCondition.current, 2000, 2.3);
        Student s8 = new Student("3", "Kacper8", "X", StudentCondition.current, 2000, 2.3);
        Student s9 = new Student("3", "Kacper9", "X", StudentCondition.current, 2000, 2.3);
        Student s10 = new Student("3", "Kacper11", "X", StudentCondition.current, 2000, 2.3);
        Student s11 = new Student("3", "Kacper12", "X", StudentCondition.current, 2000, 2.3);
        Student s12 = new Student("3", "Kacper13", "X", StudentCondition.current, 2000, 2.3);
        Student s13 = new Student("3", "Kacper14", "X", StudentCondition.current, 2000, 2.3);
        Student s14 = new Student("3", "Kacper15", "X", StudentCondition.current, 2000, 2.3);
        Student s15 = new Student("3", "Kacper116", "X", StudentCondition.current, 2000, 2.3);
        Student s16 = new Student("3", "Kacper1167", "X", StudentCondition.current, 2000, 2.3);
        List<Student> listaStudentow = new ArrayList<>();
        listaStudentow.add(s);
        listaStudentow.add(s1);
        listaStudentow.add(s2);
        listaStudentow.add(s3);
        listaStudentow.add(s4);
        listaStudentow.add(s5);
        listaStudentow.add(s6);
        listaStudentow.add(s7);
        listaStudentow.add(s8);
        listaS = listaStudentow;
        return listaStudentow;
    }

    public List<Class> uzupelnijListeClass(){
        Class c1 = new Class("GL01", 12);
        c1.addStudent(listaS.get(0));
        c1.addStudent(listaS.get(1));

        Class c2 = new Class("GL02", 12);
        c2.addStudent(listaS.get(2));
        c2.addStudent(listaS.get(3));
        c2.addStudent(listaS.get(4));
        c2.addStudent(listaS.get(5));
        c2.addStudent(listaS.get(6));

        Class c3 = new Class("GL03", 12);
        c3.addStudent(listaS.get(7));
        c3.addStudent(listaS.get(8));

        List<Class> listaClass = new ArrayList<>();
        listaClass.add(c1);
        listaClass.add(c2);
        listaClass.add(c3);
        return listaClass;
    }
}
