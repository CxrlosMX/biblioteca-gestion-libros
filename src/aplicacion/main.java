/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import biblioteca_.ControlBiblioteca;
import claseLibro.Libro;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 24/07/2021
 *
 */
public class main {
    
    public static void main(String[] args) {
        ControlBiblioteca control = new ControlBiblioteca();
        Libro l1 = new Libro("El perfume", "Gabriel", 2);
        Libro l2 = new Libro("El Agua", "Jose Marquez", 3);
        Libro l3 = new Libro("Domm", "Leo Ortiz", 2);
           Libro l4 = new Libro("Dark", "Sayu Mars", 1);
        control.addLibro(l1);
        control.addLibro(l2);
         control.addLibro(l3);
         control.addLibro(l4);

        //Mostramos libros de la biblioteca
        control.mostrarBiblioteca();
        control.prestarLibro(l1.getIsbn());
        control.prestarLibro(l1.getIsbn());
        control.prestarLibro(l1.getIsbn());
        control.prestarLibro(l2.getIsbn());
        control.prestarLibro(l2.getIsbn());
        control.prestarLibro(l2.getIsbn());
         control.prestarLibro(l2.getIsbn());
         control.prestarLibro(l3.getIsbn());
         control.prestarLibro(l3.getIsbn());
           control.prestarLibro(l4.getIsbn());
         System.out.println("");
        control.mostrarLibrosPrestados();
          System.out.println("");
        control.mostrarBiblioteca();
         control.reponerLibro(l3.getIsbn());
         control.reponerLibro(l3.getIsbn());
           System.out.println("");
        control.mostrarLibrosPrestados();
          System.out.println("");
        control.mostrarBiblioteca();
       /* //prestamos un libro
        control.prestarLibro(l1.getIsbn());
        control.prestarLibro(l1.getIsbn());
        System.out.println("");
        control.mostrarLibrosPrestados();
        System.out.println("");
        control.mostrarBiblioteca();
        control.reponerLibro(l1.getIsbn());
         System.out.println("");
        control.mostrarBiblioteca();
        
        System.out.println("");
        control.mostrarLibrosPrestados();
        control.reponerLibro(l1.getIsbn());
         System.out.println("");
        control.mostrarLibrosPrestados();
       */
        /*   //Mostrar Libros
         control.mostrarBiblioteca();

         //Reponer Libro
         control.reponerLibro(l1.getIsbn());

         //Mostrar Libros
         control.mostrarBiblioteca();

         control.mostrarLibrosPrestados();*/
        
    }
    
}
