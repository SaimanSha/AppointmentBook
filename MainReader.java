import java.io.FileNotFoundException;

public class MainReader {
    public static void main(String[] args) throws FileNotFoundException {
        Student s1 = new Student(12);
        Teacher t1 = new Teacher(s1.getTeach());
        s1.printInfo();
        t1.getSchedule().printEntireDay();
        System.out.println(Teacher.scheduleStudent(s1));


        /* while (ReScan.hasNextLine()) {
            String line = ReScan.nextLine();
            Student student = new Student(line);
            int ide = student.getTeach();
        }
        */
    }
}
