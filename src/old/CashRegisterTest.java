package old;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CashRegisterTest {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        RetailItem retailItem = new RetailItem("Long Sleeve Shirt", 20293, 15, 20);

        System.out.println("What is the quantity of items being purchased?");
        int quantity = keyboard.nextInt();

        CashRegister cashCounter = new CashRegister(retailItem, quantity);

        System.out.println("Description");
        System.out.println(retailItem.toString());
        System.out.println("Cash Register");
        System.out.println("Sub total :"+cashCounter.getSubTotal());
        System.out.println("Tax : "+cashCounter.getTax()+"%");
        System.out.println("Total Pay : "+cashCounter.getTotal());
    }
}

class RetailItem {
    private String description;
    private int itemNumber;

    private CostData cost;

    public RetailItem(String desc, int itemNum, double wholesale, double retail) {
        description = desc;
        itemNumber = itemNum;
        cost = new CostData(wholesale, retail);
    }

    public void setWholesale(double w) {
        cost.wholesale = w;
    }

    public void setRetail(double r) {
        cost.retail = r;
    }

    public double getWholesale() {
        return cost.wholesale;
    }

    public double getRetail() {
        return cost.retail;
    }

    public String toString()
    {
        String str;
        DecimalFormat dollar = new DecimalFormat("#,##0.00");

        str = "Description: " + description
                + "\nItem Number is: " + itemNumber
                + "\nWholesale Cost is: $"
                + dollar.format(cost.wholesale)
                + "\nRetail Price is: $"
                + dollar.format(cost.retail);
        return str;
    }

    private class CostData {
        public double wholesale;
        public double retail;

        public CostData(double w, double r) {
            wholesale = w;
            retail = r;
        }
    }
}

class CashRegister {
    private RetailItem retailItem;
    private int quantity;

    public CashRegister(RetailItem retailItem,int quanitity) {
        this.retailItem=retailItem;
        this.quantity=quanitity;
    }

    public double getSubTotal() {
        double subTotal=0;
        subTotal=retailItem.getRetail()*quantity;
        return subTotal;
    }

    public double getTax() {
        return retailItem.getRetail()*0.06;
    }

    public double getTotal() {
        return getSubTotal()+getTax();
    }
}