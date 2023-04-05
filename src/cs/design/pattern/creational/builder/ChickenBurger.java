package cs.design.pattern.creational.builder;

public class ChickenBurger extends Burger {

	public ChickenBurger() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		return "Chicken Burger";
	}

	@Override
	public float price() {
		return 50.5f;
	}

}
