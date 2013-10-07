package RU.org.beatseed.chemical.electron;

import RU.org.beatseed.chemical.electron.Orbital.EnergyTypeEnum;



/*
 * l - ��������� �����, ����������
 * ���������� �������� ��� (s,p,d,f...)� ����� ���������, ��������� �� ����
 * ���������� ���������� ��������� ���������� 
 * ��������� ��������� � 0.
 * ������ ��� p ��������� ����� ������� �������� � �������� -1,0,1 
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
