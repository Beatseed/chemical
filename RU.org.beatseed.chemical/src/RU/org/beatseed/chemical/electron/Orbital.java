package RU.org.beatseed.chemical.electron;

import java.util.HashMap;
import java.util.Map;



public class Orbital {
	public static enum EnergyTypeEnum {
		s, p, d, f
	};

	// количество орбиталей на каждом подуровне
	private static final Map<EnergyTypeEnum, Integer> SublevelOrbitals = new HashMap<EnergyTypeEnum, Integer>();
	static {
		SublevelOrbitals.put(EnergyTypeEnum.s, 1);
		SublevelOrbitals.put(EnergyTypeEnum.p, 3);
		SublevelOrbitals.put(EnergyTypeEnum.d, 5);
		SublevelOrbitals.put(EnergyTypeEnum.f, 7);
	}
	public static Integer getOrbitalQuantity(EnergyTypeEnum type){
		return SublevelOrbitals.get(type);
	}
	public static EnergyTypeEnum getEnergyType(Integer index){
		return EnergyTypeEnum.values().clone()[index];
	}
}
