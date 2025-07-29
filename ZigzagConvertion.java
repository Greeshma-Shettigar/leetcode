public class ZigzagConvertion {
   
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            // Reverse direction if we hit top or bottom row
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down
            currRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);
        return result.toString();
    }
    public static void main(String[] args) {
        ZigzagConvertion zc = new ZigzagConvertion();
        String input = "PAYPALISHIRING";
        int numRows = 3;
        String result = zc.convert(input, numRows);
        System.out.println("Converted String: " + result); // Expected output: "PAHNAPLSIIGYIR"
    }
}


    

