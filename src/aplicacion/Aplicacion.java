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
                        if (control.noEstaVacia()) {
                            do {
                                try {
                                    op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "    REGISTRO PRESTAMO\n"
                                            + "1.-Realizar Prestamo\n"
                                            + "2.-Reponer Libro\n"
                                            + "3.-Mostrar Libros Prestados\n"
                                            + "4.-Salir al Menu Principal\n"
                                            + "¿Qué deseá realizar?", "MENU PRESTAMO", 3));
                                    switch (op2) {
                                        case 1: {
                                            isbn = JOptionPane.showInputDialog(null, "Introduce el ISBN", "Prestando", 1);
                                            control.prestarLibro(isbn);
                                            break;
                                        }
                                        case 2: {
                                            isbn = JOptionPane.showInputDialog(null, "Introduce el ISBN", "Reponiendo", 1);
                                            control.reponerLibro(isbn);

                                            break;
                                        }
                                        case 3: {
                                            if (control.noEstaVaciaPrestados()) {
                                                control.mostrarLibrosPrestados();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Lista Prestamo Vacia", "Lista Vacia", 2);
                                            }

                                            break;
                                        }
                                        case 4: {
                                            JOptionPane.showMessageDialog(null, "Saliendo al Menu Principal", "Saliendo", 2);

                                            break;
                                        }
                                        default: {
                                            JOptionPane.showMessageDialog(null, "Introduce una opción valida", "Error de Opción", 0);

                                            break;
                                        }

                                    }

                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 1);

                                }

                            } while (op2 != 4);
                        } else {
                            JOptionPane.showMessageDialog(null, "Biblioteca Vacia", "Lista Vacia", 1);
                        }

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
                        JOptionPane.showMessageDialog(null, "Cerrando Programa", "Saliendo", 2);

                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce una opción valida", "Error de Opción", 0);

                        break;
                    }

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 1);
            }

        } while (op != 5);

    }

}
