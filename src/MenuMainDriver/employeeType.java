/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuMainDriver;

/**
 *
 * @author Pio O'Connell
 */
public class employeeType {

    public static enum EmployeeTypes {
        TEMPORARY(1), EMPLOYEE(5), MANAGERIAL(10);
        private int value;

        private EmployeeTypes(int value) {
            this.value = value;
        }
    }

}
