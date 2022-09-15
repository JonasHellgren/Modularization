package trainer;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import training_data.XoRDataSetProvider;

import java.util.Arrays;

public class XoRTrainer {

    public static final double DELTA = 0.1;
    public static final double LEARNING_RATE = 0.1;
    NeuralNetwork ann;
    int inputSize = 2;
    int outputSize = 1;
    DataSet trainingSet;

    double[] networkOutput10;
    double[] networkOutput01;
    double[] networkOutput11;
    double[] networkOutput00;

    public XoRTrainer(NeuralNetwork ann, DataSet trainingSet) {
        this.ann = ann;
        this.trainingSet = trainingSet;
    }

    public void train() {


        BackPropagation backPropagation = new BackPropagation();
        backPropagation.setMaxIterations(30000);
        backPropagation.setMaxError(0.0001);
        backPropagation.setLearningRate(LEARNING_RATE);
        ann.learn(trainingSet, backPropagation);
        calcOutputs();

    }

    public void printOutPuts() {
        calcOutputs();
        System.out.println("networkOutput10 = " + Arrays.toString(networkOutput10));
        System.out.println("networkOutput01 = " + Arrays.toString(networkOutput01));
        System.out.println("networkOutput11 = " + Arrays.toString(networkOutput11));
        System.out.println("networkOutput00 = " + Arrays.toString(networkOutput00));
    }

    private void calcOutputs() {
        ann.setInput(1, 0);
        ann.calculate();
        networkOutput10 = Arrays.copyOf(ann.getOutput(), outputSize);
        ann.setInput(0, 1);
        ann.calculate();
        networkOutput01 = Arrays.copyOf(ann.getOutput(), outputSize);
        ann.setInput(1, 1);
        ann.calculate();
        networkOutput11 = Arrays.copyOf(ann.getOutput(), outputSize);
        ann.setInput(0, 0);
        ann.calculate();
        networkOutput00 = Arrays.copyOf(ann.getOutput(), outputSize);
    }


}
