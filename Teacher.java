import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Teacher {
    public static Teacher[] staffList = new Teacher[100];
    private AppointmentBook scheduler = new AppointmentBook();

    /**
     * Precondition: 0 < ID < 101
     * @param number
     * @throws FileNotFoundException
     */
    public Teacher(int ID) throws FileNotFoundException {
        File directory = new File("schedules.txt");
        Scanner scanner = new Scanner(directory);
        for (int i = 0; i < (ID-1) * 9; i++){
            scanner.nextLine();
        }
        //System.out.println(scanner.nextLine());
        for (int p = 0; p < 8; p++) {

        }

    }
}
