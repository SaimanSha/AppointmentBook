public class AppointmentBook {
    /** 
     * Stores the values of the available minutes in each period in one day.
    */
    private boolean[][] minutes = new boolean[8][60]; // temp fix
    
    /**git
        * Returns true if minute in period is available for an appointment and returns
        * false otherwise
        * Preconditions: 1 <= period <= 8; 0 <= minute <= 59
    */
    private boolean isMinuteFree(int period, int minute) {
        return minutes[period-1][minute] == true;
    }

    /**
        * Marks the block of minutes that starts at startMinute in period and
        * is duration minutes long as reserved for an appointment
        * Preconditions: 1 <= period <= 8; 0 <= startMinute <= 59;
        * 1 <= duration <= 60
    */
    private void reserveBlock(int period, int startMinute, int duration) {
        for (int m = startMinute; m < startMinute + duration; m ++) {
            minutes[period-1][m] = false;
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
        for (int m = 0; m < 60-duration; m++) {
            if (isMinuteFree(period, m)) {
                hold = m;
                boolean Truth = true;
                for (int n = m; n < m + duration; n++) {
                    if (isMinuteFree(period, n) != true) {Truth = false;}
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
        for (int P = startPeriod; P <= endPeriod; P++) {
            int op = findFreeBlock(P, duration);
            if (op != -1) {
                reserveBlock(P, op, duration);
                return true;
            }
        }
        return false;
    }



    
        // The functions below are used for testing purposes.
    
    public void Schedule(int[][] schedule, int pd) {
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][2] == 1) {
                for (int j = schedule[i][0]; j <= schedule[i][1]; j++) {
                    minutes[pd-1][j] = true;
                }
            }
        }
    }

    public void printSchedule(int pd) {
        for (int i = 0; i < 4; i++) {
            if (i == 0) System.out.print("Minutes 00-14: ");
            else System.out.print("Minutes " + (i*15) + "-" + (i*15+14) + ": ");
            for (int j = 0; j < 15; j++) {
                String s = "O";
                if (this.isMinuteFree(pd, i*15+j)) s = "*";
                System.out.print(" | " + s);
            }
            System.out.println(" | ");
        }
    }

    public void printEntireDay() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Period " + (i+1) + ": ");
            printSchedule(i+1);
            System.out.println();
        }
    }
}