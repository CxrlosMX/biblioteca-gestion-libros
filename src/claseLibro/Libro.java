/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseLibro;

import metodos.Metodos;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 23/07/2021
 *
 */
public class Libro implements Metodos {

    private static int idSiguiente = 1;

    //Atributos 
    private String nombre;
    private String autor;
    //El valor ISBN se creara automaticamente
    private String isbn;
    private int cantidad;
    private int id;

    public Libro(String nombre, String autor, int cantidad) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidad = cantidad;
        this.id = idSiguiente++;
        this.isbn = generarIsbn();
    }
    //Metodo que nos devuelve una cadena y esa cadena sera el ISBN
    private String generarIsbn() {
        String cadena = "";
        char a;
        int n;
        for (int i = 0; i < 3; i++) {
            n = Metodos.numAleatorio(2, 1);

            if (n == 1) { //Si el numero generado es 1 nos iremos a crear una letra 
                n = Metodos.numAleatorio(90, 65);
                a = (char) n;
                cadena += a;
            } else {
                n = Metodos.numAleatorio(57, 48);
                a = (char) n;
                cadena += a;
            }
        }
        return cadena;
    }
    
    //Metodos Get y Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //Metodo para imprimir los datos

    @Override
    public String toString() {
        return  "\nID: " + id  + "\nNombre: " + nombre + "\nAutor: " + autor + "\nISBN: " + isbn + "\nCantidad: " + cantidad ;
    }
    

}
