package leetcode;

public class LC67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1","11"));
    }
      
    private static String  addBinary(String a, String b) {
        String result = "";
        int length = Math.max(a.length(),b.length());
        StringBuffer ar = new StringBuffer(a);
        StringBuffer br = new StringBuffer(b);
        ar = ar.reverse();
        br = br.reverse();
        int add1=0 ,add2 = 0,carry = 0;

        for (int i = 0; i < length; i++) {
            if(i>ar.length()-1){
                add1 = 0;
            }else {
                add1 = ar.charAt(i)=='0'?0:1;
            }
            if(i>br.length()-1){
                add2 = 0;
            }else {
                add2 = br.charAt(i)=='0'?0:1;
            }
            result = result +((carry+add1+add2)%2);
            carry = (carry + add1 + add2 )>1?1:0;

        }
        if(carry>0)
            result = result +carry;
        result = String.valueOf(new StringBuffer(result).reverse());
        return  result;
    }

    public static  String addBinary2(String a, String b) {
        System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
        return Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));
    }
}
