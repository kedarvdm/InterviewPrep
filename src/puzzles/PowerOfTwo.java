package puzzles;

public class PowerOfTwo {
	public static boolean isPowOfTwo(int n) {
	    if(n ==0)
	        return false;
	    return (n & (n-1)) == 0;
	}
	
	public static void main(String args[]){
		boolean what = isPowOfTwo(32);
		System.out.println(what);
	}
}
