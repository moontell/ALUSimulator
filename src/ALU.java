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
		if(operand.startsWith("0"))
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
		//System.out.println(exponent);
		String str="1"+operand.substring(eLength+1);
		String[] temp1 =str.split("");
		double[] eachPart1 =new double[temp1.length];
		double total=0;
		for(int i=0;i<temp1.length;i++){
			if(temp1[i].equals("1"))
			eachPart1[i]=Math.pow(2, -i);
			else eachPart1[i]=0;
			total+=eachPart1[i];
		}
		Double zhi =total*Math.pow(2, exponent);
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
		String[] temp =operand.split("");
		String result=new String();
		for(String cell:temp){
			if(cell.equals("1"))
				cell="0";
			else cell="1";
			result+=cell;
		}
		return result;
	}
	
	/**
	 * ���Ʋ�����<br/>
	 * ����leftShift("00001001", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand����nλ�Ľ��
	 */
	public String leftShift (String operand, int n) {
		String result=new String();
		for(int i=0;i<operand.length()-n;i++){
			char temp=operand.charAt(i+n);
			result+=temp;
		}
		for(int i=0;i<n;i++){
			result+="0";
		}
		return result;
		
	}
	
	/**
	 * �߼����Ʋ�����<br/>
	 * ����logRightShift("11110110", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand�߼�����nλ�Ľ��
	 */
	public String logRightShift (String operand, int n) {
		String result=new String();
		for(int i=0;i<n;i++){
			result+="0";
		}
		for(int i=0;i<operand.length()-n;i++){
			char temp=operand.charAt(i);
			result+=temp;
		}
		//System.out.println(result);
		return result;
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
		String result=new String();
		for(int i=0;i<n;i++){
			if(operand.startsWith("0"))
			result+="0";
			else result+="1";
		}
		for(int i=0;i<operand.length()-n;i++){
			char temp=operand.charAt(i);
			result+=temp;
		}
		//System.out.println(result);
		return result;
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
		char first=(char) (x&y|x&c|y&c);
		char second=(char)(x^y^c);
		String result=new String();
		result+=first;
		result+=second;
		return result;
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
		char[] s=new char[4];
		char[] cs=new char[5];
		char[] ope1=new char[4];
		char[] ope2=new char[4];
		char[] p=new char[4];
		char[] g =new char[4];
		for(int i=0;i<4;i++){
			ope1[i]=operand1.charAt(3-i);
			ope2[i]=operand2.charAt(3-i);
			p[i]=(char)(ope1[i]|ope2[i]);
			g[i]=(char)(ope1[i]&ope2[i]);
		}
		cs[0]=c;
		cs[1]=(char)(g[0]|p[0]&c);
		cs[2]=(char)(g[1]|p[1]&g[0]|p[1]&p[1]&c);
		cs[3]=(char)(g[2]|p[2]&g[1]|p[2]&p[1]&g[0]|p[2]&p[1]&p[0]&c);
		cs[4]=(char)(g[3]|p[3]&g[2]|p[3]&p[2]&g[1]|p[3]&p[2]&p[1]&g[0]|p[3]&p[2]&p[1]&p[0]&c);
		System.out.println(cs[4]+" "+cs[3]+" "+cs[2]+" "+cs[1]+" "+cs[0]);
		for(int i=0;i<4;i++){
			s[i]=new ALU().fullAdder(ope1[i], ope2[i], cs[i]).charAt(1);
		}
		StringBuilder result=new StringBuilder();
		result.append(cs[4]);
		result.append(s[3]);
		result.append(s[2]);
		result.append(s[1]);
		result.append(s[0]);
		
		return result.toString();
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
		char[] temp=new char[operand.length()+1];
		char[] cs =new char[operand.length()+1];
		cs[0]='1';
		for(int i=0;i<operand.length();i++){
			temp[i]=new ALU().menMoni(operand.charAt(operand.length()-1-i), cs[i]).charAt(1);
			cs[i+1]=new ALU().menMoni(operand.charAt(operand.length()-1-i), cs[i]).charAt(0);
			//System.out.println(temp[i]+" "+cs[i+1]);
		}
		if(cs[operand.length()]==cs[operand.length()-1])
			temp[operand.length()]='0';
		else temp[operand.length()]='1';
		StringBuilder result=new StringBuilder();
		for(int i=0;i<=operand.length();i++)	
			{result.append(temp[operand.length()-i]);
		}
		return result.toString();
	}
	//����ģ�� ��һλΪ��λ���ڶ�λΪ��
	public String menMoni (char ope1,char ope2){
		String result=new String();
		if(ope1==ope2){
			if(ope1=='0')
				result="00";
			else result="10";
		} else result ="01";
		return result;
		
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
		//���������������ĳ��ȵ�length
		if(operand1.length()<length){
			String temp=new String();
			for(int i=0;i<length-operand1.length();i++){
				temp+=operand1.charAt(0);
			}
			temp+=operand1;
			operand1=temp;
		}
		//System.out.println(operand1);
		if(operand2.length()<length){
			String temp=new String();
			for(int i=0;i<length-operand2.length();i++){
				temp+=operand2.charAt(0);
			}
			temp+=operand2;
			operand2=temp;
		}
		//System.out.println(operand2);
		
		int temp=length/4;//=2
		char[] cs=new char[temp+1];
		cs[0]=c;
		String[] temp3=new String[temp];
		//char first=operand1.charAt(0);
		//char second=operand2.charAt(0);
		int i=0; 
		do{
			String temp1 =operand1.substring(operand1.length()-4);
			//System.out.println(temp1);
			operand1=operand1.substring(0, operand1.length()-4);
			String temp2 =operand2.substring(operand2.length()-4);
			//System.out.println(temp2);
			operand2=operand2.substring(0, operand2.length()-4);

			temp3[i]=new ALU().claAdder(temp1, temp2, cs[i]).substring(1);
			//System.out.println(temp3[i]);
			cs[i+1]=new ALU().claAdder(temp1, temp2, cs[i]).charAt(0);
			i++;
		}while(operand1.length()!=0);
		//int a=(first&second&(~temp3[temp-1].charAt(0)));
		//int b=((~first)&(~second)&(temp3[temp-1].charAt(0)));
		//System.out.println(a+" "+b);
		char isOverflow ='0';
		if(cs[temp]=='1')
			isOverflow='1';
		//System.out.println(isOverflow);
		String result=new String();
		result+=isOverflow;
		for(int n=0;n<temp;n++){
			result+=temp3[temp-n-1];
		}
		return result;
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
		return new ALU().adder(operand1, operand2, '0', length);
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
		
		operand2=this.negation(operand2);
		operand2=this.oneAdder(operand2).substring(1);
		String result=this.integerAddition(operand1, operand2, length);
		return result;
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
		//fuoperand =-x
		//���������������ĳ��ȵ�length
				if(operand1.length()<length){
					String temp=new String();
					for(int i=0;i<length-operand1.length();i++){
						temp+=operand1.charAt(0);
					}
					temp+=operand1;
					operand1=temp;
				}
				//System.out.println(operand1);
				if(operand2.length()<length){
					String temp=new String();
					for(int i=0;i<length-operand2.length();i++){
						temp+=operand2.charAt(0);
					}
					temp+=operand2;
					operand2=temp;
				}
				//System.out.println(operand2);
		String fuoperand1=this.negation(operand1);
		fuoperand1=this.oneAdder(fuoperand1).substring(1);
		char[] yn=new char[length+1];
		yn[0]='0';
		for(int i=1;i<=length;i++){
			yn[i]=operand2.charAt(length-i);
		}//��y[n]��ֵ
		String y=operand2+'0';
		String result=new String();
		for(int i=0;i<length;i++){
			result+='0';
		}
		result+=y;
		//System.out.println(result);
		//initial 
		
		for(int i=0;i<length;i++){
			if(yn[i]-yn[i+1]==0){
				result=this.ariRightShift(result, 1);
				//continue;
				}
			if(yn[i]-yn[i+1]==-1){
				String temp=this.adder(fuoperand1, result.substring(0, length), '0', length).substring(1);
				result=temp+result.substring(length);
				//ystem.out.println(result);
				result=this.ariRightShift(result, 1);
				//continue;
			}
			if(yn[i]-yn[i+1]==1){
				//System.out.println(operand1+" "+result.substring(0, length));
				String temp=this.adder(operand1, result.substring(0, length), '0', length).substring(1);
				//System.out.println(temp);
				result=temp+result.substring(length);
				//System.out.println(result);
				result=this.ariRightShift(result, 1);
				//continue;
			}
			//System.out.println(result);
		}
		
		//�ж����
		char isOverflow='0';
		for(int i =0;i<length;i++){
			if(result.charAt(i)=='1'){
				isOverflow='1';
				break;
				}
		}
		result=isOverflow+result.substring(length,2*length);
		return result;
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
		String yikaishiope1=operand1;
		String fuoperand2=this.negation(operand2);
		fuoperand2=this.oneAdder(fuoperand2).substring(1);
		//���������������ĳ��ȵ�length
		if(operand1.length()<2*length){
			String temp=new String();
			for(int i=0;i<2*length-operand1.length();i++){
				temp+=operand1.charAt(0);
			}
			temp+=operand1;
			operand1=temp;
		}
		//System.out.println(operand1);
		if(operand2.length()<length){
			String temp=new String();
			for(int i=0;i<length-operand2.length();i++){
				temp+=operand2.charAt(0);
			}
			temp+=operand2;
			operand2=temp;
		}
		//System.out.println(operand2);
		for(int i=0;i<=length;i++){
			if(operand1.charAt(0)!=operand2.charAt(0)){
				String temp =this.adder(operand1.substring(0,length), operand2, '0', length).substring(1);
				operand1=temp+operand1.substring(length);
				//System.out.println(operand1);
				if(operand1.charAt(0)==operand2.charAt(0)){
					operand1+='1';
				}else{operand1+='0';
				}
				if(i!=length)
					operand1=operand1.substring(1);
				//System.out.println(operand1+" "+i);
				continue;
			}
			if(operand1.charAt(0)==operand2.charAt(0)){
				String temp =this.adder(operand1.substring(0,length), fuoperand2, '0', length).substring(1);
				operand1=temp+operand1.substring(length);
				//System.out.println(operand1);
				if(operand1.charAt(0)==operand2.charAt(0)){
					operand1+='1';
				}else{operand1+='0';
				}
				if(i!=length)
					operand1=operand1.substring(1);
				//System.out.println(operand1+" "+i);
				continue;
			}
		}
		
		String remainder=new String();
		String quotient=operand1.substring(length+1);
		char isOverflow =this.oneAdder(quotient).charAt(0);
		quotient=this.oneAdder(quotient).substring(1);
		if(operand1.charAt(0)==yikaishiope1.charAt(0)){
			remainder=operand1.substring(0,length);
		}else{
			remainder=operand1.substring(0,length);//System.out.println(remainder);
			remainder=this.adder(remainder, fuoperand2, '0', length).substring(1);
		}
		//System.out.println(remainder);
		return isOverflow+quotient+remainder;
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
		String result=new String();
		
		if(operand1.charAt(0)==operand2.charAt(0)){
			char sign =operand1.charAt(0);
			//System.out.println(sign);
			operand1=operand1.substring(1);
			operand2=operand2.substring(1);
			//���������������ĳ��ȵ�length
			if(operand1.length()<length){
				String temp=new String();
				for(int i=0;i<length-operand1.length();i++){
					temp+='0';
				}
				temp+=operand1;
				operand1=temp;
			}
			//System.out.println(operand1);
			if(operand2.length()<length){
				String temp=new String();
				for(int i=0;i<length-operand2.length();i++){
					temp+='0';
				}
				temp+=operand2;
				operand2=temp;
			}
			//System.out.println(operand2);
			
			String temp=this.adder(operand1, operand2, '0', length).substring(1);
			char isOverflow =this.adder(operand1, operand2, '0', length).charAt(0);
			//System.out.println(isOverflow);
			result =isOverflow+""+sign+temp;
		}else{
			char sign1=operand1.charAt(0);
			char sign2 =operand2.charAt(0);
			
			operand1=operand1.substring(1);
			operand2=operand2.substring(1);
			
			//���������������ĳ��ȵ�length
			if(operand1.length()<length){
				String temp=new String();
				for(int i=0;i<length-operand1.length();i++){
					temp+='0';
				}
				temp+=operand1;
				operand1=temp;
			}
			System.out.println(operand1);
			if(operand2.length()<length){
				String temp=new String();
				for(int i=0;i<length-operand2.length();i++){
					temp+='0';
				}
				temp+=operand2;
				operand2=temp;
			}
			System.out.println(operand2);
			
			String temp;
			char sign;
			System.out.println(this.adder(operand1, this.negation(operand2), '0', operand2.length())/*.charAt(0)=='0'*/);
			if(this.adder(operand1, this.negation(operand2), '0', operand2.length()).charAt(0)=='0'){
				temp =this.adder(operand1, this.negation(operand2), '0', operand2.length()).substring(1);
				sign=sign2;
				}
			else{
				temp =this.adder(operand2, this.negation(operand1), '0', operand2.length()).substring(1);
				sign =sign1;
			}
			
			temp =this.negation(temp);
			
			char isOverflow='0';
			result=isOverflow+""+sign+temp;
		}
		return result;
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
