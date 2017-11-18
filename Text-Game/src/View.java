import java.util.ArrayList;

public class View<e> {
	public void line() {
		System.out.println();
	}
	public void line(int i) {
		while(i>0) {
			i--;
			System.out.print("-");
		}
		line();
	}
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
		if(o==null) {return;}
		if(o instanceof ArrayList) {
			if(((ArrayList) o).size()==0) {
				return;
			}
			for(int i=0;i < ((ArrayList) o).size(); i++) {
				System.out.println(((ArrayList) o).get(i));
			}
			return;
		}
		System.out.println(o);
	}
	
	public void print (Object[] o) {
		int i = o.length;
		while(i>0) {
			System.out.println(o[i]);
			i--;}
		}

	public void print (Object o, Object e) {
		System.out.print(o);
		System.out.println(": "+e);
	}
}
