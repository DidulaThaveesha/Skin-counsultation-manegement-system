package Company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import static Company.Consultation.consultate;
public class ConsultationGUI {
    ConsultationGUI(){
        JFrame frame = new JFrame("information of the patients....");
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);



        /*Adding Coloumns*/
        tableModel.addColumn("Patient ID");
        tableModel.addColumn("Patient First name");
        tableModel.addColumn("Patient Surname");
        tableModel.addColumn("Patient Mobile number");
        tableModel.addColumn("Consult date  ");
        tableModel.addColumn("Time");
        tableModel.addColumn("Note");
        tableModel.addColumn("Cost");
        tableModel.addColumn("Doctor Specification");
        tableModel.addColumn("Doctor licence");
        tableModel.addColumn("picture");


         /*Append to the table  */
        for(Consultation Consultation1 : consultate){
            tableModel.insertRow(0, new Object[]{Consultation1.getLicence(),Consultation1.getName(),Consultation1.getSurname(),Consultation1.getMobileNumber(), Consultation1.getDate(), Consultation1.getTime(), Consultation1.getNote(),
                    Consultation1.getCost(), Consultation1.getSpecialisation(), Consultation1.getDoctorNo(),Consultation1.getImage()});
        }

        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
        table.setRowSorter(sorter);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);


        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Search patient ID");
        panel.add(label, BorderLayout.WEST);
        final JTextField filterText = new JTextField("");
        panel.add(filterText, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        table.getTableHeader().setBackground(Color.PINK);
        JButton b1 = new JButton("Find the patient");
        Font  font  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 15);
        b1.setBackground(Color.red);
        b1.setBounds(50,100,60,30);
        Border whiteline = BorderFactory.createLineBorder(Color.white);
        Border compound;
        table.setBackground(new Color(0x98FB98));
        b1.setForeground(Color.white);
        b1.setFont(font);
        b1.setBorder(whiteline);
        table.setBackground(new Color(0xB2E29D));


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = filterText.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                }
            }
        });
        frame.add(b1, BorderLayout.SOUTH);



        frame.setSize(1200, 800);
        frame.setVisible(true);
    }
}


