/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
public class TestCircleWithInvalidRadiusException {
	public static void main(String[] args) {
    try {
     	CircleWithException2 c1 = new CircleWithException2(-5);
     	c1.setRadius(-4);
     	CircleWithException2 c3 = new CircleWithException2(0);
    }
    catch (InvalidRadiusException ex) {
     	System.out.println(ex.toString());
    }
    System.out.println("Number of objects created: " + CircleWithException2.getNumberOfObjects());
  }
}
