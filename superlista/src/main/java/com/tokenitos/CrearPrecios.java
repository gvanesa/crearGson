package com.tokenitos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.tokenitos.LeerPrecios.leerEImprimir;

public class CrearPrecios {

    static final String RUTA_PRECIO = "super34.json";
    static File archivoPrecio = new File(RUTA_PRECIO);

    public static void main(String[] args) throws IOException {


        Gson gson = new Gson();

        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoPrecio));

        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        Collection<Valor> lista = new ArrayList<>();

        lista.add(new Valor("caramelos", 10));
        lista.add(new Valor("chocolate", 5));
        lista.add(new Valor("papas", 1));
        lista.add(new Valor("batatas", 1));
        lista.add(new Valor("cebollas", 1));
        lista.add(new Valor("bananas", 1));


        final String representacionBonita = prettyGson.toJson(lista);


        Files.writeString(Paths.get(RUTA_PRECIO), representacionBonita);

        //  bw.write(representacionBonita);
        // bw.close();
        // final Type tipoListaEmpleados = new TypeToken<List<Valor>>(){}.getType();


        //Class<Valor[]> x = Valor[].class;
        //final Valor[] preciosasdas = gson.fromJson(representacionBonita, x);
        //lista = Arrays.asList(preciosasdas);
        System.out.println(leerEImprimir(archivoPrecio));


        lista = Collections.synchronizedCollection(gson.fromJson(representacionBonita, ArrayList.class));

        System.out.println(leerEImprimir(archivoPrecio));


    }
}