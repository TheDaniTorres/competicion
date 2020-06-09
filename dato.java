import java.io.*;

class Dato {

  Piloto[] pilotos = new Piloto[30];
  Coche[] coches = new Coche[pilotos.length];
  Campeonato[] campeonatos = new Campeonato[10];
// borrar todo toito

 void clearTodo() {
   for (int i = 0; i < coches.length; i++) {
     this.coches[i] = null;
     this.pilotos[i] = null;
     this.campeonatos[i] = null;
   }

 }
//Limpiar coche
  void clearCoche() {
    for (int i = 0; i < coches.length; i++) {
      this.coches[i] = null;
    }
  }
  //Limpiar piloto
  void clearPiloto() {
    for (int i = 0; i < pilotos.length; i++) {
      this.pilotos[i] = null;
    }
  }
  //Limpiar campeonato
  void clearCampeonato() {
    for (int i = 0; i < campeonatos.length; i++) {
      this.campeonatos[i] = null;
    }
  }
// Crear piloto junto con su coche
void Crear(String nom, int num) {

      if (getUltimaPosicionLibre() >= 0 && getUltimaPosicionLibre() < coches.length){
        if(existeCoche(nom)) System.out.println("Ya existe el piloto " + nom);
          else {
            this.coches[getUltimaPosicionLibre()] = new Coche(nom, num);
            this.pilotos[getUltimaPosicionLibre()] = new Piloto(nom);
            System.out.println("Piloto " + nom + " creado, junto con su coche "+ num );
          }
      }
    }

 // crear campeonato
 void CrearCampeonato(String cam, String gan, int coche) {

       if (getUltimaPosicionLibreCampeonato() >= 0 && getUltimaPosicionLibreCampeonato() < campeonatos.length){
         if(existeCampeonato(cam)) System.out.println("Ya existe el campeonato " + cam);
           else {
             if (getUltimaPosicionLibre() >= 0 && getUltimaPosicionLibre() < coches.length){
               if (existeCoche(gan)){}
                 else {
                   this.coches[getUltimaPosicionLibre()] = new Coche(gan, coche);
                   this.pilotos[getUltimaPosicionLibre()] = new Piloto(gan);
                 }
             this.campeonatos[getUltimaPosicionLibreCampeonato()] = new Campeonato(cam, gan);
             System.out.println("Campeonato " + cam + " creado, junto con su ganador "+ gan);
           }
       }
     }
   }

// borrar coche junto con su piloto

  void Borrar(String nom){
    BorrarPiloto(nom);
    BorrarCoche(nom);
  }

  void BorrarPiloto(String nom){
    for (int i = 0; i < pilotos.length; i++) {
      if (this.pilotos[i] instanceof Piloto) {
        if(nom.equals(this.pilotos[i].getNombre())) {
          this.pilotos[i] = null;
        }
      }
    }
  }
  void BorrarCoche(String tit){
    for (int i = 0; i < coches.length; i++) {
      if (this.coches[i] instanceof Coche) {
        if(tit.equals(this.coches[i].getTitular())) {
          this.coches[i] = null;
        }
      }
    }
  }

  void BuscarCampeonato(String camp){
  boolean existe=false;
  for (int i=0; i <campeonatos.length; i++){
    if (this.campeonatos[i] instanceof Campeonato){
      if (camp.equals(this.campeonatos[i].getCampeonato())){
        existe=true;
        System.out.println("Este campeonato "+campeonatos[i].getCampeonato() + " fue ganado por " +campeonatos[i].getGanador());
      }
    }
  } System.out.println(existe ? "" : "Este campeonato no existe");
}

void BuscarPiloto(String pi){
boolean existe=false;
for (int i=0; i <coches.length; i++){
  if (this.coches[i] instanceof Coche){
    if (pi.equals(this.coches[i].getTitular())){
      existe=true;
      System.out.println("Este piloto "+coches[i].getTitular() + " tiene el coche " +coches[i].getNumero());
    }
  }
} System.out.println(existe ? "" : "Este piloto no existe");
}



// lee el fichero y carga lo que tiene dentro, lo carga dentro de las arrays o vectores
  void cargarDatosCoche(File f) throws IOException {

    clearCoche();

      BufferedReader inputStream = new BufferedReader(new FileReader(f));
      String line;
      int i = 0;
      while((line = inputStream.readLine()) != null) {
        //todas las palabras que encuentre se separaran por dos puntos
            String[] values = line.split(":");


            // Creamos el Dato con los valores que hemos leído
            Coche c = new Coche(values[0], Integer.parseInt(values[1]));
            this.coches[i] = c;
            i++;
      }

      inputStream.close();

    }
    void cargarDatosPiloto(File f) throws IOException {

      clearPiloto();

        BufferedReader inputStream = new BufferedReader(new FileReader(f));
        String line;
        int i = 0;
        while((line = inputStream.readLine()) != null) {
          //todas las palabras que encuentre se separaran por dos puntos
              String values = line;


              // Creamos el Dato con los valores que hemos leído
              Piloto p = new Piloto(values);
              this.pilotos[i] = p;
              i++;
        }

        inputStream.close();

      }

      // lee el fichero y carga lo que tiene dentro, lo carga dentro de las arrays o vectores
        void cargarDatosCampeonato(File f) throws IOException {

          clearCampeonato();

            BufferedReader inputStream = new BufferedReader(new FileReader(f));
            String line;
            int i = 0;
            while((line = inputStream.readLine()) != null) {
              //todas las palabras que encuentre se separaran por dos puntos
                  String[] values = line.split(":");


                  // Creamos el Dato con los valores que hemos leído
                  Campeonato c = new Campeonato(values[0], values[1]);
                  this.campeonatos[i] = c;
                  i++;
            }

            inputStream.close();

          }


 //guardar todo
  void Guardar(File pi, File co, File ca) throws IOException {
    guardarDatosCoches(co);
    guardarDatosPiloto(pi);
    guardarDatosCampeonato(ca);
  }

          //Guardar los datos del coche en el fichero
          void guardarDatosCoches(File f) throws IOException {
            BufferedWriter outputStream = new BufferedWriter(new FileWriter(f, false));

            for(int i = 0; i < coches.length; i++){
              if(this.coches[i] instanceof Coche) {
                outputStream.write(coches[i].getTitular()+":"+coches[i].getNumero()+"\n");
              }
            }
          outputStream.close();
      }
  //Guardar los datos del piloto en el fichero

      void guardarDatosPiloto(File f) throws IOException {
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(f, false));

        for(int i = 0; i < pilotos.length; i++){
          if(this.pilotos[i] instanceof Piloto) {
            outputStream.write(pilotos[i].getNombre()+"\n");
          }
        }
      outputStream.close();
  }
  //Guardar los datos del campeonato en el fichero
  void guardarDatosCampeonato(File f) throws IOException {
    BufferedWriter outputStream = new BufferedWriter(new FileWriter(f, false));

    for(int i = 0; i < campeonatos.length; i++){
      if(this.campeonatos[i] instanceof Campeonato) {
        outputStream.write(campeonatos[i].getCampeonato()+":"+campeonatos[i].getGanador()+"\n");
      }
    }
  outputStream.close();
}

    void mostrarPiloto(){
      for (int i = 0; i< pilotos.length; i++){
    if (this.pilotos[i] instanceof Piloto){
     if(pilotos[i] != null) System.out.println(pilotos[i].getNombre());
    }
    }
}

  void mostrarCoche(){
    for (int i = 0; i< coches.length; i++){
  if (this.coches[i] instanceof Coche){
   if(coches[i] != null) System.out.println(coches[i].getTitular()+" "+coches[i].getNumero());
  }
  }
  }

  void mostrarCampeonato(){
    for (int i = 0; i< campeonatos.length; i++){
  if (this.campeonatos[i] instanceof Campeonato){
   if(campeonatos[i] != null) System.out.println(campeonatos[i].getCampeonato()+" "+campeonatos[i].getGanador());
  }
  }
  }

  //buscar la ultima posi
  int getUltimaPosicionLibre() {
    for (int i = 0; i < coches.length; i++){
      if (coches[i] == null)
        return i;
    } return -1;
  }
  int getUltimaPosicionLibreCampeonato() {
    for (int i = 0; i < campeonatos.length; i++){
      if (campeonatos[i] == null)
        return i;
    } return -1;
  }

// mirar si existe un coche
  boolean existeCoche(String a) {

    for (int i = 0; i < coches.length; i++) {
      if (this.coches[i] instanceof Coche){
        if (a.equals(this.coches[i].getTitular())) return true;
      }
    }
    return false;
  }
  // mirar si existe un campeonato
    boolean existeCampeonato(String a) {

      for (int i = 0; i < campeonatos.length; i++) {
        if (this.campeonatos[i] instanceof Campeonato){
          if (a.equals(this.campeonatos[i].getCampeonato())) return true;
        }
      }
      return false;
    }




}
