package Company;

import java.io.FileNotFoundException;


/*Create a interface call methods that in WestminsterSkinConsultationManager */
public interface SkinConsultationManager {
    void addDoctor(Doctor doctor );
    void deleteDoctor(String remove);
    void displayDoctors();
    void saveDoctordeatails();
    void LoadDoctorDeatails() throws FileNotFoundException;

}

