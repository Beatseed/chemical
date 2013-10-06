package RU.org.beatseed.chemical;

import RU.org.beatseed.chemical.electron.S;

public class Soup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// while (true) {
		// Atom a = new Atom();
		// RU.org.beatseed.chemical.Mtable.Hydrogen m = new
		// Mtable.Hydrogen();
		Atom litiy = Mtable.builder("Li");
		// litiy.getCloud().showCloud(new Cloud.CheckOccupiedOrbitals());
		/*
		 * litiy.getCloud().showCloud(new Cloud.CheckCloud() {
		 * 
		 * @Override public boolean test(S s) { return s.occupied();
		 * 
		 * } });
		 */

		//litiy.getCloud().showCloud((S s) -> s.occupied());
		//litiy.getCloud().showCloud((S s) -> s.occupied(), (S s)->s.printinfo());
		//litiy.getCloud().showCloud( s -> s.occupied(), s->s.getAddress(), adr->System.out.println(adr));
		//Atom.showCloud(litiy.getCloud().getCloud(), s -> s.occupied(), s->s.getAddress(), adr->System.out.println(adr));
		litiy.getCloud().getCloud().stream().filter( s -> s.occupied()).map(s->s.getAddress()).forEach(adr->System.out.println(adr));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// }
			// a = null;
		}
	}
}
