import java.util.Scanner;


public class NuPack {
	
	public static double markup_pricing(String price, String people, String category)
	{
		String job_price = price.replace("$","");
		double base_price = Double.parseDouble(job_price);
		//flat mark up 5% each
		double base_mp_price = ((base_price*5)/100)+base_price;
		
		//for people 1.2% each
		people = people.substring(0,people.indexOf("p"));
		int price_people = Integer.parseInt(people);
		double personmp = ((base_mp_price*price_people*1.2)/100);
		
		double categorymp;
		if(category.equals("pharmaceuticals") || category.equals("drugs") || category.equals("medicines"))
		{
			categorymp=((base_mp_price*7.5)/100);
		}
		else if(category.equals("food"))
		{
			categorymp=((base_mp_price*13)/100);
		}
		else if(category.equals("electronics"))
		{
			categorymp=((base_mp_price*2)/100);
		}
		else
		{
			categorymp = 0.0;
		}
		return base_mp_price + personmp + categorymp;
	}
	public static double quantity_calc(double price, int quantity){
		return quantity * price;
	}
	public static void main(String args[])
	{
	    while(true)
	    {
			System.out.println("Enter the price(include ,),number of people required for the job and cateory");
			Scanner sc1=new Scanner(System.in);
			String input_string = sc1.nextLine();
			System.out.println("Enter the quantity to be repackaged");
			int quant;
			quant = sc1.nextInt();
			
			//remove all spaces
			input_string = input_string.replace(" ","");
			//remove the first comma from the price
			input_string = input_string.replaceFirst(",","");
			
			String price = null, person = null, category = null;
			try
			{
				String[] temp = input_string.split(","); 
				price = temp[0];
			    person = temp[1];
			    category = temp[2];
			    System.out.println("" + quantity_calc(markup_pricing(price, person, category),quant));
			    sc1.close();
			    break;
			}
			catch(Exception e)
			{
				
				System.out.println("Please enter a price with ,");
				continue;
			}
	  }
		
	}

}
