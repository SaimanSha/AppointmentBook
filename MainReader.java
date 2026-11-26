import java.io.FileNotFoundException;

public class MainReader {
    public static void main(String[] args) throws FileNotFoundException {
        int finalCount = 0;
        for (int i = 1; i <= 1000; i++) {
            Student s1 = new Student(12);
                // Teacher t1 = new Teacher(s1.getTeach());
            boolean TT = Teacher.scheduleStudent(s1);
            if (TT) {
                finalCount++;
                System.out.print("T ");
            } else System.out.print("F ");
        }
        System.out.println();
        System.out.println(finalCount);
    }
}
