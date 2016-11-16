package tool;

public class Test {

	public static void main(String[] args) {
		RanPwd ranPwd =new RanPwd();
		
		System.out.println("计: "+ ranPwd.Digitally(6));
		System.out.println("糶璣ゅ: "+ ranPwd.SmallEnglish(6));
		System.out.println("糶璣ゅ: "+ ranPwd.BigEnglish(6));
		System.out.println("计: "+ ranPwd.Mixing(6));
		System.out.println("计: "+ ranPwd.SmallDigitally(6));
		System.out.println("计: "+ ranPwd.BigDigitally(6));
		System.out.println("璣: "+ ranPwd.BigSmallEnglish(6));
		
		System.out.println("---------------------------------");
		String Encryption=ranPwd.Mixing(6);
		System.out.println("盞玡: "+Encryption);
		Encryption=ranPwd.Encryption(Encryption);
		System.out.println("盞: "+Encryption);
		System.out.println("秆盞: "+ranPwd.Decryption(Encryption));
	}

}
