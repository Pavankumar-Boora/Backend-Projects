package interfaceStaticAndDefault;

import java.util.ArrayList;
import java.util.List;

public class ImplemetationForInterface<E> implements Interface_C<E> {
	private List<E> list = new ArrayList<>();

	@Override
	public E add(E e) {
		list.add(e);
		return e;
	}

	@Override
	public E get(int index) {
		return index >= 0 && index < list.size() ? list.get(index) : null;
	}

	public void addElement(E element) {
		list.add(element);
	}

	public static void main(String[] args) {
		ImplemetationForInterface<String> implInterfaceString = new ImplemetationForInterface<>();
		implInterfaceString.add("first");
		implInterfaceString.add("second");
		implInterfaceString.add("third");

		System.out.println("First element  : " + implInterfaceString.getFirst());
		System.out.println("Element at index 1 : " + implInterfaceString.get(1));
		System.out.println("Number of elements : " + Interface_C.count(implInterfaceString.list));
		
		ImplemetationForInterface<Integer> implInterfaceInt = new ImplemetationForInterface<>();
		implInterfaceInt.add(1);
		implInterfaceInt.add(2);
		implInterfaceInt.add(3);

		System.out.println("\nFirst element : " + implInterfaceInt.getFirst());
		System.out.println("Element at index 1 : " + implInterfaceInt.get(1));
		System.out.println("Number of elements : " + Interface_C.count(implInterfaceString.list));
	}

}
