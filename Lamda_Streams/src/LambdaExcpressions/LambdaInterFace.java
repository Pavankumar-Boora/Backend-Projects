package LambdaExcpressions;

import java.util.stream.Stream;

@FunctionalInterface
public interface LambdaInterFace {
	public static String var="Im in Functional Interface";
	public int add(int a,int b);
	
	public static int addInt(int a,int b) {
		return a+b;
	}
	default int addDouble(int a,int b) {
		return a+b;
	}	
	
}
