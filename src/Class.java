import java.util.*;

public class Class implements Comparable<Class>{
    private String groupStudent;
    public int maxStudents;
    private List<Student> students = new ArrayList<>();

    Class(String g, int m){
        groupStudent = g;
        maxStudents = m;
    }

    Class(String g){
        groupStudent = g; maxStudents=15;
    }

    @Override
    public int compareTo(Class s) {
        return this.groupStudent.compareTo(s.groupStudent);
    }


    void addStudent(Student s){
        boolean temp = false;
        for(Student s1 : students){
            if(s1.equals(s)){
                temp = true;
            }
        }

        if(temp){
            System.out.println("This student has already been added.");
        }
        else if(students.size()>=this.maxStudents){
            System.err.println("Too many students!");
        }
        else{
            students.add(s);
            System.out.println("The student has been added!");
        }
    }

    void addPoints(Student s, double p)
    {
        for(Student s1 : students) {
            if (s1.equals(s)) {
                s1.addPoints(p);
                System.out.println("Student " + s1.getName() + " " + s1.getSurname() + " received " + p + " points!");
                break;
            }
        }
    }

    void removePoints(Student s, double p)
    {
        for(Student s1 : students) {
            if (s1.equals(s)) {
                s1.removePoints(p);
                System.out.println("Student " + s1.getName() + " " + s1.getSurname() + " deducted " + p + " points!");
            }
        }
    }

    void changeCondition(Student s, StudentCondition c){
        for(Student s1 : students) {
            if (s1.equals(s)) {
                s1.setCondition(c);
                System.out.println("Student " + s1.getName() + " " + s1.getSurname() + " received " + c + " condition!");
                break;
            }
        }
    }

    //usuwanie
    void getStudent(Student s){
        if(s.getPoints()==0){
            students.remove(s);
            System.out.println("Student " + s.getName() + " has been removed!");
        }
        else{
            System.out.println("He has more than 0 points, it cannot be deleted.");
        }
    }

    public Student search(String sur){
        Student s = new Student(sur);

        for(Student temp : students){
            if(temp.compareTo(s) == 0) {
                System.out.println("Students named " + sur +":");
                temp.print();
                return temp;
            }
        }
        System.out.println("Students named " + sur + " don't find!");
        return null;
    }

    Student searchPartial(String s) {
        for (Student s2 : students) {
            if (s2.getName().contains(s) || s2.getSurname().contains(s)) {
                s2.print();
                return s2;
            }
        }
        return null;
    }

    int countByCondition(StudentCondition c){
        int counter = 0;
        for (Student s2 : students) {
            if(s2.getCondition()==c){
                counter++;
            }
        }
        System.out.println("Students with the condition " + c + " are " + counter + ".");
        return counter;
    }

    List<Student> sortByName(){
        Collections.sort(students);
        System.out.println("Data has been sorted!");
        summary();
        return students;
    }

    //klasa anonimowa
    List<Student> sortByPoints(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2){
                return (-1*(Double.compare(s1.getPoints(), s2.getPoints())));
            }
        });
        return students;
    }

    //klasa anonimowa
    void max(){
        Student s = new Student();
        s = Collections.max(students, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getPoints(), s2.getPoints());}
        });
        System.out.println("Student with the most points: ");
        s.print();
    }

    public boolean removeStudent(Student s){
        boolean spr = false;
        int x=0;
        for(Student s1 : students){
            System.out.println(s1.getName()+"=="+s.getName()+ "&&"+ s1.getPoints()+"=="+s.getPoints() +"&&"+ s1.getSurname()+"=="+s.getSurname());
            if(s1.getName().equals(s.getName()) && s1.getPoints()==s.getPoints() && s1.getSurname().equals(s.getSurname())){
                System.out.println("1");
                students.remove(x);
                spr=true;
            }
            x++;
        }
        return spr;
    }

    void summary(){
        System.out.println("Students: ");
        for(Student s : students){
            s.print();
            System.out.println();
        }
    }

    List<Student> getStudents(){
        return students;
    }

    String getGroupStudent(){
        return groupStudent;
    }

    int getMaxStudents(){
        return this.maxStudents;
    }

    void setGroupStudent(String s) { this.groupStudent=s;}
}
