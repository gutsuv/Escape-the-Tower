import java.util.Scanner;

public class controller {
	Scanner control = new Scanner(System.in);
	ObjectHolder model;
	public controller(ObjectHolder main) {
		model = main;
		while(true) {
			determine(control.next());
		}
	}
	private void determine(String input) {
		if(input.length()==1) {
			try {navigate(input);}catch(Exception E) {}
		}else if(false){
			
		}else if(false){
			
		}else if(false){
		
		}else if(false){
			
		}else if(false){
			
		}else if(false){
			
		}else if(false){
			
		}
	}
	private void navigate(String input) throws Exception {
		model.navigate(input.charAt(0));
	}
	
}
