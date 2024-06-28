package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LamdaGroupingCollections {

	public static void main(String[] args) {
		 List<Employee> emplList=new ArrayList<Employee>();
		 emplList.add(new Employee(1, "Pavan", "Developer"));
		 emplList.add(new Employee(2, "Kumar", "Developer"));
		 emplList.add(new Employee(3, "Sagar", "Engineering"));
		 emplList.add(new Employee(4, "Venky", "Developer"));
		 emplList.add(new Employee(5, "Akhil", "Testing"));
		 emplList.add(new Employee(6, "Sunil", "Developer"));
		 emplList.add(new Employee(7, "Anil", "Testing"));
		 emplList.add(new Employee(8, "Sai", "Engineering"));
		 
		 emplList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((a,b)-> System.out.println(a+"\n"+b));
		emplList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getEmployeeName, Collectors.toList())))
			.forEach((k,v)->System.out.println("The key is : "+k+" and the value is : "+v));
	}
}
