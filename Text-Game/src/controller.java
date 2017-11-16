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
			navigate(input);
		}else if(false){
			
		}else if(false){
			
		}else if(false){
		
		}else if(false){
			
		}else if(false){
			
		}else if(false){
			
		}else if(false){
			
		}
	}
	private void navigate(String input) {
		model.navigate(input.charAt(0));
	}
	
}
