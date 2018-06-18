package com.sameergauba.ml.testmain;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

/**
 * Created by sameer on 24/9/17.
 */
public class ApacheOpenNLPMain {
	public static void main(String args[]) throws Exception {

		// Loading Parts of speech-maxent model
		InputStream inputStream = new FileInputStream("src/main/resources/apache/opennlp/en-pos-maxent.bin");
		POSModel model = new POSModel(inputStream);

		// Instantiating POSTaggerME class
		POSTaggerME tagger = new POSTaggerME(model);

		String sentence = "Hello this is a lecture on speech recognition recognising to, machine learning, security, mqtt";

		// Tokenizing the sentence using WhitespaceTokenizer class
		WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
		String[] tokens = whitespaceTokenizer.tokenize(sentence);

		// Generating tags
		String[] tags = tagger.tag(tokens);

		// Instantiating the POSSample class
		POSSample sample = new POSSample(tokens, tags);
		System.out.println(sample.toString());
		
		 double [] probs = tagger.probs();       
	      System.out.println("  ");       
	      
	      //Printing the probabilities  
	      for(int i = 0; i<probs.length; i++) 
	         System.out.println(probs[i]); 

	}
}
