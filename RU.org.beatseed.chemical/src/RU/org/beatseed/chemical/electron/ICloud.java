package RU.org.beatseed.chemical.electron;

import java.util.LinkedList;

import RU.org.beatseed.chemical.electron.Cloud.CheckCloud;

public interface ICloud {

	LinkedList<S> getCloud();

	public void invade(int numberOfElectrons) throws Exception;

	public void showEMap();

	public void showECloud();

	void showCloud(CheckCloud tester);

}
