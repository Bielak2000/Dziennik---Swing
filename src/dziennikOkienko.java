import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class dziennikOkienko extends JFrame implements ActionListener {
    List<Class> listaClass = new ArrayList<>();
    List<Student> listaStudentow = new ArrayList<>();
    JButton przycisk1, przycisk3;//, przycisk2;
    JLabel j;
    public dziennikOkienko(List<Class> listaClass1, List<Student> listaStudentow1){
        listaStudentow = listaStudentow1;
        listaClass = listaClass1;
        setSize(400,150);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Dziennik");
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.red);
        przycisk1 = new JButton("Zacznij prace z dziennikiem");
        //przycisk2 = new JButton("Operacje na studentach");
        przycisk3 = new JButton("Wyjscie");
        j = new JLabel("Witaj w moim dzienniku!");
        j.setForeground(Color.green);
        j.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(j);
        add(przycisk1);
        add(przycisk3);
        setVisible(true);
        przycisk1.addActionListener(this);
        przycisk3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object z = e.getSource();
        if(z == przycisk1){
            grupyy g = new grupyy(listaClass, listaStudentow);
        }
        else if(z==przycisk3){
            dispose();
        }
    }


}
