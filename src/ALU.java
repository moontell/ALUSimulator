/**
 * ģ��ALU���������͸���������������
 * @151250095_���ۻ� [�뽫�˴��޸�Ϊ��ѧ��_������]
 *
 */

public class ALU {

	/**
	 * ����ʮ���������Ķ����Ʋ����ʾ��<br/>
	 * ����integerRepresentation("9", 8)
	 * @param number ʮ������������Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param length �����Ʋ����ʾ�ĳ���
	 * @return number�Ķ����Ʋ����ʾ������Ϊlength
	 */
	public String integerRepresentation (String number, int length) {
		// TODO YOUR CODE HERE.
		String result =new String();
		if(number.equals("-"+(int)Math.pow(2, length-1))){
			result="1";
			while(result.length()<length)
				result+="0";
			return result;
		}
		String[] str =number.split("");
		String sign =new String();
		if(str[0].equals("-")){
			sign ="1";
			StringBuilder s=new StringBuilder();
			int Num =Integer.parseInt(number.substring(1));
			while((!(Num==0))){
				int n=Num%2;
				Num=Num/2;
				s.append(n);
			}
			int numOf0=length-1-s.length();
			result=sign;
			for(int i=0;i<numOf0;i++)
				result+="0";
			for(int i=0;i<s.length();i++)
				result+=s.charAt(s.length()-i-1);
		}else{
			sign ="0";
			StringBuilder s=new StringBuilder();
			int Num =Integer.parseInt(number);
			while((!(Num==0))){
				int n=Num%2;
				Num=Num/2;
				s.append(n);
			}
			int numOf0=length-1-s.length();
			result=sign;
			for(int i=0;i<numOf0;i++)
				result+="0";
			for(int i=0;i<s.length();i++)
				result+=s.charAt(s.length()-i-1);
		}
		if(result.length()==length)
			return result;
		else return "overflow";
	}
	public String unsignedIntegerRepresentation (int number, int length) {
		// TODO YOUR CODE HERE.
		String result =new String();
			StringBuilder s=new StringBuilder();
			while((!(number==0))){
				int n=number%2;
				number=number/2;
				s.append(n);
			}
			int Num0=length-s.length();
			for(int i=0;i<Num0;i++)
				result+="0";
			for(int i=0;i<s.length();i++)
				result+=s.charAt(s.length()-i-1);
			
		if(result.length()==length)
			return result;
		else return "overflow";
	}
	
	/**
	 * ����ʮ���Ƹ������Ķ����Ʊ�ʾ��
	 * ��Ҫ���� 0������񻯡����������+Inf���͡�-Inf������ NaN�����أ������� IEEE 754��
	 * �������Ϊ��0���롣<br/>
	 * ����floatRepresentation("11.375", 8, 11)
	 * @param number ʮ���Ƹ�����������С���㡣��Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return number�Ķ����Ʊ�ʾ������Ϊ 1+eLength+sLength���������ң�����Ϊ���š�ָ���������ʾ����β������λ���أ�
	 */
	public String floatRepresentation (String number, int eLength, int sLength) {
		String result=new String();
		String sign ="0";
		String weishu =new String();
		StringBuilder xiaoshuBin=new StringBuilder();
		double xiaoshuDec;
		if(number.equals("0")){
			while(result.length()<1+eLength+sLength)
				result+="0";
			return result;
		}
		if(number.equals("+Inf")){
			result+="0";
			while(result.length()<1+eLength)
				result+="1";
			while(result.length()<1+eLength+sLength)
				result+="0";
			return result;
		}
		if(number.equals("-Inf")){
			result+="1";
			while(result.length()<1+eLength)
				result+="1";
			while(result.length()<1+eLength+sLength)
				result+="0";
			return result;
		}
		if(number.equals("NaN")){
			while(result.length()<1+eLength+sLength)
				result+="1";
			return result;
		}
		if(Double.parseDouble(number)<Math.pow(2, -Math.pow(2, eLength-1))&&Double.valueOf(number)>-Math.pow(2, -Math.pow(2, eLength-1)))
			{
			if(number.startsWith("-")){
				sign="1";
				xiaoshuBin=new StringBuilder();
				xiaoshuDec=Double.parseDouble(number.substring(1));
				//System.out.println("С����ʮ���� " +xiaoshuDec);
				while(xiaoshuDec!=(int)xiaoshuDec){
					xiaoshuBin.append((int)(xiaoshuDec*2));
					xiaoshuDec =xiaoshuDec*2-(int)(xiaoshuDec*2);
				}
				System.out.println(xiaoshuBin);
				result=sign;//xiaoshuBin.substring((int) Math.pow(2, eLength-1));
				while(result.length()<1+eLength)
					result+="0";
				if(xiaoshuBin.substring((int) Math.pow(2, eLength-1)).length()>sLength)
					result+=xiaoshuBin.substring((int) Math.pow(2, eLength-1),(int) Math.pow(2, eLength-1)+sLength+1);
				else{
					result+=xiaoshuBin.substring((int) Math.pow(2, eLength-1));
					while(result.length()<1+eLength+sLength)
						result+="0";
				}
			}else{
				xiaoshuBin=new StringBuilder();
				xiaoshuDec=Double.parseDouble(number.substring(1));
				//System.out.println("С����ʮ���� " +xiaoshuDec);
				while(xiaoshuDec!=(int)xiaoshuDec){
					xiaoshuBin.append((int)(xiaoshuDec*2));
					xiaoshuDec =xiaoshuDec*2-(int)(xiaoshuDec*2);
				}
				//System.out.println(xiaoshuBin);
				result=sign;//xiaoshuBin.substring((int) Math.pow(2, eLength-1));
				while(result.length()<1+eLength)
					result+="0";
				if(xiaoshuBin.substring((int) Math.pow(2, eLength-1)).length()>sLength)
					result+=xiaoshuBin.substring((int) Math.pow(2, eLength-1),(int) Math.pow(2, eLength-1)+sLength+1);
				else{
					result+=xiaoshuBin.substring((int) Math.pow(2, eLength-1));
					while(result.length()<1+eLength+sLength)
						result+="0";
				}
			}
			return result;
			}
		
		
		
		//����������С��
		String zhengshu=number.substring(0,number.indexOf("."));
		String xiaoshu ="0"+number.substring(number.indexOf("."));
		String exponentBin=new String();
		
		//�������ֱ�Ϊ�����Ʊ��
		String[] str =zhengshu.split("");
		
		StringBuilder zhengshuBin =new StringBuilder();
		int beginOfNum=0;
		if(str[0].equals("-")){
			sign ="1";
			beginOfNum=1;
		}
		//System.out.println("����λ"+sign);
		StringBuilder s=new StringBuilder();
		int Num =Integer.parseInt(zhengshu.substring(beginOfNum));
		if(Num==0)
			s.append(0);
		while((!(Num==0))){
			int n=Num%2;
			Num=Num/2;
			s.append(n);
		}
		for(int i=0;i<s.length();i++)
			zhengshuBin.append(s.charAt(s.length()-i-1));
		//System.out.println("����bin "+zhengshuBin);//��������bin�Ƿ���ȷ
		
		
		//��С�����ֱ�Ϊ�����Ʊ��
		 xiaoshuBin=new StringBuilder();
		xiaoshuDec=Double.parseDouble(xiaoshu);
		//System.out.println("С����ʮ���� " +xiaoshuDec);
		while(xiaoshuDec!=(int)xiaoshuDec){
			xiaoshuBin.append((int)(xiaoshuDec*2));
			xiaoshuDec =xiaoshuDec*2-(int)(xiaoshuDec*2);
		}
		
		//if����Ϊ�ж��������ֶ�ָ����Ӱ�죬���ҰѲ�������bin����β�� �����������Ϊ0��������else���ɷ������־���ָ����ֵ��
		int exponent = (int) (Math.pow(2, eLength-1)-1);
		if(zhengshuBin.length()>1||(zhengshuBin.toString()).equals("1")){
		exponent+=(int) (zhengshuBin.length()-1);
		//System.out.println(zhengshuBin+" "+exponent);
		
		
		}else{
			int i=0;
			//System.out.println(xiaoshuBin);
			String[] temp =xiaoshuBin.toString().split("");
			while(temp[i].equals("0")){
				
				i++;
			};
			i++;
			exponent=exponent-i;
			//System.out.println(exponent-(int) (Math.pow(2, eLength-1)-1));
		};//�����������β������ָ���Ĺ�ʽ
		exponentBin=new ALU().unsignedIntegerRepresentation(exponent, eLength);
	/*	StringBuilder r=new StringBuilder();
		while((!(exponent==0))){
			int n=exponent%2;
			exponent=exponent/2;
			r.append(n);
		}
		System.out.println(r);
		for(int i=0;i<r.length();i++)
			exponentBin+=r.charAt(r.length()-i-1);
			System.out.println("ָ������"+exponentBin);//����*/
		
		//System.out.println("ָ������"+exponentBin);
		weishu=zhengshuBin.toString()+xiaoshuBin.toString();
		weishu=weishu.substring(weishu.indexOf("1")+1);//β���Ѿ�ȥ1��û�в�������0��Ҳû����0ȡ�ᣩ
		//��λ���Ĵ���
		//System.out.println(weishu);
		while(weishu.length()<sLength)
			weishu+="0";//while��β��������ʱ����0
		if(weishu.length()>sLength)
			weishu=weishu.substring(0, sLength);
		return sign+exponentBin+weishu;
	}
	
	/**
	 * ����ʮ���Ƹ�������IEEE 754��ʾ��Ҫ�����{@link #floatRepresentation(String, int, int) floatRepresentation}ʵ�֡�<br/>
	 * ����ieee754("11.375", 32)
	 * @param number ʮ���Ƹ�����������С���㡣��Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param length �����Ʊ�ʾ�ĳ��ȣ�Ϊ32��64
	 * @return number��IEEE 754��ʾ������Ϊlength���������ң�����Ϊ���š�ָ���������ʾ����β������λ���أ�
	 */
	public String ieee754 (String number, int length) {
		String result=new String();
		if(length==32)
			result=new ALU().floatRepresentation(number, 8, 23);
		if(length==64)
			result=new ALU().floatRepresentation(number, 11, 52);
		return result;
	}
	
	/**
	 * ��������Ʋ����ʾ����������ֵ��<br/>
	 * ����integerTrueValue("00001001")
	 * @param operand �����Ʋ����ʾ�Ĳ�����
	 * @return operand����ֵ����Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 */
	public String integerTrueValue (String operand) {
		// TODO YOUR CODE HERE.
		String[] temp =operand.split("");
		int[] eachPart =new int[temp.length];
		int total=0;
		for(int i=0;i<temp.length;i++){
			if(temp[i].equals("1"))
			eachPart[i]=(int)Math.pow(2, temp.length-1-i);
			else eachPart[i]=0;
			total+=eachPart[i];
		}
		total=total-eachPart[0]*2;
		String result=Integer.toString(total);
		return result;
	}
	
	/**
	 * ���������ԭ���ʾ�ĸ���������ֵ��<br/>
	 * ����floatTrueValue("01000001001101100000", 8, 11)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return operand����ֵ����Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ����������ֱ��ʾΪ��+Inf���͡�-Inf���� NaN��ʾΪ��NaN��
	 */
	public String floatTrueValue (String operand, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		String sign;
		if(operand.charAt(0)==0)
			sign="";
		else sign="-";
		String[] temp=operand.substring(1,eLength+1).split("");
		int[] eachPart =new int[temp.length];
		int exponent=0;
		for(int i=0;i<temp.length;i++){
			if(temp[i].equals("1"))
			eachPart[i]=(int)Math.pow(2, temp.length-1-i);
			else eachPart[i]=0;
			exponent+=eachPart[i];
		}	
		exponent-=127;
		System.out.println(exponent);
		double weishuJia1 =Double.parseDouble("1."+operand.substring(1+eLength));
		Double zhi =weishuJia1*Math.pow(2, exponent);
		String result=new String();
		result+=sign;
		result+=zhi.toString();
		return result;
	}
	
	/**
	 * ��λȡ��������<br/>
	 * ����negation("00001001")
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @return operand��λȡ���Ľ��
	 */
	public String negation (String operand) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * ���Ʋ�����<br/>
	 * ����leftShift("00001001", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand����nλ�Ľ��
	 */
	public String leftShift (String operand, int n) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �߼����Ʋ�����<br/>
	 * ����logRightShift("11110110", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand�߼�����nλ�Ľ��
	 */
	public String logRightShift (String operand, int n) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �������Ʋ�����<br/>
	 * ����logRightShift("11110110", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand��������nλ�Ľ��
	 */
	public String ariRightShift (String operand, int n) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * ȫ����������λ�Լ���λ���мӷ����㡣<br/>
	 * ����fullAdder('1', '1', '0')
	 * @param x ��������ĳһλ��ȡ0��1
	 * @param y ������ĳһλ��ȡ0��1
	 * @param c ��λ�Ե�ǰλ�Ľ�λ��ȡ0��1
	 * @return ��ӵĽ�����ó���Ϊ2���ַ�����ʾ����1λ��ʾ��λ����2λ��ʾ��
	 */
	public String fullAdder (char x, char y, char c) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 4λ���н�λ�ӷ�����Ҫ�����{@link #fullAdder(char, char, char) fullAdder}��ʵ��<br/>
	 * ����claAdder("1001", "0001", '1')
	 * @param operand1 4λ�����Ʊ�ʾ�ı�����
	 * @param operand2 4λ�����Ʊ�ʾ�ļ���
	 * @param c ��λ�Ե�ǰλ�Ľ�λ��ȡ0��1
	 * @return ����Ϊ5���ַ�����ʾ�ļ����������е�1λ�����λ��λ����4λ����ӽ�������н�λ��������ѭ�����
	 */
	public String claAdder (String operand1, String operand2, char c) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * ��һ����ʵ�ֲ�������1�����㡣
	 * ��Ҫ�������š����š�����ŵ�ģ�⣬
	 * ������ֱ�ӵ���{@link #fullAdder(char, char, char) fullAdder}��
	 * {@link #claAdder(String, String, char) claAdder}��
	 * {@link #adder(String, String, char, int) adder}��
	 * {@link #integerAddition(String, String, int) integerAddition}������<br/>
	 * ����oneAdder("00001001")
	 * @param operand �����Ʋ����ʾ�Ĳ�����
	 * @return operand��1�Ľ��������Ϊoperand�ĳ��ȼ�1�����е�1λָʾ�Ƿ���������Ϊ1������Ϊ0��������λΪ��ӽ��
	 */
	public String oneAdder (String operand) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �ӷ�����Ҫ�����{@link #claAdder(String, String, char)}����ʵ�֡�<br/>
	 * ����adder("0100", "0011", ��0��, 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param c ���λ��λ
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����ӽ��
	 */
	public String adder (String operand1, String operand2, char c, int length) {
		// TODO YOUR CODE HERE.
				return null;
	}
	
	/**
	 * �����ӷ���Ҫ�����{@link #adder(String, String, char, int) adder}����ʵ�֡�<br/>
	 * ����integerAddition("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����ӽ��
	 */
	public String integerAddition (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �����������ɵ���{@link #adder(String, String, char, int) adder}����ʵ�֡�<br/>
	 * ����integerSubtraction("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ��������
	 */
	public String integerSubtraction (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �����˷���ʹ��Booth�㷨ʵ�֣��ɵ���{@link #adder(String, String, char, int) adder}�ȷ�����<br/>
	 * ����integerMultiplication("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ĳ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ����˽�������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����˽��
	 */
	public String integerMultiplication (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �����Ĳ��ָ������������ɵ���{@link #adder(String, String, char, int) adder}�ȷ���ʵ�֡�<br/>
	 * ����integerDivision("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ĳ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊ2*length+1���ַ�����ʾ�������������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0�������lengthλΪ�̣����lengthλΪ����
	 */
	public String integerDivision (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �����������ӷ������Ե���{@link #adder(String, String, char, int) adder}�ȷ�����
	 * ������ֱ�ӽ�������ת��Ϊ�����ʹ��{@link #integerAddition(String, String, int) integerAddition}��
	 * {@link #integerSubtraction(String, String, int) integerSubtraction}��ʵ�֡�<br/>
	 * ����signedAddition("1100", "1011", 8)
	 * @param operand1 ������ԭ���ʾ�ı����������е�1λΪ����λ
	 * @param operand2 ������ԭ���ʾ�ļ��������е�1λΪ����λ
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ����������ţ�����ĳ���������ĳ���С��lengthʱ����Ҫ���䳤����չ��length
	 * @return ����Ϊlength+2���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������2λΪ����λ����lengthλ����ӽ��
	 */
	public String signedAddition (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �������ӷ����ɵ���{@link #signedAddition(String, String, int) signedAddition}�ȷ���ʵ�֡�<br/>
	 * ����floatAddition("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ļ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param gLength ����λ�ĳ���
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����ӽ�������е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatAddition (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �������������ɵ���{@link #floatAddition(String, String, int, int, int) floatAddition}����ʵ�֡�<br/>
	 * ����floatSubtraction("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ļ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param gLength ����λ�ĳ���
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ�������������е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatSubtraction (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �������˷����ɵ���{@link #integerMultiplication(String, String, int) integerMultiplication}�ȷ���ʵ�֡�<br/>
	 * ����floatMultiplication("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ĳ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����˽��,���е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatMultiplication (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �������������ɵ���{@link #integerDivision(String, String, int) integerDivision}�ȷ���ʵ�֡�<br/>
	 * ����floatDivision("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ĳ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����˽��,���е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatDivision (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
}
