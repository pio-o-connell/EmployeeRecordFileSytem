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
public class Maintenance {

    public static Employee checkIfExists(String accountNumber, ArrayList<Employee> Employees) {
        Employee index = null;

        for (Employee element : Employees) {
            if (element.getEmployeeId().equals(accountNumber)) {
                index = element;
            }
        }
        if (index == null) {
            System.out.println("\n Sorry no record for that employee. \n");
        }
        return index;

    }

    public static void displayContentsOfRecord(Employee employee0) {
        System.out.println("\n\t Employee Number " + employee0.getEmployeeId());
        System.out.println("\n\t  Employee Name " + employee0.getName());
        System.out.println("\n\t  Employee Address " + employee0.getAddress());
        System.out.println("\n\t  Employee Salary " + employee0.getSalary());
        System.out.println("\n\t  Employee Start Date " + employee0.getStartDate());
    }

    public static String getSearchString(Scanner keyboard) {
        System.out.println("\n\n\n\nSearch by ID for an employee ...");
        System.out.println("\n\t Enter Employee Number (e.g. M00118177)  ");
        String str = keyboard.nextLine();
        return str;
    }

    /*	public static void updateCustomerName(){
		System.out.println("Current customer's name is: "+getName());
		System.out.println("Type in the new customer\'s name if you wish to update,otherwise hit return\n");
		String name= input.nextLine();
		if (name.length() !=0)
			setName(name);		
	}
	
	public static void updateCustomerAddress(){
		System.out.println("Current customer's address is: "+getAddress());
		System.out.println("Type in the new customer\'s address if you wish to update,otherwise hit return\n");
		String address= input.nextLine();
		if (address.length() !=0)
			setName(address);		
	}
	
	public static void updateCustomersSalary(){
		double salary;
		String tempSalary=null;
		
		Boolean invalidInput = true;
		System.out.println("Current customer's salary is: "+getSalary());
		System.out.println("Type in the new customer\'s salary if you wish to update,otherwise hit return\n");
		
		do {
			tempSalary = keyboard.nextLine();
			if(tempSalary.length() == 0){
				break;
			} else if(tempSalary.length() != 0){
			try {
				salary = Double.parseDouble(tempSalary);
				setSalary(salary);
				invalidInput = false;
			}catch (NumberFormatException e){
				System.out.println("Invalid input. Type in the new customer\'s salary if you wish to update,otherwise hit return\n");
			}
			}
		}
		while(invalidInput);
	}
	
	public static void updateStartDate(){
		String date= null;
		Calendar startDate = Calendar.getInstance();
		
		Boolean invalidInput = true;
		System.out.println("Current customer's start date is: "+getStartDate());
 
		System.out.println("Type in the new customer\'s salary if you wish to update,otherwise hit return\n");
		
		do {
			date = keyboard.nextLine();
			if(date.length() == 0){
				break;
			} else if(date.length() != 0){
				try{
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
			 }catch (java.util.InputMismatchException e){
				 invalidInput = false;
				 System.out.println("\n\t Invalid .Enter employee start date e.g. 10/03/1969 ");
			 //	 keyboard.next();
		     }catch (java.lang.NumberFormatException e1){
		    	 invalidInput = false;
		    	 System.out.println("\n\t Invalid .Enter employee start date e.g. 10/03/1969 ");
		     }
		}
		}
		while(invalidInput);
	}*/
}
