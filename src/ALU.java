/**
 * 模拟ALU进行整数和浮点数的四则运算
 * @151250095_刘港欢 [请将此处修改为“学号_姓名”]
 *
 */

public class ALU {

	/**
	 * 生成十进制整数的二进制补码表示。<br/>
	 * 例：integerRepresentation("9", 8)
	 * @param number 十进制整数。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param length 二进制补码表示的长度
	 * @return number的二进制补码表示，长度为length
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
	 * 生成十进制浮点数的二进制表示。
	 * 需要考虑 0、反规格化、正负无穷（“+Inf”和“-Inf”）、 NaN等因素，具体借鉴 IEEE 754。
	 * 舍入策略为向0舍入。<br/>
	 * 例：floatRepresentation("11.375", 8, 11)
	 * @param number 十进制浮点数，包含小数点。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return number的二进制表示，长度为 1+eLength+sLength。从左向右，依次为符号、指数（移码表示）、尾数（首位隐藏）
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
				//System.out.println("小数的十进制 " +xiaoshuDec);
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
				//System.out.println("小数的十进制 " +xiaoshuDec);
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
		
		
		
		//分离整数与小数
		String zhengshu=number.substring(0,number.indexOf("."));
		String xiaoshu ="0"+number.substring(number.indexOf("."));
		String exponentBin=new String();
		
		//整数部分变为二进制表达
		String[] str =zhengshu.split("");
		
		StringBuilder zhengshuBin =new StringBuilder();
		int beginOfNum=0;
		if(str[0].equals("-")){
			sign ="1";
			beginOfNum=1;
		}
		//System.out.println("符号位"+sign);
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
		//System.out.println("整数bin "+zhengshuBin);//测试整数bin是否正确
		
		
		//把小数部分变为二进制表达
		 xiaoshuBin=new StringBuilder();
		xiaoshuDec=Double.parseDouble(xiaoshu);
		//System.out.println("小数的十进制 " +xiaoshuDec);
		while(xiaoshuDec!=(int)xiaoshuDec){
			xiaoshuBin.append((int)(xiaoshuDec*2));
			xiaoshuDec =xiaoshuDec*2-(int)(xiaoshuDec*2);
		}
		
		//if（）为判断整数部分对指数的影响，并且把部分整数bin加入尾数 如果整数部分为0，则跳入else（由分数部分决定指数的值）
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
		};//在这里添加由尾数决定指数的公式
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
			System.out.println("指数部分"+exponentBin);//错误*/
		
		//System.out.println("指数部分"+exponentBin);
		weishu=zhengshuBin.toString()+xiaoshuBin.toString();
		weishu=weishu.substring(weishu.indexOf("1")+1);//尾数已经去1（没有不够长加0，也没有向0取舍）
		//对位数的处理
		//System.out.println(weishu);
		while(weishu.length()<sLength)
			weishu+="0";//while当尾数不够长时增加0
		if(weishu.length()>sLength)
			weishu=weishu.substring(0, sLength);
		return sign+exponentBin+weishu;
	}
	
	/**
	 * 生成十进制浮点数的IEEE 754表示，要求调用{@link #floatRepresentation(String, int, int) floatRepresentation}实现。<br/>
	 * 例：ieee754("11.375", 32)
	 * @param number 十进制浮点数，包含小数点。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param length 二进制表示的长度，为32或64
	 * @return number的IEEE 754表示，长度为length。从左向右，依次为符号、指数（移码表示）、尾数（首位隐藏）
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
	 * 计算二进制补码表示的整数的真值。<br/>
	 * 例：integerTrueValue("00001001")
	 * @param operand 二进制补码表示的操作数
	 * @return operand的真值。若为负数；则第一位为“-”；若为正数或 0，则无符号位
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
	 * 计算二进制原码表示的浮点数的真值。<br/>
	 * 例：floatTrueValue("01000001001101100000", 8, 11)
	 * @param operand 二进制表示的操作数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return operand的真值。若为负数；则第一位为“-”；若为正数或 0，则无符号位。正负无穷分别表示为“+Inf”和“-Inf”， NaN表示为“NaN”
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
	 * 按位取反操作。<br/>
	 * 例：negation("00001001")
	 * @param operand 二进制表示的操作数
	 * @return operand按位取反的结果
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
	 * 左移操作。<br/>
	 * 例：leftShift("00001001", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 左移的位数
	 * @return operand左移n位的结果
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
	 * 逻辑右移操作。<br/>
	 * 例：logRightShift("11110110", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 右移的位数
	 * @return operand逻辑右移n位的结果
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
	 * 算术右移操作。<br/>
	 * 例：logRightShift("11110110", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 右移的位数
	 * @return operand算术右移n位的结果
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
	 * 全加器，对两位以及进位进行加法运算。<br/>
	 * 例：fullAdder('1', '1', '0')
	 * @param x 被加数的某一位，取0或1
	 * @param y 加数的某一位，取0或1
	 * @param c 低位对当前位的进位，取0或1
	 * @return 相加的结果，用长度为2的字符串表示，第1位表示进位，第2位表示和
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
	 * 4位先行进位加法器。要求采用{@link #fullAdder(char, char, char) fullAdder}来实现<br/>
	 * 例：claAdder("1001", "0001", '1')
	 * @param operand1 4位二进制表示的被加数
	 * @param operand2 4位二进制表示的加数
	 * @param c 低位对当前位的进位，取0或1
	 * @return 长度为5的字符串表示的计算结果，其中第1位是最高位进位，后4位是相加结果，其中进位不可以由循环获得
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
	 * 加一器，实现操作数加1的运算。
	 * 需要采用与门、或门、异或门等模拟，
	 * 不可以直接调用{@link #fullAdder(char, char, char) fullAdder}、
	 * {@link #claAdder(String, String, char) claAdder}、
	 * {@link #adder(String, String, char, int) adder}、
	 * {@link #integerAddition(String, String, int) integerAddition}方法。<br/>
	 * 例：oneAdder("00001001")
	 * @param operand 二进制补码表示的操作数
	 * @return operand加1的结果，长度为operand的长度加1，其中第1位指示是否溢出（溢出为1，否则为0），其余位为相加结果
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
	//与门模拟 第一位为进位，第二位为和
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
	 * 加法器，要求调用{@link #claAdder(String, String, char)}方法实现。<br/>
	 * 例：adder("0100", "0011", ‘0’, 8)
	 * @param operand1 二进制补码表示的被加数
	 * @param operand2 二进制补码表示的加数
	 * @param c 最低位进位
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相加结果
	 */
	public String adder (String operand1, String operand2, char c, int length) {
		//增加两个操作数的长度到length
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
	 * 整数加法，要求调用{@link #adder(String, String, char, int) adder}方法实现。<br/>
	 * 例：integerAddition("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被加数
	 * @param operand2 二进制补码表示的加数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相加结果
	 */
	public String integerAddition (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return new ALU().adder(operand1, operand2, '0', length);
	}
	
	/**
	 * 整数减法，可调用{@link #adder(String, String, char, int) adder}方法实现。<br/>
	 * 例：integerSubtraction("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被减数
	 * @param operand2 二进制补码表示的减数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相减结果
	 */
	public String integerSubtraction (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		
		operand2=this.negation(operand2);
		operand2=this.oneAdder(operand2).substring(1);
		String result=this.integerAddition(operand1, operand2, length);
		return result;
	}
	
	/**
	 * 整数乘法，使用Booth算法实现，可调用{@link #adder(String, String, char, int) adder}等方法。<br/>
	 * 例：integerMultiplication("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被乘数
	 * @param operand2 二进制补码表示的乘数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的相乘结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相乘结果
	 */
	public String integerMultiplication (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		//fuoperand =-x
		//增加两个操作数的长度到length
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
		}//对y[n]赋值
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
		
		//判断溢出
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
	 * 整数的不恢复余数除法，可调用{@link #adder(String, String, char, int) adder}等方法实现。<br/>
	 * 例：integerDivision("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被除数
	 * @param operand2 二进制补码表示的除数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为2*length+1的字符串表示的相除结果，其中第1位指示是否溢出（溢出为1，否则为0），其后length位为商，最后length位为余数
	 */
	public String integerDivision (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		String yikaishiope1=operand1;
		String fuoperand2=this.negation(operand2);
		fuoperand2=this.oneAdder(fuoperand2).substring(1);
		//增加两个操作数的长度到length
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
	 * 带符号整数加法，可以调用{@link #adder(String, String, char, int) adder}等方法，
	 * 但不能直接将操作数转换为补码后使用{@link #integerAddition(String, String, int) integerAddition}、
	 * {@link #integerSubtraction(String, String, int) integerSubtraction}来实现。<br/>
	 * 例：signedAddition("1100", "1011", 8)
	 * @param operand1 二进制原码表示的被加数，其中第1位为符号位
	 * @param operand2 二进制原码表示的加数，其中第1位为符号位
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度（不包含符号），当某个操作数的长度小于length时，需要将其长度扩展到length
	 * @return 长度为length+2的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），第2位为符号位，后length位是相加结果
	 */
	public String signedAddition (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		String result=new String();
		
		if(operand1.charAt(0)==operand2.charAt(0)){
			char sign =operand1.charAt(0);
			//System.out.println(sign);
			operand1=operand1.substring(1);
			operand2=operand2.substring(1);
			//增加两个操作数的长度到length
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
			
			//增加两个操作数的长度到length
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
	 * 浮点数加法，可调用{@link #signedAddition(String, String, int) signedAddition}等方法实现。<br/>
	 * 例：floatAddition("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 二进制表示的被加数
	 * @param operand2 二进制表示的加数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @param gLength 保护位的长度
	 * @return 长度为2+eLength+sLength的字符串表示的相加结果，其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatAddition (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 浮点数减法，可调用{@link #floatAddition(String, String, int, int, int) floatAddition}方法实现。<br/>
	 * 例：floatSubtraction("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 二进制表示的被减数
	 * @param operand2 二进制表示的减数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @param gLength 保护位的长度
	 * @return 长度为2+eLength+sLength的字符串表示的相减结果，其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatSubtraction (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 浮点数乘法，可调用{@link #integerMultiplication(String, String, int) integerMultiplication}等方法实现。<br/>
	 * 例：floatMultiplication("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 二进制表示的被乘数
	 * @param operand2 二进制表示的乘数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return 长度为2+eLength+sLength的字符串表示的相乘结果,其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatMultiplication (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 浮点数除法，可调用{@link #integerDivision(String, String, int) integerDivision}等方法实现。<br/>
	 * 例：floatDivision("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 二进制表示的被除数
	 * @param operand2 二进制表示的除数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return 长度为2+eLength+sLength的字符串表示的相乘结果,其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatDivision (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
}
