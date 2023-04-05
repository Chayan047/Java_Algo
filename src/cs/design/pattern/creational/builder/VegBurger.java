package cs.design.pattern.creational.builder;

public class VegBurger extends Burger {

	@Override
	public String name() {

		return "Veg Burger";
	}

	@Override
	public float price() {
		return 25.0f;
	}

}