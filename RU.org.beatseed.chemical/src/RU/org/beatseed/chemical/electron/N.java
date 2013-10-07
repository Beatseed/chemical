package RU.org.beatseed.chemical.electron;



/*
 * n - главное квантовое число, уровень, соответствует номеру периода в периодической системе
 * уровень необходимо заполнить подуровнями, номеру уровня соответствует число подуровней. 
 * При этом каждый последующий подуровень имеет новый вид.
 * на 1- s(sharp), на 2 - s,p(principle), на 3 - s,p,d(diffuse), на 4 - s,p,d,f(fundamental), и т.д.
 * 
 */
public class N extends QuantNumber<Integer> implements IQuantNumber<Integer> {
	private ICloud atomcloud;

	N(ICloud parent, int number) {
		super(null, number);
		atomcloud = parent;
		for (int i = 0; i < number; i++) {
			getChilds().push(new L(this, i, Orbital.getEnergyType(i)));

		}
	}

	public ICloud getCloud() {
		return atomcloud;
	}

}
