public class Q_06_EditDistance {
    // Recursive way
    static int recCall = 0;
    public static int editDistance(String s1, String s2){

        String str1 = s1;
        String str2 = s2;
        if(str1.length() ==0 && str2.length()==0){
            return 0;
        }
        if(str1.length() != 0 && str2.length()==0){
            return str1.length();
        }
        if(str1.length() == 0){
            return str2.length();
        }
        if(str1.equals(str2)){
            return 0;
        }
        // First character and different
        if(str1.charAt(0) != str2.charAt(0)){
            // Add
            int addAns = Integer.MAX_VALUE;
            if(str1.length()<str2.length()){
                str1 = str2.charAt(0) + str1;
            }else {
                str2 = str1.charAt(0) + str2;
            }
            addAns = editDistance(str1.substring(1),str2.substring(1));
            // Delete
            int deleteAns = Integer.MAX_VALUE;
            int replaceAns = Integer.MAX_VALUE;
            str1 = s1;
            str2 = s2;
            if(str1.length()!=str2.length()){
                if(str1.length()<str2.length()){
                    str2 = str2.substring(1);
                }else {
                    str1 = str1.substring(1);
                }
                deleteAns = editDistance(str1,str2);

            }
            str1 = s1;
            str2 = s2;
            str1 = str2.charAt(0) + str1.substring(1);

            replaceAns = editDistance(str1.substring(1),str2.substring(1));

            // Replace
            return 1 + Math.min(addAns,Math.min(deleteAns,replaceAns));
        }else{
            return editDistance(str1.substring(1),str2.substring(1));
        }
    }

    public static int editDistance2(String s1, String s2){
        recCall++;
        String str1 = s1;
        String str2 = s2;
        if(str1.length() == 0 || str2.length() == 0){
            return Math.max(str1.length(), str2.length());
        }
        if(str1.charAt(0) == str2.charAt(0)){
            return 1 + editDistance2(str1.substring(1),str2.substring(1));
        }else{
            // Try to make str2 to str1
            // Add
            int addAns = 0;
            char firstChar = str1.charAt(0);
            str2 = firstChar + s2;
            addAns = editDistance2(str1.substring(1),str2.substring(1));

            // Replace
            str2 = firstChar+s2.substring(1);
            int replaceAns = editDistance2(str1.substring(1),str2.substring(1));

            // Delete
            str2 = s2.substring(1);
            int deleteAns = editDistance2(str1,str2);
            return 1 + Math.min(addAns,Math.min(replaceAns,deleteAns));
        }
    }

    // DP with memoization

    public static void main(String[] args) {
        String str1 = "whgtdwhgtdg";
        String str2 = "aswcfg";
        System.out.println(editDistance(str1,str2));
        System.out.println(editDistance2(str1,str2)+" total recursive calls are: "+recCall);
    }
}
