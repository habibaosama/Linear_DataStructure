package lab4;

interface IPolynomialSolver {
public void setPolynomial(char poly, int[][] terms);
public String print(char poly);
public void clearPolynomial(char poly);

public float evaluatePolynomial(char poly, float value);

public int[][] add(char poly1, char poly2);

public int[][] subtract(char poly1, char poly2);

public int[][] multiply(char poly1, char poly2);
}
