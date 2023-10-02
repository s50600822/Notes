package hoa.can.code.ez;

public class ReverseInteger {
    public static int reverse(int x) {
        boolean neg = false;
        String MAX = "2147483647";
        String MIN = "2147483648";
        if(x<0){
            neg =true;
        }
        String s = Integer.toString(Math.abs(x));
        String result = new StringBuilder(s).reverse().toString();
        if(neg){
            if (MIN.length() < result.length())
                return 0;
            return Integer.parseInt(result)*-1;
        }
        if(MAX.length()< result.length() || (MAX.length() == result.length() && MAX.compareTo(result)<0) )
            return 0;
        return Integer.parseInt(result);
    }


    public static int reverse2(int x) {
        long finalNum = 0;
        while(x!=0){
            int lastDig = x%10;
            finalNum += lastDig;
            finalNum = finalNum*10;
            x= x/10;
        }
        finalNum = finalNum/10;
        if(finalNum > Integer.MAX_VALUE || finalNum<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*finalNum);
        }
        return (int)finalNum;
    }

    public static int clgt(int x){
        return 1;
    }
// The motherfucker seems to supply such a test case
//    public static void main(String[] args) {
//        System.out.println(clgt(9646324351));
//    }
}
