package client;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.math.BigDecimal;
import compute.Compute;

public class ComputePi {
    public static void main(String args[]) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = "Compute";

            Scanner scanner = new Scanner(System.in);
            Registry registry = LocateRegistry.getRegistry("localhost");
            System.out.println("Enter the values from 1 to 3 \n");
            int i = scanner.nextInt();

            switch(i)
            {
            case 1:

                Compute comp = (Compute) registry.lookup(name);

                System.out.println("Number of digits is \n");
                int no_of_digits=scanner.nextInt();
                Pi task = new Pi(no_of_digits);
                BigDecimal pi = comp.executeTask(task);
                System.out.println(pi);
                break;
            case 2:


                Compute comp_1 = (Compute) registry.lookup(name);

                System.out.println("Enter the minimum number");
                int min=scanner.nextInt();
                System.out.println("Enter the maximum number");
                int max=scanner.nextInt();

                Primes task2=new Primes(min,max);
//                String result=task2.computePrime(min,max);
                String result=comp_1.executeTask(task2);
                System.out.println(result);
                break;
            
            case 3:
            	System.exit(0);
            }

        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
    
}