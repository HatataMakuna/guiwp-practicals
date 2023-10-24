package entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Sale {

  private Calendar date;
  private static int nextSaleID = 1001;
  private int saleID;
  private Coffee coffee;
  private int quantity;

  public Sale() {
    this.date = new GregorianCalendar();
    this.saleID = nextSaleID++;
  }

  public Sale(Coffee coffee, int quantity) {
    this.coffee = coffee;
    this.quantity = quantity;
    this.date = new GregorianCalendar();
    this.saleID = nextSaleID++;
  }

  public Coffee getCoffee() {
    return coffee;
  }

  public Calendar getDate() {
    return date;
  }

  public static int getNextSaleID() {
    return nextSaleID;
  }

  public int getSaleID() {
    return saleID;
  }

  public void setCoffee(Coffee coffee) {
    this.coffee = coffee;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotal() {
    return quantity * coffee.getPrice();
  }
}
