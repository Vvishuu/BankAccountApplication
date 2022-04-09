package bankApp;

public interface IBaseRate {
	// Write a method to return base rate
	default double getBaseRate() {
		return 2.5;
	}

}
