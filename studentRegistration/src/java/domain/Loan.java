package domain;

public class Loan {
    private double amount;
    private double rate;
    private int yr;

    public Loan() {
    }
    
    public Loan(double amount, double rate, int yr) {
        this.amount = amount;
        this.rate = rate;
        this.yr = yr;
    }

//    public double getBMI() {
//        return weight / (height * height);
//    }

//    public String getStatus() {
//        double bmi = getBMI();
//        if (bmi < 16) {
//            return "Seriously underweight";
//        } else if (bmi < 18) {
//            return "Underweight";
//        } else if (bmi < 24) {
//            return "Normal";
//        } else if (bmi < 29) {
//            return "Overweight";
//        } else if (bmi < 35) {
//            return "Obese Class I";
//        } else {
//            return "Obese Class II, III";
//        }
//    }

    public double getAmount() {
        return amount;
    }
    public double getRate() {
        return rate;
    }
    public int getYr() {
        return yr;
    }
}