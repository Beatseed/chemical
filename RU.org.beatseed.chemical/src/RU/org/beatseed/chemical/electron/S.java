package RU.org.beatseed.chemical.electron;

public class S extends QuantNumber<Double> implements IQuantNumber<Double> {
	private IElectron e;
	S(IQuantNumber<Integer> parent, double number) {
		super(parent, number);
		// this.quantNumber = number;
		if(((M) parent).addS()){
		((N) (parent.getParent().getParent())).getCloud().getCloud().push(this);
		}
	}

	public boolean occupied() {
		return e != null;
	}

	public boolean occupy(Electron e) {
		if (!occupied()&&((M) getParent()).takeS()) {
			this.e = e;
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(QuantNumber<? extends Number> arg0) {
		S entry = (S) arg0;
		// check n+l
		int result = ((M) this.getParent()).getSumnl()
				- ((M) entry.getParent()).getSumnl();
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
		result = ((M) entry.getParent()).getFreeS() - ((M) this.getParent()).getFreeS();
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
	public void printinfo(){
		System.out.println("n: "
				+ this.getParent().getParent().getParent()
						.getQuantNumber() + " l: "
				+ this.getParent().getParent().getQuantNumber() + " m: "
				+ this.getParent().getQuantNumber() + " s: "
				+ this.getQuantNumber() + " tenant: " + this.e);
	}
	public String getAddress(){
		return "n: "
				+ this.getParent().getParent().getParent()
				.getQuantNumber() + " l: "
		+ this.getParent().getParent().getQuantNumber() + " m: "
		+ this.getParent().getQuantNumber() + " s: "
		+ this.getQuantNumber() + " tenant: " + this.e;
	}
	public IElectron getE(){
		return e;
	}
}
