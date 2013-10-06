package RU.org.beatseed.chemical.electron;

import java.util.LinkedList;

import RU.org.beatseed.chemical.electron.Cloud.EnergyTypeEnum;

public class QuantNumber<T> implements IQuantNumber<T>,
		Comparable<QuantNumber<? extends Number>> {
	IQuantNumber<Integer> parent;

	protected EnergyTypeEnum quantNumberType;
	protected LinkedList<QuantNumber<? extends Number>> childs;
	protected QuantNumberInt<T> quantNumberO;

	QuantNumber(IQuantNumber<Integer> parent, T number) {
		// quantNumber = number;
		childs = new LinkedList<QuantNumber<? extends Number>>();
		this.parent = parent;

		quantNumberO = new QuantNumberInt<T>();
		quantNumberO.set(number);
	}

	private class QuantNumberInt<R> {
		private R quantNumber;

		public void set(R t) {
			this.quantNumber = t;
		}

		public R get() {
			return quantNumber;
		}
	}

	public T getQuantNumber() {
		return quantNumberO.get();
	}

	@Override
	public IQuantNumber<Integer> getParent() {

		return parent;
	}

	@Override
	public int compareTo(QuantNumber<? extends Number> o) {

		QuantNumber<? extends Number> entry = o;
		@SuppressWarnings("unchecked")
		int result = ((QuantNumber<? extends Number>) this).getQuantNumber()
				.intValue() - entry.getQuantNumber().intValue();
		if (result != 0) {
			return result;
		}
		return 0;
	}

}
