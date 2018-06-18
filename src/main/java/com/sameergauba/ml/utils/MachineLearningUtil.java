package com.sameergauba.ml.utils;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

public class MachineLearningUtil {
	

	
	public static DoubleMatrix normalizeFeatures(DoubleMatrix X){
		for(int i=0; i<X.getColumns(); i++){
			DoubleMatrix column = X.getColumn(i);
			double mean = column.mean();
			double variance = MatrixFunctions.pow(column.sub(mean),2).sum()/(column.length-1);
			double sd = Math.sqrt(variance);
			double range = column.max() - column.min();
			column = column.sub(column.min());
			column = column.div(range);
			X.putColumn(i, column);
		}
		return X;
	}

}
