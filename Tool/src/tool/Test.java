package tool;

public class Test {

	public static void main(String[] args) {
		RanPwd ranPwd =new RanPwd();
		
		System.out.println("數字: "+ ranPwd.Digitally(9));
		System.out.println("小寫英文: "+ ranPwd.SmallEnglish(6));
		System.out.println("大寫英文: "+ ranPwd.BigEnglish(6));
		System.out.println("小大數字: "+ ranPwd.Mixing(6));
		System.out.println("小數: "+ ranPwd.SmallDigitally(6));
		System.out.println("大數: "+ ranPwd.BigDigitally(6));
		System.out.println("大小英: "+ ranPwd.BigSmallEnglish(6));
		
		System.out.println("---------------------------------");
		String Encryption=ranPwd.Mixing(6);
		System.out.println("加密前: "+Encryption);
		Encryption=ranPwd.Encryption(Encryption);
		System.out.println("加密後: "+Encryption);
		System.out.println("解密後: "+ranPwd.Decryption(Encryption));
	}

}
