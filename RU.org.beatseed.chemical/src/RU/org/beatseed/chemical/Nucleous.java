package RU.org.beatseed.chemical;

public class Nucleous {
	private int protons;
	private int neutrons;
	private double aem;
	private int chargesign;

	public Nucleous(int protons, int neutrons) {
		this.protons = protons;
		this.neutrons = neutrons;
		aem = Neutron.aem * neutrons + Proton.aem * protons;
		chargesign = Proton.chargeSign * protons;
	}

}
