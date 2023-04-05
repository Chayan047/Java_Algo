package cs.design.pattern.creational.builder;

public abstract class ColdDrinks implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

}
