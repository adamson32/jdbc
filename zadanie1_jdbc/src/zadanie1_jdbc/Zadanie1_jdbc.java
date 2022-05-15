
package zadanie1_jdbc;


public class Zadanie1_jdbc {

    
    public static void main(String[] args) {
       
       DaoEmployee dao = new DaoEmployee();
       dao.connect();
       
       Employee p1=new Employee("Jan","Kowalski",28,"123456987","jan.kowalski@op.pl");
       Employee p2=new Employee("Piotr","Nowak",24,"987654321","piotr.nowak@outlook.com");
       Employee p3=new Employee("Jan","Nowak",24,"789654321","jan.nowak@outlook.com");
       Employee p4=new Employee("Adam","Janowski",32,"889654321","adam.janowski@outlook.com");
       dao.addEmployee(p1);
       dao.addEmployee(p2);
       dao.addEmployee(p3);
       dao.addEmployee(p4);
       
       dao.getAllEmployees();
        System.out.println("Pracownik o id=3: ");
        Employee p5=dao.getEmployeeByID(3);
        System.out.println(p5);
        dao.dropEmployeeByID(3);
        dao.updateEmployee(2,"Kamil","Nowakowski",34,"789001234","kamil.nowakowski@outlook.com");
        String s="outlook.com";
        System.out.println("Pracownicy, których email kończy się na: outlook.com");
        dao.getEmployeesByEmail(s);
    }
    
}
