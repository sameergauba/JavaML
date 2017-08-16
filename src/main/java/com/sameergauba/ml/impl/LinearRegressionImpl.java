package com.sameergauba.ml.impl;

import java.util.ArrayList;
import java.util.List;

import org.jblas.DoubleMatrix;

import com.sameergauba.ml.LinearRegression;

public class LinearRegressionImpl implements LinearRegression{
	
	private DoubleMatrix theta;
	private double alpha = 0.01;
	private long iterationsForGradientDescend = 400;
	private List<Double> costFunctionValues;

	public DoubleMatrix train(double[][] X, double[] y) {
		
		DoubleMatrix xMatrix = new DoubleMatrix(X);
	    DoubleMatrix yMatrix = new DoubleMatrix(y);
	    int xMatrixRows = xMatrix.getRows();
	    
	    DoubleMatrix allOnes = DoubleMatrix.ones(xMatrixRows);
	    xMatrix = DoubleMatrix.concatHorizontally(allOnes, xMatrix);
	    
	    theta = DoubleMatrix.zeros(xMatrix.columns);
	    costFunctionValues = new ArrayList<Double>();
	    for(long i=0; i<iterationsForGradientDescend; i++){
	    	DoubleMatrix J = xMatrix.mmul(theta).sub(yMatrix);
	    	
	    	costFunctionValues.add(J.sum());
	    	DoubleMatrix newX = xMatrix.transpose().mmul(J);
	    	newX = newX.mul(alpha/xMatrix.rows);
	    	theta = theta.sub(newX);
	    }
	    
	    return theta;
	}

	public DoubleMatrix getTheta() {
		return theta;
	}

	public double predict(double[] x) {
		DoubleMatrix xMatrix = new DoubleMatrix(x);
		xMatrix = xMatrix.transpose();
		DoubleMatrix allOnes = DoubleMatrix.ones(xMatrix.rows);
	    xMatrix = DoubleMatrix.concatHorizontally(allOnes, xMatrix);
		Double y = xMatrix.mmul(theta).get(0, 0);
		return y;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public long getIterationsForGradientDescend() {
		return iterationsForGradientDescend;
	}

	public void setIterationsForGradientDescend(long iterationsForGradientDescend) {
		this.iterationsForGradientDescend = iterationsForGradientDescend;
	}

	public List<Double> getCostFunctionValues() {
		return costFunctionValues;
	}

	public void setCostFunctionValues(List<Double> costFunctionValues) {
		this.costFunctionValues = costFunctionValues;
	}
	
}
