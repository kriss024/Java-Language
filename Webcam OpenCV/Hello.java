import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;

class Hello {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat m = new Mat(2, 10, CvType.CV_8UC1, new Scalar(255));
        System.out.println("OpenCV Mat: " + m.dump());

    }

}