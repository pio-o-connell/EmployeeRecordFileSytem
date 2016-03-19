/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuMainDriver;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pio O'Connell
 */
public class FileManger {

    public static void dumpDB(ArrayList<Employee> Employees, Scanner keyboard) {
        String filename;

        System.out.println("\n Enter filename: ");
        filename = keyboard.nextLine();
        try {
            PrintWriter myOutfile = new PrintWriter(filename);
            myOutfile.println(Employees);
            myOutfile.close();
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage() + "caught");
        }

    }

}
