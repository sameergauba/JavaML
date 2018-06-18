package com.sameergauba.ml.testmain;

import java.util.stream.Stream;

import org.jblas.DoubleMatrix;

import com.sameergauba.ml.ArrayDataDTO;
import com.sameergauba.ml.LinearRegression;
import com.sameergauba.ml.MachineLearningFactory;
import com.sameergauba.ml.utils.DataReadUtil;

public class WineDataRegressionMain {
	
	public static void main(String[] args) {
		LinearRegression linearRegression = MachineLearningFactory.getLinearRegression();
		ArrayDataDTO arrayDataDTO = DataReadUtil.readDoubleFromCSV("src/main/resources/winequalityred.csv", ";", false);
		linearRegression.setIterationsForGradientDescend(50000);
		linearRegression.setAlpha(0.0001);
		double[] y = Stream.of(arrayDataDTO.getY()).mapToDouble(Double::doubleValue).toArray();
		DoubleMatrix theta = linearRegression.train(arrayDataDTO.getX(), y);
		//System.out.println("J : " + linearRegression.getCostFunctionValues());
		System.out.println("Theta : " + theta);
		//double[] x = {11.6,0.475,0.4,1.4,0.091,6,28,0.99704,3.0,0.65,10.0333333333333};
		//double[] x = {6.4,0.56,0.15,1.8,0.078,17,65,0.99294,3.33,0.6,10.5};
		//double[] x = {6.6,0.56,0.14,2.4,0.064,13,29,0.99397,3.42,0.62,11.7};
		
		ArrayDataDTO arrayDataDTOValidate = DataReadUtil.readDoubleFromCSV("src/main/resources/winequalitytest.csv", ";", false);
		int i=0;
		for(double[] X : arrayDataDTOValidate.getX()){
			
			System.out.println("\nPredicted value : " + linearRegression.predict(X));
			System.out.println("Actual value : " + arrayDataDTOValidate.getY()[i]);
			i++;
		}
		
		//System.out.println(linearRegression.predict(x));
	}

}
