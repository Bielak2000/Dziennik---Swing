import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DataGenerator dataGen = new DataGenerator();
        List<Student> listaStudentow = new ArrayList<>();
        listaStudentow = dataGen.uzupelnijListeStudentow();
        List<Class> listaClass = new ArrayList<>();
        listaClass = dataGen.uzupelnijListeClass();
        for(Student s : listaStudentow)
            System.out.println(s);
        for(Class c : listaClass)
            c.summary();

        dziennikOkienko window = new dziennikOkienko(listaClass, listaStudentow);
    }
}