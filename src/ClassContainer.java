import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ClassContainer {
    private LinkedHashMap<String, Class> groups = new LinkedHashMap<>();

    public void addClass(String s, int n){
        Class c = new Class(s,n);
        groups.put(s,c);
        System.out.println("Group " + s + " has been added!");
    }

    public void removeClass(String s){
        groups.remove(s);
        System.out.println("Groups " + s + " has been removed!");
    }

    public List<Class> findEmpty(){
        List<Class> emptyGroups = new ArrayList<>();
        for(Class c : groups.values()){
            if(c.getStudents().isEmpty()){
                emptyGroups.add(c);
            }
        }
        System.out.println("Empty groups: ");
        for(Class c : emptyGroups){
            System.out.println(c.getGroupStudent());
        }
        return emptyGroups;
    }

    public Class getGroup(String s){
        return groups.get(s);
        }

    public void summary(){
        double temp;
        for(Class c : groups.values()){
            temp = (c.getStudents().size()/(double)c.getMaxStudents())*100;
            System.out.println(c.getGroupStudent() + " - " + Math.round(temp) + "% full.");
        }
    }
}
