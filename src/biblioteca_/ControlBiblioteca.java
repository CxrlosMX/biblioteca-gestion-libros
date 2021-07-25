/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca_;

import claseLibro.Libro;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 23/07/2021
 *
 */
public class ControlBiblioteca {

    //Crearemos un arrego de objetos de Tipo Libro
    private ArrayList<Libro> libros;
    private ArrayList<Libro> prestados;
    private int contador, contadorPrestados;

    public ControlBiblioteca() {
        libros = new ArrayList<Libro>();
        prestados = new ArrayList<Libro>();
        contador = -1;
        contadorPrestados = -1;

    }

    //Metodo para registrar un libro
    public void addLibro(Libro l) {
        libros.add(l);
        JOptionPane.showMessageDialog(null, "Libro Registrado!!!", "Registrado", 1);
        contador++;
    }

    //Metodo para dar de baja a un libro
    public void deleteBook(String isbn) {
        boolean encontrado = false;
        for (int i = 0; i < libros.size() && !encontrado; i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                JOptionPane.showMessageDialog(null, "Libro Eliminado: " + libros.get(i), "Eliminado", 1);
                libros.remove(i);
                contador--;
                encontrado = true;
            }

        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontro el Libro", "Error de Busqueda", 2);
        }
    }

    //Metodo para buscar un libro
    public void serchBook(String isbn) {
        boolean encontrado = false;
        for (int i = 0; i < libros.size() && !encontrado; i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                JOptionPane.showMessageDialog(null, libros.get(i), "Datos", 1);
                encontrado = true;
            }

        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontro el Libro", "Error de Busqueda", 2);
        }
    }

    //Método para prestar un libro
    public void prestarLibro(String isbn) {
        boolean encontrado = false;
        for (int i = 0; i < libros.size() && !encontrado; i++) {
            if (libros.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                //Primero verificamos que el ISBN sea igual al introducido y si es igual entocnes verificamos si la cantidad de ese  libro es >0
                if (libros.get(i).getCantidad() > 0) {
                    JOptionPane.showMessageDialog(null, "Libro: " + libros.get(i).getNombre() + " Prestado", "Libro Prestado", 1);
                    libros.get(i).setCantidad(libros.get(i).getCantidad() - 1);//Le restamos una cantidad a la lista
                    if (noEstaVaciaPrestados()) {
                        boolean fin = false;
                        for (int j = 0; j < prestados.size() && !fin; j++) {
                            if (prestados.get(j).getIsbn().equalsIgnoreCase(isbn)) {
                                prestados.get(j).setCantidad(prestados.get(j).getCantidad() + 1);
                                fin = true;
                                encontrado = true;
                            }
                            else if (!fin && ( j==prestados.size() - 1)) {
                                Libro l = new Libro(libros.get(i).getNombre(), libros.get(i).getAutor(), 1);
                                l.setIsbn(libros.get(i).getIsbn());
                                prestados.add(l);
                                contadorPrestados++;
                                encontrado = true;
                                fin=true;
                            }
                        }

                    } else {
                        Libro l = new Libro(libros.get(i).getNombre(), libros.get(i).getAutor(), 1);
                        l.setIsbn(libros.get(i).getIsbn());
                        prestados.add(l);
                        contadorPrestados++;
                        encontrado = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Libros Insuficientes:\n" + libros.get(i).getNombre(), "Insuficientes Piezas", 2);
                    encontrado = true;
                }
            }

        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Libro no encontrado", "Error de Busqueda", 1);
        }
    }

    //Método para reponer libro
    public void reponerLibro(String isbn) {
        boolean encontrado = false;
        for (int i = 0; i < libros.size() && !encontrado; i++) {
            if (libros.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                libros.get(i).setCantidad(libros.get(i).getCantidad() + 1);
                JOptionPane.showMessageDialog(null, "Libro Repuesto: \n" + libros.get(i).getNombre(), "Libro Repuesto", 1);
                boolean fin = false;
                for (int j = 0; j < prestados.size() && !fin; j++) {
                    if (prestados.get(j).getIsbn().equalsIgnoreCase(isbn)) {
                        prestados.get(j).setCantidad(prestados.get(j).getCantidad() - 1);
                        if (prestados.get(j).getCantidad() == 0) {
                            prestados.remove(j);
                        }
                        fin = true;
                        encontrado = true;
                    }
                }

            }

        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Ningun Libro Encontrado", "Error de Busqueda", 0);
        }
    }

    //Metodo para mostrar los libros de la biblioteca
    public void mostrarBiblioteca() {
        System.out.println("Biblioteca");
        for (Libro i : libros) {
            System.out.println(i);
        }
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros Prestados");
        for (Libro i : prestados) {
            
            System.out.println("ISBN: " + i.getIsbn() + "\nNombre: " + i.getNombre() + "\nAutor: " + i.getAutor() + "\nCantidad: " + i.getCantidad());
            System.out.println("");
        }
    }

    //Metodo que verifica si la lista no esta Vacia
    public boolean noEstaVacia() {
        return (contador != -1);
    }

    //Metodo que verifica si la lista no esta Vacia
    public boolean noEstaVaciaPrestados() {
        return (contadorPrestados != -1);
    }
}
