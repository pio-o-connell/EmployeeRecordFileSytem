/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuMainDriver;

import java.util.*;

/**
 *
 * @author Pio O'Connell
 */

public class Managerial extends Employee {

    private double nmrDaysWorked;
    private String label = "Full Time Managerial";

    public Managerial(String employee_id0, String name0, String address0, double salary0, Calendar startDate0) {
        super(employee_id0, name0, address0, salary0, startDate0);

    }

    public Managerial() {

    }

    public double computeHolidayPay() {
        return nmrDaysWorked * 0.04;
    }

    /*public void setNmrDaysWorked(double nmrDaysWorked0)
	{
		nmrDaysWorked = nmrDaysWorked0;
	}*/
    public void setNmrDaysWorked() {

        boolean correctType = false;
        do {
            try {
                System.out.println("\n\t Enter Number of days worked ");
                nmrDaysWorked = keyboard.nextDouble();
                correctType = true;
                keyboard.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n\t Invalid .Enter employee salary ");
                keyboard.next();
            }
        } while (!correctType);

    }

    public double getNmrDaysWorked() {
        return nmrDaysWorked;
    }

    public String toString() {
        return "\n" + label + "   " + getEmployeeId() + "  " + getName() + "  " + getAddress() + "    " + getSalary() + getStartDate() + "\n\n";
    }

}
