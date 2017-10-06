package sklse.yongfeng.jslicer;

public class Hello {

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(n + "! = " + Factorial(n));
		int num1 = 15,
			num2 = 20;
		System.out.println("Maximun of <" + num1 + ", " + num2 + "> = " + MaximumDivisor(num1, num2));
	}
	
	public static int Factorial(int n){
		if(n == 0 || n == 1){
			return 1;
		}else{
			return Factorial(n-1) * n;
		}
	}
	
	public static int MaximumDivisor(int num1, int num2){
		int divisor = num1>num2?num1:num2;
		while(divisor > 0){
			if(num1%divisor == 0 && num2%divisor ==0){
				break;
			}
			divisor--;
		}	
		return divisor;
	}

}
