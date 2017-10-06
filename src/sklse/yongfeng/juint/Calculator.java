package sklse.yongfeng.juint;

/** Calculator implements the basic operation of 2 numbers*/
public class Calculator {
	
	private int num1 = 0;
	
	private int num2 = 0;
	
	private int result = 0;
	
	Calculator(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int Add(){
		this.result = this.num1 + this.num2;
		return this.result;
	}
	
	public int Minus(){
		this.result = this.num1 - this.num2;
		return this.result;
	}
	
	public int Multiply(){
		this.result = this.num1 * this.num2;
		return this.result;
	}
	
	public int Divide(){
		this.result = this.num1 / this.num2; // here exist two bugs
		return this.result;
	}
	
	public int Mode(){
		this.result = this.num1 % this.num2; 
		return this.result;
	}
	
	public int Max(){
		if(this.num1 > this.num2){
			this.result = this.num1;
		}else{
			this.result = this.num2;
		}
		return this.result;
	}

}
