package question2;

import java.io.Serializable;

public class Employee implements Serializable{

private static final long serialVersionUID = 2L;

     String empId;
     String empName;
     String empPhone;
     String empAddress;
     int salary;

public Employee(String empId, String empName, String empPhone, String empAddress, int salary) {
	
      this.empId = empId;
      this.empName = empName;
      this.empPhone = empPhone;
      this.empAddress = empAddress;
      this.salary = salary;
}

@Override
public String toString() {
	
     return "Employee [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone + ", empAddress="+ empAddress + ", salary=" + salary + "]";
   
   }

}