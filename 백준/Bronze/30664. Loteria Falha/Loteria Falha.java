import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			BigInteger bi = sc.nextBigInteger();
			if(bi.equals(BigInteger.ZERO)) break;
			
			String message = bi.mod(BigInteger.valueOf(42)).equals(BigInteger.ZERO) ? "PREMIADO" : "TENTE NOVAMENTE";
			System.out.println(message);
		}
	}
}