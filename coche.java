class Coche {

  private int numero;
  private String titular;


	/**
	* Default Coche constructor
	*/
	public Coche(String titular, int numero) {
		this.numero = numero;
		this.titular = titular;
	}


	/**
	* Returns value of numero
	* @return
	*/
	public int getNumero() {
		return numero;
	}

	/**
	* Sets new value of numero
	* @param
	*/
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	* Returns value of titular
	* @return
	*/
	public String getTitular() {
		return titular;
	}

	/**
	* Sets new value of titular
	* @param
	*/
	public void setTitular(String titular) {
		this.titular = titular;
	}
}
