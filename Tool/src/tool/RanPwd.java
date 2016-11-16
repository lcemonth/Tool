package tool;

interface Password{
	public String Encryption(String pwd);
	public String Decryption(String pwd);
}

public class RanPwd implements Password{
	private String garbled="";		//Return
	private String zoneStatus="";	//亂數區域
	private Integer range;
	private Integer ascii;			
	
	public String Digitally(int pwdLength){			//數字亂數
		range=10;
		ascii=48;
		return Compute(pwdLength);
	}
	public String BigEnglish(int pwdLength){		//大寫英文亂數
		range=26;
		ascii=65;
		return Compute(pwdLength);
	}
	public String SmallEnglish(int pwdLength){		//小寫英文亂數
		range=26;
		ascii=97;
		return Compute(pwdLength);
	}
	public String Mixing(int pwdLength){			//混合亂數
		zoneStatus="mixing";
		return Compute(pwdLength);
	}
	public String SmallDigitally(int pwdLength){	//小寫+數字
		zoneStatus="smallDigitally";
		return Compute(pwdLength);
	}
	public String BigDigitally(int pwdLength){		//大寫+數字
		zoneStatus="bigDigitally";
		return Compute(pwdLength);
	}
	public String BigSmallEnglish(int pwdLength){	//小寫+大寫
		zoneStatus="bigSmallEnglish";
		return Compute(pwdLength);
	}
	private int Ran(int i){	//亂數
		return (int)(Math.random()*i);
	}
	private void Zonestatus(){
		switch (zoneStatus) {
			case "mixing":		//混合亂數
				range=(Ran(2)==1)?10:26;
				ascii=(range==10)?48:(Ran(2)==1)?65:97;
				break;
			case "smallDigitally":		//小寫+數字
				range=(Ran(2)==1)?10:26;
				ascii=(range==10)?48:97;
				break;
			case "bigDigitally":		//大寫+數字
				range=(Ran(2)==1)?10:26;
				ascii=(range==10)?48:65;
				break;
			default:	//小寫+大寫
				range=26;
				ascii=(Ran(2)==1)?65:97;
				break;
		}
	}
	private String Compute(int pwdLength){	//迴圈
		garbled="";
		for(int i=0;i<pwdLength;i++){
			if(zoneStatus.length()!=0)
				Zonestatus();
			RanPwds();
		}
		zoneStatus="";
		return garbled;
	}
	
	/*
	 * 利用Math 給與range 與 ascii起始
	 * 再轉為char
	 * ASCII 請參閱:https://zh.wikipedia.org/wiki/ASCII
	 * */
	private void RanPwds(){
		this.garbled+=(char)(Ran(range)+ascii);
	}

	
	/*
	 * 此方法是簡易加解密，容易遭到破解
	 * 如要加強，需要在Encryption()再增加公式來增加複雜度
	 * 可透過密碼長度、年月日時、電話、身分證碼......等，自行加入規則。
	 * */
	@Override
	public String Encryption(String pwd){	//簡易加密
		String encryptionPwd="";
		int[] asciiPwd=new int[pwd.length()];
		int ascii[] = new int[pwd.length()]; 
		for(int i=0; i< pwd.length(); i++) {
			ascii[i] = pwd.charAt(i);
			asciiPwd[i]+=(ascii[i]+Ivc(i));		//15為加密的Key
			encryptionPwd+=(char)asciiPwd[i];
		}
		return encryptionPwd;
	}
	@Override
	public String Decryption(String pwd){	//簡易解密
		String encryptionPwd="";
		int[] asciiPwd=new int[pwd.length()];
		int ascii[] = new int[pwd.length()]; 
		for(int i=0; i< pwd.length(); i++) {
			ascii[i] = pwd.charAt(i);
			asciiPwd[i]+=(ascii[i]-Ivc(i));		//15為解密的Key
			encryptionPwd+=(char)asciiPwd[i];
		}
		return encryptionPwd;
	}
	
	/*
	 * Information Verification Code
	 * 因為是ASCII 所以Ivc的範圍為-4~1
	 * 如要加強須將傳進來的pwd加入公式 來加解密
	 * 
	 * */
	private int Ivc(int pwd){
		return -4;
	}
}