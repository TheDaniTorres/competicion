import java.util.Scanner;
import java.io.*;

class Menu {

        Scanner in = new Scanner(System.in);
        File pi = new File("pilotos.data");
        File co = new File("coches.data");
        File ca = new File("campeonatos.data");
        Dato c= new Dato();

        Menu()  throws IOException {
        c.cargarDatosCoche(co);
        c.cargarDatosPiloto(pi);
        c.cargarDatosCampeonato(ca);
      }


      //Menu principal

      void menuPrincipal() throws IOException{
        System.out.println("           BIENVENIDO       ");
        opcionPrincipal();
        int eleccion = in.nextInt();
        while (eleccion != 5){
          in.nextLine();
          switch (eleccion) {
            case 1:
              menuCrear();
            break;
            case 2:
              menuBorrar();
            break;
            case 3:
              menuMostrar();
            break;
            case 4:
              menuBuscar();
            break;

          }
          opcionPrincipal();
          eleccion = in.nextInt();
        }
      }

        private void opcionPrincipal(){
      System.out.println(" ----------------------------------------");
      System.out.println(" ");
      System.out.println("1.Crear campeonato o piloto");
      System.out.println("2.Borrar coche o piloto");
      System.out.println("3.Mostrar campeonato o piloto");
      System.out.println("4.Buscar campeonato o piloto");
      System.out.println("5.Salir");
      System.out.print("Seleccione que quiere hacer: ");
    }

    private void opcionesCrear(){
     System.out.println("   ------------------------   ");
     System.out.println(" ");
     System.out.println("Crear:");
     System.out.println("1.Campeonato");
     System.out.println("2.Piloto");
     System.out.println("3.Atras");
     System.out.print("Seleccione que quiere hacer: ");

   }

   private void opcionesBorrar(){
    System.out.println("   ------------------------   ");
    System.out.println(" ");
    System.out.println("Borrar:");
    System.out.println("1.Coche");
    System.out.println("2.Piloto");
    System.out.println("3.Atras");
    System.out.print("Seleccione que quiere hacer: ");

  }

  private void opcionesMostrar(){
   System.out.println("   ------------------------   ");
   System.out.println(" ");
   System.out.println("Mostrar:");
   System.out.println("1.Campeonato");
   System.out.println("2.Piloto");
   System.out.println("3.Atras");
   System.out.print("Seleccione que quiere hacer: ");

 }

 private void opcionesBuscar(){
  System.out.println("   ------------------------   ");
  System.out.println(" ");
  System.out.println("Buscar:");
  System.out.println("1.Campeonato");
  System.out.println("2.Piloto");
  System.out.println("3.Atras");
  System.out.print("Seleccione que quiere hacer: ");

}

void menuCrear()  throws IOException{

         opcionesCrear();


         int eleccion = in.nextInt();
         while (eleccion != 3){
           in.nextLine();
           switch (eleccion) {
             case 1:
               System.out.println("");
               System.out.println("-----------------------------------");
               System.out.println("Crear Campeonato");
               System.out.println(" ");
               crearC();
               c.guardarDatosCampeonato(ca);
               c.guardarDatosCoches(co);
               c.guardarDatosPiloto(pi);
               System.out.println("");
               break;
             case 2:
             System.out.println("");
             System.out.println("-----------------------------------");
             System.out.println("Crear Piloto");
             System.out.println(" ");
             crearP();
             c.guardarDatosCoches(co);
             c.guardarDatosPiloto(pi);
             System.out.println("");
             break;
             case 3:
               menuPrincipal();
             break;
           }
           opcionesCrear();
           eleccion = in.nextInt();
         }
       }


       void crearC(){
            System.out.print("Introduzca el nombre del campeonato: ");
            String nom = in.nextLine();

            System.out.print("Introduzca el nombre del ganador(piloto) del campeonato: ");
            String gan = in.nextLine();

            System.out.print("Introduzca el numero del coche del piloto: ");
            int num = in.nextInt();

            c.CrearCampeonato(nom, gan, num);
          }

          void crearP(){
               System.out.print("Introduzca el nombre del piloto: ");
               String nom = in.nextLine();

               System.out.print("Introduzca el numero del coche del piloto: ");
               int num = in.nextInt();

               c.Crear(nom, num);
             }

             void menuBorrar()  throws IOException{

                      opcionesBorrar();


                      int eleccion = in.nextInt();
                      while (eleccion != 3){
                        in.nextLine();
                        switch (eleccion) {
                          case 1:
                            System.out.println("");
                            System.out.println("-----------------------------------");
                            System.out.println("Borrar Coche");
                            System.out.println(" ");
                            borrarCP();
                            c.guardarDatosCoches(co);
                            c.guardarDatosPiloto(pi);
                            System.out.println("");
                            break;
                          case 2:
                          System.out.println("");
                          System.out.println("-----------------------------------");
                          System.out.println("Borrar Piloto");
                          System.out.println(" ");
                          borrarCP();
                          c.guardarDatosCoches(co);
                          c.guardarDatosPiloto(pi);
                          System.out.println("");
                          break;
                          case 3:
                            menuPrincipal();
                          break;
                        }
                        opcionesBorrar();
                        eleccion = in.nextInt();
                      }
                    }

             void borrarCP(){
               System.out.print("Introduzca el nombre del piloto: ");
               String nom = in.nextLine();
               c.Borrar(nom);
    }



               void menuMostrar()  throws IOException{

                        opcionesMostrar();


                        int eleccion = in.nextInt();
                        while (eleccion != 3){
                          in.nextLine();
                          switch (eleccion) {
                            case 1:
                              System.out.println("");
                              System.out.println("-----------------------------------");
                              System.out.println("Mostrar Campeonato");
                               System.out.println(" ");
                              c.mostrarCampeonato();
                              c.guardarDatosCoches(co);
                              c.guardarDatosPiloto(pi);
                              System.out.println("");
                              break;
                            case 2:
                            System.out.println("");
                            System.out.println("-----------------------------------");
                            System.out.println("Mostrar Piloto");
                                  System.out.println(" ");
                            c.mostrarCoche();
                            c.guardarDatosCoches(co);
                            c.guardarDatosPiloto(pi);
                            System.out.println("");
                            break;
                            case 3:
                              menuPrincipal();
                            break;
                          }
                          opcionesMostrar();
                          eleccion = in.nextInt();
                        }
                      }

              void menuBuscar()  throws IOException{

                               opcionesBuscar();


                               int eleccion = in.nextInt();
                               while (eleccion != 3){
                                 in.nextLine();
                                 switch (eleccion) {
                                   case 1:
                                     System.out.println("");
                                     System.out.println("-----------------------------------");
                                     System.out.println("Buscar Campeonato");
                                     System.out.println(" ");
                                      String busc = in.nextLine();
                                     c.BuscarCampeonato(busc);
                                     c.guardarDatosCoches(co);
                                     c.guardarDatosPiloto(pi);
                                     System.out.println("");
                                     break;
                                   case 2:
                                   System.out.println("");
                                   System.out.println("-----------------------------------");
                                   System.out.println("Buscar Piloto");
                                   System.out.println(" ");
                                      String pil = in.nextLine();
                                   c.BuscarPiloto(pil);
                                   c.guardarDatosCoches(co);
                                   c.guardarDatosPiloto(pi);
                                   System.out.println("");
                                   break;
                                   case 3:
                                     menuPrincipal();
                                   break;
                                 }
                                 opcionesBuscar();
                                 eleccion = in.nextInt();
                               }
                             }


      }
