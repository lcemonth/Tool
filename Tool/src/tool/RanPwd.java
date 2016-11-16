package tool;

interface Password{
	public String Encryption(String pwd);
	public String Decryption(String pwd);
}

public class RanPwd implements Password{
	private String garbled="";		//Return
	private String zoneStatus="";	//�üưϰ�
	private Integer range;
	private Integer ascii;			
	
	public String Digitally(int pwdLength){			//�Ʀr�ü�
		range=10;
		ascii=48;
		return Compute(pwdLength);
	}
	public String BigEnglish(int pwdLength){		//�j�g�^��ü�
		range=26;
		ascii=65;
		return Compute(pwdLength);
	}
	public String SmallEnglish(int pwdLength){		//�p�g�^��ü�
		range=26;
		ascii=97;
		return Compute(pwdLength);
	}
	public String Mixing(int pwdLength){			//�V�X�ü�
		zoneStatus="mixing";
		return Compute(pwdLength);
	}
	public String SmallDigitally(int pwdLength){	//�p�g+�Ʀr
		zoneStatus="smallDigitally";
		return Compute(pwdLength);
	}
	public String BigDigitally(int pwdLength){		//�j�g+�Ʀr
		zoneStatus="bigDigitally";
		return Compute(pwdLength);
	}
	public String BigSmallEnglish(int pwdLength){	//�p�g+�j�g
		zoneStatus="bigSmallEnglish";
		return Compute(pwdLength);
	}
	private int Ran(int i){	//�ü�
		return (int)(Math.random()*i);
	}
	private void Zonestatus(){
		switch (zoneStatus) {
			case "mixing":		//�V�X�ü�
				range=(Ran(2)==1)?10:26;
				ascii=(range==10)?48:(Ran(2)==1)?65:97;
				break;
			case "smallDigitally":		//�p�g+�Ʀr
				range=(Ran(2)==1)?10:26;
				ascii=(range==10)?48:97;
				break;
			case "bigDigitally":		//�j�g+�Ʀr
				range=(Ran(2)==1)?10:26;
				ascii=(range==10)?48:65;
				break;
			default:	//�p�g+�j�g
				range=26;
				ascii=(Ran(2)==1)?65:97;
				break;
		}
	}
	private String Compute(int pwdLength){	//�j��
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
	 * �Q��Math ���Prange �P ascii�_�l
	 * �A�ରchar
	 * ASCII �аѾ\:https://zh.wikipedia.org/wiki/ASCII
	 * */
	private void RanPwds(){
		this.garbled+=(char)(Ran(range)+ascii);
	}

	
	/*
	 * ����k�O²���[�ѱK�A�e���D��}��
	 * �p�n�[�j�A�ݭn�bEncryption()�A�W�[�����ӼW�[������
	 * �i�z�L�K�X���סB�~���ɡB�q�ܡB�����ҽX......���A�ۦ�[�J�W�h�C
	 * */
	@Override
	public String Encryption(String pwd){	//²���[�K
		String encryptionPwd="";
		int[] asciiPwd=new int[pwd.length()];
		int ascii[] = new int[pwd.length()]; 
		for(int i=0; i< pwd.length(); i++) {
			ascii[i] = pwd.charAt(i);
			asciiPwd[i]+=(ascii[i]+Ivc(i));		//15���[�K��Key
			encryptionPwd+=(char)asciiPwd[i];
		}
		return encryptionPwd;
	}
	@Override
	public String Decryption(String pwd){	//²���ѱK
		String encryptionPwd="";
		int[] asciiPwd=new int[pwd.length()];
		int ascii[] = new int[pwd.length()]; 
		for(int i=0; i< pwd.length(); i++) {
			ascii[i] = pwd.charAt(i);
			asciiPwd[i]+=(ascii[i]-Ivc(i));		//15���ѱK��Key
			encryptionPwd+=(char)asciiPwd[i];
		}
		return encryptionPwd;
	}
	
	/*
	 * Information Verification Code
	 * �]���OASCII �ҥHIvc���d��-4~1
	 * �p�n�[�j���N�Ƕi�Ӫ�pwd�[�J���� �ӥ[�ѱK
	 * 
	 * */
	private int Ivc(int pwd){
		return -4;
	}
}