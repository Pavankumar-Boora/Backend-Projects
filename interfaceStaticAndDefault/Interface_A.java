package interfaceStaticAndDefault;

import java.util.List;

public interface Interface_A<E> {
	E add(E e);

	E get(int index);


	default E getFirst() {
		return this.get(0);
	}
	

	public static <E> int count(List<E> l) {
		int count = 0;
		for (E e : l) {
			count++;
		}
		return count;
	}

}
