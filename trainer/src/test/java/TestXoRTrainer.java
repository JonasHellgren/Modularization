import org.junit.Assert;
import org.junit.Test;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import trainer.XoRTrainer;
import training_data.XoRDataSetProvider;

public class TestXoRTrainer {
    public static final double DELTA = 0.1;
    XoRTrainer trainer;

    @Test
    public void testXoR() {
        NeuralNetwork ann=new MultiLayerPerceptron(2, 10, 1);
        DataSet trainingSet = XoRDataSetProvider.provideXoR();
        trainer=new XoRTrainer(ann,trainingSet);
        trainer.train();
        trainer.printOutPuts();
        assertOutPuts();
    }

    private void assertOutPuts() {
        Assert.assertEquals(1 ^ 0, trainer.getNetworkOutput01()[0], DELTA);  //0
        Assert.assertEquals(0 ^ 1, trainer.getNetworkOutput01()[0], DELTA);  //1
        Assert.assertEquals(1 ^ 1, trainer.getNetworkOutput11()[0], DELTA);  //1
        Assert.assertEquals(0 ^ 0, trainer.getNetworkOutput00()[0], DELTA);  //0
    }

}
