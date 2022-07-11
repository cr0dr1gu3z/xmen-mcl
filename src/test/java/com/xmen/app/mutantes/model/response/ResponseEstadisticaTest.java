package com.xmen.app.mutantes.model.response;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResponseEstadisticaTest {
	
     long countMutantDNA;
	
	long countHumanDNA;
	
	double ratio;

	@Test
	 @SuppressWarnings("squid:S2699")
	void setCountMutantDNA() {
		long countMutantDNA = 1;
		this.countMutantDNA = countMutantDNA;
	}

	@Test
	 @SuppressWarnings("squid:S2699")
	 void setCountHumanDNA() {
		long countHumanDNA = 6;
		this.countHumanDNA = countHumanDNA;
	}


	@Test
	 @SuppressWarnings("squid:S2699")
	 void setRatio() {
		
		double ratio = 4/100;
		this.ratio = ratio;
	}
	

}
