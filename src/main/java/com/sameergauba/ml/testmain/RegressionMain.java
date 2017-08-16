package com.sameergauba.ml.testmain;

import com.sameergauba.ml.LinearRegression;
import com.sameergauba.ml.MachineLearningFactory;

public class RegressionMain {
	
	public static void main(String[] args) {
		LinearRegression linearRegression = MachineLearningFactory.getLinearRegression();
		double[][] X = {{2,3},{3,3},{4,3},{2,8},{10,3},{2,10},{12,3}};
		double[] y = {10, 11, 12, 15, 18, 17, 20};
		linearRegression.train(X, y);
		double[] x = {12,4};
		System.out.println(linearRegression.predict(x));
	}

}
