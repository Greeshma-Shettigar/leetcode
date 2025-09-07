public class RomanToInteger {
    public int romanToInt(String s) {
          int[] values = new int[26]; // mapping using char index
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = values[s.charAt(i) - 'A'];
            if (i + 1 < s.length()) {
                int next = values[s.charAt(i + 1) - 'A'];
                if (current < next) {
                    total -= current;  // subtract case
                    continue;
                }
            }
            total += current;
        }
        return total;
    }
    
}
/*Why subtract when current < next?

Roman numerals normally add values, but in special cases a smaller numeral before a bigger one means subtraction:

IV = 4 → instead of 1 + 5 = 6, it’s 5 - 1 = 4

IX = 9 → instead of 1 + 10 = 11, it’s 10 - 1 = 9

XL = 40 → 50 - 10

XC = 90 → 100 - 10

CD = 400 → 500 - 100

CM = 900 → 1000 - 100

So when we see a smaller numeral before a larger one, we must subtract instead of add.

👉 Example: "IX"

Look at I = 1 and X = 10

Since 1 < 10, subtract → total = -1

Next add 10 → total = 9 */