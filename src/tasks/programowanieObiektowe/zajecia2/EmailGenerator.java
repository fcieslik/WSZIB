package tasks.programowanieObiektowe.zajecia2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmailGenerator {

    public static List<Employee> employeePersonalData = new ArrayList<Employee>();

    public static void main(String[] args) {
        addEmployee();
    }

    public static void addEmployee() {
        Scanner reader = new Scanner(System.in);
        boolean addAnotherEmail = true;

        while(addAnotherEmail) {
            System.out.println("Enter employee name: ");
            String name = reader.next();
            System.out.println("Enter employee name: ");
            String surname = reader.next();
            employeePersonalData.add(new Employee(name.toLowerCase(), surname.toLowerCase(),generateEmailAdress(name.toLowerCase(), surname.toLowerCase()) ));
            printOutAllEmployees();
            System.out.println("Add another email? Y/N");
            String toContinue = reader.next();
            if (toContinue.equals("N")) {
                addAnotherEmail = false;
            }
        }
        reader.close();
    }

    private static String generateEmailAdress(String name, String surname) {
        return isTheSamePersonalData(name, surname) ? checkNextDuplicateEmailNumber(name, surname) : name + "." + surname + "@mex.com";
    }

    private static String checkNextDuplicateEmailNumber(String name, String surname) {
        int duplicateNumber = 1;
        for (int i = 0; i < employeePersonalData.size(); i++) {
            if(employeePersonalData.get(i).equals(new Employee(name, surname, name + "." + surname + duplicateNumber + "@mex.com"))) {
                duplicateNumber++;
            }
        }
        return name + "." + surname + duplicateNumber + "@mex.com";
    }

    private static void printOutAllEmployees() {
        Iterator<Employee> iterator = employeePersonalData.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static boolean isTheSamePersonalData(String name, String surname) {
        Employee tmp = new Employee(name, surname, name + "." + surname + "@mex.com");
        for (int i = 0; i < employeePersonalData.size(); i++) {
            if(employeePersonalData.get(i).equals(tmp)) {
                return true;
            }
        }
        return false;
    }
}