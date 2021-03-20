import static java.lang.System.out;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.clustering.*;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;
import net.sf.javaml.core.*;
import net.sf.javaml.distance.PearsonCorrelationCoefficient;
import net.sf.javaml.featureselection.scoring.GainRatio;
import net.sf.javaml.featureselection.subset.GreedyForwardSelection;
import net.sf.javaml.filter.normalize.NormalizeMidrange;

// Java Machine Learning Library (Java-ML)
// http://java-ml.sourceforge.net/

public class Main {

    public static void main(String[] args) {

        /* values of the attributes. */
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9 };

        /* Create and an Instance with the above values and its class label set to "positive" */
        Instance instance = new DenseInstance(values,"positive");
        out.println(instance);
        double d = instance.value(1);
        out.println(d);

        out.println("<------------------->");

        double[][] dane = {{ 4.7, 3.2, 1.3, 0.2 },
                { 5.0, 3.4, 1.5, 0.2 },
                { 5.7, 4.4, 1.5, 0.4 },
                { 5.1, 3.8, 1.5, 0.3 },
                { 5.0, 3.0, 1.6, 0.2 },
                { 7.0, 3.2, 4.7, 1.4 },
                { 6.7, 3.0, 5.0, 1.7 },
                { 5.6, 2.7, 4.2, 1.3 },
                { 5.7, 2.9, 4.2, 1.3 },
                { 6.7, 3.0, 5.2, 2.3 },
                { 6.2, 3.4, 5.4, 2.3 } };

        String[] klasy = {"Iris-setosa",
                    "Iris-setosa",
                    "Iris-setosa",
                    "Iris-setosa",
                    "Iris-setosa",
                    "Iris-versicolor",
                    "Iris-versicolor",
                    "Iris-versicolor",
                    "Iris-versicolor",
                    "Iris-virginica",
                    "Iris-virginica"};

        Dataset data = new DefaultDataset();
        for (int i = 0; i < dane.length; i++) {
            Instance tmpInstance = new DenseInstance(dane[i]);
            tmpInstance.setClassValue(klasy[i]);
            data.add(tmpInstance);
        }
        out.println(data);

        out.println("<------------------->");

        NormalizeMidrange nmr=new NormalizeMidrange(0.5,1);
        /* Instanciate new filter */
        nmr.build(data);
        out.println(data);
        /* Filter another instances */
        nmr.filter(data);
        out.println(data);


        out.println("<------------------->");
        /* We create a clustering algorithm, in this case the k-means
        * algorithm with 4 clusters. */
        Clusterer km = new KMeans(4);
        /* We cluster the data */
        Dataset[] clusters = km.cluster(data);
        /* Create a measure for the cluster quality */
        ClusterEvaluation sse = new SumOfSquaredErrors();
        /* Measure the quality of the clustering */
        double score=sse.score(clusters);
        out.println("Sum of squared errors: "+score);
        out.println("Clusters length: "+clusters.length);
        for(int i=1; i<clusters.length; i++){
            out.println(clusters[i]);
        }
        out.println();
        out.println("<------------------->");
        /* Create a feature scoring algorithm */
        GainRatio ga = new GainRatio();
        /* Apply the algorithm to the data set */
        ga.build(data);
        /* Print out the score of each attribute */
        for (int i = 0; i < ga.noAttributes(); i++)
            System.out.println("Score of attribute: "+ga.score(i));

        out.println("<------------------->");
        /* Construct a greedy forward subset selector */
        GreedyForwardSelection gfa = new GreedyForwardSelection(1, new PearsonCorrelationCoefficient());
        /* Apply the algorithm to the data set */
        gfa.build(data);
        /* Print out the attribute that has been selected */
        System.out.println("Selected attributes: "+gfa.selectedAttributes());

        out.println("<------------------->");
        /* Contruct a KNN classifier that uses 5 neighbors to make a
        *decision. */
        Classifier knn = new KNearestNeighbors(5);
        knn.buildClassifier(data);

        int correct = 0, wrong = 0;
        /* Classify all instances and check with the correct class values */
        for (Instance inst : data) {
            Object predictedClassValue = knn.classify(inst);
            Object realClassValue = inst.classValue();
            if (predictedClassValue.equals(realClassValue))
                correct++;
            else
                wrong++;
        }
        out.println("Correct: "+correct+" Wrong: "+wrong);
    }
}
