package RU.org.beatseed.chemical.electron;

/*
 * m - квантовое число, орбиталь
 * каждая орбиталь имеет 2 спина с номерами 0.5, -0.5
 */

public class M extends QuantNumber<Integer> implements IQuantNumber<Integer> {
	public int sumnl;
	public int freeS;

	M(IQuantNumber<Integer> parent, int number) {
		super(parent, number);
		sumnl = parent.getParent().getQuantNumber() + parent.getQuantNumber();
		childs.push(new S(this, 0.5));
		childs.push(new S(this, -0.5));

	}

}
