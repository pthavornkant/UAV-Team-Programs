/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uavstuff;

import org.opencv.core.*;
import org.opencv.*;
import org.opencv.highgui.*;
import com.atul.JavaOpenCV.Imshow;
import org.opencv.imgproc.Imgproc;
import java.lang.Byte;
//https://github.com/master-atul/ImShow-Java-OpenCV for JAR file


/**
 *
 * @author Patrick
 */
public class UAVStuff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                // TODO code application logic here
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
      Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
      System.out.println( "mat = " + mat.dump() );
      
      System.out.println(System.getProperty("user.dir")); 
      Mat vineyard;
      
      vineyard = Highgui.imread("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\UAVStuff\\src\\uavstuff\\" + "bigfield1.jpg");
      
      Imshow first = new Imshow("Really Goddamn Big");
      first.showImage(vineyard);
      
      Mat re_vin = new Mat();
      
      Size sz = new Size(400, 400);
      
      Imgproc.resize(vineyard, re_vin, sz);
      
      Mat gray_vin = new Mat();
      
      Imgproc.cvtColor(re_vin, gray_vin, Imgproc.COLOR_RGB2GRAY);
      
      //CODE STILL IN PROGRESS
      int size = (int) re_vin.total() * re_vin.channels();
      double[] buff = new double[size];
      
      Imshow nim = new Imshow("Original Vineyard");
      nim.showImage(re_vin);
      
      System.out.println("re_vin has " + re_vin.channels() + " channels.");
   
      double total_pix = re_vin.rows() * re_vin.cols();
      double modify_count = 0;
      
      System.out.println("Total Pixels: " + total_pix);
      
      for (int i = 0; i < re_vin.rows(); i++)
      {
          for (int j = 0; j < re_vin.cols(); j++)
          {
             double[] rgb_values = re_vin.get(i, j);
             double[] yellowfy = {0, 255, 255};
             double[] whiteify = {255, 255, 255};
             //System.out.println("RGB Values are the following. R: " + rgb_values[0] + " G: " + rgb_values[1] + " B: " + rgb_values[2]);
              if (rgb_values[0] > 100 && rgb_values[1] > 100 && rgb_values[2] > 100)
              {
                  re_vin.put(i, j, yellowfy);
                  modify_count++;
              }
              if (rgb_values[0] < 50 && rgb_values[1] < 50 && rgb_values[2] < 50)
              {
                  re_vin.put(i, j, whiteify);
              }
          }    
          //System.out.println("Still running at i = " + i);
      }
      
      System.out.println("Modify count = " + modify_count);
      
      System.out.println("Bad Crop Percentage is: " + ((modify_count/total_pix)*100) + "%.");
      
      for (int i = 0; i < vineyard.rows(); i++)
      {
          for (int j = 0; j < vineyard.cols(); j++)
          {
             double[] rgb_values = vineyard.get(i, j);
             double[] yellowfy = {0, 255, 255};
             double[] whiteify = {255, 255, 255};
             //System.out.println("RGB Values are the following. R: " + rgb_values[0] + " G: " + rgb_values[1] + " B: " + rgb_values[2]);
              if (rgb_values[0] > 100 && rgb_values[1] > 100 && rgb_values[2] > 100)
              {
                  vineyard.put(i, j, yellowfy);
              }
              if (rgb_values[0] < 50 && rgb_values[1] < 50 && rgb_values[2] < 50)
              {
                  vineyard.put(i, j, whiteify);
              }
          }    
          //System.out.println("Still running at i = " + i);
      }
      
      Imshow supabig = new Imshow("Really yellow");
      supabig.showImage(vineyard);
      //END CODE STILL IN PROGRESS
         
      Imshow im = new Imshow("Vineyard Result");
      im.showImage(re_vin);
    }}