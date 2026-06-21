package Role;

public class Employee {
    
    private int emplyId;
    private String emplyname;
    private double salary;


    //constructor
    public Employee(int emplyId, String emplyname, double salary) {
        this.emplyId = emplyId;
        this.emplyname = emplyname;
        this.salary = salary;
    }


    //Getter and Setter
    public int getEmplyId(){
        return emplyId;
    }

    public void setEmplyId(int emplyId){
        this.emplyId = emplyId;
    }


    public String getEmplyname() {
        return emplyname;
    }


    public void setEmplyname(String emplyname) {
        this.emplyname = emplyname;
    }


    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        if (salary < 25000){
            System.out.println("You are employee of this or that department ...");
        }
        this.salary = salary;
    }
  

    
   public void display(){
    System.out.println("ID : "+ emplyId + " | " + "Name : " + emplyname + " | " + "Salary : " + salary);
   }

    
    

}
