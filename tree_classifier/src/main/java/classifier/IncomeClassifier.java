package classifier;

import weka.classifiers.trees.J48;
import weka.core.*;

public class IncomeClassifier {

    public static final int NUM_ATTRIBUTES = 5;

    Instances trainingData;
    String[] options;

    public IncomeClassifier(Instances trainingData, String[] options) {
        this.trainingData = trainingData;
        this.options = options;
    }

    public  J48 trainTree() {
        J48 id3tree = new J48();

        try {
            id3tree.setOptions(options);
            trainingData.setClassIndex(trainingData.numAttributes()-1);
            id3tree.buildClassifier(trainingData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id3tree;
    }

    public Instance createInstance(int a, String ed, String st, String occup, String categ) {
        Instance i1 = new DenseInstance(NUM_ATTRIBUTES);

        Attribute age=trainingData.attribute(0);
        Attribute education=trainingData.attribute(1);
        Attribute status=trainingData.attribute(2);
        Attribute occupation=trainingData.attribute(3);
        Attribute incomeCategory=trainingData.attribute(4);

        i1.setValue(age, a);
        i1.setValue(education, ed);
        i1.setValue(status, st);
        i1.setValue(occupation, occup);
        i1.setValue(incomeCategory, categ);
        return i1;
    }
}
