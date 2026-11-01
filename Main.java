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

        AppointmentBook.Schedule(sample, 1);
        AppointmentBook.printSchedule(1);
        AppointmentBook.findFreeBlock(2, 15);
    }
}