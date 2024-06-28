package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		// Creating a stream from a collection
		List<Integer> list = Arrays.asList(8, 6, 4, 1, 3, 9, 5);

//		String[] my = { "N", "J", "A", "Z", "B" };

//		Stream<String> streamArray = Stream.of(my);
//		streamArray.forEach(e->System.out.println(e));

		Stream<Integer> streamFromList1 = list.stream();

//		streamFromList1.forEach(e -> {
//			System.out.println("hey");
//			System.out.println(e);
//		});

//		streamFromList1.forEach(e -> {
//			System.out.println("hey");
//			System.out.println(e);
//		});

//		long count = streamFromList1.count();
//		System.out.println(count + " count of the streamFromList1");

//		Stream<Integer> sorted = streamFromList1.sorted();
//		sorted.forEach(e->System.out.println(e));

//		Normal way
//		for (Integer integer : list) {
//			System.out.println("Doubled values for list : "+integer*integer);
//		}

//		streamFromList1.forEach(e->System.out.println("Doubled values for list : "+e*e));

//		Stream<Integer> streamMap= streamFromList1.map(e->e*e);
//		streamMap.forEach(e->System.out.println(e));

//		sorting, doublin and printing
//		list.stream()
//				.map(e->e*2)
//				.sorted()
//				.forEach(e->System.out.println("doubled value is : "+e));

//		Predicate<Integer> predicate=new Predicate<Integer>() {	
//			@Override
//			public boolean test(Integer n) {
//				return n%2==0;
//			}
//		
//		};

//		Predicate<Integer> predicate= n ->  n%2==0;

//		Function<Integer,Integer> function =new Function<Integer,Integer>() {
//
//			@Override
//			public Integer apply(Integer t) {
//				return t+t;
//			}
//			
//		};

		Function<Integer, Integer> function = t -> t + t;

//		list.stream()
////				.filter(predicate)
//				.filter(n ->  n%2==0)
////				.map(function)
//				.map(t-> t + t)
//				.sorted()
//				.forEach(e -> System.out.println("doubled value is : " + e));

		
		int result= list.stream()
				.filter(n -> n % 2 == 0)
				.map(t -> t + t)	
				.sorted()
				.reduce(0, (r,e)-> r+e );

			System.out.println(result);
	}
}
