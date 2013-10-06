package RU.org.beatseed.chemical.electron;

public interface IQuantNumber<T> {
	T getQuantNumber();

	IQuantNumber<Integer> getParent();
}
