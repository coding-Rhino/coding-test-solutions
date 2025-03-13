package src.Lv1.Uniform;

import java.util.*;

public class Uniform {
    public static void main(String[] args) {
        int[] nValues = {5, 5, 3};

        int[][] lostCases = {
                {2, 4},
                {2, 4},
                {3}
        };

        int[][] reserveCases = {
                {1, 3, 5},
                {3},
                {1}
        };

        for (int i = 0; i < nValues.length; i++) {
            int n = nValues[i];
            int[] lost = lostCases[i];
            int[] reserve = reserveCases[i];

            int result = solution(n, lost, reserve);
            System.out.println(result);
        }
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        Map<Integer, Integer> aroundCount = new HashMap<>();

        for (int i = 0; i < lost.length; i++) {
            lostList.add(lost[i]);
        }

        for (int i = 0; i < reserve.length; i++) {
            reserveList.add(reserve[i]);
        }

        for (int i = 0; i < lost.length; i++) {
            aroundCount.put(lost[i], 0);
        }

        answer = n - lost.length;

        for (int i = 0; i < lost.length; i++) {
            if (reserveList.contains(lost[i])) {
                answer++;
                lostList.remove(Integer.valueOf(lost[i]));
                reserveList.remove(Integer.valueOf(lost[i]));
                aroundCount.remove(lost[i]);
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (aroundCount.get(lost[i]) == null) {
                continue;
            }
            if (reserveList.contains(lost[i] - 1) && reserveList.contains(lost[i] + 1)) {
                aroundCount.put(lost[i], 2);
            } else if (reserveList.contains(lost[i] - 1) || reserveList.contains(lost[i] + 1)) {
                aroundCount.put(lost[i], 1);
            }
        }

        while (aroundCount.containsValue(1)) {
            for (int i = 0; i < lost.length; i++) {
                if (aroundCount.get(lost[i]) == null) {
                    continue;
                }
                if (aroundCount.get(lost[i]) == 1) {
                    if (lostList.contains(Integer.valueOf(lost[i]))) {
                        if (reserveList.contains(Integer.valueOf(lost[i] - 1))) {
                            answer++;
                            lostList.remove(Integer.valueOf(lost[i]));
                            reserveList.remove(Integer.valueOf(lost[i] - 1));
                            aroundCount.remove(lost[i]);
                        } else if (reserveList.contains(Integer.valueOf(lost[i] + 1))) {
                            answer++;
                            lostList.remove(Integer.valueOf(lost[i] + 1));
                            reserveList.remove(Integer.valueOf(lost[i] + 1));
                            aroundCount.remove(lost[i]);
                        }
                        for (int j = 0; j < lost.length; j++) {
                            if (!lostList.contains(Integer.valueOf(lost[j]))) {
                                continue;
                            }
                            if (reserveList.contains(Integer.valueOf(lost[j] - 1)) && reserveList.contains(Integer.valueOf(lost[j] + 1))) {
                                aroundCount.put(lost[j], 2);
                            } else if (reserveList.contains(Integer.valueOf(lost[j] - 1)) || reserveList.contains(Integer.valueOf(lost[j] + 1))) {
                                aroundCount.put(lost[j], 1);
                            } else {
                                aroundCount.put(lost[j], 0);
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i < lost.length; i++) {
            if (aroundCount.get(lost[i]) == null) {
                continue;
            }
            if (aroundCount.get(lost[i]) == 2) {
                if (lostList.contains(Integer.valueOf(lost[i]))) {
                    if (reserveList.contains(Integer.valueOf(lost[i] - 1))) {
                        answer++;
                        lostList.remove(Integer.valueOf(lost[i]));
                        reserveList.remove(Integer.valueOf(lost[i] - 1));
                        aroundCount.remove(lost[i]);
                    } else if (reserveList.contains(lost[i] + 1)) {
                        answer++;
                        lostList.remove(Integer.valueOf(lost[i] + 1));
                        reserveList.remove(Integer.valueOf(lost[i] + 1));
                        aroundCount.remove(lost[i]);
                    }
                    for (int j = 0; j < lost.length; j++) {
                        if (!lostList.contains(Integer.valueOf(lost[j]))) {
                            continue;
                        }
                        if (reserveList.contains(Integer.valueOf(lost[j] - 1)) && reserveList.contains(Integer.valueOf(lost[j] + 1))) {
                            aroundCount.put(lost[j], 2);
                        } else if (reserveList.contains(Integer.valueOf(lost[j] - 1)) || reserveList.contains(Integer.valueOf(lost[j] + 1))) {
                            aroundCount.put(lost[j], 1);
                        } else {
                            aroundCount.put(lost[j], 0);
                        }
                    }
                }
            }
            for (int k = 0; k < lost.length; k++) {
                if (aroundCount.get(lost[k]) == null) {
                    continue;
                }
                if (aroundCount.get(lost[k]) == 1) {
                    if (lostList.contains(Integer.valueOf(lost[k]))) {
                        if (reserveList.contains(Integer.valueOf(lost[k] - 1))) {
                            answer++;
                            lostList.remove(Integer.valueOf(lost[k]));
                            reserveList.remove(Integer.valueOf(lost[k] - 1));
                            aroundCount.remove(lost[k]);
                        } else if (reserveList.contains(Integer.valueOf(lost[k] + 1))) {
                            answer++;
                            lostList.remove(Integer.valueOf(lost[k] + 1));
                            reserveList.remove(Integer.valueOf(lost[k] + 1));
                            aroundCount.remove(lost[k]);
                        }
                        for (int j = 0; j < lost.length; j++) {
                            if (!lostList.contains(Integer.valueOf(lost[j]))) {
                                continue;
                            }
                            if (reserveList.contains(Integer.valueOf(lost[j] - 1)) && reserveList.contains(Integer.valueOf(lost[j] + 1))) {
                                aroundCount.put(lost[j], 2);
                            } else if (reserveList.contains(Integer.valueOf(lost[j] - 1)) || reserveList.contains(Integer.valueOf(lost[j] + 1))) {
                                aroundCount.put(lost[j], 1);
                            } else {
                                aroundCount.put(lost[j], 0);
                            }
                        }
                    }
                }
            }
        }


        return answer;
    }
}
