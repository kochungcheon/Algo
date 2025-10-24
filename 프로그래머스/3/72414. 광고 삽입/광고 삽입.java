class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = convertSec(play_time);
        int advSec = convertSec(adv_time);

        int[] times = new int[playSec + 2];
        for (String log : logs) {
            String[] se = log.split("-");
            times[convertSec(se[0])]++;
            times[convertSec(se[1])]--;
        }

        for (int i = 1; i <= playSec; i++)
            times[i] += times[i - 1];

        long[] prefix = new long[playSec + 2];
        for (int i = 1; i <= playSec; i++)
            prefix[i] = prefix[i - 1] + times[i];

        long max = prefix[advSec];
        int advStart = 0;

        for (int i = advSec + 1; i <= playSec; i++) {
            long current = prefix[i] - prefix[i - advSec];
            if (current > max) {
                max = current;
                advStart = i - advSec + 1;
            }
        }

        return secToTime(advStart);
    }

    private int convertSec(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 3600 +
               Integer.parseInt(t[1]) * 60 +
               Integer.parseInt(t[2]);
    }

    private String secToTime(int sec) {
        int h = sec / 3600;
        int m = (sec % 3600) / 60;
        int s = sec % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
