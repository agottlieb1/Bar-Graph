/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project1;
import processing.core.*;
/**
 *
 * @author agottlieb
 */
public class Main extends PApplet {
     @Override
    public void setup() {
        // Variables windowWidth and windowHeight convert the string inputs from
        // the args array and converts them in to an integer to create the size
        // of the graph.
        int windowWidth = Integer.parseInt(args[1]);
        int windowHeight = Integer.parseInt(args[2]);
        // windowWidth and windowHeight are used as the parameters for the size
        // function
        size (windowWidth,windowHeight);
        
        // The dataValues[] is used to store the indexes of the arg[] minus the
        // first 3 indexes which elements contain the project name, windowWidth
        // & windowHeight
        float dataValues[] = new float[args.length-3];
        // variable to store the largest data value
        float maxValue = 0;
        float normalizeValue [] = new float [dataValues.length];
       // This for loop converts the index elements in to floats
        for(int i =0;i<dataValues.length;i++){
            dataValues[i] = Float.parseFloat(args[3+i]);
        }
        //This for loop compares the elements in the dataValue array to max
        //value variable and stores the highest value in maxValue
        for(int i = 0; i <dataValues.length;i++){
            if (maxValue <= dataValues[i])
                  maxValue = dataValues[i];
        }
        // This for loop is used to normalize each element index in the
        // dataValue array

        for (int i= 0; i< dataValues.length;i++){
            normalizeValue [i] = dataValues [i]/maxValue;

        }

        float maxHeight = windowHeight - 20;
        float barWidth = (windowWidth/normalizeValue.length-
              (normalizeValue.length+1));
       // This for loop creates the rectangles and creates random colors for
        // each one
        for (int i = 0; i <normalizeValue.length;i++){
            float barHeight= (maxHeight * normalizeValue[i]);
            float y = maxHeight- barHeight + 20;
            float x = (5+i*barWidth)+(i+1)*5;
            fill(random(255),random(255),random(255));
            rect(x,y,barWidth,barHeight);
        }

        for(int i= 1; i<args.length; i++) {
           System.out.println(args[i]);
        }
    }
      public static void main (String[] args) {
          String tempArgs [] = new String [args.length +2];
          tempArgs[0]= "--present";
          tempArgs[1]= "project1.Main";
          for (int i = 2; i <tempArgs.length;i++)
              tempArgs[i]= args[i-2];

         PApplet.main(tempArgs);
     }
   
}



