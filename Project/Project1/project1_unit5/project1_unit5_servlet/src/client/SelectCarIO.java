package client;

import java.util.ArrayList;

import model.Automobile;

public interface SelectCarIO {
	public ArrayList<String> getModelList();
	public Automobile getAutomobile(String modelName);
}
