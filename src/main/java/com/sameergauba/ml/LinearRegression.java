package com.sameergauba.ml;

import java.util.List;

import org.jblas.DoubleMatrix;

public interface LinearRegression {
	
	DoubleMatrix train(double[][] X, double[] y);
	double predict(double[] x);
	void setIterationsForGradientDescend(long iterationsForGradientDescend);
	void setAlpha(double alpha);
	
	List<Double> getCostFunctionValues();

}
