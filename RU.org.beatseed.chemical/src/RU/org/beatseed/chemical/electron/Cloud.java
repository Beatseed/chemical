package RU.org.beatseed.chemical.electron;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Cloud implements ICloud {
	static enum EnergyTypeEnum {
		s, p, d, f
	};

	// ���������� ��������� �� ������ ���������
	static Map<EnergyTypeEnum, Integer> SublevelOrbitals = new HashMap<EnergyTypeEnum, Integer>();
	static {
		SublevelOrbitals.put(EnergyTypeEnum.s, 1);
		SublevelOrbitals.put(EnergyTypeEnum.p, 3);
		SublevelOrbitals.put(EnergyTypeEnum.d, 5);
		SublevelOrbitals.put(EnergyTypeEnum.f, 7);
	}

	protected LinkedList<N> elevels;
	protected LinkedList<S> ecloud;

	/*
	 * ����������� ������ ��������� ���������� ��� ���������� �������� ������
	 * ����������� �������� ������� ����������� - ������� ������� � ����������
	 * ���������� � ������� ���������� ����� n + l, � ��� ����� � ��� ��
	 * �������� ���� ����� ���� ������������� ������ � ������� n.
	 */
	public Cloud(int numOfLevels) {
		// levels = new LinkedList<Level>();
		elevels = new LinkedList<N>();
		ecloud = new LinkedList<S>();
		for (int i = 1; i <= numOfLevels; i++) {
			// levels.push(new Level(this, i));
			elevels.push(new N(this, i));
		}

	}

	/*
	 * ���������� ������������ ������ ����������� numberOfElectrons - ����������
	 * ���������� ����� �������� ������������ ������� (non-Javadoc)
	 * 
	 * @see RU.org.beatseed.chemical.electron.ICloud#invade(int)
	 */
	public void invade(int numberOfElectrons) throws Exception {
		Electron e;
		for (int i = 0; i < numberOfElectrons; i++) {
			e = new Electron();
			if (!findOrbitalKRule(e))
				throw new Exception();
		}
	}

	/*
	 * ���������� ��������� �� ������� �����������. ������� ������� � ����������
	 * ���������� � ������� ���������� ����� n + l, � ��� ����� � ��� ��
	 * �������� ���� ����� ���� ������������� ������ � ������� n. � ������
	 * ������� ����������� �������� � ���������� �������� ������
	 */
	private boolean findOrbitalKRule(Electron e) {
		// ��������� ������ ��������� ��������� � ������ ��������� �����
		Collections.sort(ecloud);
		for (S s : ecloud) {
			if (s.occupy(e)) {
				return true;
			}
		}

		return false;
	}

	/*
	 * private boolean findOrbital(Electron e) { // ��������� ����������������
	 * �����, ������� � 1��,s ��������� � �.�. // ������ ��������� �� �������� �
	 * ����� � ��� ��� ������� �������� // �������� LIFO, 1 ������ � �������
	 * ������� // ������� for (Iterator<N> iterator =
	 * elevels.descendingIterator(); iterator .hasNext();) { N n =
	 * iterator.next(); // ���������� for (Iterator<QuantNumber<?>> iterator2 =
	 * n.childs .descendingIterator(); iterator2.hasNext();) {
	 * 
	 * QuantNumber<?> l = iterator2.next(); // �������� for
	 * (Iterator<QuantNumber<?>> iterator3 = l.childs .descendingIterator();
	 * iterator3.hasNext();) { QuantNumber<?> m = iterator3.next(); // ���� for
	 * (Iterator<QuantNumber<?>> iterator4 = m.childs .descendingIterator();
	 * iterator4.hasNext();) { QuantNumber<?> s = iterator4.next(); // ����
	 * ��������� ��������� ����, ������ ��� if (((S) s).occupy(e)) return true;
	 * } }
	 * 
	 * } } return false; }
	 */
	public void showEMap() {
		for (N n : elevels) {
			for (QuantNumber<?> l : n.childs) {
				for (QuantNumber<?> m : l.childs) {
					for (QuantNumber<?> s : m.childs) {
						System.out.println("Electron map- n: "
								+ n.getQuantNumber() + " l: "
								+ l.getQuantNumber() + " m: "
								+ m.getQuantNumber() + " s: "
								+ m.getQuantNumber() + ((S) s).e);

					}
				}

			}
		}
		System.out.println("");
	}

	public void showECloud() {

		for (S s : ecloud) {
			System.out.println("Electron map- n: "
					+ s.getParent().getParent().getParent().getQuantNumber()
					+ " l: " + s.getParent().getParent().getQuantNumber()
					+ " m: " + s.getParent().getQuantNumber() + " s: "
					+ s.getQuantNumber() + " tenant: " + s.e);
		}

	}

	public interface CheckCloud {
		boolean test(S s);
	}

	public static class CheckOccupiedOrbitals implements CheckCloud {
		@Override
		public boolean test(S s) {
			return s.occupied();
		}
	}

	public void showCloud(CheckCloud tester) {

		for (S s : ecloud) {
			if (tester.test(s)) {
				System.out.println("Electron map- n: "
						+ s.getParent().getParent().getParent()
								.getQuantNumber() + " l: "
						+ s.getParent().getParent().getQuantNumber() + " m: "
						+ s.getParent().getQuantNumber() + " s: "
						+ s.getQuantNumber() + " tenant: " + s.e);
			}
		}

	}

	/*
	 * public void showCloudPredicate(Predicate<S> tester) {
	 * 
	 * for (S s : ecloud) { if (tester.test(s)) {
	 * System.out.println("Electron map- n: " +
	 * s.getParent().getParent().getParent() .getQuantNumber() + " l: " +
	 * s.getParent().getParent().getQuantNumber() + " m: " +
	 * s.getParent().getQuantNumber() + " s: " + s.getQuantNumber() +
	 * " tenant: " + s.e); } }
	 * 
	 * }
	 */

	@Override
	public LinkedList<S> getCloud() {

		return ecloud;
	}
}
