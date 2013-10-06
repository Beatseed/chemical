package RU.org.beatseed.chemical;

//import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import RU.org.beatseed.chemical.electron.Cloud;
import RU.org.beatseed.chemical.electron.ICloud;
//import RU.org.beatseed.chemical.electron.S;

public class Atom implements Comparable<Object> {

	static int spins = 2;
	private ICloud cloud;
	protected Nucleous nucleous;

	protected String name;
	protected int period;
	protected int group;
	protected int A;

	Atom(String name, int A, int period, int group, boolean makeBody) {
		this.name = name;
		this.A = A;
		this.period = period;
		this.group = group;
		if (makeBody) {
			buildAtom();
		}

	}

	private void buildAtom() {
		if (nucleous == null) {
			nucleous = new Nucleous(A, A);
		}
		if (cloud == null) {
			cloud = new Cloud(period);

			try {
				cloud.invade(A);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// cloud.showECloud();
	}

	@Override
	public int compareTo(Object o) {
		return this.A - ((Atom) o).A;

	}

	public ICloud getCloud() {
		return cloud;
	}
	
	/*
	public static void showCloud(List<S>roster,Predicate<S> tester,Function<S,String>mapper,Consumer<String> block){
		for(S s:roster){
			if (tester.test(s)) {
				String data=mapper.apply(s);
				block.accept(data);
			}
		}
	}*/
	public static <X, Y> void showCloud(
		    Iterable<X> source,
		    Predicate<X> tester,
		    Function <X, Y> mapper,
		    Consumer<Y> block) {
		    for (X p : source) {
		        if (tester.test(p)) {
		            Y data = mapper.apply(p);
		            block.accept(data);
		        }
		    }
		}
}
