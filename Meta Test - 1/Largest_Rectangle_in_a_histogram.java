import java.util.ArrayList;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    //int largestRectangle(vector <int> &heights){
      int n = heights.size();
      if(n<=0){
        return 0;
      }
      int maxArea=0;
      for(int j=0; j<n; j++){
        int minVal=heights.get(j),maxVal=heights.get(j);
        for(int i=j-1;i>=0;i--){
          if(heights.get(i) < minVal){
            minVal = heights.get(i);
          }
          if(minVal*(j-i+1)>maxVal){
            maxVal = minVal*(j-i+1);
          }
        }
        if(maxVal>maxArea){
          maxArea=maxVal;
        }
      }
      return maxArea;
    }

  }
