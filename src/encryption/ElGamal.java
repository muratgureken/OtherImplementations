package encryption;

import java.util.LinkedList;
import java.util.Random;

public class ElGamal 
{
	int a;
	int b;
	Random rand;
	public LinkedList<Integer> en_msg = new LinkedList<Integer>();
	public LinkedList<Character> dr_msg = new LinkedList<Character>();
	
	public ElGamal() {
		rand = new Random();
		a = 2+rand.nextInt(98);
	}
	
	public void gcd(int a , int b)
	{
		if(a<b)
		{
			gcd(b,a);
		}
		else if(a%b==0)
		{
			this.b = b;
		}
		else
		{
			gcd(b,a%b);
		}
	}
	
	public int gen_key(int q)
	{
		int key, pow_, max_;
		pow_ = (int)Math.pow(10, 20);
		max_ = q - pow_;
		key = pow_+rand.nextInt(max_);
		gcd(q,key);
		while(b!=1)
		{
			max_ = b - pow_;
			key = pow_+rand.nextInt(max_);
			gcd(q,key);			
		}
		return key;
	}
	
	public int power(int a, int b, int c) {
		int x = 1;
		int y = a;
		
		while(b>0)
		{
			if(b%2==0)
			{
				x = (x*y)%c;
			}
			y = (y*y)%c;
			b = (int)(b/2);
		}
		return x%c;
	}
	
	public int encrypt(String msg, int q, int h, int g)
	{
		Character c;
		en_msg.clear();
		
		int k= gen_key(q);
		int s = power(h, k, q);
		int p = power(g, k, q);
		System.out.println("g^k used : "+p);
		System.out.println("gâk used : "+s);
		
		for(int i=0;i<msg.length();i++) 
		{
			c = msg.charAt(i);
			en_msg.add(s*(int)c);
		}
		
		return p;
	}
	
	public String decrypt(int p, int key, int q)
	{
		dr_msg.clear();
		String str="";
		
		int h = power(p, key, q);
		for(int i=0;i<en_msg.size();i++)
		{
			dr_msg.add((char)((int)(en_msg.get(i)/h)));
			str = str+(char)((int)(en_msg.get(i)/h));
		}
		return str;
	}
}
