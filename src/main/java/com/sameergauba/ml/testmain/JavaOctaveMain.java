/*package com.sameergauba.ml.testmain;

import com.sameergauba.ml.octave.OctaveConstantUtil;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;

public class JavaOctaveMain {

	public static void main(String[] args) {

	    
	    OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
	    OctaveDouble matA = new OctaveDouble(new double[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}, 3, 5);
	    octave.put("a", matA);
	    octave.eval("a;");
	    
	    OctaveDouble matX = new OctaveDouble(new double[]{2,3,4,2,10,2,12,3,3,3,8,3,10,3}, 7,2) ;
	    OctaveDouble maty = new OctaveDouble(new double[]{10, 11, 12, 15, 18, 17, 20}, 7, 1) ;
	    octave.put("X", matX);
	    octave.put("y", maty);
	     
	    String matB = "b = [1,2,3; 4,5,6; 7,8,9];";
	    octave.eval(matB);
	     
	    octave.eval("x = b(1,:);");
	    octave.eval("pwd");
	    octave.eval("cd " + OctaveConstantUtil.DIRECTORY_PATH);
	    octave.eval("pwd");
	    octave.eval("linear_regression;");
	    OctaveDouble price = (OctaveDouble)octave.get("price");
	    *//*octave.eval("X = data(:, 1); y = data(:, 2);");
	    OctaveDouble varX = (OctaveDouble) octave.get("x");
	    System.out.println("Result: "+varX.get(1,1)+" "+varX.get(1,2)+" "+varX.get(1,3));*//*
	    octave.close();
	}

}*/
