package src.Lv2;

public class AnalogClock {

    public static void main(String[] args) {

        int[][] testCases = {
                {0, 5, 30, 0, 7, 0},
                {12, 0, 0, 12, 0, 30},
                {0, 6, 1, 0, 6, 6},
                {11, 59, 30, 12, 0, 0},
                {11, 58, 59, 11, 59, 0},
                {1, 5, 5, 1, 5, 6},
                {0, 0, 0, 23, 59, 59}
        };

        for (int[] testCase : testCases) {
            int h1 = testCase[0], m1 = testCase[1], s1 = testCase[2];
            int h2 = testCase[3], m2 = testCase[4], s2 = testCase[5];

            int result = solution(h1, m1, s1, h2, m2, s2);

            System.out.println("result: " + result);
        }
    }

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        double hAngle = 0;
        double mAngle = 0;
        double sAngle = 0;
        int hCount = 0;
        int mCount = 0;
        int noon = 0;



        hAngle = (h1 % 12) * 30 + m1 * 0.5 + s1 * 0.05 / 6;
        mAngle = m1 * 6 + s1 * 0.1;
        sAngle = s1 * 6;

        int second = (h2 - h1) * 60 * 60 + (m2 - m1) * 60 + (s2 - s1);

        for (int i = 1; i <= second; i++) {
            if (sAngle < hAngle) {
                hAngle = hAngle + 0.05 / 6;
                if((int)((hAngle % (int)hAngle) * 100) == 49 || (int)((hAngle % (int)hAngle) * 100) == 99){
                    hAngle = hAngle * 100.0;
                    hAngle = Math.round(hAngle) / 100.0;
                }
                mAngle = mAngle + 0.1;
                mAngle = mAngle * 10.0;
                mAngle = Math.round(mAngle) / 10.0;
                sAngle = sAngle + 6;
                if (sAngle >= hAngle) {
                    if (hAngle >= 360) {
                        hAngle -= 360;
                        answer --;
                    }
                    if (mAngle >= 360) {
                        mAngle -= 360;
                    }
                    if (sAngle >= 360) {
                        sAngle -= 360;
                    }
                    hCount++;
                }
                hAngle = hAngle - 0.05 / 6;
                mAngle = mAngle - 0.1;
                sAngle = sAngle - 6;
            }
            if (sAngle < mAngle) {
                hAngle = hAngle + 0.05 / 6;
                if((int)((hAngle % (int)hAngle) * 100) == 49 || (int)((hAngle % (int)hAngle) * 100) == 99){
                    hAngle = hAngle * 100.0;
                    hAngle = Math.round(hAngle) / 100.0;
                }
                mAngle = mAngle + 0.1;
                mAngle = mAngle * 10.0;
                mAngle = Math.round(mAngle) / 10.0;
                sAngle = sAngle + 6;
                if (sAngle >= mAngle) {
                    if (hAngle >= 360) {
                        hAngle -= 360;
                        answer --;
                    }
                    if (mAngle >= 360) {
                        mAngle -= 360;
                    }
                    if (sAngle >= 360) {
                        sAngle -= 360;
                    }
                    mCount++;
                }
                hAngle = hAngle - 0.05 / 6;
                mAngle = mAngle - 0.1;
                sAngle = sAngle - 6;
            }
            hAngle = hAngle + 0.05 / 6;
            if((int)((hAngle % (int)hAngle) * 100) == 49 || (int)((hAngle % (int)hAngle) * 100) == 99){
                hAngle = hAngle * 100.0;
                hAngle = Math.round(hAngle) / 100.0;
            }
            mAngle = mAngle + 0.1;
            mAngle = mAngle * 10.0;
            mAngle = Math.round(mAngle) / 10.0;
            sAngle = sAngle + 6;
            if (hAngle >= 360) {
                hAngle -= 360;
            }
            if (mAngle >= 360) {
                mAngle -= 360;
            }
            if (sAngle >= 360) {
                sAngle -= 360;
            }
            if (mAngle == 0 && hAngle == 0) {
                noon++;
            }
        }
        answer = hCount + mCount - noon;

        if (m1 == 0 && s1 == 0) {
            answer++;
        }
        return answer;
    }
}
