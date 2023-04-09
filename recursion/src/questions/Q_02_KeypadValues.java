package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_02_KeypadValues {

    public static String[] values = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> keypad(int num){
        // 234
        if(num == 0){
            List<String> list = new ArrayList<>();
            list.add(values[num]);
            return list;
        }
        int lastDigit = num%10;
        int remainingDigits = num/10;
        List<String> remainingList = keypad(remainingDigits);

        String digitValues = values[lastDigit];
        List<String> newList = new ArrayList<>();
        for(int i=0;i<remainingList.size();i++){
            for(int j=0;j<digitValues.length();j++){
                newList.add(remainingList.get(i)+digitValues.charAt(j));
            }
        }

        return newList;
    }
    public static void main(String[] args) {
        int num = 23;
        List<String> list = keypad(num);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.size());
    }
}
