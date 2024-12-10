
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    public void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    public void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isValidNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isValidNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    public void int2NumberTest() {
        int num = 10;
        String res = Ex1.int2Number(num, 2);
        Assertions.assertEquals("1010b2", res);
        res = Ex1.int2Number(num, 17);
        Assertions.assertEquals("", res);
        res = Ex1.int2Number(0, 2);
        Assertions.assertEquals("0", res);
        res = Ex1.int2Number(-1, 2);
        Assertions.assertEquals("", res);
        res = Ex1.int2Number(num, 1);
        Assertions.assertEquals("", res);
    }
    @Test
    public void maxIndexTest() {
        String[] arr = {"2", "3", "1", "2"};
        int res = Ex1.maxIndex(arr);
        assertEquals(1,res);
        String[] arr1 = {"10b2", "100b2", "1000b2"};
        res = Ex1.maxIndex(arr1);
        assertEquals(2,res);
        String[] arr2 = {"1000b3", "100b2", "1000b3"};
        res = Ex1.maxIndex(arr2);
        assertEquals(0,res);
        String[] arr3 = {"", "100b3", "1000b3"};
        res = Ex1.maxIndex(arr3);
        assertEquals(2,res);
        String[] arr4 = {null, "1000b5", "1000b2"};
        res = Ex1.maxIndex(arr4);
        assertEquals(1,res);
        String[] arr5 = {"b5", "1000", "1000b2"};
        res = Ex1.maxIndex(arr5);
        assertEquals(1,res);
    }
    @Test
    public void number2IntTest(){
        String num = "10";
        int res = Ex1.number2Int(num);
        assertEquals(10,res);
        num = "100b2";
        res = Ex1.number2Int(num);
        assertEquals(4,res);
        num = "100bA";
        res = Ex1.number2Int(num);
        assertEquals(100,res);
        num = "100b";
        res = Ex1.number2Int(num);
        assertEquals(-1,res);
        num = "bA";
        res = Ex1.number2Int(num);
        assertEquals(-1,res);
        num = "10AbA";
        res = Ex1.number2Int(num);
        assertEquals(-1,res);
        num = " 10bA";
        res = Ex1.number2Int(num);
        assertEquals(-1,res);
        num = "1FbG";
        res = Ex1.number2Int(num);
        assertEquals(31,res);
        num = "10AbB";
        res = Ex1.number2Int(num);
        assertEquals(131,res);
        num = "100b16";
        res = Ex1.number2Int(num);
        assertEquals(-1,res);
        num = "-1";
        res = Ex1.number2Int(num);
        assertEquals(-1,res);
    }
    @Test
    public void equalsNumbersTest(){
        String num1 = "10";
        String num2 = "10bA";
        assertTrue(Ex1.equals(num1,num2));
        num2 = "1010b2";
        assertTrue(Ex1.equals(num1,num2));
        num2 = "-1";
        assertFalse(Ex1.equals(num1,num2));
        num2 = null;
        assertFalse(Ex1.equals(num1,num2));
        num2 = "0";
        assertFalse(Ex1.equals(num1,num2));
        num2 = "100b3";
        assertFalse(Ex1.equals(num1,num2));
        num2 = "100b17";
        assertFalse(Ex1.equals(num1,num2));
        num2 = "100b";
        assertFalse(Ex1.equals(num1,num2));
        num2 = "bA";
        assertFalse(Ex1.equals(num1,num2));
        num2 = "CbB";
        assertFalse(Ex1.equals(num1,num2));
        num1 = "31bA";
        num2 = "1FbG";
        assertTrue(Ex1.equals(num1,num2));
    }
}
