package RU.org.beatseed.chemical.electron;

import RU.org.beatseed.chemical.electron.Cloud.EnergyTypeEnum;

/*
 * l - ��������� �����, ����������
 * ���������� �������� ��� (s,p,d,f...)� ����� ���������, ��������� �� ����
 * ���������� ���������� ��������� ���������� 
 * ��������� ��������� � 0.
 * ������ ��� p ��������� ����� ������� �������� � �������� -1,0,1 
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
