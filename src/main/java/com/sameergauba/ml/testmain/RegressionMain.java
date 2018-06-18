package com.sameergauba.ml.testmain;

import org.jblas.DoubleMatrix;

import com.sameergauba.ml.LinearRegression;
import com.sameergauba.ml.MachineLearningFactory;

public class RegressionMain {
	
	public static void main(String[] args) {
		LinearRegression linearRegression = MachineLearningFactory.getLinearRegression();
		double[][] X = {{2,3},{3,3},{4,3},{2,8},{10,3},{2,10},{12,3}};
		double[] y = {10, 11, 12, 15, 18, 17, 20};
		linearRegression.setIterationsForGradientDescend(8000);
		DoubleMatrix theta = linearRegression.train(X, y);
		System.out.println("J : " + linearRegression.getCostFunctionValues());
		System.out.println("Theta : " + theta);
		double[] x = {12,4};
		System.out.println(linearRegression.predict(x));
	}

}
