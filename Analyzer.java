import java.util.ArrayList;

public class Analyzer {
    private int[][] M;
    private String string1;
    private String string2;

    public int LCS(String s1, String s2) {
        // Assign class variables
        string1 = s1;
        string2 = s2;
        M = new int[s1.length()][s2.length()];
        int lcsLength = 0;
        int cur = 0;
        int bestI = 0, bestJ = 0;

        // Create memoized array
        for(int i = 0; i <=  s1.length() - 1; i++) {
            for(int j = 0; j <= s2.length() - 1; j++) {
                cur = opt(i, j);
                if(cur > lcsLength) {
                    lcsLength = cur;
                    bestI = i;
                    bestJ = j;
                }
            }
        }

        System.out.println("Longest substring: " + traceback(bestI, bestJ));

        return lcsLength;
    }

    private int opt(int i, int j) {
        // If index is nonzero, return its value
        if(i < 0 || j < 0) {
            return 0;
        }
        else if(M[i][j] != 0) {
            return M[i][j];
        }
        // Recurrence relation
        else {
            // If two characters match, append and move down a layer
            if(string1.substring(i, i + 1).equals(string2.substring(j, j + 1))) {
                M[i][j] = 1 + opt(i - 1, j - 1);
            }
            // If they don't, take the best by adjusting compared letters
            else {
                M[i][j] = Math.max(opt(i, j - 1), opt(i - 1, j));
            }

            return M[i][j];
        }
    }

    private String traceback(int i, int j) {
        String trace = "";

        if(i < 0 || j < 0) {
            return "";
        }
        // Recurrence relation
        else {
            // If two characters match, append and move down a layer
            if(string1.substring(i, i + 1).equals(string2.substring(j, j + 1))) {
                trace = traceback(i - 1, j - 1) + string1.substring(i, i + 1);
            }
            // If they don't, take the best by adjusting compared letters
            else {
                if(traceback(i, j - 1).length() > traceback(i - 1, j).length())
                    trace = traceback(i, j - 1);
                else
                    trace = traceback(i - 1, j);
            }

            return trace;
        }
    }
}
