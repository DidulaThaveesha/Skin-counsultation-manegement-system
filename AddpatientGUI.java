package Company;

import javax.crypto.SecretKey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.security.MessageDigest;


import static Company.Consultation.*;
import static Company.WestminsterSkinConsultationManager.Doctors;


public class AddpatientGUI {
    private static final String UNICODE_FORMAT = "UTF-8";

// object for calling consultation class
    static Consultation counsultataion = new Consultation();
    //variable
    String encrypteddetails= null;


    AddpatientGUI() {
        //labels & Buttons
        JFrame frame = new JFrame("Patient Consultation");
        JPanel panel =new JPanel();
        frame.setSize(1200, 675);
        frame.add(panel);

        panel.setLayout(new GridLayout(13, 2, 10, 10));
        panel.setBackground(new Color(0xB2E29D));


        JLabel label5 = new JLabel("Patient id: " );
        panel.add(label5);
        JTextField PatientId = new JTextField(20);
        panel.add(PatientId);

        JLabel label1 = new JLabel("Patient's First name: ");
        panel.add(label1);
        JTextField fName = new JTextField(20);
        panel.add(fName);

        JLabel label2 = new JLabel("Patient's Sure name: ");
        panel.add(label2);
        JTextField sName = new JTextField(20);
        panel.add(sName);

        JLabel label3 = new JLabel("Patient's Date of birth: ");
        panel.add(label3);
        JTextField dob = new JTextField(20);
        panel.add(dob);

        JLabel label4 = new JLabel("Patient's mobile number: ");
        panel.add(label4);
        JTextField mob = new JTextField(20);
        panel.add(mob);

        JLabel label6 = new JLabel("Date: ");
        panel.add(label6);
        JTextField date = new JTextField(20);
        panel.add(date);

        JLabel label7 = new JLabel("Time: ");
        panel.add(label7);
        JTextField time = new JTextField(50);
        panel.add(time);

        JLabel label8 = new JLabel("Patient's Note: ");
        panel.add(label8);
        JTextArea note = new JTextArea(5,15);
        panel.add(note);

        JLabel label10 = new JLabel("Specification: ");
        panel.add(label10);
        JTextField Specification = new JTextField(20);
        panel.add(Specification);

        JLabel label11 = new JLabel("Doctor licence no: ");
        panel.add(label11);
        JTextField doctor = new JTextField(20);
        panel.add(doctor);

        JLabel label9 = new JLabel("Cost: ");
        panel.add(label9);
        JTextField cost = new JTextField(20);
        panel.add(cost);


        /*Buttons*/

        JButton button3 = new JButton("encrypt data");
        panel.add(button3);

        JButton button1 = new JButton("Upload");
        panel.add(button1);
        JLabel label12 = new JLabel();
        label12.setSize(100,200);
        panel.add(label12);

        JButton button = new JButton("Submit...");
        panel.add(button);



/*Action listener for the button 3*/
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genarateKey();
                note.setText(encrypteddetails);
                label12.setText(encrypteddetails);
            }
        });

        //Actions for the submit button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = fName.getText();
                String surname = sName.getText();
                String date_of_birth = dob.getText();
                String mobile_num = mob.getText();
                String date1 = date.getText();
                String time1 = time.getText();
                String note1 = note.getText();
                String Speci1 = Specification.getText();
                String doc1 = doctor.getText();
                String licence1 = PatientId.getText();
                String picture1 = label12.getText();

            //add user inputs in to the consultation array
                Patient p1 = new Patient(licence1, name, surname, date_of_birth, mobile_num);
                counsultataion.addpatataion(p1);
                int count = p1.getCount();
                p1.setCount(count + 1);

                //Check the patient is duplicated or not!

                int same_team = 0;
                if (tempListforcost.size() >= 1) {
                    for (Company.Patient ignored : Addpatient) {

                        if (tempListforcost.contains(ignored.getID())) {
                            same_team = 2;
                        } else {
                            same_team = 1;
                        }

                    }
                    tempListforcost.add(String.valueOf(licence1));


                } else {
                    same_team = 1;
                    tempListforcost.add(String.valueOf(licence1));
                }

                String pcost = " ";
                if (same_team == 1) {
                    cost.setText("15");
                    pcost = cost.getText();


                } else if (same_team == 2) {
                    cost.setText("25");

                    pcost = cost.getText();

                }

                Consultation c1 = new Consultation(licence1, name, surname, date_of_birth, mobile_num, date1, time1, note1, pcost, doc1, Speci1,picture1);
                counsultataion.addConsultataion(c1);

                //if doctor is not available assigning another doctor

                int same_team1 = 0;
                if (tempListforcheckdoctoravailability.size() >= 1) {
                    for (Company.Consultation ignored : consultate) {

                        if (tempListforcheckdoctoravailability.contains(ignored.getDate()) && tempListforcheckdoctoravailability.contains(ignored.getTime()) && tempListforcheckdoctoravailability.contains(ignored.getDoctorNo())) {
                            same_team1 = 2;

                        } else {
                            same_team1 = 1;
                        }

                    }
                    tempListforcheckdoctoravailability.add(doc1);
                    tempListforcheckdoctoravailability.add(date1);
                    tempListforcheckdoctoravailability.add(time1);
                    tempListforcheckdoctoravailability.add(Speci1);
                    tempListforencription.add(note1);
                    tempListforencription.add(String.valueOf(label2));

                } else {

                    same_team1 = 1;
                    tempListforcheckdoctoravailability.add(doc1);
                    tempListforcheckdoctoravailability.add(date1);
                    tempListforcheckdoctoravailability.add(time1);
                    tempListforcheckdoctoravailability.add(Speci1);
                    tempListforencription.add(note1);
                    tempListforencription.add(String.valueOf(label2));
                }

                if (same_team1 == 1) {

                } else if (same_team1 == 2) {


                    for (Company.Consultation ignored : consultate) {

                        for (int i = 0; i < Doctors.size(); i++) {

                            if (Doctors.get(i).getSpecialisation().equals(ignored.getSpecialisation())) {


                                if (!Doctors.get(i).getLicence().equals(ignored.getDoctorNo())) {

                                    if (tempListforcheckdoctoravailability.contains(ignored.getDate()) && tempListforcheckdoctoravailability.contains(ignored.getTime())) {

                                        doctor.setText(Doctors.get(i).getLicence());
                                    }
                                }
                            }
                        }

                    }
                }
            }
        });
//add photo button
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filer = new FileNameExtensionFilter(" *.Image","jpg","gif"+"png");
                file.addChoosableFileFilter(filer);
                int result = file.showSaveDialog(null);
                if(result ==JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    label12.setIcon(ResizeImage(path));
                } else if (result==JFileChooser.CANCEL_OPTION ) {
                    System.out.println("No file found");

                }

            }
        });


        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    /*------------------------------------ add picture -----------------------------------*/
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(100,700,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;

    }

    /*------------------------------------ encryption data-----------------------------------*/

    public  SecretKey genarateKey(){
        String details = String.valueOf(tempListforencription);

        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(details.getBytes());


            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            encrypteddetails = s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        /* Display the unencrypted and encrypted passwords. */

        System.out.println("Encrypted code: " + encrypteddetails);


        return null;
    }


}


//reference:-https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
//java encription-https://www.section.io/engineering-education/implementing-aes-encryption-and-decryption-in-java/
//image adding-https://www.codespeedy.com/how-to-add-an-image-in-jframe/#:~:text=Firstly%2C%20we%20create%20a%20JLabel,is%20null%2C%20nothing%20is%20displayed.