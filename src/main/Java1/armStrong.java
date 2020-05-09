package main.Java1;

public class armStrong {
    static void isarmStrong(int n){
        int c=0,a,temp;
        System.out.println(n);
        temp=n;
        while(n>0)
        {
            a=n%10;
            n=n/10;
            c=c+(a*a*a);
        }
        if(temp==c)
            System.out.println("is armstrong number");
        else
            System.out.println("is Not armstrong number");
    }

    public static void main(String[] args)  {
       isarmStrong(153);
       int[] test={0,1,370,371,407,797,560,900};
       for(int i=0;i<test.length;i++){
           isarmStrong(test[i]);
       }
}
}