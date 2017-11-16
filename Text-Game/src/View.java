
public class View {
	public void print (String a) {
		System.out.println(a);
	}
	public void print (String[] a) {
		int i = a.length;
		while(i>0) {
			System.out.println(a[i]);
			i--;
		}
	}
	public void print (Object o) {
		System.out.println(o);
	}
	
	public void print (Object[] o) {
		int i = o.length;
		while(i>0) {
			System.out.println(o[i]);
			i--;}
		}
}
