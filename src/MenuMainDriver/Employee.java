/*
 * Contains all the maintenance functionality for Employee
 * 
 * 20/03/1916
 */
package MenuMainDriver;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Pio O'Connell
 */
public abstract class Employee {

    private String employee_id;
    private String name;
    private String address;
    private double salary;
    private Calendar dateOfBirth;
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

    public void setName(String name0) {
        name = name0;
    }

    public String getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId() {
        System.out.println("\n\n\n\nAdd an employee ...");
        System.out.println("\n\t Enter Employee Number ");
        employee_id = keyboard.nextLine();

    }

    public void setEmployeeId(String employeeID0) {
        employee_id = employeeID0;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        System.out.println("\n\t Enter Employee address ");
        address = keyboard.nextLine();
    }

    public void setAddress(String address0) {
        address = address0;
    }

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

    public void setSalary(double salary0) {
        salary = salary0;
    }

    public Calendar getStartDate() {
        return startDate;
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

    public void setStartDate(Calendar date0) {
        startDate = date0;
    }

    public Calendar getDOB() {
        return dateOfBirth;
    }

    public void setDOB() {

        Boolean correctType = false;
        Calendar tempstartDate = Calendar.getInstance();

        do {
            try {
                System.out.println("\n\tEnter employee DOB e.g. e.g. 10/03/1969");
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
        dateOfBirth = tempstartDate;
    }

    public void setDOB(Calendar date0) {
        dateOfBirth = date0;
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


    /*public Calendar getStartDate()
	{
		return startDate;
	}*/
    public String toString() {
        int start_Date1, start_Date2, start_Date3;
        int DOB1,DOB2,DOB3;
        String StaffType = new String();
        
        DOB1 = startDate.get(Calendar.MONTH);
        DOB2 = startDate.get(Calendar.YEAR);
        DOB3 = startDate.get(Calendar.DAY_OF_MONTH);
        start_Date1 = dateOfBirth.get(Calendar.MONTH);
        start_Date2 = dateOfBirth.get(Calendar.YEAR);
        start_Date3 = dateOfBirth.get(Calendar.DAY_OF_MONTH);
        
        if (this instanceof FullStaff) {
            StaffType = "Full Time Staff";
        }
            else if (this instanceof Managerial){
                StaffType = "Managerial Staff";
            }
                else if (this instanceof Temporary){
                     StaffType = "Temporary";
                }
    
        
        return "\n Employee ID : " + this.employee_id 
                    + "\n Employee Name : " + this.name
                        + "\n Employee DOB : "+ DOB3+"\\"+ DOB1+"\\"+DOB2 
                          + " \n Employment Type : " + StaffType
                            + " \n Employee Address : " + this.address
                                + "\n Employee Salary" + this.salary
                                   + "\n Employee Start Date" + start_Date3+"\\"+start_Date1+"\\"+start_Date2
                                      + "\n\n\n";
                
    }

    public void updateCustomerName() {
        System.out.println("Current customer's name is: " + getName());
        System.out.println("Type in the new customer\'s name if you wish to update,otherwise hit return\n");
        String name = keyboard.nextLine();
        if (name.length() != 0) {
            setName(name);
        }
    }

    public void updateCustomerAddress() {
        System.out.println("Current customer's address is: " + getAddress());
        System.out.println("Type in the new customer\'s address if you wish to update,otherwise hit return\n");
        String address = keyboard.nextLine();
        if (address.length() != 0) {
            setAddress(address);
        }
    }

    public void updateCustomersSalary() {
        String tempSalary = null;
        double tempSalaryValue = 0;

        Boolean invalidInput = true;
        System.out.println("Current customer's salary is: " + getSalary());
        System.out.println("Type in the new customer\'s salary if you wish to update,otherwise hit return\n");

        do {
            tempSalary = keyboard.nextLine();
            if (tempSalary.length() == 0) {
                break;
            } else if (tempSalary.length() != 0) {
                try {
                    tempSalaryValue = Double.parseDouble(tempSalary);
                    setSalary(tempSalaryValue);
                    invalidInput = false;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Type in the new customer\'s salary if you wish to update,otherwise hit return\n");
                }
            }
        } while (invalidInput);
    }

    public void updateStartDate() {
        String date = null;
        Calendar tempDate = null;

        Boolean invalidInput = true;
        System.out.println("Current customer's start date is: " + getStartDate());

        System.out.println("Type in the new customer\'s start date if you wish to update,otherwise hit return\n");

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

                    tempDate.set(Calendar.YEAR, year);
                    tempDate.set(Calendar.MONTH, month);
                    tempDate.set(Calendar.DAY_OF_MONTH, day);
                    setStartDate(tempDate);
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

    public void updateDOB() {
        String date = null;
        Calendar tempDate = null;

        Boolean invalidInput = true;
        System.out.println("Current customer's start date is: " + getDOB());

        System.out.println("Type in the new customer\'s start date if you wish to update,otherwise hit return\n");

        do {
            date = keyboard.nextLine();
            if (date.length() == 0) {
                break;
            } else if (date.length() != 0) {
                try {
                    System.out.println("\n\tEnter employee DOB e.g. e.g. 10/03/1969");
                    String str1 = keyboard.nextLine();
                    String str[] = str1.split("/");

                    int day = Integer.parseInt(str[0]);
                    int month = Integer.parseInt(str[1]);
                    int year = Integer.parseInt(str[2]);

                    tempDate.set(Calendar.YEAR, year);
                    tempDate.set(Calendar.MONTH, month);
                    tempDate.set(Calendar.DAY_OF_MONTH, day);
                    setDOB(tempDate);
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
