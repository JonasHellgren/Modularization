package training_data;

import lombok.Getter;
import org.neuroph.core.data.DataSet;
import org.neuroph.util.data.norm.MaxNormalizer;
import org.neuroph.util.data.norm.Normalizer;

@Getter
public class SwedishAutoInsuranceDataProvider {

    DataSet trainingSet;
    DataSet testSet;

    public SwedishAutoInsuranceDataProvider(int percentageTestSet) {
        createSets(percentageTestSet);
    }

    private void createSets(int percentageTestSet) {
        System.out.println("Creating training set...");
        String dataSetFileName = "data_sets/autodata.txt";
        int inputsCount = 1;
        int outputsCount = 1;

        // create training set from file
        DataSet dataSet = DataSet.createFromFile(dataSetFileName, inputsCount, outputsCount, ",", false);
        Normalizer norm = new MaxNormalizer();
        norm.normalize(dataSet);
        dataSet.shuffle();

        //dataSet.createTrainingAndTestSubsets()
        //   dataSet.
        //List<DataSet> subSets = dataSet.createTrainingAndTestSubsets(60, 40);
        DataSet[] subSets = dataSet.createTrainingAndTestSubsets(100-percentageTestSet, percentageTestSet);
        trainingSet = subSets[0];
        testSet = subSets[1];

    }

}
