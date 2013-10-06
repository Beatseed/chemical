package RU.org.beatseed.chemical.electron;

import RU.org.beatseed.chemical.electron.Cloud.EnergyTypeEnum;

/*
 * l - квантовое число, подуровень
 * подуровень отличает тип (s,p,d,f...)и число орбиталей, зависищее от типа
 * подуровень необходимо заполнить орбиталями 
 * нумерация орбиталей с 0.
 * пример для p подуровня будут созданы орбитали с номерами -1,0,1 
 */

public class L extends QuantNumber<Integer> implements IQuantNumber<Integer> {
	L(IQuantNumber<Integer> parent, int number, EnergyTypeEnum numberType) {
		super(parent, number);
		childs.push(new M(this, 0));
		quantNumberType = numberType;

		for (int l = (int) Cloud.SublevelOrbitals.get(numberType) / 2; l != 0; l--) {

			childs.push(new M(this, l));
			childs.push(new M(this, -l));

		}

	}

}
