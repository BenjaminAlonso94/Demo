package excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Spreadsheet {
    FileInputStream excelInputStream = null;
    OutputStream excelNewOutputStream = null;
    XSSFWorkbook workbook = null;
    XSSFSheet sheet = null;
    XSSFRow xssfRow = null;
    XSSFCell cellNew = null;
    int rows = 0;
    int cells = 0;
    final boolean flagNomCamp = false;

    public void setWorkbook(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public boolean isFlagNomCamp() {
        return flagNomCamp;
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setSheet(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public XSSFSheet getSheet() {
        return sheet;
    }

    public void setCellNew(XSSFCell cellNew) {
        this.cellNew = cellNew;
    }

    public void setXssfRow(XSSFRow xssfRow) {
        this.xssfRow = xssfRow;
    }

    public XSSFCell getCellNew() {
        return cellNew;
    }

    public XSSFRow getXssfRow() {
        return xssfRow;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }

    public void openExcel(String file) {
        try {
            excelInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(excelInputStream);
            sheet = workbook.getSheetAt(0);
            rows = sheet.getLastRowNum();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createRow() {
        xssfRow = sheet.createRow(rows + 1);
    }

    public void formatCell(CellType cellType, boolean data) {
        cells = xssfRow.getLastCellNum();
        if (cells < 0) {
            cells++;
        }
        cellNew = xssfRow.createCell(cells);
        cellNew.setCellType(cellType);
        cellNew.setCellValue(data);
    }

    public void formatCell(CellType cellType, String data) {
        cells = xssfRow.getLastCellNum();
        if (cells < 0) {
            cells++;
        }
        cellNew = xssfRow.createCell(cells);
        cellNew.setCellType(cellType);
        cellNew.setCellValue(data);
    }

    public void createCell(String data, boolean ban) {
        if (flagNomCamp == true) {
            if (ban == true) {
                formatCell(CellType.STRING, data);
            }
        } else if (flagNomCamp == false) {
            if (ban == false) {
                formatCell(CellType.STRING, data);
            }
        }
    }

    public void createCell(Number data, boolean ban) {
        if (flagNomCamp == true) {
            if (ban == true) {
                formatCell(CellType.NUMERIC, data.toString());
            }
        } else if (flagNomCamp == false) {
            if (ban == false) {
                formatCell(CellType.NUMERIC, data.toString());
            }
        }
    }

    public void createCell(boolean data, boolean ban) {
        if (flagNomCamp == true) {
            if (ban == true) {
                formatCell(CellType.BOOLEAN, data);
            }
        } else if (flagNomCamp == false) {
            if (ban == false) {
                formatCell(CellType.BOOLEAN, data);
            }
        }
    }

    public void closeExcel(String file) {
        try {
            excelNewOutputStream = new FileOutputStream(file);
            workbook.write(excelNewOutputStream);
            excelInputStream.close();
            excelNewOutputStream.close();
        } catch (Exception e) {
            System.out.println("Error al intentar cerrar el excel");
        }
    }
}
