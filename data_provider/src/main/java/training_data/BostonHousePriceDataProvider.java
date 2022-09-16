package training_data;

import lombok.Getter;
import org.neuroph.core.data.DataSet;
import org.neuroph.util.data.norm.MaxNormalizer;
import org.neuroph.util.data.norm.Normalizer;

@Getter
public class BostonHousePriceDataProvider {

    DataSet trainingSet;
    DataSet testSet;
    int inputsCount = 13;
    int outputsCount = 1;

    public BostonHousePriceDataProvider(int percentageTestSet) {
        createSets(percentageTestSet);
    }

    private void createSets(int percentageTestSet) {

        System.out.println("Creating training set...");
        // get path to training set
        String trainingSetFileName = "data_sets/bostonhouse.txt";


        // create training set from file
        DataSet dataSet = DataSet.createFromFile(trainingSetFileName, inputsCount, outputsCount, ",");
        Normalizer norm = new MaxNormalizer();
        norm.normalize(dataSet);
        dataSet.shuffle();

        DataSet[] subSets = dataSet.createTrainingAndTestSubsets(100-percentageTestSet, percentageTestSet);
        trainingSet = subSets[0];
        testSet = subSets[1];

    }

}
