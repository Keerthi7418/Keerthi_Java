package question1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project implements Serializable {

    String projectCode;
    String projectName;
    int projectStrength;

    public Project(String projectCode, String projectName, int projectStrength) {

        this.projectCode = projectCode;
        this.projectName = projectName;
        this.projectStrength = projectStrength;

    }

    @Override

    public String toString() {
    	
        return "Project [projectCode=" + projectCode + ", projectName=" + projectName + ", projectStrength=" + projectStrength + "]";

    }

}

 class Employee implements Serializable {

    String employeeId;
    String employeeName;
    String employeePhone;
    String employeeAddress;
    int employeeSalary;



    public Employee(String employeeId, String employeeName, String employeePhone, String employeeAddress, int employeeSalary) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;

    }

    @Override

    public String toString() {

        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePhone=" + employeePhone + ", employeeAddress=" + 
        employeeAddress + ", employeeSalary=" + employeeSalary + "]";

    }

}



class ProjectSerializer implements Serializable {

    Map<Project, List<Employee>> projectMap1 = new HashMap<>();
    List<Employee> elist1 = new ArrayList<>();
    List<Employee> elist2 = new ArrayList<>();
    List<Employee> elist3 = new ArrayList<>();

    public void serializeProjectDetails(Map<Project, List<Employee>> projectMap) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializedData.ser"))) {
            oos.writeObject(projectMap);

            System.out.println("Output: SerializeData");

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")
    public void deserializeProjectDetails() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializedData.ser"))) {
            Map<Project, List<Employee>> deserializedMap = (Map<Project, List<Employee>>) ois.readObject();

            System.out.println("Output: DeSerializeData");

            for (Map.Entry<Project, List<Employee>> entry : deserializedMap.entrySet()) {

                System.out.println("DeSerialized Data :");
                System.out.println("The Project " + entry.getKey() + " Has the following Employees");
                System.out.println("Employees .............");
                
                for (Employee employee : entry.getValue()) {
                	
                    System.out.println(employee);

                }

            }

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

        }

    }

}

