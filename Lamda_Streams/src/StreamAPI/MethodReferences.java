package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferences {
	public static void main(String[] args) {

	

		MyObject myObject = new MyObject();

		List<String> fruits = Arrays.asList("Apple", "Banana", "Guava", "Grapes");

//		Bounded method references
//		fruits.stream().map(myObject::toUppercase).forEach(System.out::println);
//		fruits.stream().map(e->myObject.toUppercase(e)).forEach(System.out::println);
//		fruits.stream().map(String::toUpperCase).forEach(System.out::println);

//		UnBounded method references
//		List<MyObject> myObjectList = new ArrayList<MyObject>();
//		myObjectList.add(new MyObject("Apple"));
//		myObjectList.add(new MyObject("Banana"));
//		myObjectList.add(new MyObject("Guava"));
//		myObjectList.add(new MyObject("Grapes"));
//		
//		myObjectList.stream().map(MyObject::toUppercase).forEach(System.out::println);
//		myObjectList.stream().map(e->e.toUppercase()).forEach(System.out::println);

//		Constructor method references 
//		Supplier<MyObject> myObjectSupplier = MyObject::new;
//		System.out.println(myObjectSupplier.get());
		
		
		
		fruits.stream().map(MyObject::new).collect(Collectors.toList()).forEach(System.out::println);
//		
//		
//		Map<Integer, String> items=Map.of(1,"A"
//										 ,2,"B"
//										 ,3,"A"
//										 ,4,"B");
//		Map<String, List<Entry<Integer, String>>> collect = items.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue));
		

	}
}
