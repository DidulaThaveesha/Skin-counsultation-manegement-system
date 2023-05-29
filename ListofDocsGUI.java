package Company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static Company.WestminsterSkinConsultationManager.Doctors;


public class ListofDocsGUI extends JFrame{

    private JTable table;
    private JScrollPane scrollPane;

    public ListofDocsGUI() {
        /*create table and append a doctors for the table*/
        setTitle("List oF Doctors ");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Doctor Id");
        tableModel.addColumn("First Names");
        tableModel.addColumn("Sure name");
        tableModel.addColumn("specialisation");
        tableModel.addColumn("Mobile Number");
        tableModel.addColumn("DOB");

        for (Doctor doctor : Doctors) {
            tableModel.insertRow(0, new Object[]{doctor.getLicence(), doctor.getName(), doctor.getSurname(), doctor.getSpecialisation(), doctor.getMobileNumber(),
                    doctor.getDob()});
        }

        //table for dia-mentions
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        table.setAutoCreateRowSorter(true); // sorting of the rows on a particular column
        add(scrollPane, BorderLayout.CENTER);
        table.setBackground(new Color(0xB2E29D));
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


