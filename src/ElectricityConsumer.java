import java.util.Scanner;
public class ElectricityConsumer {

    int consumer_number;
    String consumer_name;
    int previous_month_reading;
    double bill_amount_Bimonthly;
    int current_month_reading;
    int units_consumed;
    boolean BiMonthly = false;
    int number_of_units_consumed;
    double sum;
    int number_of_Units_Monthly_Consumed;
    double bill_amount_Monthly;
    double profitForConsumer;
    public void displayDomesticFares_BiMonth_Monthly() {
        System.out.println("Domestic Fare Details Monthly & Bi- Monthly");
        System.out.println("*******************************************");
        System.out.println("First  100 units   -   Rs.  0    per unit");
        System.out.println("101 -  200 units   -   Rs.  2.25 per unit Only For Subsidy Eligible Consumer");
        System.out.println("101 -  400 units   -   Rs.  4.50 per unit");
        System.out.println("401 -  500 units   -   Rs.  6    per unit");
        System.out.println(" up to 500 units   -   Rs. 225   subsidy");
        System.out.println("501 -  600 units   -   Rs.  8    per unit");
        System.out.println("601 -  800 units   -   Rs.  9    per unit");
        System.out.println("801 - 1000 units   -   Rs. 10    per unit");
        System.out.println("    > 1001 units   -   Rs. 11    per unit\n");
    }

    public void getDetails() {
        Scanner inputs = new Scanner(System.in);
        System.out.println("Welcome To Electricity Bill Calculator MonthWise");
        System.out.println("************************************************");
        System.out.println("Please Enter Your Name : ");
        this.consumer_name = inputs.nextLine().toUpperCase();
        System.out.println("Please Enter Your Consumer Number : ");
        this.consumer_number = inputs.nextInt();
        System.out.println("Please Enter Your Previous Month Reading : ");
        this.previous_month_reading = inputs.nextInt();
        System.out.println("Please Enter Your Current Month Reading : ");
        this.current_month_reading = inputs.nextInt();
        System.out.println("Is this Bi-Monthly Connection (yes/no) : ");
        if (inputs.next().equals("yes"))
            this.BiMonthly = true;
    }

    public void unitCalculation() {
        this.number_of_units_consumed = this.current_month_reading - this.previous_month_reading;
        this.units_consumed = number_of_units_consumed;
        System.out.println("Total Unit Consumed = " + units_consumed+" Units");
        System.out.println("*******************");

    }
    public void generateBill_BiMonthly() {
        unitCalculation();
        sum = 0;
        for (int i = 1; i <= number_of_units_consumed; i++) {
            if (i <= 100) {
                sum = sum + 0;
            }else if (i <= 200 && units_consumed<=500) {
                sum = sum + 2.25;
            } else if (i <= 400) {
                sum = sum + 4.50;
            } else if (i <= 500) {
                sum = sum + 6;
            } else if (i  <= 600) {
                sum = sum + 8;
            } else if (i  <= 800) {
                sum = sum + 9;
            } else if (i  <= 1000) {
                sum = sum + 10;
            } else {
                sum = sum + 11;
            }
        }
        this.bill_amount_Bimonthly = sum;
        System.out.println("Bill Amount Bi-Monthly For "+units_consumed+" Units"+" is Rs. "+ bill_amount_Bimonthly);
    }

    public void generateBill_Monthly() {
    unitCalculation();
        if (BiMonthly){
            this.number_of_Units_Monthly_Consumed = units_consumed / 2;
            System.out.println("Average of Per Month Unit Consumed = "+number_of_Units_Monthly_Consumed+" Units");
        }
        else {

            this.number_of_Units_Monthly_Consumed = units_consumed;
            System.out.println("Consumer Units Consumed: "+number_of_Units_Monthly_Consumed+" Units");
        }

        sum = 0;
        for (int i = 1; i <= number_of_Units_Monthly_Consumed; i++) {
            if (i <= 100) {
                sum = sum + 0;
            }else if (i <= 200 && number_of_Units_Monthly_Consumed<=500) {
                sum = sum + 2.25;
            } else if (i <= 400) {
                sum = sum + 4.50;
            } else if (i <= 500) {
                sum = sum + 6;
            } else if (i  <= 600) {
                sum = sum + 8;
            } else if (i  <= 800) {
                sum = sum + 9;
            } else if (i  <= 1000) {
                sum = sum + 10;
            } else {
                sum = sum + 11;
            }
        }
        this.bill_amount_Monthly = sum;
        System.out.println("Bill Amount monthly is Rs: "+ bill_amount_Monthly);
    }

    public void averageProfit() {
        profitForConsumer= bill_amount_Bimonthly - bill_amount_Monthly*2;
        System.out.println("\n############################################################################");
        System.out.println("\nAverage Profit For Consumer Paid The Bill Monthly is Rs: "+profitForConsumer);
        System.out.println("\n############################################################################");
    }

    public void displayDetails() {
        System.out.println("The Electricity Bill Details");
        System.out.println("****************************");
        System.out.println("Consumer Number : "+this.consumer_number);
        System.out.println("Consumer Name : "+this.consumer_name);
    }
    public void displayBill() {
        if (BiMonthly){
            displayDetails();
            generateBill_BiMonthly();
            System.out.println("\nIn Case You Pay The Bill MonthlyWise");
            System.out.println("************************************");
            generateBill_Monthly();
            averageProfit();
        }
        else {
            displayDetails();
            generateBill_Monthly();
        }
    }

}