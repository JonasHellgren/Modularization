import org.junit.Test;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import trainer.XoRTrainer;
import training_data.XoRDataSetProvider;

public class TestXoRTrainer {

    @Test
    public void testXoR() {

        NeuralNetwork ann=new MultiLayerPerceptron(2, 10, 1);
        DataSet trainingSet = XoRDataSetProvider.provideXoR();

        XoRTrainer trainer=new XoRTrainer(ann,trainingSet);


        trainer.train();
        trainer.printOutPuts();

    }



}
