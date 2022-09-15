import org.junit.Before;
import org.junit.Test;
import org.neuroph.core.data.DataSetRow;
import training_data.XoRDataSetProvider;

import java.util.Arrays;

public class TestXoRDataSetProvider {


    XoRDataSetProvider xoRDataSetProvider;

    @Before
    public void init() {

        xoRDataSetProvider=new XoRDataSetProvider();
    }

    @Test
    public void testXoRdata() {
        for (DataSetRow testSetRow : xoRDataSetProvider.provideXoR().getRows()) {
            System.out.println("testSetRow.getInput() = " + Arrays.toString(testSetRow.getInput()));
            System.out.println("DesiredOutput = " + Arrays.toString(testSetRow.getDesiredOutput()));
        }
    }

}
