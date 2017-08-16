package com.sameergauba.ml;

import com.sameergauba.ml.impl.LinearRegressionImpl;

public class MachineLearningFactory {
	
	private static LinearRegression linearRegression;

	public static LinearRegression getLinearRegression() {
		if(linearRegression == null){
			linearRegression = new LinearRegressionImpl();
		}
		return linearRegression;
	}
	
	

}
