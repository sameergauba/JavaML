package com.sameergauba.ml;

import org.jblas.DoubleMatrix;

public interface LogisticRegression {
	
	DoubleMatrix train(double[][] X, double[] y);
	double predict(double[] x);

}
