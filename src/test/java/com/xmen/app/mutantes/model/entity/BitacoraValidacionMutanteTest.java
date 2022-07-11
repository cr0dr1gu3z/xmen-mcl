package com.xmen.app.mutantes.model.entity;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BitacoraValidacionMutanteTest {
	
	
	private Long id;
	
    private String dna = "ATGCGA"; 
    
    
    
    
    
    private Boolean esMutante = false;
    

	 String getDna() {
		return dna;
	}

	 @Test
	 @SuppressWarnings("squid:S2699")
    void setDna() {
	   String dna = "ATGCGC";
		this.dna = dna;
	}



	

 

	@Test
	@SuppressWarnings("squid:S2699")
	void setEsMutante() {
		Boolean esMutante = true;
		this.esMutante = esMutante;
	}


}
