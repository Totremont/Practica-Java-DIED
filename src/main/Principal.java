package main;

import clases.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Pais pais1 = new Pais("Argentina");
        Pais pais2 = new Pais("Chile");

        Provincia prov1 = new Provincia("Santa Fe",pais1);
        Provincia prov2 = new Provincia("Buenos Aires",pais1);
        Provincia prov3 = new Provincia("Santiago de Chile",pais2);

        Localidad local1 = new Localidad("Santo Tome",prov1);
        Localidad local2 = new Localidad("Campana",prov2);
        Localidad local3 = new Localidad("Arenas",prov3);


        Responsable res1 = new Responsable("Ezequiel",local1,"Ucrania");
        Responsable res2 = new Responsable("Carlos",local1,"Rusia");
        Responsable res3 = new Responsable("Marta",local2,"Gas");
        Responsable res4 = new Responsable("Monica",local3,"Europa");

        ArrayList<Responsable> responsables = new ArrayList<Responsable>()
        {
            {
                add(res1);
                add(res2);
                add(res3);
                add(res4);
            }
        };

        Bien bien1 = new Bien("Samsung Galaxy A52","Aceptable calidad/precio",55000d);
        Bien bien2 = new Bien("Cocucha","Coca Cola Zero Light sin Gas Vegana",100d);
        Bien bien3 = new Bien("Pc","gtx 3080, i9 9700k, 32 gb ram. fuera de stock",85000d);
        Bien bien4 = new Bien("Hola","Un Hola",4d);
        Bien bien5 = new Bien("Adios","Un Adios :(",4d);
        Bien bien6 = new Bien("Ferrero Rocher","50% Chocolate, 300% precio inflado",500d);

        ArrayList<Bien> bienes = new ArrayList<Bien>()
        {
            {
                add(bien1);
                add(bien2);
                add(bien3);
                add(bien4);
                add(bien5);
                add(bien6);
            }
        };

        Proveedor proveedor1 = new Proveedor("Ezequiel",local1,bienes);
        Proveedor proveedor2 = new Proveedor("Carlos",local1,bienes);
        Proveedor proveedor3 = new Proveedor("Marta",local2,bienes);
        Proveedor proveedor4 = new Proveedor("Monica",local3,bienes);

        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>()
        {
            {
                add(proveedor1);
                add(proveedor2);
                add(proveedor3);
                add(proveedor4);
            }
        };

        Empresa empresa = new Empresa(bienes,proveedores,responsables);
        //ArrayList<Bien> prueba = empresa.listarBienesByPrecioMayor(1000d);
        empresa.crearFactura(bienes,res1,proveedor1,LocalDate.of(2022,1,3));
        empresa.crearFactura(bienes.subList(0,3),res3,proveedor1,LocalDate.of(2022,1,5));
        empresa.crearFactura(bienes.subList(3,5),res1,proveedor2,LocalDate.of(2021,7,23));
        ArrayList<String> prueba = empresa.listarFactuadasPorProveedor(proveedor1);
        prueba.forEach(System.out::println);
        //ArrayList<Bien> prueba = empresa.listarBienesByLocalidad(local1);
        //for (Bien bien : prueba) System.out.println(bien.getAlias());


    }
}
