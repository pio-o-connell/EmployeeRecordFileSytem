/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuMainDriver;

import java.util.Scanner;
import java.util.*;
/**
 *
 * @author Pio O'Connell
 */
public abstract class Engine {



public static int MainMenu(Scanner input){
	int selection;
	
	System.out.println("\n\n\nPersonnel System  ");
	System.out.println("\n --------------------");
	System.out.println("\n Please Choose from one of options below ");
	System.out.println("\n[1]  Add a 'new' employee.");
	System.out.println("\n[2]  Find an employee.");
	System.out.println("\n[3]  Modify Employee details.");
	System.out.println("\n[4]  Output all employees to a file.");
	System.out.println("\n[5]  Calculate holiday pay due to a staff member");
	System.out.println("\n[6]  Calculate how long an employee has worked with the company.");

	System.out.println("\n[7]  Quit");
	
	//System.out.println("Please enter you selection(1..6) ");
	//int selection =0;
	//while(!input.hasNextInt()){
	//	System.out.println("\n Please enter your selection(1..6)");
	//	input.nextInt();
	//}
	//selection = input.nextInt();
	selection = getChoice( input);
	return selection;
}




public static void addAnEmployee(Scanner keyboard,Employee employee0){
	
	
	
	//System.out.println ("\n\n\n\nAdd an employee ...");
	//System.out.println("\n\t Enter Employee Number ");
	//employee.setEmployeeId(keyboard.nextLine());
	employee0.setEmployeeId();
	//System.out.println("\n\t Enter Employee name ");
	//employee0.setName(keyboard.nextLine());
	employee0.setName();
	//System.out.println("\n\t Enter Employee address ");
	employee0.setAddress();
	employee0.setSalary();
	employee0.setStartDate();
	//System.out.println(employee0);
	
	
}

public static employeeType.EmployeeTypes getEmployeetype(Scanner input){
	char ch=' ';
	boolean found =false;
	employeeType.EmployeeTypes Employee = employeeType.EmployeeTypes.TEMPORARY;
	
	while(!found)
	{
		System.out.println("\n\tIs the employee Part-Time/Employee/Managerial ...('P'/'E'/'M')");
		ch = input.next().trim().charAt(0);
		input.nextLine();
		switch(ch){
			case 'P':
			case 'p':
				System.out.println("\n PArt-Time");
				Employee = employeeType.EmployeeTypes.TEMPORARY;
				found=true;
				break;
			case 'E':
			case 'e':
				System.out.println("\n Employee");
				Employee = employeeType.EmployeeTypes.EMPLOYEE;
				found=true;
				break;
			case 'M':
			case 'm':
				System.out.println("\n Managerial");
				Employee = employeeType.EmployeeTypes.MANAGERIAL;
				found=true;
				break;
			default:
				System.out.println("\n Invalid input");
				break;
		}
	}
	return Employee;
}

public static int getChoice(Scanner keyboard){
	int Choice = 0;
	boolean correctType = false;
	do {
		try {
			System.out.println("Please enter you selection(1..6) ");
			Choice = keyboard.nextInt();
			correctType = true;
			keyboard.nextLine();
						
		} catch (java.util.InputMismatchException e){
			System.out.println("\n Invalid .Please enter you selection(1..6) ");
			keyboard.next();
		}
	}
	while (!correctType);
	
   return Choice;	
	
}

/*public static double getSalary(Scanner keyboard){
	double salary = 0;
	boolean correctType = false;
	do {
		try {
			System.out.println("\n\t Enter employee salary");
			salary = keyboard.nextDouble();
			correctType = true;
			keyboard.nextLine();
		}catch (java.util.InputMismatchException e){
			System.out.println("\n\t Invalid .Enter employee salary ");
			keyboard.next();
		}
	}
	while(!correctType);
	return salary;
 }*/

/*
public static Calendar getStartDate(Scanner keyboard){
	 Calendar startDate = Calendar.getInstance();
	 Boolean correctType = false;
	 
	 do {
		 try {
			 System.out.println("\n\tEnter employee start date e.g. e.g. 10/03/1969");
			 String str1 = keyboard.nextLine();
//			 System.out.println(str1);
			 String str[] = str1.split("/");
			
			 int day = Integer.parseInt(str[0]);
			 int month = Integer.parseInt(str[1]);
			 int year = Integer.parseInt(str[2]);
			
			 startDate.set(Calendar.YEAR, year);
			 startDate.set(Calendar.MONTH, month);
			 startDate.set(Calendar.DAY_OF_MONTH, day);
//			 System.out.println(startDate);
			 correctType = true;
		 }catch (java.util.InputMismatchException e){
			 correctType = false;
			 System.out.println("\n\t Invalid .Enter employee start date e.g. 10/03/1969 ");
		 //	 keyboard.next();
	     }catch (java.lang.NumberFormatException e1){
	    	 correctType = false;
	    	 System.out.println("\n\t Invalid .Enter employee start date e.g. 10/03/1969 ");

	     }
		
	} while(!correctType);
return startDate;
}*/

/*
public  void updateAccount(Employee employee0){
	employee0.updateCustomerName();
	employee0.updateCustomerAddress();
	employee0.updateCustomersSalary();
	employee0.updateStartDate();
}
*/



}
