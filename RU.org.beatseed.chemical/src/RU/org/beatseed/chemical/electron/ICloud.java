package RU.org.beatseed.chemical.electron;

import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;



public interface ICloud {

	LinkedList<S> getCloud();

	public void invade(int numberOfElectrons) throws Exception;

	public void showEMap();

	public void showCloud();

	void showCloud(Predicate<S> tester,Function<S,String>mapper,Consumer<String> block);

	
}
