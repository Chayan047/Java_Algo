/**
 * 
 */
package cs.design.pattern.behavariol.observer;

/**
 * @author csardar
 *
 */
public class ObserverPatternDemo {

	/**
	 * 
	 */
	public ObserverPatternDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subject subject = new Subject();

	      new HexaObserver(subject);
	      new OctalObserver(subject);
	      new BinaryObserver(subject);

	      System.out.println("First state change: 15");	
	      subject.setState(15);
	      System.out.println("Second state change: 10");	
	      subject.setState(10);

	}

}
