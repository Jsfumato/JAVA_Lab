package num5;

public class Employee {
	private int employeeID;
	public String employeeName;
	
	private static int idKey = 20150;
	
	public Employee(String name){
		Employee.idKey++;
		this.employeeID = Employee.idKey;
		this.employeeName = name;
	}
	
	public int getEmployeeID(){
		return this.employeeID;
	}
}
