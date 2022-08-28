import java.util.*;
class AccountActions
{
	int balance;
	
	void Deposit(int amount)
	{
		System.out.println("deposited"+amount);
		balance+=amount;
	}


	void Withdrawn(int amount)
	{		

		if(balance>=amount)
		{
		
			System.out.println("captcha:");
			
			String captcha=GenerateCaptcha(5);
			System.out.println(captcha);
			
			
			Scanner input = new Scanner(System.in);
    			System.out.println("Enter captcha");

    			String user_captcha = input.nextLine();  
    			//System.out.println("Username is: " + userName); 
			
			int compare=captcha.compareTo(user_captcha);
			
			if(compare==0)
			{
				System.out.println("withdrawn"+amount);
				balance-=amount;
			}
			else
			{
				Withdrawn(amount);
			}

		}
		else
		{
			try
			{
				throw new Exception();
			}
			catch(Exception e)
			{
				System.out.println("cannot withdrawn amount ");
				CheckBalance();
			}
		}
	}

	void CheckBalance()
	{
		System.out.println("account balance is"+balance);
	}

	 static String GenerateCaptcha(int n)
   	 {
        		//to generate random integers in the range [0-61]
       		 Random rand = new Random(36);
         
       		 // Characters to be included
       		 char chrs[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
      
      
        		// Generate n characters from above set and
       		 // add these characters to captcha.
       		String captcha = "";
       		for(int i=0;i<=n;i++)
			{
				
           			captcha+=chrs[rand.nextInt(chrs.length)];
        		}
           
        	return captcha;
   	 }
	
	
}
class BankAccount
{
	public static void main(String args[])
	{
		Bank cust=new Bank();


		Scanner my_obj = new Scanner(System.in);  
    		System.out.println("Enter username");

    		String userName = my_obj.nextLine();  
    		System.out.println("Username is: " + userName); 

	
		cust.Withdrawn(123);
		cust.Withdrawn(43);
		//cust.Withdrawn();
		cust.Deposit(523);
		cust.Withdrawn(134);
		cust.CheckBalance();



	}

}