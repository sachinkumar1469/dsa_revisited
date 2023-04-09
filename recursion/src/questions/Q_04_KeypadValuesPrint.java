package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_04_KeypadValuesPrint {

    public static String[] values = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void printKeypad(String str,String answerSoFar){
        if(str.length() == 0){
            // Do something or print here
            System.out.print(answerSoFar+" ");
            return;
        }
        int firstNum = Integer.parseInt(str.substring(0,1));
        String numValues = values[firstNum];


        for(int j=0;j<numValues.length();j++){
            printKeypad(str.substring(1),answerSoFar+numValues.charAt(j));
        }
    }
    public static void main(String[] args) {
        String num = "234";
        int n = 123;
        printKeypad(num,"");
    }
}
