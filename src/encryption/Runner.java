package encryption;

import java.math.BigInteger;
import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		Random rand;
		rand = new Random();

		/*String str = "A";
		Character c = str.charAt(0);
		int cd = (int)c;
		System.out.println((int)c);
		System.out.println((char)cd);*/
		int pow_, max_;
		pow_ = Math.pow(10, 20);
		max_ = Math.pow(10, 50) - pow_;
		System.out.println("max : "+max_+" pow:"+pow_+" max:"+Math.pow(10, 50));
		ElGamal elg = new ElGamal();
		String msg = "encryption";
		System.out.println("Original Message : "+msg);
		int q = pow_+rand.nextInt(max_);
		int g = 2 + rand.nextInt(q-2);
		
		int key = elg.gen_key(q);
		int h = elg.power(g, key, q);
		System.out.println("g used : "+g);
		System.out.println("gâ used : "+h);
		
		int p = elg.encrypt(msg, q, h, g);
		System.out.println("Decrypted Message : "+elg.decrypt(p, key, q));
		
		
	}

}
