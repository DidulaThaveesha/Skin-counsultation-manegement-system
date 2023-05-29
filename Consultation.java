package Company;

import java.util.ArrayList;

public class Consultation {
    /*array lists for store objects*/
    static ArrayList<Patient> Addpatient = new ArrayList<Patient>();
    static ArrayList<Consultation> consultate = new ArrayList<Consultation>();
    static  ArrayList <String> tempListforcost = new ArrayList<String >();
    static  ArrayList <String> tempListforcheckdoctoravailability = new ArrayList<String >();
    static  ArrayList <String> tempListforencription = new ArrayList<String >();


    /*variables*/
    String date;
    String time;
    String cost;
    String note;


    /*get the doctors and patients Information*/
    String doctorNo;
    String specialisation;
    String licence;
    String name;
    String Surname;
    String mobileNumber;
    String dob;
    String image;



    public Consultation() {

    }
//create a constructor
    public Consultation(String licence, String name, String Surname, String mobileNum, String dob, String date, String time, String note, String cost, String doc, String specialisation, String image) {
        this.licence =licence;
        this.name = name;
        this.Surname = Surname;
        this.dob=dob;
        this.mobileNumber=mobileNum;
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.note = note;
        this.doctorNo = doc;
        this.specialisation=specialisation;
        this.image =image;
    }



    /*getter and setter methosd*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void addpatataion(Patient patatio) {
        Addpatient.add(patatio);

    }
    //create a method for add a consultation
    public void addConsultataion(Consultation Consultation) {
        consultate.add(Consultation);
    }


    @Override
    public String toString() {
        return
                date + '\'' +
                        time + '\'' +
                        cost + '\'' +
                        note + '\'' +

                        doctorNo + '\'' +
                        specialisation + '\'' +
                        licence + '\'' +
                        name + '\'' +
                        Surname + '\'' +
                        mobileNumber + '\'' +
                        dob + '\'' +
                        image
                ;
    }
}

