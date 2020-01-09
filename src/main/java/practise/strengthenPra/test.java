package practise.strengthenPra;

public class test {

    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);//true
        System.out.println(f3 == f4);//false
        //Integer 取值范围为-128-127  超过将新new值追加


        String str1 = "hello";
        String str2 = "he" + new String("llo");
        String str3 = "he" + "llo";
        System.err.println(str1 == str2);//false
        System.err.println(str1 == str3);//true

    }
}