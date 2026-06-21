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
            
            if (file.exists()) {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("Reading Line " + line);  //Demo Testing
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                String name = parts[0].trim();
                int id = Integer.parseInt(parts[1].trim());
                double salary = Double.parseDouble(parts[2].trim());
                employees.add(new Employee(id, name, salary));
            }
        }
        System.out.println("Loaded " + employees.size() + " employees from the file.");
    } catch (IOException | NumberFormatException e) {
        System.out.println("Error loading employees: " + e.getMessage());
    }
} else {
    System.out.println("Not found file! Starting Fresh !!!!!!!!!!");
}

        //Creating Menu 
        boolean running = true;

        while(running){
            System.out.println("\n      MENU       ");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit!");

            System.out.print("Enter the Choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1 : //Add Employee
                System.out.println(                     );
                System.out.println("            ADD THE EMPLOYEE             ");
                System.out.println(                     );

                System.out.print("How Many Employees you want to add : ");
                int n = sc.nextInt();
                sc.nextLine();

                try(FileWriter fw = new FileWriter("Employees.txt", true)){
                    for(int i=0;i < n; i++){
                    System.out.println("\n -----Employees " + (i + 1) + " ------");

                    System.out.print("Enter the Employee ID : ");
                    int ID = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter the Employee name : ");
                    String Name = sc.nextLine();

                    System.out.print("Enter the Employee Salary : ");
                    Double Salary = sc.nextDouble();

                    Employee emp = new Employee(ID, Name, Salary);
                    employees.add(emp);

                    fw.write(emp.getEmplyname() + " , " + emp.getEmplyId() + " , " + emp.getSalary() + System.lineSeparator());
                    fw.flush();
                    }
                }   catch(IOException e){
                        System.out.println("File Writing Error......" + e.getMessage());
            }
                break;

                case 2: //View Employee
                System.out.println(                     );
                System.out.println("            VIEW THE EMPLOYEE             ");
                System.out.println(                     );
                
                        System.out.println("\n ---- All Employees ----");
                        for(Employee emp : employees){
                        emp.display();
                        }
                    break;

                case 3: //Search Employee
                System.out.println(                     );
                System.out.println("            SEARCH THE EMPLOYEE             ");
                System.out.println(                     );


                        boolean run = true;

                        while (run) {
                        System.out.println("\n      MENUS       ");
                        System.out.println("1. By Names ");
                        System.out.println("2. By ID   ");

                        System.out.print("\n\n Enter the Choice : ");
                        int choices = sc.nextInt();
                        sc.nextLine();

                        switch(choices){

                            case 1: //Names

                            System.out.print("\n\n Searching Employee Name : ");
                            String Name = sc.nextLine();
                            
                            boolean found = false;
                            
                            for(Employee emp : employees)
                            if(emp.getEmplyname().equalsIgnoreCase(Name)){
                                emp.display();
                                found = true;
                            }
                            if(!found){
                                System.out.println("Employee is Not Found !!");
                            }

                            break;

                            case 2 : // ID

                            System.out.print("\n\n Searching Employee ID : ");
                            int ID = sc.nextInt();
                            sc.nextLine();
                            
                            boolean found2 = false;
                            
                            for(Employee emp : employees)
                            if(emp.getEmplyId() == ID ){
                                emp.display();
                                found2 = true;
                            }
                            if(!found2){
                                System.out.println("Employee is Not Found !!");
                            }
                            break;

                            default:
                                System.out.println("No Employee Found!!");
                        }
                    }

                case 4: //Update Salary
                System.out.println(                     );
                System.out.println("            UPDATE DETAILS OF THE EMPLOYEE             ");
                System.out.println(                     );

                System.out.print("Enter Employee ID: ");
                int UpdateID = sc.nextInt();
                sc.nextLine();

                boolean found = false;

                for(Employee emp : employees){
                    if(emp.getEmplyId() == UpdateID){
                        System.out.print("Employee Found!");
                        emp.display();

                        System.out.print("Enter the updated Salary : ");
                        try{
                            double updatesalary = sc.nextDouble();
                            emp.setSalary(updatesalary);
                            found = true;
                            System.out.println("Successfully salary is updated");
                        }catch(Exception e){
                            System.out.println("Invlaid Slary Input");
                            sc.nextLine();
                        }
                    }if(!found){
                        System.out.println("Employee is not found");
                    }
                }
                    break;

                case 5: // Delete Employee
                    break;

                case 6: //Exit
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}