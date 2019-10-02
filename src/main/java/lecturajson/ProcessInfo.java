package lecturajson;

import excel.Spreadsheet;
import gherkin.deps.com.google.gson.*;

import java.io.FileReader;

public class ProcessInfo extends Spreadsheet {
    final static String fileJson = System.getProperty("user.dir") + "//data//Json.txt";
    final static String fileInsumos = System.getProperty("user.dir") + "//data//Insumos.xlsx";

    public static void main(String args[]) {
        try {
            JsonParser parser = new JsonParser();
            ProcessInfo pInfo = new ProcessInfo();
            FileReader fr = new FileReader(fileJson);
            JsonElement datos = parser.parse(fr);
            pInfo.openExcel(fileInsumos);
            pInfo.createRow();
            pInfo.dumpJSONElement(datos);
            pInfo.closeExcel(fileInsumos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dumpJSONElement(JsonElement elemento) {
        if (elemento.isJsonObject()) {
            //System.out.println("Es objeto");
            JsonObject obj = elemento.getAsJsonObject();
            java.util.Set<java.util.Map.Entry<String, JsonElement>> entradas = obj.entrySet();
            java.util.Iterator<java.util.Map.Entry<String, JsonElement>> iter = entradas.iterator();
            while (iter.hasNext()) {
                java.util.Map.Entry<String, JsonElement> entrada = iter.next();
                if (!entrada.getKey().equals("RESPONSE")) {
                    createCell(entrada.getKey(), true);
                }
                //System.out.println("Clave: " + entrada.getKey());
                //System.out.println("Valor:");
                dumpJSONElement(entrada.getValue());
            }
        } else if (elemento.isJsonArray()) {
            JsonArray array = elemento.getAsJsonArray();
            //System.out.println("Es array. Numero de elementos: " + array.size());
            java.util.Iterator<JsonElement> iter = array.iterator();
            while (iter.hasNext()) {
                JsonElement entrada = iter.next();
                dumpJSONElement(entrada);
            }
        } else if (elemento.isJsonPrimitive()) {
            //System.out.println("Es primitiva");
            JsonPrimitive valor = elemento.getAsJsonPrimitive();
            if (valor.isBoolean()) {
                //System.out.println("Es booleano: " + valor.getAsBoolean());
                createCell(valor.getAsBoolean(), false);
            } else if (valor.isNumber()) {
                //System.out.println("Es numero: " + valor.getAsNumber());
                createCell(valor.getAsNumber(), false);
            } else if (valor.isString()) {
                //System.out.println("Es texto: " + valor.getAsString());
                createCell(valor.getAsString(), false);
            }
        } else if (elemento.isJsonNull()) {
            //System.out.println("Es NULL");
        } else {
            //System.out.println("Es otra cosa");
        }
    }
}
