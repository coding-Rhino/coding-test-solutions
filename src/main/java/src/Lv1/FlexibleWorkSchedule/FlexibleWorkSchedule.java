package src.Lv1.FlexibleWorkSchedule;

public class FlexibleWorkSchedule {
    public static void main(String[] args) {
        int[] schedules1 = {700, 800, 1100};
        int[][] timelogs1 = {
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        int startday1 = 5;
        System.out.println(solution(schedules1, timelogs1, startday1));

        int[] schedules2 = {730, 855, 700, 720};
        int[][] timelogs2 = {
                {710, 700, 650, 735, 700, 931, 912},
                {908, 901, 805, 815, 800, 831, 835},
                {705, 701, 702, 705, 710, 710, 711},
                {707, 731, 859, 913, 934, 931, 905}
        };
        int startday2 = 1;
        System.out.println(solution(schedules2, timelogs2, startday2));
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        int[] maxSchedules = new int[schedules.length];
        boolean islate = false;

        for (int employee = 0; employee < maxSchedules.length; employee++) {
            if ((schedules[employee] + 10) % 100 >= 60) {
                maxSchedules[employee] = schedules[employee] + 100 - 60;
            } else {
                maxSchedules[employee] = schedules[employee];
            }
        }

        for (int time = 0; time < timelogs.length; time++) {
            int currentday = startday;
            for (int employee = 0; employee < timelogs[time].length; employee++) {
                if (currentday != 6 && currentday != 7) {
                    if (timelogs[time][employee] > maxSchedules[time] + 10) {
                        islate = true;
                        break;
                    }
                }
                currentday++;
                if (currentday > 7) {
                    currentday %= 7;
                }
            }
            if (!islate) {
                answer++;
            }
            islate = false;
        }

        return answer;
    }
}
