package employee;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.*;
class Employee implements Serializable {
	int empno;
	String ename;
	int salary;
	Employee(int empno,String ename,int salary){
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
	}
	public String toString() {
		return empno+""+ename+""+salary;
	}
}
	

		
	

public class EmployeeDemo {

	

	public static void main(String[] args) throws Exception{
		int choice = -1;
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		File file = new File("employee.txt");
		ArrayList<Employee> al = new ArrayList<Employee>();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null;
		if(file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>)ois.readObject();
			ois.close();
		}
		
		do {
			System.out.println("1.INSERT");
			System.out.println("2.DISPLAY");
			System.out.println("3.SEARCH");
			System.out.println("4.DELETE");
			System.out.println("0.EXIT");
			System.out.println("Enter Your Choice: ");
			choice = s.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter how many employees you want: ");
				int n = s.nextInt();
				for(int i=0;i<n;i++) {
				
				
				System.out.print("Enter Employee No: ");
				int empno = s.nextInt();
				System.out.print("Enter Employee Name: ");
				String ename = s1.nextLine();
				System.out.print("Enter Employee Salary: ");
				int salary = s.nextInt();
				al.add(new Employee(empno,ename,salary));
				}
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(al);
				oos.close();
				
				break;
			case 2:
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
				System.out.println("------");
				li = al.listIterator();
				while(li.hasNext())
					System.out.println(li.next());
				System.out.println("-------");
				}else {
					System.out.println("File not Exists...!");
				}
				
						
				break;
			case 3:
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
				boolean found = false;
				System.out.println("Enter empno to search: ");
				int empno = s.nextInt();
				
				
				System.out.println("-------");
				li = al.listIterator();
				while(li.hasNext()) {
					Employee e = (Employee)li.next();
					if(e.empno == empno){
						System.out.println(e);
					found = true;
				}
				}
				if(!found)
					System.out.println("Record Not Found...!");
				System.out.println("----------");
			}else {
				System.out.println("File not Exist...!");
			}
				break;
			case 4:if(file.isFile()) {
				ois = new ObjectInputStream(new FileInputStream(file));
				al = (ArrayList<Employee>)ois.readObject();
				ois.close();
				boolean found = false;
				System.out.println("Enter empno to Delete: ");
				int empno = s.nextInt();
				System.out.println("--------");
				li = al.listIterator();
				while(li.hasNext()) {
					Employee e = (Employee)li.next();
					if(e.empno == empno) {
						li.remove();
						found = true;
					}
				}
				if(found) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(al);
				oos.close();
				System.out.println("Record Deleted Successfully...!");
				}
				else {
					System.out.println("Record Not Found...!");
					
				}
				System.out.println("-------");
			}else {
				System.out.println("File not Exists...!");
			}
				break;
			}
			}while(choice!=0);
		}
}
		
	
				
				
				
				

			
			
			
			
			
			
			
		
				
			
			
			
				
		
			
		
		 
	


				
					
				
			
					
				
				
				
				
					
				
			
			
		
					
				
				
			
			
		
		// TODO Auto-generated method stub

	


