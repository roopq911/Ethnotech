class Electricity{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the electricity bill");
		int units=sc.nextInt();
		int bill=0;
		if(units<=200){
			bill=0;
		}
		else if(units>200 && units<=300){
			bill=50;
		}
		else if(units>1000){
			bill=200;
		}
		else{
			bill=300;
		}
		System.out.println("Electricity bill:"+bill);
		sc.close();
	}
}










+

