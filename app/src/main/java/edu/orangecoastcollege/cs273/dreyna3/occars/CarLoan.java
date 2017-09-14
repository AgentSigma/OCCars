package edu.orangecoastcollege.cs273.dreyna3.occars;

/**
 * Created by dreyna3 on 9/14/2017.
 */

public class CarLoan {

    private static final double STATE_TAX = 0.08;
    private double mPrice;
    private double mDownPayment;
    private int mTerm;

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    public int getTerm() {
        return mTerm;
    }

    public void setTerm(int term) {
        mTerm = term;
    }

    public double borrowedAmount(){
        return mPrice - mDownPayment;
    }

    public double taxAmount(){
        return mPrice * STATE_TAX;
    }

    public double totalAmount(){
        return mPrice + taxAmount();
    }

    public double interestAmount() {
        double interestRate;
        /*
        3 = 4.62% apr
        4 = 4.19% apr
        5 = 4.16% apr
         */
        switch (mTerm) {
            case 3:
                interestRate = 0.462;
                break;
            case 4:
                interestRate = 0.419;
                break;
            case 5:
                interestRate = 0.416;
                break;
            default:
                //never reached
                interestRate = 0.0;
                break;
        }
        return borrowedAmount() * interestRate;
    }

    public double monthlyPayment(){
        return (borrowedAmount() * interestAmount()) / (mTerm * 12);
    }

}
