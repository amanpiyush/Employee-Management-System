import Role.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(                     );
        System.out.println("            WELCOME TO EMPLOYEE DATA MANAGEMENT             ");
        System.out.println(                     );

        ArrayList<Employee> employees = new ArrayList<>();

        //Load Existing Employee if they present in the file

        File file = new File("Employees.txt");
        
        if(file.exists()){
            
            try(BufferedReader br  = new BufferedReader(new FileReader(file))){
                String line;
                while ((line = br.readLine()) != null) {
                    //Excepting line in the format : name , id , salary
                    String[] parts = line.split(",");
                    if (parts.length >= 3) {
                        String name = parts[0].trim();
                        int id = Integer.parseInt(parts[1].trim());
                        int salary = Integer.parseInt(parts[2].trim());
                        employees.add(new Employee(id, name, salary));
                    }
                }
                System.out.println("Loaded " + employees.size() + " employees from file. ");
            }catch(IOException | NumberFormatException e){
                System.out.println("Error Loading employees : " + e.getMessage());
            }

        }else{
            System.out.println("No existing Employee.txt found, starting fresh.");
        }




        System.out.print("How many Employee detail you want to Enter : ");
        int n = sc.nextInt();
        sc.nextLine();

        try{

            FileWriter fw = new FileWriter("Employees.txt", true);


        for(int i = 0; i < n; i++){
            System.out.println("\n --- employee " + (i+1) + " ----");

            System.out.print("Enter your Id     : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter your Name   : ");
            String name = sc.nextLine();

            System.out.print("Enter your Salary : ");
            double salary = sc.nextDouble();
            sc.nextLine(); // consume newline

            // Create employee and ADD to ArrayList
            Employee emp = new Employee(id, name, salary);
            fw.write("Id : "+ emp.getEmplyId()+ " | " + "Name : " + emp.getEmplyname()+" | "+ "Salary : " + emp.getSalary() + " | | ");
            employees.add(emp);
        }
        fw.close();

        }catch(Exception e){
            System.out.println("File Error : " + e.getMessage());
        }


        // Display all employees
        System.out.println("\n\n--- All Employees ---");
        for(Employee emp : employees){
            emp.display();
        };

        //Search Employee
        System.out.print("\nEnter the ID : ");
        int searchId = sc.nextInt();
        sc.nextLine();

        Boolean found = false;

        for(Employee emp : employees)
        {
            if(emp.getEmplyId() == searchId)
            {
                emp.display();
                found = true;
                break;
            }
        }
        if(!found)
        {
            System.out.println("Employee Not Found!");
        }

    }
}