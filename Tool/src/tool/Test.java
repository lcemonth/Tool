package tool;

public class Test {

	public static void main(String[] args) {
		RanPwd ranPwd =new RanPwd();
		
		System.out.println("�Ʀr: "+ ranPwd.Digitally(6));
		System.out.println("�p�g�^��: "+ ranPwd.SmallEnglish(6));
		System.out.println("�j�g�^��: "+ ranPwd.BigEnglish(6));
		System.out.println("�p�j�Ʀr: "+ ranPwd.Mixing(6));
		System.out.println("�p��: "+ ranPwd.SmallDigitally(6));
		System.out.println("�j��: "+ ranPwd.BigDigitally(6));
		System.out.println("�j�p�^: "+ ranPwd.BigSmallEnglish(6));
		
		System.out.println("---------------------------------");
		String Encryption=ranPwd.Mixing(6);
		System.out.println("�[�K�e: "+Encryption);
		Encryption=ranPwd.Encryption(Encryption);
		System.out.println("�[�K��: "+Encryption);
		System.out.println("�ѱK��: "+ranPwd.Decryption(Encryption));
	}

}
