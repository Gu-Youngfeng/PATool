package sklse.yongfeng.spoon;

public class Person {
	
	private String name;
	private String gender;
	private int age;
	
	Person(String n, String g, int a){
		
		if(Check(n, g, a)){
			this.name = n;
			this.gender = g;
			this.age = a;
		}else{
			this.name = "None";
			this.gender = "None";
			this.age = -1;
		}
	}
	
	public void showPerson(){
		System.out.printf("Name:%16s.\nGender:%14s.\nAge:%17d.", name, gender, age);
	}
	
	public boolean Check(String n, String g, int a){
		boolean flag = true;
		
		try{
			n.replaceAll(" ", "-");
		}catch(Exception e){
			System.out.println("Replacement Error!");
		}
		
		try{
			g.toUpperCase();
		}catch(Exception e){
			System.out.println("Upperation Error!");
		}
		
		try{
			// do nothing
		}catch(Exception e){
			System.out.println("Exception!");
		}
		
		try{
			// do nothing
		}catch(Exception e){
			// do nothing
		}
		
		for(int i=0; i<a; i++){
			a++;
			a--;
		}
		
		return flag;
	}

}
