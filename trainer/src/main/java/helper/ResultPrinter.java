package helper;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

import java.util.Arrays;

public class ResultPrinter {

    // Displays inputs, desired output (from dataset) and actual output (calculated by neural network) for every row from data set.
    public static  void printNetworkAndDesiredOutputForEveryDataRow(NeuralNetwork neuralNet, DataSet testSet) {

        System.out.println("Showing inputs, desired output and neural network output for every row in test set.");

        for (DataSetRow testSetRow : testSet.getRows()) {
            neuralNet.setInput(testSetRow.getInput());
            neuralNet.calculate();
            double[] networkOutput = neuralNet.getOutput();
            System.out.println("Output: " + networkOutput[0]+", Desired output" + Arrays.toString(testSetRow.getDesiredOutput()));

        }
    }
}
