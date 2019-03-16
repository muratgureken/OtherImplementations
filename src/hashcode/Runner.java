package hashcode;

public class Runner {

	public static void main(String[] args) {
		String str = "Murat";
		System.out.println("String : "+str+" hasshcode:"+str.hashCode());
		str = "Mura";
		System.out.println("String : "+str+" hasshcode:"+str.hashCode());
		str = "Murat.";
		System.out.println("String : "+str+" hasshcode:"+str.hashCode());		
		str = "Murat ";
		System.out.println("String : "+str+" hasshcode:"+str.hashCode());			
		str = "Murat";
		System.out.println("String : "+str+" hasshcode:"+str.hashCode());			
		str = str.toUpperCase();
		System.out.println("String : "+str+" hasshcode:"+str.hashCode());
		str = str.toLowerCase();
		System.out.println("String : "+str+" hasshcode:"+str.hashCode());
	}

}
