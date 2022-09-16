package helper;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

import java.util.Arrays;

public class Evaluator {

    // Evaluates performance of neural network.
    // Contains calculation of Confusion matrix for classification tasks or Mean Ssquared Error and Mean Absolute Error for regression tasks.
    // Difference in binary and multi class classification are made when adding Evaluator (MultiClass or Binary).
    public static double calculateAverageError(NeuralNetwork neuralNet, DataSet dataSet) {

        double[] networkOutput=new double[dataSet.size()];
        double[] desiredOutput=new double[dataSet.size()];

        int idx=0;
        double[] patternError = new double[dataSet.getRows().size()];
        for (DataSetRow testSetRow : dataSet.getRows()) {
            neuralNet.setInput(testSetRow.getInput());
            neuralNet.calculate();
            networkOutput[idx]=neuralNet.getOutput()[0];
            desiredOutput[idx]=testSetRow.getDesiredOutput()[0];
            patternError[idx] = Math.abs(networkOutput[idx] - desiredOutput[idx]);
            idx++;
        }

        return Arrays.stream(patternError).average().orElse(Double.NaN);
    }


}
