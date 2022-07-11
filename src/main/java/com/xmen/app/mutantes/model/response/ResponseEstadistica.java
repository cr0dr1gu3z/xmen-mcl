package com.xmen.app.mutantes.model.response;

import java.io.Serializable;




public class ResponseEstadistica implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long countMutantDNA;
	
	private long countHumanDNA;
	
	private double ratio;

	public long getCountMutantDNA() {
		return countMutantDNA;
	}

	public void setCountMutantDNA(long countMutantDNA) {
		this.countMutantDNA = countMutantDNA;
	}

	public long getCountHumanDNA() {
		return countHumanDNA;
	}

	public void setCountHumanDNA(long countHumanDNA) {
		this.countHumanDNA = countHumanDNA;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
		
}
