/*
 * Full-time staff inherited from Employee class
 * 
 * 
 */
package MenuMainDriver;

import java.util.*;

/**
 *
 * @author Pio O'Connell
 */
public class FullStaff extends Employee {

    private double nmrDaysWorked;
    private String label = "Full Time Employee";

    public FullStaff(String employee_id0, String name0, String address0, double salary0, Calendar startDate0) {
        super(employee_id0, name0, address0, salary0, startDate0);

    }

    public FullStaff() {

    }

    public double computeHolidayPay() {
        return nmrDaysWorked * 0.02;
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

 /*   public String toString() {
        return "\n" + label + "   " + getEmployeeId() + "  " + getName() + "  " + getAddress() + "    " + getSalary() + getStartDate() + "\n\n";
    }*/

}
