package RU.org.beatseed.chemical.electron;



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
			getChilds().push(new L(this, i, Orbital.getEnergyType(i)));

		}
	}

	public ICloud getCloud() {
		return atomcloud;
	}

}
