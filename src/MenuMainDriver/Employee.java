/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuMainDriver;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author user
 */
public abstract class Employee {

    private String employee_id;
    private String name;
    private String address;
    private double salary;
    private Calendar startDate;
//	private double nmrDaysWorked=0;
    Scanner keyboard = new Scanner(System.in);

    public Employee(String employee_id0, String name0, String address0, double salary0, Calendar startDate0) {
        employee_id = employee_id0;
        name = name0;
        address = address0;
        salary = salary0;
        startDate = startDate0;

    }

    public Employee() {

    }

    abstract public double computeHolidayPay();

    public String getName() {

        return name;
    }

    public void setName() {
        System.out.println("\n\n\n\nAdd an employee ...");
        System.out.println("\n\t Enter Employee Name ");
        name = keyboard.nextLine();
    }

    /*public void setName(String name0)
	{
		name = name0;
	}*/
    public String getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId() {
        System.out.println("\n\n\n\nAdd an employee ...");
        System.out.println("\n\t Enter Employee Number ");
        employee_id = keyboard.nextLine();

    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        System.out.println("\n\t Enter Employee address ");
        address = keyboard.nextLine();
    }

    /*public void setSalary(double salary0)
	{
		salary = salary0;
	}*/
    public double getSalary() {
        return salary;
    }

    public void setSalary() {

        boolean correctType = false;
        do {
            try {
                System.out.println("\n\t Enter employee salary");
                salary = keyboard.nextDouble();
                correctType = true;
                keyboard.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n\t Invalid .Enter employee salary ");
                keyboard.next();
            }
        } while (!correctType);

    }

    public void setStartDate() {

        Boolean correctType = false;
        Calendar tempstartDate = Calendar.getInstance();

        do {
            try {
                System.out.println("\n\tEnter employee start date e.g. e.g. 10/03/1969");
                String str1 = keyboard.nextLine();
//				 System.out.println(str1);
                String str[] = str1.split("/");

                int day = Integer.parseInt(str[0]);
                int month = Integer.parseInt(str[1]);
                int year = Integer.parseInt(str[2]);

                tempstartDate.set(Calendar.YEAR, year);

                tempstartDate.set(Calendar.MONTH, month);
                tempstartDate.set(Calendar.DAY_OF_MONTH, day);
                tempstartDate.set(Calendar.HOUR_OF_DAY, (int) 0);
                tempstartDate.set(Calendar.MINUTE, (int) 0);
                tempstartDate.set(Calendar.SECOND, (int) 0);
//				 System.out.println(startDate);
                correctType = true;
            } catch (java.util.InputMismatchException e) {
                correctType = false;
                System.out.println("\n\t Invalid .Enter employee start date e.g. 10/03/1969 ");
                //	 keyboard.next();
            } catch (java.lang.NumberFormatException e1) {
                correctType = false;
                System.out.println("\n\t Invalid .Enter employee start date e.g. 10/03/1969 ");

            }

        } while (!correctType);
        startDate = tempstartDate;
    }

    /*	public void setNmrDaysWorked(){
		
		boolean correctType = false;
		do {
			try {
				System.out.println("\n\t Enter Number of days worked ");
				nmrDaysWorked = keyboard.nextDouble();
				correctType = true;
				keyboard.nextLine();
			}catch (java.util.InputMismatchException e){
				System.out.println("\n\t Invalid .Enter employee salary ");
				keyboard.next();
			}
		}
		while(!correctType);
		
	 }*/
    public void getTimeWorked() {
        Calendar tempstartDate = Calendar.getInstance();
        long timeWorked = (tempstartDate.getTimeInMillis() - startDate.getTimeInMillis()) / 1000;
        long numYears = timeWorked / 31536000;

        long numDays = ((timeWorked % 31536000) / 86400);
        long start_year = startDate.get(Calendar.YEAR);
        long currentYear = tempstartDate.get(Calendar.YEAR);
        while (currentYear >= start_year) {
            if ((currentYear % 4 == 0) && (currentYear % 100 != 0) || (currentYear % 400 == 0));
            numDays--;
            currentYear--;

        }
        long numHours = (((timeWorked % 31536000) % 86400) / 3600);
        long numMinutes = ((((timeWorked % 31536000) % 86400) % 3600) / 60);
        long numSeconds = (((timeWorked % 31536000) % 86400) % 3600) % 60;
        System.out.println("\n\t Time worked" + numYears + "in years " + numDays + "days  ");

    }

    public Calendar getStartDate() {
        return startDate;
    }

    /*public Calendar getStartDate()
	{
		return startDate;
	}*/
    public String toString() {
        return "\n" + this.employee_id + "  " + this.name + "  " + this.address + "  " + this.salary + this.startDate + "\n\n";
    }

    public void updateCustomerName() {
        System.out.println("Current customer's name is: " + getName());
        System.out.println("Type in the new customer\'s name if you wish to update,otherwise hit return\n");
        String name = keyboard.nextLine();
        if (name.length() != 0) {
            setName();
        }
    }

    public void updateCustomerAddress() {
        System.out.println("Current customer's address is: " + getAddress());
        System.out.println("Type in the new customer\'s address if you wish to update,otherwise hit return\n");
        String address = keyboard.nextLine();
        if (address.length() != 0) {
            setName();
        }
    }

    public void updateCustomersSalary() {
        String tempSalary = null;

        Boolean invalidInput = true;
        System.out.println("Current customer's salary is: " + getSalary());
        System.out.println("Type in the new customer\'s salary if you wish to update,otherwise hit return\n");

        do {
            tempSalary = keyboard.nextLine();
            if (tempSalary.length() == 0) {
                break;
            } else if (tempSalary.length() != 0) {
                try {
                    salary = Double.parseDouble(tempSalary);
                    invalidInput = false;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Type in the new customer\'s salary if you wish to update,otherwise hit return\n");
                }
            }
        } while (invalidInput);
    }

    public void updateStartDate() {
        String date = null;

        Boolean invalidInput = true;
        System.out.println("Current customer's start date is: " + getStartDate());

        System.out.println("Type in the new customer\'s salary if you wish to update,otherwise hit return\n");

        do {
            date = keyboard.nextLine();
            if (date.length() == 0) {
                break;
            } else if (date.length() != 0) {
                try {
                    System.out.println("\n\tEnter employee start date e.g. e.g. 10/03/1969");
                    String str1 = keyboard.nextLine();
                    String str[] = str1.split("/");

                    int day = Integer.parseInt(str[0]);
                    int month = Integer.parseInt(str[1]);
                    int year = Integer.parseInt(str[2]);

                    startDate.set(Calendar.YEAR, year);
                    startDate.set(Calendar.MONTH, month);
                    startDate.set(Calendar.DAY_OF_MONTH, day);
//				 System.out.println(startDate);
                    invalidInput = false;
                } catch (java.util.InputMismatchException e) {
                    invalidInput = false;
                    System.out.println("\n\t Invalid .Enter employee start date e.g. 10/03/1969 ");
                    //	 keyboard.next();
                } catch (java.lang.NumberFormatException e1) {
                    invalidInput = false;
                    System.out.println("\n\t Invalid .Enter employee start date e.g. 10/03/1969 ");
                }
            }
        } while (invalidInput);
    }

}
