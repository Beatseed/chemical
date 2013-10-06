package RU.org.beatseed.chemical.electron;

import RU.org.beatseed.chemical.electron.Cloud.EnergyTypeEnum;

/*
 * n - ������� ��������� �����, �������, ������������� ������ ������� � ������������� �������
 * ������� ���������� ��������� �����������, ������ ������ ������������� ����� ����������. 
 * ��� ���� ������ ����������� ���������� ����� ����� ���.
 * �� 1- s(sharp), �� 2 - s,p(principle), �� 3 - s,p,d(diffuse), �� 4 - s,p,d,f(fundamental), � �.�.
 * 
 */
public class N extends QuantNumber<Integer> implements IQuantNumber<Integer> {
	private ICloud atomcloud;

	N(ICloud parent, int number) {
		super(null, number);
		atomcloud = parent;
		for (int i = 0; i < number; i++) {
			childs.push(new L(this, i, EnergyTypeEnum.values().clone()[i]));

		}
	}

	public ICloud getCloud() {
		return atomcloud;
	}

}
