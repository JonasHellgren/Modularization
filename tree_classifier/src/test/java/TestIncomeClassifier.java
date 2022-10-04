import classifier.IncomeClassifier;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import training_data.IncomeDataProvider;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

public class TestIncomeClassifier {

    public static final String DEFAULT_CATEGORY = "low";

    @Test
    public void showTrainingData() {
        Instances trainingData = getInstances();
        System.out.println("trainingData = " + trainingData);
    }


    @Test
    public void createTree() {
        Instances trainingData = getInstances();
        String[] options = new String[]{"-C", "0.50", "-M", "1"};
        IncomeClassifier classifier=new IncomeClassifier(trainingData,options);
        J48 tree = classifier.trainTree();
        System.out.println(tree);

        Assert.assertEquals(5,tree.measureNumLeaves(),0.01);
    }

    @SneakyThrows
    @Test
    public void valueOfSingleInstance() {
        Instances trainingData = getInstances();
        String[] options = new String[]{"-C", "0.50", "-M", "1"};
        IncomeClassifier classifier=new IncomeClassifier(trainingData,options);
        J48 tree = classifier.trainTree();
        Instance instance = classifier.createInstance(39, "bachelor", "neverMarried", "transport", DEFAULT_CATEGORY);
        instance.setDataset(trainingData);
        int result = (int) tree.classifyInstance(instance);
        Attribute incomeCategory=trainingData.attribute(4);
        String readableResult = incomeCategory.value(result);
        System.out.println("readableResult = " + readableResult);

        Assert.assertEquals("medium", readableResult);
    }

    private Instances getInstances() {
        IncomeDataProvider dataProvider = new IncomeDataProvider();
        return dataProvider.getTrainingData();
    }

}
