package Company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class WestminsterSkinConsultationManager implements SkinConsultationManager,Serializable {
    /*cretead a array list call doctornames to add all data*/
    static ArrayList<Doctor> Doctors = new ArrayList<>();
    /*collect sorting data*/
    static ArrayList<String> tempdoctornames = new ArrayList<String>();

    /*save files*/
    private File table=new File("file.txt");




    /*Counting maximum doctors */
    static int no_of_doctors=10;
    Scanner input = new Scanner(System.in);

    /*---------------------------Add Doctor method-----------------------------------*/
    @Override
    public void addDoctor(Doctor doctor) {
        if(no_of_doctors==Doctors.size()){
            System.out.println("All the Doctors that can be put have been put.");
        }

        else {
            Doctors.add(doctor);

            no_of_doctors=-1;
        }
    }
    /*---------------------------delete Doctor method-----------------------------------*/
    @Override
    public void deleteDoctor(String remove) {
        if (Doctors.size() == 0) {
            System.out.println("There are no more doctors");
        } else {
            for (int x = 0; x < Doctors.size(); x++){
                if (Doctors.get(x).getLicence().equals(remove)){
                    System.out.println(" Doctors are Deleted");
                    Doctors.remove(x);

                    no_of_doctors=+1;
                    break;
                }
            }
        }
    }

    /*---------------------------Print the list of the doctors-----------------------------------*/
    @Override
    public void displayDoctors() {

        String Table = "| %-14.8s   | %-14s| %-14.8s       | %-14.8s       | %-16.8s     | %-16.10s     | %n";
        System.out.format("________________________________________________________________________________________________________________________________%n");
        System.out.format("|Doctor First name |Doctor Surname |Doctor mobile number |Doctor licence number |Doctor  date of birth | Doctor Specialisation |%n");
        System.out.format("|+_________________|_______________|______________________|______________________|______________________|______________________|%n");
        Collections.sort(Doctors, Comparator.comparing(Person::getSurname));
        for (Doctor doctor:Doctors) {
            System.out.format(Table,doctor.getName(),doctor.getSurname(), doctor.getMobileNumber(),doctor.getLicence(),doctor.getDob(),doctor.getSpecialisation());
        }

    }

    /*---------------------------save data method-----------------------------------*/
    @Override
    public void saveDoctordeatails(){
        try {
            File tableStatFile = new File("file.txt");
            table.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ObjectOutputStream detailStore = new ObjectOutputStream(new FileOutputStream(table));
                if (Doctors.size() == 0) {
                    System.out.println("---------There are no doctors stored in the System.---------");
                } else {
                    detailStore.writeObject(Doctors);
                    System.out.println("---The Information You Provided Has Been Successfully Stored.---");
                }
                detailStore.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    /*---------------------------recover data method-----------------------------------*/
    @Override
    public void LoadDoctorDeatails() throws FileNotFoundException {
        try {
            File file = new File("file.txt");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ObjectInputStream recoverData = new ObjectInputStream(new FileInputStream(table));
                Doctors = (ArrayList<Doctor>) recoverData.readObject();
                recoverData.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.print("");
            }
        }

    }

}

//Reference sort method-:https://stackoverflow.com/questions/5815423/sorting-arraylist-in-alphabetical-order-case-insensitive
//https://beginnersbook.com/2013/12/how-to-sort-arraylist-in-java/