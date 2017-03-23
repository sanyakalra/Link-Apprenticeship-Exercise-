import java.util.Scanner;


public class NuPack {
	
	public static double markup_pricing(String job, String people, String category)
	{
		String newjob = job.replace("$","");
		double base_price = Double.parseDouble(newjob);
		//flat mark up 5% each
		double base_mp_price = ((base_price*5)/100)+base_price;
		
		//for people 1.2% each
		people = people.substring(0,people.indexOf("p"));
		int price_people = Integer.parseInt(people);
		double personmp = ((base_price*price_people*1.2)/100);
		
		double categorymp;
		if(category.equals("pharmaceuticals") || category.equals("drugs") || category.equals("medicines"))
		{
			categorymp=((base_price*7.5)/100);
		}
		else if(category.equals("food"))
		{
			categorymp=((base_price*13)/100);
		}
		else if(category.equals("electronics"))
		{
			categorymp=((base_price*2)/100);
		}
		else
		{
			categorymp = 0.0;
		}
		return base_mp_price + personmp + categorymp;
	}
	public static void main(String args[])
	{
		
		Scanner sc1=new Scanner(System.in);
		String input_string = sc1.nextLine();
		sc1.close();
		
		System.out.println("" + markup_pricing(price, person, category));
	}

}
