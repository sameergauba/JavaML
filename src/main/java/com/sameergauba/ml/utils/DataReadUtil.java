package com.sameergauba.ml.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.sameergauba.ml.ArrayDataDTO;

public class DataReadUtil {

	public static ArrayDataDTO readDoubleFromCSV(String fileName, String saperator, boolean readFirstLine) {
		List<double[]> books = new ArrayList<double[]>();
		List<Double> ylist = new ArrayList<Double>();
		ArrayDataDTO arrayDataDTO = new ArrayDataDTO();
		Path pathToFile = Paths.get(fileName); 
		try { 
			BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
			String line = br.readLine();
			if(!readFirstLine){
				line = br.readLine();
			}
			while (line != null) { 
				String[] attributes = line.split(saperator);
				double[] X = new double[attributes.length-1];
				for(int i=0; i<attributes.length-1; i++){
					X[i] = Double.parseDouble(attributes[i]);
				}
				ylist.add(Double.parseDouble(attributes[attributes.length-1]));
				books.add(X);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		Double[] y = new Double[ylist.size()]; 
		y = ylist.toArray(y);

		arrayDataDTO.setY(y);
		int l = books.size();
		Object[] objects = books.toArray();
		double[][] xarray = books.toArray(new double[books.size()][0]);
		arrayDataDTO.setX(xarray);
		return arrayDataDTO;
	}

}
