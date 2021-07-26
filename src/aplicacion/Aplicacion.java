/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import biblioteca_.ControlBiblioteca;
import claseLibro.Libro;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 25/07/2021
 *
 */
public class Aplicacion {

    public static void main(String[] args) {
        //Ménu Biblioteca
        int op = 0, op2 = 0;
        String isbn;
        //Creamos nuestra Lista
        ControlBiblioteca control = new ControlBiblioteca();

        //Creamos un Objeto de Tipo Libro
        Libro libro;

        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "   BIBLIOTECA TECNM\n"
                        + "1.-Registrar Libro\n"
                        + "2.-Registro Prestamos\n"
                        + "3.-Buscar Libro\n"
                        + "4.-Mostrar Biblioteca\n"
                        + "5.-Salir\n¿Que desea realzar?", "Menu Principal", 3));
                switch (op) {
                    case 1: {//Registrar Libro
                        libro = control.rellenar();
                        control.addLibro(libro);
                        break;
                    }
                    case 2: {//Ménu prestamo

                        break;
                    }
                    case 3: {//Realizar Busqueda
                        if (control.noEstaVacia()) {
                            isbn = JOptionPane.showInputDialog(null, "Introduce el ISBN", "Buscando", 1);
                            control.serchBook(isbn);
                        } else {
                            JOptionPane.showMessageDialog(null, "Biblioteca Vacia", "Lista Vacia", 1);
                        }

                        break;
                    }
                    case 4: {//Mostramos la biblioteca
                        if (control.noEstaVacia()) {
                            control.mostrarBiblioteca();
                        } else {
                            JOptionPane.showMessageDialog(null, "Biblioteca Vacia", "Lista Vacia", 1);
                        }

                        break;
                    }
                    case 5: {

                        break;
                    }
                    default: {

                        break;
                    }

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 1);
            }

        } while (op != 5);

    }

}
