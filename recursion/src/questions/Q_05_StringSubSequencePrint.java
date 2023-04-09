package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_05_StringSubSequencePrint {

    public static void print(String str,String answerList){
        if(str.length()==0){
            System.out.println(answerList);
            return;
        }
        char first = str.charAt(0);
        print(str.substring(1),answerList);
        print(str.substring(1),answerList+first);
    }
    public static void main(String[] args) {
        String str = "abc";
        List<String> ls = new ArrayList<>();
        ls.add("");
        print(str,"");
    }
}
