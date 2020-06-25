package com.tokenitos;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class LeerPrecios {


    public static void leerEImprimir(File archivo) throws IOException {

        Gson gson = new Gson();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(archivo));

        String texto = "";
        String fichero = "";


        while ((texto=br.readLine())!= null) {


            fichero += texto;

        }


        final Type tipoListaEmpleados = new TypeToken<List<Valor>>(){}.getType();
        final List<Valor> preciosasdas = gson.fromJson(fichero, tipoListaEmpleados);


        System.out.println(preciosasdas);






    }
}
