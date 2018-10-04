package client;

import java.io.Serializable;

import compute.Task;

public class Primes implements Task<String>,Serializable {

	
	private static final long serialVersionUID = 1L;
	private final  int max;
	private final int min;
	
	

	
		public Primes(int max,int min)
		{
			this.max=max;
			this.min=min;
		}
		
		@Override
		public String execute() {
			return computePrime(min,max);
		}
		
		public static String computePrime(int min,int max)
		{
			String placeHolder="";
			for(int i=min;i<=max;i++) 
			{
				
				if(i==2 || i==3 || i==5 || i==7) 
				{
					placeHolder=placeHolder+" "+ i;
				}
				if(i!=1 && i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0)
				{
				placeHolder=placeHolder+" "+ i;
				}
				
			}
			
			return placeHolder;
			
		}
			

	
}
