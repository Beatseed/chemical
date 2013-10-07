package RU.org.beatseed.chemical.electron;

/*
 * m - квантовое число, орбиталь
 * каждая орбиталь имеет 2 спина с номерами 0.5, -0.5
 */

public class M extends QuantNumber<Integer> implements IQuantNumber<Integer> {
	private int sumnl;
	private int freeS;
	private static final int maxS=2;
	M(IQuantNumber<Integer> parent, int number) {
		super(parent, number);
		sumnl = parent.getParent().getQuantNumber() + parent.getQuantNumber();
		getChilds().push(new S(this, 0.5));
		getChilds().push(new S(this, -0.5));

	}
	public boolean addS(){
		if (freeS<=maxS){
			freeS++;
			return true;
		}
		return false;
	}
	public boolean takeS(){
		if (freeS>0){
			freeS--;
			return true;
		}
		return false;
	}
	public int getFreeS(){
		return freeS;
	}
	public int getSumnl(){
		return sumnl;
	}
}
