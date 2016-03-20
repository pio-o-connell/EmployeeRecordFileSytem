/*
 * Entry point to the program
 * 
 * 
 */
package MenuMainDriver;

import java.util.*;

/**
 *
 * @author Pio O'Connell
 */
public class maindriver {

    public static void main(String[] args) {
        employeeType.EmployeeTypes Employee = employeeType.EmployeeTypes.TEMPORARY;
        Scanner input = new Scanner(System.in);
        Boolean runMenu = true;
        ArrayList<Employee> Employees = new ArrayList<Employee>();
        Employee tempEmployee;
        Maintenance maintence = new Maintenance();

        while (runMenu) {
            int selection = Engine.MainMenu(input);

            switch (selection) {
                case 1: // Add a new employee
                    System.out.println("You wish to add a 'new' employee");
                    Employee = Engine.getEmployeetype(input);
                    switch (Employee) {
                        case TEMPORARY:
                            System.out.println("\n Temporary");
                            Temporary tts = new Temporary();
                            Engine.addAnEmployee(input, tts);
                            Employees.add(tts);
                            break;
                        case EMPLOYEE:
                            System.out.println("\n Employee");
                            FullStaff fts = new FullStaff();
                            Engine.addAnEmployee(input, fts);
                            Employees.add(fts);
                            break;
                        case MANAGERIAL:
                            System.out.println("\n Managerial");
                            Managerial ms = new Managerial();
                            Engine.addAnEmployee(input, ms);
                            Employees.add(ms);
                            break;
                        default:
                            System.out.println("\n Invalid input");
                            break;
                    }
                    break;
                case 2: // find an employee by id
                    //  System.out.println("You wish to find an employee");
                    String str = maintence.getSearchString(input);
                    tempEmployee = maintence.checkIfExists(str, Employees);
                    maintence.displayContentsOfRecord(tempEmployee);
                    break;
                case 3:
                    System.out.println("You wish to modify employee details");
                    str = maintence.getSearchString(input);
                    tempEmployee = maintence.checkIfExists(str, Employees);
                    if (tempEmployee != null) {
                        tempEmployee.updateCustomerName();
                        tempEmployee.updateCustomerAddress();
                        tempEmployee.updateCustomersSalary();
        //                tempEmployee.updateStartDate();
                    }
                    break;
                case 4:
                    System.out.println("You wish to output all employees to a file");
                    FileManger.dumpDB(Employees, input);
                    System.out.println(" all employees successfully written ");
                    break;
                case 5:
                    System.out.println("You wish to calculate how much holiday pay due to employee");
                    str = maintence.getSearchString(input);
                    tempEmployee = maintence.checkIfExists(str, Employees);
                    Calendar tempstartDate = Calendar.getInstance();
                    long currentYear = tempstartDate.get(Calendar.YEAR);

                    if (tempEmployee instanceof FullStaff) {
                        FullStaff fs = (FullStaff) tempEmployee;
                        fs.setNmrDaysWorked();
                        if ((currentYear % 4 == 0) && (currentYear % 100 != 0) || (currentYear % 400 == 0)) {
                            System.out.println("\n\t Holiday Pay for employee " + (fs.getSalary() / 366) * fs.computeHolidayPay());
                        } else {
                            System.out.println("\n\t Holiday Pay for employee " + (fs.getSalary() / 365) * fs.computeHolidayPay());
                        }
                    } else if (tempEmployee instanceof Managerial) {
                        Managerial ms = (Managerial) tempEmployee;
                        ms.setNmrDaysWorked();
                        if ((currentYear % 4 == 0) && (currentYear % 100 != 0) || (currentYear % 400 == 0)) {
                            System.out.println("\n\t Holiday Pay for employee" + (ms.getSalary() / 366) * ms.computeHolidayPay());
                        } else {
                            System.out.println("\n\t Holiday Pay for employee" + (ms.getSalary() / 365) * ms.computeHolidayPay());
                        }
                    } else if (tempEmployee instanceof Temporary) {
                        Temporary ts = (Temporary) tempEmployee;
                        ts.setNmrDaysWorked();
                        if ((currentYear % 4 == 0) && (currentYear % 100 != 0) || (currentYear % 400 == 0)) {
                            System.out.println("\n\t Holiday Pay for temp employee" + (ts.getSalary() / 366) * ts.computeHolidayPay());
                        } else {
                            System.out.println("\n\t Holiday Pay for temp employee" + (ts.getSalary() / 365) * ts.computeHolidayPay());
                        }
                    }

                    break;
                case 6:
                    System.out.println("You wish to calculate how long a staff member has worked with the company");
                    str = maintence.getSearchString(input);
                    tempEmployee = maintence.checkIfExists(str, Employees);
                    tempEmployee.getTimeWorked();
                    break;
                case 7:
                    System.out.println("You wish to quit");
                    runMenu = false;
                    break;
                default:
                    System.out.println("Not a menu option,please select 1..6");

            }

        }
        System.out.println(Employees);
    }

}
