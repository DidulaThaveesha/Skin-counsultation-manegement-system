package Company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUImain extends JFrame{

    public void menu() throws FontFormatException {
        /*create a j frame and panel */
        JFrame frame = new JFrame("Westminster Skin Care Consultation");
        /*Add a background image for the j frame*/
        ImageIcon image = new ImageIcon("gg_1200x675.jpg");
        JLabel blabel=new JLabel(image);
        frame.setLayout(new BorderLayout());
        frame.add(blabel, BorderLayout.CENTER);
        frame.setSize(image.getIconWidth(), image.getIconHeight());


        JLabel header = new JLabel("Westminster Skin Care Consultation ");//menu
        /*Button names*/
        JButton b1 = new JButton("List of Doctors");

        JButton b3 = new JButton("Patient details &Consultation");

        JButton b6 = new JButton("information of the patients");

        header.setForeground(Color.lightGray);
        header.setFont(header.getFont().deriveFont(30f));//header

        Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 15);
        Border whiteline = BorderFactory.createLineBorder(Color.RED);
        Border compound;

        //button for dia-mentions
        b1.setBounds(500, 300, 300, 60);
        b1.setBackground(Color.lightGray);
        b1.setForeground(Color.black);
        b1.setFont(font);
        b1.setBorder(whiteline);

        b3.setBounds(500, 400, 300, 60);
        b3.setBackground(Color.lightGray);
        b3.setForeground(Color.black);
        b3.setFont(font);
        b3.setBorder(whiteline);

        b6.setBounds(500, 500, 300, 60);
        b6.setBackground(Color.lightGray);
        b6.setForeground(Color.black);
        b6.setFont(font);
        b6.setBorder(whiteline);

        header.setBounds(350, 40, 750, 75);

/*Add buttons to the frame*/
        frame.add(b1);

        frame.add(b3);

        frame.add(b6);

        frame.add(header);

        frame.setSize(1200, 675);

        frame.add(blabel);

        blabel.setBounds(500,500,1000,1000);
        frame.setVisible(true);




        /*show list of Doctors buttons' method*/
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListofDocsGUI();
                frame.setVisible(true);
            }
        });
        /*show Patient details & Consultation table buttons' method */
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultationGUI( );
                frame.setVisible(false);
            }
        });
        /*show information of the patients buttons' method*/
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddpatientGUI( );

                frame.setVisible(false);
            }
        });

    }
}

//reference:-https://www.javatpoint.com/java-swing
//https://www.guru99.com/java-swing-gui.html
//https://www.youtube.com/watch?v=Kmgo00avvEw
