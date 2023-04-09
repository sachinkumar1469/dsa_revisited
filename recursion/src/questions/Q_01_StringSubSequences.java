package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_01_StringSubSequences {

    public static List<String> subSequences(String str){
        if(str == ""){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char first = str.charAt(0);
        List<String> remaining = subSequences(str.substring(1));
        var size = remaining.size();
        for(var i=0;i<size;i++){
            remaining.add(first+remaining.get(i));
        }
        return remaining;
    }
    public static void main(String[] args) {
        var str = "abc";
        List<String> list = subSequences(str);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
