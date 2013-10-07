package RU.org.beatseed.chemical.electron;

import RU.org.beatseed.chemical.electron.Orbital.EnergyTypeEnum;



/*
 * l - квантовое число, подуровень
 * подуровень отличает тип (s,p,d,f...)и число орбиталей, зависищее от типа
 * подуровень необходимо заполнить орбиталями 
 * нумерация орбиталей с 0.
 * пример для p подуровня будут созданы орбитали с номерами -1,0,1 
 */

public class L extends QuantNumber<Integer> implements IQuantNumber<Integer> {
	private EnergyTypeEnum quantNumberType;
	L(IQuantNumber<Integer> parent, int number, EnergyTypeEnum numberType) {
		super(parent, number);
		getChilds().push(new M(this, 0));
		quantNumberType=numberType;
		for (int l = (int)Orbital.getOrbitalQuantity(numberType) / 2; l != 0; l--) {
			getChilds().push(new M(this, l));
			getChilds().push(new M(this, -l));
		}
	}

}
