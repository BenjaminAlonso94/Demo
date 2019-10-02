package excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

@RunWith(Parameterized.class)
public class MainExcel {
    private String a;
    private String b;
    private String aTimesB;
    private String another;

    @Parameterized.Parameters
    public static Collection spreadsheetData() throws IOException, InvalidFormatException {
        SpreadsheetData spreadsheetData = new SpreadsheetData(System.getProperty("user.dir") + "//data//data.xlsx");
        Collection<Object[]> object = spreadsheetData.getData();
        Iterator it = object.iterator();
        while (it.hasNext()) {
            System.out.println("Datos del collection " + it.next().toString());
        }
        return object;
    }

    public MainExcel(String a, String b, String aTimesB, String another) {
        super();
        this.a = a;
        this.b = b;
        this.aTimesB = aTimesB;
        this.another = another;
    }

    @Test
    public void shouldCalculat() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(aTimesB);
    }
}
