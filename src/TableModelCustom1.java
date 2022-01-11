import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TableModelCustom1 extends AbstractTableModel {
    public String[] kolumny1;
    public List<Student> nazwy1;

    public TableModelCustom1(List<Student> listaStudentow1, String[] kolumny) throws MyException {
        if(listaStudentow1.isEmpty())
            throw new MyException();
        nazwy1 = new ArrayList<>();
        for(Student s : listaStudentow1) {
            nazwy1.add(s);
        }
        kolumny1 = kolumny;
    }

    @Override
    public int getRowCount() {
        return nazwy1.size();
    }

    @Override
    public int getColumnCount() {
        return kolumny1.length;
    }

    @Override
    public String getColumnName(int col){
        return kolumny1[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = nazwy1.get(rowIndex);
        switch(columnIndex){
            case 0: return s.getName();
            case 1: return s.getSurname();
            case 2: return s.getCondition();
            case 3: return s.getPoints();
            default: return null;
        }
    }

    public void addRow(Student c) {
        nazwy1.add(c);
        fireTableRowsInserted(nazwy1.size() - 1, nazwy1.size() - 1);
    }

    public void removeRow(int i) throws MyException {
        if(i<0)
            throw new MyException();
        else {
            nazwy1.remove(i);
            fireTableRowsDeleted(i - 1, nazwy1.size() - 1);
        }
    }

    public void zmien(int i, String x) throws MyException {
        if(i<0)
            throw new MyException();
        else{
            double x1 = Double.parseDouble(x);
            if(x1<0)
                throw new MyException();
            else {
                nazwy1.get(i).setPoints(x1);
                fireTableRowsUpdated(0, nazwy1.size());
            }
        }
    }

    public void sort(){
        Collections.sort(nazwy1);
        fireTableRowsUpdated(0, nazwy1.size());
    }

    List<Student> searchPartial(String s) throws MyException {
        List<Student> temp = new ArrayList<>();
        for (Student s2 : nazwy1) {
            if (s2.getName().contains(s)) {
                temp.add(s2);
            }
        }
        return temp;
    }

    public void search(String s) throws MyException {
        List<Student> listaZnalezionych = searchPartial(s);
        if(listaZnalezionych.isEmpty())
            throw new MyException();
        Studencii st = new Studencii(listaZnalezionych);
    }

    public void pokazWzgledemPunktow(String x) throws MyException {
        double x1 = Double.parseDouble(x);
        List<Student> s1 = new ArrayList<>();
        for(Student s : nazwy1){
            if(s.getPoints()>=x1){
                s1.add(s);
            }
        }
        if(s1.isEmpty())
            throw new MyException();
        Studencii stud = new Studencii(s1);
    }

    public void zmienStan(int x, String s) throws MyException {
        if(x<0)
            throw new MyException();
        else {
            if (s.equals("Obecny"))
                nazwy1.get(x).setCondition(StudentCondition.current);
            else if (s.equals("Spozniony"))
                nazwy1.get(x).setCondition(StudentCondition.belated);
            else if (s.equals("Chory"))
                nazwy1.get(x).setCondition(StudentCondition.sick);
            else if (s.equals("Odrabiajacy"))
                nazwy1.get(x).setCondition(StudentCondition.workingOut);
            else
                throw new MyException();
            fireTableRowsUpdated(0, nazwy1.size());
        }
    }

}
