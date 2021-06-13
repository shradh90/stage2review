package primefactor;

import java.util.Scanner;

public class primefactor {
	 public static void main(String[] args) {
         System.out.println("enter a number");
         Scanner sc = new Scanner(System.in);
         int num = sc.nextInt();
         primefactor(num);
	 }
	 public static boolean isprime (int num){
         if(num == 0 || num == 1){
                 return false;
         } else {
                 if(num == 2){
                 return true;
         }
         boolean flag = true;
         for(int i=2;i<=num/2;i++){
                 if(num % i == 0){
                 flag = false;
                 }
         }
         		return flag;
         	}
         }
         public static void primefactor(int num){
         if(isprime(num)){
                 System.out.println(num);
         } else {
                 for(int i = 2; i <= num / 2; i++){
                         if(num % i == 0 && isprime(i)){
                                 System.out.println(i);
                         }
                 }
         }
 }


}

