package RU.org.beatseed.chemical;

import RU.org.beatseed.chemical.electron.Cloud;
import RU.org.beatseed.chemical.electron.ICloud;

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
}
