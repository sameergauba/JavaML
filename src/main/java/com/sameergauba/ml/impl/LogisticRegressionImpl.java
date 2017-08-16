package com.sameergauba.ml.impl;

import java.util.List;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

import com.sameergauba.ml.LogisticRegression;

public class LogisticRegressionImpl implements LogisticRegression{
	
	private DoubleMatrix theta;
	private List<Double> costFunctionValues;
	private double regularizationParameter ;

	public DoubleMatrix train(double[][] X, double[] y) {
		DoubleMatrix xMatrix = new DoubleMatrix(X);
	    DoubleMatrix yMatrix = new DoubleMatrix(y);
	    int xMatrixRows = xMatrix.getRows();
	    
	    DoubleMatrix allOnes = DoubleMatrix.ones(xMatrixRows);
	    xMatrix = DoubleMatrix.concatHorizontally(allOnes, xMatrix);
	    
	    theta = DoubleMatrix.zeros(xMatrix.columns);
	    
	    DoubleMatrix z = getSigmoid(xMatrix.mmul(theta));
	    
		return theta;
	}

	private DoubleMatrix getSigmoid(DoubleMatrix mmul) {
		mmul = mmul.mul(-1);
		mmul = MatrixFunctions.exp(mmul).add(1);
		mmul = MatrixFunctions.pow(mmul, -1);
		return mmul;
	}

	public double predict(double[] x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
