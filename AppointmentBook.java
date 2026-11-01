public class AppointmentBook {
    /** 
     * Stores the values of the available minutes in each period in one day.
    */
    private static boolean[][] minutes = new boolean[8][60];
    
    /**git
        * Returns true if minute in period is available for an appointment and returns
        * false otherwise
        * Preconditions: 1 <= period <= 8; 0 <= minute <= 59
    */
    private boolean isMinuteFree(int period, int minute) {
        return minutes[period-1][minute];
    }

    /**
        * Marks the block of minutes that starts at startMinute in period and
        * is duration minutes long as reserved for an appointment
        * Preconditions: 1 <= period <= 8; 0 <= startMinute <= 59;
        * 1 <= duration <= 60
    */
    private void reserveBlock(int period, int startMinute, int duration) {
        for (int m = startMinute; m <= startMinute + duration; m ++) {
            minutes[period-1][m] = true;
        }
    }
 
    /**
        * Searches for the first block of duration free minutes during period, as described in
        * part (a). Returns the first minute in the block if such a block is found or returns -1 if no
        * such block is found.
        * Preconditions: 1 <= period <= 8; 1 <= duration <= 60
    */
    public int findFreeBlock(int period, int duration) {
        int hold;
        for (int m = 0; m <= 59; m++) {
            if (isMinuteFree(period-1, m)) {
                hold = m;
                boolean Truth = true;
                for (int n = m; n <= m + duration; n++) {
                    if (isMinuteFree(period-1, n)) {Truth = false;}
                }
                if (Truth) {return hold;}
            }
        }
        return -1;
    }

    /**
        * Searches periods from startPeriod to endPeriod, inclusive, for a block
        * of duration free minutes, as described in part (b). If such a block is found,
        * calls reserveBlock to reserve the block of minutes and returns true; otherwise
        * returns false.
        * Preconditions: 1 <= startPeriod <= endPeriod <= 8; 1 <= duration <= 60
    */
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        for (int P = startPeriod-1; P <= endPeriod-1; P++) {
            int op = findFreeBlock(P, duration);
            if (op != 1) {
                reserveBlock(P+1, op, duration);
                return true;
            }
        }
        return false;
    }

        // The functions below are used for testing purposes.
    
    public static void Schedule(int[][] schedule, int pd) {
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][2] == 1) {
                for (int j = schedule[i][0]; j < schedule[i][1]; j++) {
                    minutes[pd][j] = true;
                }
            }
        }
    }

    public static void printSchedule(int pd) {
        for (int i = 0; i < 60; i++) {
            System.out.print(minutes[pd][i] + ", ");
        }
        System.out.println();
    }
}