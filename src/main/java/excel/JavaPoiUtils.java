package excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Utility class, where we will create methods for training read and write excel files,
 * with <a href="https://poi.apache.org/">Apache POI</a>, we use
 * <a href="https://poi.apache.org/spreadsheet/">POI-HSSF and POI-XSSF - Java API To Access Microsoft</a>
 * HSSF is the POI Project's pure Java implementation of the Excel '97(-2007) file.
 *
 * Clase de utilidades, donde crearemos métodos
 * para el aprendizaje de la lectura y escritura de ficheros excel con
 * <a href="https://poi.apache.org/">Apache POI</a>, usaremos
 * <a href="https://poi.apache.org/spreadsheet/">POI-HSSF and POI-XSSF - Java API To Access Microsoft</a>
 * HSSF es el proyecto POI de implementación total en Java para ficheros Excel '97(-2007).
 *
 * @author Xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org).
 */
public class JavaPoiUtils {

    /**
     * Explanation of the method by which we read the excel file we pass as
     * parameter if exists, and where we copy its content in a new excel spreadsheet
     * is also passed as a parameter.
     * Método con el que leemos el fichero excel que pasamos como
     * parámetro si existe y donde copiamos su contenido en una nueva hoja excel que
     * también se pasa como parámetro.
     * @param excelFile <code>String</code>
     *      excel File we are going to read.
     *      Fichero excel que vamos a leer.
     * @param excelNewFile <code>String</code>
     *      excel File we are going to write.
     *      Fichero excel en el que vamos a escribir.
     */
    public void readWriteExcelFile(File excelFile, File excelNewFile){
        InputStream excelStream = null;
        OutputStream excelNewOutputStream = null;
        try {
            excelStream = new FileInputStream(excelFile);
            excelNewOutputStream = new FileOutputStream(excelNewFile);
            // High level representation of a workbook.
            // Representación del más alto nivel de la hoja excel.
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(excelStream);
            XSSFWorkbook xssfWorkbookNew = new XSSFWorkbook();
            // We chose the sheet is passed as parameter.
            // Elegimos la hoja que se pasa por parámetro.
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            // We create the new sheet we are going to use.
            // Creamos la hoja nueva que vamos a utilizar.
            XSSFSheet xssfSheetNew = xssfWorkbookNew.createSheet("Copy-Copia");
            // An object that allows us to read a row of the excel sheet, and extract from it the cell contents.
            // Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
            XSSFRow xssfRow;
            XSSFRow xssfRowNew;
            // Initialize the object to read the value of the cell
            // Inicializo el objeto que leerá el valor de la celda
            XSSFCell cellNew;
            // I get the number of rows occupied on the sheet
            // Obtengo el número de filas ocupadas en la hoja
            int rows = xssfSheet.getLastRowNum();
            String cellValue;

            // Creating title row (creando unas filas con título)

            // ENGLISH TITLE (Titulo en inglés)
            xssfRowNew = xssfSheetNew.createRow(1);
            cellNew = xssfRowNew.createCell(1);
            cellNew.setCellType(CellType.STRING);
            cellNew.setCellValue("THIS IS A COPY");
            // SPANISH TITLE (Título en español)
            xssfRowNew = xssfSheetNew.createRow(3);
            cellNew = xssfRowNew.createCell(1);
            cellNew.setCellType(CellType.STRING);
            cellNew.setCellValue("ESTO ES UNA COPIA");
            // For this example we'll loop through the rows getting all the cells to copy them in the new sheet.
            // Para este ejemplo vamos a recorrer todas las filas para obtener todas las celdas y copiarlas en la nueva hoja.
            for (int r = 0; r < rows; r++) { xssfRow = xssfSheet.getRow(r); if (xssfRow == null){ break; }else{ System.out.print("Row: " + r + " -> ");
                // Creamos la columna en la nueva excel
                xssfRowNew = xssfSheetNew.createRow(r + 10);
                for (int c = 0; c < xssfRow.getLastCellNum(); c++) {
                        /*
                            We have those cell types (tenemos estos tipos de celda):
                                CELL_TYPE_BLANK, CELL_TYPE_NUMERIC, CELL_TYPE_BLANK, CELL_TYPE_FORMULA, CELL_TYPE_BOOLEAN, CELL_TYPE_ERROR
                        */
                    cellValue = xssfRow.getCell(c) == null?"":
                            (xssfRow.getCell(c).getCellType() == CellType.STRING)?xssfRow.getCell(c).getStringCellValue():
                                    (xssfRow.getCell(c).getCellType() == CellType.NUMERIC)?"" + xssfRow.getCell(c).getNumericCellValue():
                                            (xssfRow.getCell(c).getCellType() == CellType.BOOLEAN)?"" + xssfRow.getCell(c).getBooleanCellValue():
                                                    (xssfRow.getCell(c).getCellType() == CellType.BLANK)?"BLANK":
                                                            (xssfRow.getCell(c).getCellType() == CellType.FORMULA)?"FORMULA":
                                                                    (xssfRow.getCell(c).getCellType() == CellType.ERROR)?"ERROR":"";
                    System.out.print("[Column " + c + ": " + cellValue + "] ");
                    cellNew = xssfRowNew.createCell(c);
                    cellNew.setCellType(CellType.STRING);
                    cellNew.setCellValue(cellValue);
                }
                System.out.println();
            }
            }
            xssfWorkbookNew.write(excelNewOutputStream);
            excelNewOutputStream.close();
            System.out.println("Your excel file has been generated!(¡Se ha generado tu hoja excel!");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
    }

    /**
     * Main method for the tests for the methods of the class <strong>Java
     * read excel</strong> and <strong>Java create excel</strong>
     * with <a href="https://poi.apache.org/">Apache POI</a>.
     *
     * Método main para las pruebas para los método de la clase,
     * pruebas de <strong>Java leer excel</strong> y  <strong>Java crear excel</strong>
     * con <a href="https://poi.apache.org/">Apache POI</a>.
     * @param args
     */
    public static void main(String[] args){
        JavaPoiUtils javaPoiUtils = new JavaPoiUtils();
        File excelFile = new File(System.getProperty("user.dir") + "//data//Insumos.xlsx");
        File newExcelFile = new File(System.getProperty("user.dir") + "//data//InsumosNew.xlsx");
        if (!newExcelFile.exists()){
            try {
                newExcelFile.createNewFile();
            } catch (IOException ioe) {
                System.out.println("(Error al crear el fichero nuevo)" + ioe);
            }
        }
        javaPoiUtils.readWriteExcelFile(excelFile, newExcelFile);
    }
}