import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student {
    private int Teach = 0;
    private int start = 0;
    private int end = 0;
    private int length = 0;

    public Student(int ID) throws FileNotFoundException {
        File directory = new File("requests.txt");
        Scanner scanner = new Scanner(directory);
        for (int x = 0; x < ID-1; x++) scanner.nextLine();
        String str = scanner.nextLine();
        scanner.close();

        int[] parts = new int[4];
        int c = 0;
        while (str.contains(" ")) {
            int pos = str.indexOf(" ");
            String part = str.substring(0, pos);
            str = str.substring(pos + 1);
            parts[c] = Integer.parseInt(part);
            c++;
        }
        this.Teach = parts[0];
        this.start = parts[1];
        this.end = parts[2];
        this.length = Integer.parseInt(str);
    }

    public Student(String str) {
        int[] parts = new int[4];
        int c = 0;
        while (str.contains(" ")) {
            int pos = str.indexOf(" ");
            String part = str.substring(0, pos);
            str = str.substring(pos + 1);
            parts[c] = Integer.parseInt(part);
            c++;
        }
        this.Teach = parts[0];
        this.start = parts[1];
        this.end = parts[2];
        this.length = Integer.parseInt(str);
    }

    public Student(int Teach, int start, int end, int length) {
        this.Teach = Teach;
        this.start = start;
        this.end = end;
        this.length = length;
    }
    
    public int getTeach() { return this.Teach; }
    public int getStart() { return this.start; }
    public int getEnd() { return this.end; }
    public int getLength() { return this.length; }
    public void printInfo() {System.out.println("Teacher ID: " + Teach + "; Request Info: " + start + ", " + end + ", " + length);}
}
