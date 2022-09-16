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

import java.util.Arrays;

import helper.Evaluator;
import helper.ResultPrinter;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;
import org.neuroph.util.data.norm.MaxNormalizer;
import org.neuroph.util.data.norm.Normalizer;
import training_data.BostonHousePriceDataProvider;

/**
 *
 * @author Nevena Milenkovic
 */
/*
 INTRODUCTION TO THE PROBLEM AND DATA SET INFORMATION:

 1. Data set that will be used in this experiment: Boston House Price Dataset
    The Boston House Price Dataset involves the prediction of a house price in thousands of dollars given details of the house and its neighborhood.
    The original data set that will be used in this experiment can be found at link:
    https://raw.githubusercontent.com/jbrownlee/Datasets/master/housing.data

2. Reference:  U.S Census Service
   Harrison, D. and Rubinfeld, D.L. (1978) Hedonic prices and the demand for clean air. J. Environ. Economics and Management 5, 81–102.
   Belsley D.A., Kuh, E. and Welsch, R.E. (1980) Regression Diagnostics. Identifying Influential Data and Sources of Collinearity. New York: Wiley.

3. Number of instances: 506

4. Number of Attributes: 13 pluss class attributes (all are continuous values)

5. Attribute Information:
 Inputs:
 13 attributes:
 13 continuous features are computed for each house:
 1) CRIM: per capita crime rate by town.
 2) ZN: proportion of residential land zoned for lots over 25,000 sq.ft.
 3) INDUS: proportion of nonretail business acres per town.
 4) CHAS: Charles River dummy variable (= 1 if tract bounds river; 0 otherwise).
 5) NOX: nitric oxides concentration (parts per 10 million).
 6) RM: average number of rooms per dwelling.
 7) AGE: proportion of owner-occupied units built prior to 1940.
 8) DIS: weighted distances to five Boston employment centers.
 9)0 RAD: index of accessibility to radial highways.
 10) TAX: full-value property-tax rate per $10,000.
 11) PTRATIO: pupil-teacher ratio by town.
 12) B: 1000(Bk – 0.63)^2 where Bk is the proportion of blacks by town.
 13) LSTAT: % lower status of the population.

 14) Output: MEDV: Median value of owner-occupied homes in $1000s..

6. Missing Values: None.


 */
public class BostonHousePrice implements LearningEventListener {


    public static final int NOF_NEURONS_HIDDEN = 2;
    public static final double LEARNING_RATE = 0.1;
    public static final int MAX_ITERATIONS = 100;
    public static final double MAX_ERROR = 0.001;
    public static final int PERCENTAGE_TEST_SET = 2;

    public static void main(String[] args) {
        (new BostonHousePrice()).run();
    }

    public void run() {

        BostonHousePriceDataProvider dataProvider=new BostonHousePriceDataProvider(PERCENTAGE_TEST_SET);

        System.out.println("Creating neural network...");
        MultiLayerPerceptron neuralNet = new MultiLayerPerceptron(
                TransferFunctionType.TANH,
                dataProvider.getInputsCount(),
                NOF_NEURONS_HIDDEN,
                NOF_NEURONS_HIDDEN,
                dataProvider.getOutputsCount());

        neuralNet.setLearningRule(new MomentumBackpropagation());
        MomentumBackpropagation learningRule = (MomentumBackpropagation) neuralNet.getLearningRule();
       // learningRule.addListener(this);
        learningRule.setLearningRate(LEARNING_RATE);
        learningRule.setMaxIterations(MAX_ITERATIONS);
        learningRule.setMaxError(MAX_ERROR);

        System.out.println("Training network...");
        // train the network with training set
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
        MomentumBackpropagation bp = (MomentumBackpropagation) event.getSource();
        System.out.println(bp.getCurrentIteration() + ". iteration | Total network error: " + bp.getTotalNetworkError());
    }
}
