package gfg_top20DP_InterviewQuestions;

import java.util.Arrays;
import java.util.Collections;

class Box implements Comparable<Box>{

       int height, length, width;

       int baseArea;

       public Box(int h,int d,int w) {

          height = h;
          length = d;
          width = w;
       }

       @Override
       public String toString() {
          return "[Box : " + height + ", " + length + ", " + width + "]";
       }

       //to sort the Box according the base area in desecding order
       @Override
       public int compareTo(Box o) {
          return o.baseArea - this.baseArea;
       }

}

public class _8_BoxStacking {

	public static void main(String[] args) {
		
		Integer[] test = {13, 7, 6, 45, 21, 9, 2, 100};

		//To get Descending Order
        Arrays.sort(test, Collections.reverseOrder());

        System.out.println("Modified test[] : " + Arrays.toString(test));

        Box boxes[] = new Box[4];

        boxes[0] = new Box(4, 6, 7);

        boxes[1] = new Box(1, 2, 3);

        boxes[2] = new Box(4, 5, 6);

        boxes[3] = new Box(10, 12, 32);

        System.out.println(maxStackHeight(boxes));

	}
	
	private static int maxStackHeight(Box boxes[]) {

        int n = boxes.length;

        if(n == 0)
           return 0;

        Box rotated[] = new Box[3*n];

        for(int i = 0;i < n;i++){

        	Box box = boxes[i];

        	rotated[3*i] = new Box(box.height, Math.max(box.width,box.length), Math.min(box.width,box.length));

        	rotated[3*i + 1] = new Box(box.width, Math.max(box.height,box.length), Math.min(box.height,box.length));
        	
        	rotated[3*i + 2] = new Box(box.length, Math.max(box.width,box.height), Math.min(box.width,box.height));

        }

        for(int i = 0; i < rotated.length; i++)
           rotated[i].baseArea = rotated[i].width * rotated[i].length;

        Arrays.sort(rotated);

        int tot = 3 * n;

        int msh[] = new int[tot];

        for(int i = 0; i < tot; i++){

        	msh[i] = 0;
        	
        	Box box = rotated[i];

        	int val = 0;

        	for(int j = 0; j < i; j++){
		
        		Box prevBox = rotated[j];
		
        		if(box.width < prevBox.width && box.length < prevBox.length){
		          val = Math.max(val, msh[j]);
		      }
		  }
		
		  msh[i] = val + box.height;

        }

        int max = -1;

        for(int i = 0; i < tot; i++){
        	max = Math.max(max, msh[i]);
        }

        return max;

	}

}
