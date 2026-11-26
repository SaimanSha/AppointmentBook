import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Teacher {
    public static Teacher[] staffList = new Teacher[100];
    private AppointmentBook scheduler = new AppointmentBook();
    private int ID;

    /**
     * Precondition: 0 < ID < 100
     * @param number
     * @throws FileNotFoundException
     */
    public Teacher(int ID) throws FileNotFoundException {
                                                                    int n7 = 0;
        this.ID = ID-1;
        File directory = new File("schedules.txt");
        Scanner scanner = new Scanner(directory);
        for (int i = 0; i < (this.ID) * 9; i++) {
            scanner.nextLine();
            n7++;
        }
                                                                    System.out.println("Line: " + n7);
        for (int p = 1; p <= 8; p++) {
            String line = scanner.nextLine();
                                                                    System.out.println(line);
            this.scheduler.Schedule(line, p);
        }
        Teacher.staffList[ID] = this;
        scanner.close();
    }

    public static boolean teacherIdentified(int ID) {
        return (Teacher.staffList[ID] != null); }

    public static boolean scheduleStudent(Student student) throws FileNotFoundException {
        int ID = student.getTeach();
        Teacher Prof;
        if (teacherIdentified(ID)) {
            Prof = staffList[ID];
        } else {
            Prof = new Teacher(ID);
        }
        int start = student.getStart();
        int end = student.getEnd();
        int len = student.getLength();
        AppointmentBook AP = Prof.scheduler;
        return AP.makeAppointment(start, end, len);
    }

    public AppointmentBook getSchedule() {
        return this.scheduler; }
}


