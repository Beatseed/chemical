package RU.org.beatseed.chemical.electron;

public class S extends QuantNumber<Double> implements IQuantNumber<Double> {
	// private double quantNumber;

	IElectron e;

	S(IQuantNumber<Integer> parent, double number) {
		super(parent, number);
		// this.quantNumber = number;
		((M) parent).freeS++;
		((N) (parent.getParent().getParent())).getCloud().getCloud().push(this);
	}

	public boolean occupied() {
		return e != null;
	}

	public boolean occupy(Electron e) {
		if (!occupied()) {
			this.e = e;
			((M) parent).freeS--;
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(QuantNumber<? extends Number> arg0) {
		S entry = (S) arg0;
		// check n+l
		int result = ((M) this.getParent()).sumnl
				- ((M) entry.getParent()).sumnl;
		if (result != 0) {
			return result;
		}
		// check n
		result = this.getParent().getParent().getParent().getQuantNumber()

		- entry.getParent().getParent().getParent().getQuantNumber();
		if (result != 0) {
			return result;
		}
		// check free spins in m,less energy where 2 spins free
		result = ((M) entry.getParent()).freeS - ((M) this.getParent()).freeS;
		if (result != 0) {
			return result;
		}
		// check m
		result = this.getParent().getQuantNumber()
				- entry.getParent().getQuantNumber();
		if (result != 0) {
			return result;
		}
		// check S
		result = (int) (this.getQuantNumber() - entry.getQuantNumber());
		if (result != 0) {
			return result;
		}
		return 0;
	}
}
