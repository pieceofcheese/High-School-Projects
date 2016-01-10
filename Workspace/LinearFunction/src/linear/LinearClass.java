package linear;

public class LinearClass implements LinearFunctionMethods {
	
	public LinearClass(double slopes, double yIntc) {
		
		slope = slopes;
		intc = yIntc;
		
	}

	@Override
	public double getSlope() {
		// TODO Auto-generated method stub
		return slope;
	}

	@Override
	public double getYintercept() {
		// TODO Auto-generated method stub
		return intc;
	}

	@Override
	public double getRoot() {
		
		double root = -(intc/slope);
		
		return root;
	}

	@Override
	public double getYvalue(double x) {
		double y = (slope*x + intc);
		
		return y;
	}

	@Override
	public double getXvalue(double y) {
		double x = (y-intc)/slope;
		
		return x;
	}
	
	public double slope;
	public double intc;
	
}
