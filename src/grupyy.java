import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class grupyy extends JFrame {
    private JLabel j;
    private JTable table;
    private JLabel nazwa;
    private JTextField tnazwa;
    private JButton add;
    private JPanel Panel1;
    private JButton button1;
    private JButton pokaz;
    private JButton zmien;
    private JButton sort;
    private JTextField timie;
    private JTextField tnazwisko;
    private JTextField tpunkty;
    private JLabel imie;
    private JLabel punkty;
    private JLabel nazwisko;
    private JButton dodajStudentaDoGrupyButton;
    private JButton usunStudentaZGrupyButton;
    private JButton pokazWszystkichStudentowButton;

    public grupyy(List<Class> listaClass1,List<Student> listaStudentow1) {
        setContentPane(Panel1);
        setTitle("Grupy");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            TableModelCustom t = new TableModelCustom(listaClass1);
            table.setModel(t);

            setVisible(true);

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Class c = new Class(tnazwa.getText());
                    t.addRow(c);
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
                        JOptionPane.showMessageDialog(null, "Nie wybrano grupy!", "Warning",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano grupy!");
                    }
                }
            });

            //dodoalem kolejny przycisk zeby bylo latwiej, zaznaczony wysietla a jak usunac?
            pokaz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.show(i);
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie wybrano grupy!", "Warning",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano grupy!");
                    }
                }
            });


            zmien.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.zmien(i, tnazwa.getText());
                    }
                    catch(MyException e1) {
                        JOptionPane.showMessageDialog(null, "Nie wybrano grupy!", "Warning", JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano grupy!");
                    }
                }
            });

            sort.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.sort();
                }
            });

            dodajStudentaDoGrupyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student s = new Student(timie.getText(), tnazwisko.getText(), tpunkty.getText());
                    int x = table.getSelectedRow();
                    try {
                        t.addStudent(s, x);
                        listaStudentow1.add(s);
                    }
                    catch(MyException e1) {
                        JOptionPane.showMessageDialog(null, "Nie wybrano grupy!", "Warning", JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano grupy!");
                    }
                }
            });

            usunStudentaZGrupyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student s = new Student(timie.getText(), tnazwisko.getText(), tpunkty.getText());
                    int x = table.getSelectedRow();
                    try {
                        t.removeStudent(s, x);
                    }
                    catch(MyException e1) {
                        JOptionPane.showMessageDialog(null, "Nie wybrano grupy lub nie istnieje student o takich danych!", "Warning", JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano grupy!");
                    }
                }
            });

        } catch (MyException e) {
            JOptionPane.showMessageDialog(null, "Lista jest pusta!", "Warning",JOptionPane.WARNING_MESSAGE);
            e.printError("Lista jest pusta!");
        }

        pokazWszystkichStudentowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studencii s = new Studencii(listaStudentow1);
            }
        });
    }
}
