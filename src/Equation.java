/**
 * A basic equation class that handles 0-2nd degree functions
 * @author jlars
 *
 */
public class Equation {
	
	private double coeff[];
	
	/**
	 * Initializes a function with an array of coefficients
	 * @param coeff Array of 3 coefficients
	 */
	public Equation(double[] coeff) {
		this.coeff = coeff;
	}
	
	/**
	 * Evaluate this function at any real x
	 * @param x the x value to evaluate this function at
	 * @return the value at f(x) with the given x
	 */
	
	public double evaluate(double x) {
		return (coeff[0] * (x * x)) + (coeff[1] * x) + coeff[2];
	}
	
	/**
	 * Evaluates the derivative of the given function at any real x
	 * @param x the x value to evaluate the derivative of this function at
	 * @return the value at f'(x) with the given x
	 */
	
	public double evalDer(double x) {
		return (2 * coeff[0] * x) + coeff[1];
	}
	
	/**
	 * Returns a string of this equation
	 * @return A string form of this equation
	 */
	public String getEquation() {
		return coeff[0] + "x^2 + " + coeff[1] + "x + " + coeff[2];
	}

}
