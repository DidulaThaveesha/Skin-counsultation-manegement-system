package Company;
import java.io.Serializable;

public abstract class Person implements Serializable{
    /*Create private variables*/
    private String name;
    private String Surname;
    private String mobileNumber;
    private String dob;

    /* Build Constructor for add method*/
    public Person(String name, String mobileNumber, String dob,String Surname) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.dob = dob;
        this.Surname=Surname;
    }


    /*Getter Setter for names*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*Getter Setter for mobile number*/

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
    /*Getter Setter for date of birth*/

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }




    @Override
    //create to string
    public String toString() {
        return
                name + '\'' +
                        Surname + '\'' +
                        mobileNumber + '\'' +
                        dob + '\''
                ;
    }
}

