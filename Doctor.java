package Company;

import java.util.Comparator;

public class Doctor extends Person {
    private String specialisation;
    private String licence;


    /*constructor for add driver method*/
    public Doctor(String name, String mobileNum, String dob, String licence, String Surname, String specialisation) {
        super(name, mobileNum, dob, Surname);
        this.licence = licence;
        this.specialisation = specialisation;
    }


    /*getters and setters*/
    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    //create to string
    public String toString() {
        return super.toString() + specialisation + '\'' +
                licence + '\''
                ;
    }
}
