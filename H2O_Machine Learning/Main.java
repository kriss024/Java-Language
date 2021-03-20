import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.prediction.BinomialModelPrediction;

public class Main {
    private static String modelClassName = "deeplearning";

    public static void main(String[] args) throws Exception {
        hex.genmodel.GenModel rawModel;
        rawModel = (hex.genmodel.GenModel) Class.forName(modelClassName).newInstance();
        EasyPredictModelWrapper model = new EasyPredictModelWrapper(rawModel);

        RowData row = new RowData();
        row.put("Magnitude", "1.6101");
        row.put("Depth", "5.0217");

        BinomialModelPrediction p = model.predictBinomial(row);
        System.out.println("Label is earthquake: " + p.label);
        System.out.print("Class probabilities: ");

        for (int i = 0; i < p.classProbabilities.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            String result = String.format("%.6f", p.classProbabilities[i]);
            System.out.print(result);
        }
        System.out.println("");

        //------------------------------------

        row.clear();
        row.put("Magnitude", "1.9791");
        row.put("Depth", "4.0371");

        p = model.predictBinomial(row);
        System.out.println("Label is earthquake: " + p.label);
        System.out.print("Class probabilities: ");

        for (int i = 0; i < p.classProbabilities.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            String result = String.format("%.6f", p.classProbabilities[i]);
            System.out.print(result);
        }
        System.out.println("");


    }
}