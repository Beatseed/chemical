package RU.org.beatseed.chemical;

import java.util.Hashtable;

public class Mtable {
	public static Hashtable<String, Atom> map;
	static {
		map = new Hashtable<String, Atom>();
		map.put("H", (new Atom("H", 1, 1, 1, false)));
		map.put("He", new Atom("He", 2, 1, 18, false));
		map.put("Li", new Atom("Li", 3, 2, 1, false));
		map.put("Be", new Atom("Be", 4, 2, 2, false));
		map.put("B", new Atom("B", 5, 2, 13, false));
		map.put("C", new Atom("C", 6, 2, 14, false));
		map.put("N", new Atom("N", 7, 2, 15, false));
		map.put("O", new Atom("O", 8, 2, 16, false));
		map.put("F", new Atom("F", 9, 2, 17, false));
		map.put("Ne", new Atom("Ne", 10, 2, 18, false));
		map.put("Na", new Atom("Na", 11, 3, 1, false));
		map.put("Mg", new Atom("Mg", 12, 3, 2, false));
		map.put("Al", new Atom("Al", 13, 3, 13, false));
		map.put("Si", new Atom("Si", 14, 3, 14, false));
		map.put("P", new Atom("P", 15, 3, 15, false));
		map.put("S", new Atom("S", 16, 3, 16, false));
		map.put("Cl", new Atom("Cl", 17, 3, 17, false));
		map.put("Ar", new Atom("Ar", 18, 3, 18, false));
		map.put("K", new Atom("K", 19, 4, 1, false));
		map.put("Ca", new Atom("Ca", 20, 4, 2, false));
		map.put("Sc", new Atom("Sc", 21, 4, 3, false));
		map.put("Ti", new Atom("Ti", 22, 4, 4, false));
		map.put("V", new Atom("V", 23, 4, 5, false));
	}

	public static Atom builder(String name) {

		Atom a = map.get(name);

		return new Atom(a.name, a.A, a.period, a.group, true);

	}

}
