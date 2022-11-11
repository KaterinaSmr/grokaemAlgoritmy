package dynamicProgramming;



public class LongestSubstring {

    public static void main(String[] args) {
        String rowString = "blue";
        String colString = "clues";
        String[] rowStringArr = rowString.split("");
        String[] colStringArr = colString.split("");
        int[][] calcTable = new int[rowStringArr.length][colStringArr.length];

        int max = 0;
        int maxI = -1;
        int maxJ = -1;

        for (int i = 0; i < rowStringArr.length; i++) {
            for (int j = 0; j < colStringArr.length; j++) {
                calcTable[i][j] = 0;
                if (rowStringArr[i].equals(colStringArr[j])) {
                    if (i > 0 && j > 0) {
                        calcTable[i][j] = calcTable[i - 1][j - 1] + 1;
                    } else {
                        calcTable[i][j] = 1;
                    }
                }
                if (calcTable[i][j] > max){
                    max = calcTable[i][j];
                    maxI = i;
                    maxJ = j;
                }
                System.out.print(calcTable[i][j] + "  ");
            }
            System.out.println();
        }

        String[] longestSubstring = new String[max];

        for (int k = max-1; k >= 0; k--) {
            longestSubstring[k] = rowStringArr[maxI--];
        }

        System.out.println("Bigest substr lenght " + max);
        System.out.println("Largest substring " + String.join("", longestSubstring));

    }
}
