/**
 * Copyright 2013 Neuroph Project http://neuroph.sourceforge.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import helper.Evaluator;
import helper.ResultPrinter;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.core.learning.error.MeanSquaredError;
import org.neuroph.nnet.Adaline;
import org.neuroph.nnet.learning.LMS;
import org.neuroph.util.data.norm.MaxNormalizer;
import org.neuroph.util.data.norm.Normalizer;
import training_data.SwedishAutoInsuranceDataProvider;

/**
 *
 * @author Nevena Milenkovic
 */
/*
 INTRODUCTION TO THE PROBLEM AND DATA SET INFORMATION:

 1. Data set that will be used in this experiment: Swedish Auto Insurance Dataset
    The Swedish Auto Insurance Dataset involves predicting the total payment for all claims in thousands of Swedish Kronor, given the total number of claims.
    The original data set that will be used in this experiment can be found at link:
    https://www.math.muni.cz/~kolacek/docs/frvs/M7222/data/AutoInsurSweden.txt

2. Reference: Swedish Committee on Analysis of Risk Premium in Motor Insurance

3. Number of instances: 63

4. Number of Attributes: 2 (input is numerical, output is continuous)

5. Attribute Information:
   In the following data
   X = number of claims (numerical)
   Y = total payment for all the claims in thousands of Swedish Kronor (continuous) for geographical zones in Sweden.


6. Missing Values: none




 */
public class SwedishAutoInsurance implements LearningEventListener {

    public static final double LEARNING_RATE = 0.1;
    public static final int MAX_ITERATIONS = 10;
    public static final double MAX_ERROR = 0.00001;
    public static final int INPUT_NEURONS_COUNT = 1;
    public static final int PERCENTAGE_TEST_SET = 2;

    public static void main(String[] args) {
        (new SwedishAutoInsurance()).run();
    }

    public void run() {

        SwedishAutoInsuranceDataProvider dataProvider=new SwedishAutoInsuranceDataProvider(PERCENTAGE_TEST_SET);

        System.out.println("Creating neural network...");
        Adaline neuralNet = new Adaline(INPUT_NEURONS_COUNT);

        neuralNet.setLearningRule(new LMS());
        LMS learningRule = (LMS) neuralNet.getLearningRule();
        learningRule.addListener(this);
        learningRule.setLearningRate(LEARNING_RATE);
        learningRule.setMaxIterations(MAX_ITERATIONS);
        learningRule.setMaxError(MAX_ERROR);

        // train the network with training set
        System.out.println("Training network...");
        neuralNet.learn(dataProvider.getTrainingSet());
        System.out.println("Training completed.");
        System.out.println("Testing network...");

        System.out.println("Network performance on the test set");
        double avg= Evaluator.calculateAverageError(neuralNet, dataProvider.getTestSet());
        System.out.println("Avg error on test set is: " + avg);

        System.out.println("Saving network");
        // save neural network to file
        neuralNet.save("nn1.nnet");

        System.out.println("Done.");

        System.out.println();
        System.out.println("Network outputs for test set");
        ResultPrinter.printNetworkAndDesiredOutputForEveryDataRow(neuralNet, dataProvider.getTestSet());
    }


    @Override
    public void handleLearningEvent(LearningEvent event) {
        LMS bp = (LMS) event.getSource();
        System.out.println(bp.getCurrentIteration() + ". iteration | Total network error: " + bp.getTotalNetworkError());
    }

}
