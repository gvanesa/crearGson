package com.tokenitos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;

public class LeerPrecios {


    public static Collection<Valor> leerEImprimir(File archivo) throws IOException {

        Gson gson = new Gson();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(archivo));

        String texto = "";
        String fichero = "";


        while ((texto=br.readLine())!= null) {


            fichero += texto;

        }


        final Type tipoListaEmpleados = new TypeToken<Collection<Valor>>(){}.getType();
        final Collection<Valor> preciosasdas = gson.fromJson(fichero, tipoListaEmpleados);


        return preciosasdas;






    }
}
