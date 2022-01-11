import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Studencii extends JFrame {
    private JLabel j;
    private JTable table;
    private JLabel Nazwisko;
    private JLabel nazwa;
    private JTextField tpunkty;
    private JTextField tnazwa;
    private JButton add;
    private JButton button1;
    private JPanel panel;
    private JTextField tnazwisko;
    private JButton zmien;
    private JButton sortuj;
    private JButton szukaj;
    private JComboBox Box;
    private JButton zmienStanStudentaButton;
    private JTextField tstan;
    private JLabel stan;

    public Studencii(List<Student> listaStudentow1){
        setContentPane(panel);
        setTitle("Studenci");
        setSize(700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box.addItem("2");
        Box.addItem("3");
        Box.addItem("4");
        Box.addItem("5");

        try{
            TableModelCustom1 t = new TableModelCustom1(listaStudentow1, new String[]{"Imie", "Nazwisko", "Status", "Punkty"});
            table.setModel(t);

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student s = new Student(tnazwa.getText(), tnazwisko.getText(), tpunkty.getText());
                    t.addRow(s);
                }
            });

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.removeRow(i);
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie wybrano studenta!", "Warning",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano studenta!");
                    }
                }
            });
            zmien.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.zmien(i, tpunkty.getText());
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie wybrano studenta lub zla ilosc punktow!", "Warning",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano studenta lub zla ilosc punktow!");
                    }

                }
            });

            sortuj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.sort();
                }
            });

            szukaj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        t.search(tnazwa.getText());
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie znaleziono studenta!", "Warning",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie znaleziono studenta!");
                    }
                }
            });

            Box.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String punkty = Box.getSelectedItem().toString();
                    try {
                        t.pokazWzgledemPunktow(punkty);
                    }catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie znaleziono studenta!", "Warning",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie znaleziono studenta!");
                    }
                }
            });

            zmienStanStudentaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        int x = table.getSelectedRow();
                        t.zmienStan(x, tstan.getText());
                    }catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Podano zly stan lub nie wybrano studenta!\n Mozliwe stany: Obency, Chory, Spozniony, Odrabiajacy.", "Warning",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie znaleziono studenta!");
                    }
                }
            });

            setVisible(true);
        } catch (MyException e) {
            JOptionPane.showMessageDialog(null, "Lista jest pusta!", "Warning",JOptionPane.WARNING_MESSAGE);
            e.printError("Lista jest pusta!");
        }

    }
}
