//Mortgage.java

public class Mortgage {
    
    public static void main (String[] args){
        double payment, principal = 80000;
        double annualInterest = .065;
        int years = 15;
        
        if (args.length == 3) {
           try {
              principal = Double.parseDouble(args[0]);
              annualInterest = Double.parseDouble(args[1]);
              years = Integer.parseInt(args[2]);
           }
           catch (Exception e) {
              System.out.println("Wrong input " + e.getMessage() );
              System.exit(0);
           }
           print(principal, annualInterest, years);
        
        } else {
            System.out.println("Usage: java Mortgage principal annualInterest years ");
            System.out.println("\nFor example: java Mortgage 80000 .065 15 ");
            System.out.println("\nYou will get the output like the following: \n");
	    print(principal, annualInterest, years);
            System.exit(0);
        }
    }
    public static double calculatePayment(double principal, double annRate, int years){
        double monthlyInt = annRate / 12;
        double monthlyPayment = (principal * monthlyInt)
                    / (1 - Math.pow(1/ (1 + monthlyInt), years * 12));
        return format(monthlyPayment, 2);
    }
    public static double format(double amount, int places) {
        double temp = amount; 
        temp = temp * Math.pow(10, places);
        temp = Math.round(temp);
        temp = temp/Math.pow(10, places);
        return temp;
    }
    public static void print(double pr, double annRate, int years){
        double mpayment = calculatePayment(pr, annRate, years);
        System.out.println("The principal is $" + (int)pr);
        System.out.println("The annual interest rate is " + format(annRate * 100, 2) +"%");
        System.out.println("The term is " + years + " years");
        System.out.println("Your monthly payment is $" + mpayment);
    }
}
