package LambdaExcpressions;

public class LambdaExcpression {
	public static void main(String[] args) {
		
		
//		LambdaInterFace lambdaInterFace1=(int a,int b)->{int r=a+b;return r;};
		
		LambdaInterFace lambdaInterFace1=(a,b)->a+b;
		
		
		new TestLambdaExcpression().testLambdaExcpression(lambdaInterFace1, 10, 30);
		System.out.println(LambdaInterFace.addInt(50, 100));
		System.out.println(LambdaInterFace.var);
	}
}