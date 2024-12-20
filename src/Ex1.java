import java.util.Arrays;

public class Ex1 {
    public static int convertBaseStringToInt(String value){
        int num = 0;
        if (value.equals("A")) {
            num = 10;
        } else if (value.equals("B")) {
            num = 11;
        } else if (value.equals("C")) {
            num = 12;
        } else if (value.equals("D")) {
            num = 13;
        } else if (value.equals("E")) {
            num = 14;
        } else if (value.equals("F")) {
            num = 15;
        } else if (value.equals("G")) {
            num = 16;
        }else {
            num = Integer.parseInt(value);
        }
        return num;
    }
    public static String convertIntToBaseString(int value){
        String base = "";
        if (value == 10){
            base = "A";
        } else if (value == 11){
            base = "B";
        } else if (value == 12) {
            base = "C";
        } else if (value == 13) {
            base = "D";
        } else if (value == 14) {
            base = "E";
        } else if (value == 15) {
            base = "F";
        } else if (value == 16) {
            base = "G";
        }else{
            base = value + "";
        }
        return base;
    }
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String represenng a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if (num == null || num.isEmpty()){
            return ans;
        }
        String[] bases = {"2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G"};
        int index = num.indexOf("b");
        String base = "A";
        if (index == 0){
            return ans;
        }
        if (index != -1) {
            base = num.substring(index + 1);
            num = num.substring(0, index);
        }
        boolean found = false;
        String[] allowed = {"0", "1"};
        for (int i = 0; i < bases.length && !found; i++) {
            if (i != 0) {
                allowed = Arrays.copyOf(allowed, allowed.length + 1);
                allowed[allowed.length - 1] = bases[i - 1];
            }
            if (bases[i].equals(base)) {
                found = true;
            }
        }
        if (!found) {
            return ans;
        }
        int result = 0;
        for (int j = 0; j < num.length(); j++) {
            found = false;
            String ch = num.charAt(j) + "" ;
            for (int g = 0; g < allowed.length && !found; g++) {
                if (ch.equals(allowed[g])) {
                    found = true;
                }
            }
            if (!found){
                return ans;
            }
            int fac = convertBaseStringToInt(ch);
            int baseNum = convertBaseStringToInt(base);
            result = result + (fac * (int)Math.pow(baseNum, num.length() - 1 - j));
        }
        ans = result;
        return ans;
    }


    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */

    public static boolean isValidNumber(String a) {
        boolean ans = true;
        String[] bases = {"2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G"};
        if (a == null || a.isEmpty()){
            return false;
        }
        int index = a.indexOf("b");
        String base = "A";
        if (index == 0){
            return false;
        }
        if (index != -1) {
            base = a.substring(index + 1);
            a = a.substring(0, index);
        }
        boolean found = false;
        String[] allowed = {"0", "1"};
        for (int i = 0; i < bases.length && !found; i++) {
            if (i != 0) {
                allowed = Arrays.copyOf(allowed, allowed.length + 1);
                allowed[allowed.length - 1] = bases[i - 1];
            }
            if (bases[i].equals(base)) {
                found = true;
            }
        }
        if (!found) {
            return false;
        }
        for (int j = 0; j < a.length(); j++) {
            found = false;
            String ch = a.charAt(j) + "" ;
            for (int g = 0; g < allowed.length && !found; g++) {
                if (ch.equals(allowed[g])) {
                    found = true;
                }
            }
            if (!found){
                return false;
            }
        }
        return ans;
    }
    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        if (num < 0 || base < 2 || base > 16){
            return ans;
        }
        if (num == 0) {
            ans = "0";
        }
        while (num / base != 0 || num%base != 0){
            ans = convertIntToBaseString(num%base) + ans;
            num = num / base;
        }
        if (base != 10){
            ans = ans + "b" + convertIntToBaseString(base);
        }
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        int num1 = number2Int(n1);
        int num2 = number2Int(n2);
        if(num1 == -1 || num2 == -1){
            ans =  false;
        }else{
            ans = num1 == num2;
        }
        return ans;
    }
    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        int biggerNum = number2Int(arr[0]);
        for (int i = 1; i < arr.length; i++){
            int num = number2Int(arr[i]);
            if (num > biggerNum){
                biggerNum = num;
                ans = i;
            }
        }
        return ans;
    }
}
