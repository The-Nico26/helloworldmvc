package model;

import contract.IModel;

public class Model implements IModel {
	DAOHelloWorld dao = new DAOHelloWorld();
	
	public String getHelloWorld() {
		return "Hello World";
	}

}
