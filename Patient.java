package Company;

public class Patient extends Person{
    private String ID;
    public int count;

    /*Constructors*/
    public Patient(String ID, String name, String Surname, String dob, String mobileNumber) {
        super(name, mobileNumber, dob,Surname);
        this.ID =ID;

    }

    /*getters&setters*/
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    //create to string
    public String toString()
    {
        return  ID ;
    }
}

