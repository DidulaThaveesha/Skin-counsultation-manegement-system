package Company;

import  java.awt.*;
import java.util.Scanner;
import static Company.WestminsterSkinConsultationManager.tempdoctornames;
public class ConsoleMenu {
    /*Create a object in WestminsterSkinConsultationManager class*/
    static WestminsterSkinConsultationManager westministerSkinCareConsultataion=new WestminsterSkinConsultationManager();
    static GUImain gui = new GUImain();



    public static void menu() {
        System.out.println("..........Doctors menu...............");
        System.out.println("_____________________________________");
        System.out.println("Press 1 :Add a Doctor");
        System.out.println("Press 2 :Delete doctor");
        System.out.println("Press 3 :Display list of doctors and specialisation");
        System.out.println("Press 4 :Save &load files");
        System.out.println("Press 5 :GUI menu");
        System.out.println("Press 6 :Exist");
        System.out.println("------------------------------------");
        System.out.print("Enter the Number :-");
    }

    Scanner input = new Scanner(System.in);

    public void menulsit_for_Functionalities() throws FontFormatException {


        menu();
        String instruction;
        instruction = input.next();
        while (instruction!="6") {
            if (instruction.equals("1")) {
                doctorinput();   /*calling method for add Doctors*/
                menulsit_for_Functionalities();

            } else if (instruction.equals("2")) {
                deleteinput();/*call methods for delete Doctors*/
                menulsit_for_Functionalities();

            }  else if (instruction.equals("3")) {
                westministerSkinCareConsultataion.displayDoctors();/*calling method for view Doctors*/
                menulsit_for_Functionalities();
            }  else if (instruction.equals("4")) {
                westministerSkinCareConsultataion.saveDoctordeatails();/*calling method for save&load Doctors*/
                menulsit_for_Functionalities();
            }  else if (instruction.equals("6")) {
                exit();
            }  else if (instruction.equals("5")) {
                gui.menu();   /*calling method for GUI part*/
                menulsit_for_Functionalities();

            }
            else {
                System.out.println("Wrong Input");
                menulsit_for_Functionalities();
            }
        }


    }
//add doctor method
    private void doctorinput() {
        System.out.print("Enter Doctor licence Number:");

        String licence=input.next();


        while (true) {
            int name1 = 0;
            for (Doctor doctor : WestminsterSkinConsultationManager.Doctors) {
                if (doctor.getLicence().equals(licence)) {
                    name1 = 1;
                    break;
                }
            }
            if (name1 == 1) {
                System.out.println("This doctor is duplicated");
                System.out.print("Reenter licence Number:");
                licence = input.next();

            } else {
                break;
            }
        }
        String name;
        System.out.print("Enter Doctor's name:");
        name = input.next();
        try{
        while (!name.matches("^[a-zA-Z]+$")){
            System.out.println("Invalid Input");
            System.out.print("Enter Doctor's name:");
            name = input.next();
        }
    }catch(Exception e){
        System.out.println(e.toString());
    }

        while (true) {
            int name1 = 0;
            for (Doctor doctor : WestminsterSkinConsultationManager.Doctors) {
                if (doctor.getName().equals(name)) {
                    name1 = 1;
                    break;
                }
            }
            if (name1 == 1) {
                System.out.println("This doctor is duplicated");
                System.out.print("Reenter the name:");
                name = input.next();

            } else {
                break;
            }
        }
        System.out.print("Enter Doctor's Sure name:");
        String Surname=input.next();
        try{
            while (!Surname.matches("^[a-zA-Z]+$")){
                System.out.println("Invalid Input");
                System.out.print("Enter Doctor's surname:");
                Surname = input.next();
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        while (true) {
            int name1 = 0;
            for (Doctor doctor : WestminsterSkinConsultationManager.Doctors) {
                if (doctor.getSurname().equals(Surname)) {
                    name1 = 1;
                    break;
                }
            }
            if (name1 == 1) {
                System.out.println("This doctor is duplicated");
                System.out.print("Reenter surname:");
                Surname = input.next();

            } else {
                break;
            }
        }
        System.out.print("Enter Doctor's mobile number:");
        String mobilenumber=input.next();
        System.out.print("Enter Doctor date of birth:");
        String dob=input.next();
        System.out.print("Enter Doctor Specification:");
        String specilisation=input.next();
        Doctor d1=new Doctor(name,mobilenumber,dob,licence,Surname,specilisation);
        westministerSkinCareConsultataion.addDoctor(d1);
        tempdoctornames.add(Surname);
    }
//delete doctor method
    private void deleteinput(){
        String delete_name;
        System.out.print("Enter Doctor's licence Number:");
        delete_name = input.next();
        while (true) {
            int samename = 0;
            for (Doctor doctor : WestminsterSkinConsultationManager.Doctors) {
                if (doctor.getLicence().equals(delete_name)) {
                    samename = 1;
                    break;
                }
            }
            if (!(samename ==1)) {
                System.out.println("No similar licence number.");
                System.out.print("Reenter number:");
                delete_name=input.next();

            }
            else {
                break;
            }

        }

        /*calling delete method*/
        westministerSkinCareConsultataion.deleteDoctor(delete_name);
    }
    /*exit method*/
    public void exit(){
        System.out.println("Program Exited...");
        System.exit(-1);

    }
}

//Reference for The exception made for not being able to put numbers in a name-https://stackoverflow.com/questions/14961890/java-detecting-if-a-variable-is-a-string-or-an-integer