package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_03_PermutationsOfString {
    public static List<String> permutations(String str){
        if(str.length()==0){
            List<String> ls = new ArrayList<String>();
            ls.add("");
            return ls;
        }
//        System.out.println("Str is:"+str);
        char[] charArr = str.toCharArray();
        List<String> permutaionList = new ArrayList<>();
        for(int i=0;i<charArr.length;i++){
            char c = charArr[i];
            String newRemainingString = "";
            for(int j=0;j<charArr.length;j++){
                if(i!=j){
                    newRemainingString+=charArr[j];
                }
            }
//            System.out.println("New remaingString for "+c+" is:"+newRemainingString);
            List<String> remainingPermutaionList = permutations(newRemainingString);
//            System.out.println("And list is: "+Arrays.toString(remainingPermutaionList.toArray()));
            for(int k=0;k<remainingPermutaionList.size();k++){
                permutaionList.add(c+remainingPermutaionList.get(k));
            }
        }
        return permutaionList;
    }
    public static void main(String[] args) {
        String s = "abcd";
        List<String> list = permutations(s);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.size());
    }
}
