import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TableModelCustom extends AbstractTableModel {
    public String[] kolumny1;
    public List<Class> nazwy1;

    public TableModelCustom(List<Class> listaClass1) throws MyException {
        if(listaClass1.isEmpty())
            throw new MyException();
        nazwy1 = new ArrayList<>();
        for(Class c1 : listaClass1) {
            nazwy1.add(c1);
        }
        kolumny1 = new String[]{"Nazwa"};
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
        Class c = nazwy1.get(rowIndex);

        switch(columnIndex){
            case 0: return c.getGroupStudent();
            default: return null;
        }
    }

    public void addRow(Class c) {
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

    public void show(int i) throws MyException {
        if(i<0)
            throw new MyException();
        else {
            Studencii s = new Studencii(nazwy1.get(i).getStudents());
        }

    }

    public void zmien(int i, String x) throws MyException {
        if(i<0)
            throw new MyException();
        else {
            nazwy1.get(i).setGroupStudent(x);
            fireTableRowsUpdated(0, nazwy1.size());
        }
    }

    public void sort(){
        Collections.sort(nazwy1);
        fireTableRowsUpdated(0, nazwy1.size());
    }

    public void addStudent(Student s, int x) throws MyException {
        if(x<0)
            throw new MyException();
        else {
            nazwy1.get(x).addStudent(s);
            fireTableRowsUpdated(0, nazwy1.size());
        }
    }

    public void removeStudent(Student s, int x) throws MyException {
        if(x<0)
            throw new MyException();
        else {
            boolean spr = nazwy1.get(x).removeStudent(s);
            if(!spr)
                throw new MyException();
            fireTableRowsUpdated(0, nazwy1.size());
        }
    }
}
