package training_data;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

public class XoRDataSetProvider {

    public static  DataSet provideXoR() {

        DataSet trainingSet = new DataSet(2, 1);
        trainingSet.addRow(new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainingSet.addRow(new DataSetRow(new double[]{0, 1}, new double[]{1}));
        trainingSet.addRow(new DataSetRow(new double[]{1, 0}, new double[]{1}));
        trainingSet.addRow(new DataSetRow(new double[]{1, 1}, new double[]{0}));

        return trainingSet;

    }

}
