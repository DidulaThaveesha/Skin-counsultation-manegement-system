package Company;

import java.awt.*;
import java.io.IOException;


public class Main {

    public static void main(String args[]) throws IOException, FontFormatException {


        WestminsterSkinConsultationManager westmin = new WestminsterSkinConsultationManager();
        westmin.LoadDoctorDeatails();/*recover data*/
        ConsoleMenu console = new ConsoleMenu();
        console.menulsit_for_Functionalities(); /*Calling console method to show option*/
        new GUImain(); /*calling main interface*/


    }
}

