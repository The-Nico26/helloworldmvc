package main;

import controller.Controller;
import model.Model;
import view.View;

public class Main {
	public Main(){
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(view, model);
	}
	public static void main(String[] args){
		new Main();
	}
}
