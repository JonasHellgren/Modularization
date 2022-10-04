package training_data;

import java.util.ArrayList;
import java.util.Arrays;

import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.*;

public class IncomeDataProvider {


    public static final int NUM_ATTRIBUTES = 5;

    Instances trainingData;
    Attribute age;
    Attribute education;
    Attribute status;
    Attribute occupation;
    Attribute incomeCategory;

    public Instances getTrainingData() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        age = new Attribute("age");
        education = new Attribute("education", Arrays.asList("bachelor", "highSchool", "doctorate"));
        status = new Attribute("status", Arrays.asList("neverMarried", "married", "divorced"));
        occupation = new Attribute("occupation", Arrays.asList("transport", "pro", "agri", "army"));
        incomeCategory = new Attribute("incomeCategory", Arrays.asList("low", "medium", "high"));

        attributes.add(age);
        attributes.add(education);
        attributes.add(status);
        attributes.add(occupation);
        attributes.add(incomeCategory);

        trainingData = new Instances("whatever", attributes, 0);

        trainingData.add(createInstance(39, "bachelor", "neverMarried", "transport", "medium"));
        trainingData.add(createInstance(50, "bachelor", "married", "pro", "medium"));
        trainingData.add(createInstance(18, "highSchool", "neverMarried", "agri", "low"));
        trainingData.add(createInstance(28, "bachelor", "married", "pro", "medium"));
        trainingData.add(createInstance(37, "highSchool", "married", "agri", "medium"));
        trainingData.add(createInstance(24, "highSchool", "neverMarried", "army", "low"));
        trainingData.add(createInstance(52, "highSchool", "divorced", "transport", "medium"));
        trainingData.add(createInstance(40, "doctorate", "married", "pro", "high"));
        return trainingData;
    }

    Instance createInstance(int a, String ed, String st, String occup, String categ) {
        Instance i1 = new DenseInstance(NUM_ATTRIBUTES);
        i1.setValue(age, a);
        i1.setValue(education, ed);
        i1.setValue(status, st);
        i1.setValue(occupation, occup);
        i1.setValue(incomeCategory, categ);
        return i1;
    }

}
