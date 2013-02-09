package pl.kwi.main;

import java.math.BigInteger;
import java.util.*;

public class Main {
	
    public static BigInteger silnia(int n){
        
    	BigInteger s = BigInteger.valueOf(1);
    	for (int i = 1; i <= n; i++) {
			s = s.multiply(BigInteger.valueOf(i));
		}
    	return s;    	
    }
     
    public static void main(String args[]){
        int n;
        System.out.println("Podaj liczbê dla której obliczyæ silniê: ");
        Scanner wejscie=new Scanner(System.in);
        n = wejscie.nextInt();
        System.out.printf("Silnia z %d wynosi %,d", n, silnia(n));
        
    }
}
