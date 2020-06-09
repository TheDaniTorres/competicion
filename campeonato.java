class Campeonato {

  private String campeonato;
  private String ganador;

	/**
	* Default Campeonato constructor
	*/
	public Campeonato(String campeonato, String ganador) {
		this.campeonato = campeonato;
		this.ganador = ganador;
	}



	/**
	* Returns value of campeonato
	* @return
	*/
	public String getCampeonato() {
		return campeonato;
	}

	/**
	* Sets new value of campeonato
	* @param
	*/
	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}

	/**
	* Returns value of ganador
	* @return
	*/
	public String getGanador() {
		return ganador;
	}

	/**
	* Sets new value of ganador
	* @param
	*/
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

  /**
  * Create string representation of Campeonato for printing
  * @return
  */
  @Override
  public String toString() {
    return "Campeonato [campeonato=" + campeonato + ", ganador=" + ganador + "]";

}
}
