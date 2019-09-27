package excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MainExcel {

    private String a;
    private String b;
    private String aTimesB;

    @Parameterized.Parameters
    public static Collection spreadsheetData() throws IOException, InvalidFormatException {
        return new SpreadsheetData(System.getProperty("user.dir") + "//data//data.xlsx").getData();
    }

    public MainExcel(String a, String b, String aTimesB) {
        super();
        this.a = a;
        this.b = b;
        this.aTimesB = aTimesB;
    }

    @Test
    public void shouldCalculat() {
        System.out.println("jalou");
    }
}
