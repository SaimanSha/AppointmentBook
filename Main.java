public class Main {
    public static void main(String[] args) {
        int[][] sample = {
            {0, 9, 0},
            {10, 14, 1},
            {15, 29, 0},
            {30, 44, 1},
            {45, 49, 0},
            {50, 59, 1}
        };
        AppointmentBook Book1  = new AppointmentBook();
        Book1.Schedule(sample, 2);
        Book1.printSchedule(2);

        System.out.println(Book1.findFreeBlock(2, 15));
        System.out.println(Book1.findFreeBlock(2, 9));
        System.out.println(Book1.findFreeBlock(2, 20));
        System.out.println();


        int [][] sample2 = { {0, 24, 0}, {25, 29, 1}, {30, 59, 0} };
        int [][] sample3 = { {0, 14, 1}, {15, 40, 0}, {41, 59, 1} };
        int [][] sample4 = { {0, 4, 0}, {5, 29, 1}, {30, 43, 0}, {44, 59, 1} };
        AppointmentBook Book2  = new AppointmentBook();
        Book2.Schedule(sample2, 2);
        Book2.Schedule(sample3, 3);
        Book2.Schedule(sample4, 4);
        Book2.printEntireDay();

        System.out.println(Book2.makeAppointment(2, 4, 22));
        System.out.println(Book2.makeAppointment(3, 4, 3));
        System.out.println(Book2.makeAppointment(2, 4, 30));
        System.out.println();
        Book2.printEntireDay();
    }
}