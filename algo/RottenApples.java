/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class RottenApples {
  static List<String> LASTFresh;
  public static void main(String[] args) {
        LASTFresh = new ArrayList<>();
        int arr[][] = { {2, 1, 0, 2, 1, 0, 1}, 
                        {1, 0, 1, 2, 1, 0, 1}, 
                        {1, 0, 0, 2, 1, 0, 0}
                      }; 
        int R = arr.length;
        int C = arr[0].length;
        int ans = dayCount(arr, R, C); 

        System.out.println(ans);
  }
  
  public static int dayCount(int[][] arr, int R, int C){
      int day = 0;
      List<String> fresh = new ArrayList<>();
      List<String> rotten = new ArrayList<>();
    
      if(arr.length == 0) return day;
    
      for(int i=0; i<R; ++i){
        for(int j=0; j<C; ++j){
          if(arr[i][j] == 2){
            rotten.add(i+"-"+j);
          }else if(arr[i][j] == 1){
            fresh.add(i+"-"+j);
          }
        }
      }
    
      if(rotten.size() == 0) return day;
      // each     
      while(fresh.size() > 0){
          
          List<String> rot = new ArrayList<>();
          for(int s=0; s<rotten.size(); ++s){
            String r = rotten.get(s);
            
            String[] o = r.split("-");
            int i = Integer.valueOf(o[0]), j = Integer.valueOf(o[1]);
            traverseAndMark(arr, i, j, rot);
          }
        //rotten = new ArrayList<>();
        
        for(String r : rot){
          rotten.add(r);
          fresh.remove(r);
        }
        if(LASTFresh.size() == fresh.size()){
            return day;
          }
        day++;
        LASTFresh = new ArrayList<>(fresh);
        System.out.println(fresh);
      }
    return day;
  }
  
  public static void traverseAndMark(int[][] arr, int i, int j, List<String> rot){
      int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
      for(int[] d : dirs){
        int i1 = i+d[0],j1 = j+d[1];
        
        
        if( !(i1 < 0 || i1 > arr.length-1 || j1 <0 || j1 > arr[0].length-1) &&  arr[i1][j1] == 1){
          rot.add(i1+"-"+j1);
          arr[i1][j1] = 2;
        }
      }
  }
  
}



// Minimum time required to rot all apples ?

// Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
// 0: Empty cell
// 1: Cells have fresh apple
// 2: Cells have rotten apple

// on Day 1: It will rot all neighbour apples (up, down, left, right), same process continues next day..

// Determine what is the minimum time required so that all the apples become rotten. A rotten apple at index [i,j] can rot other fresh apple at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). 

  
  
//   while(fresh.length > 0){
//     if(lastFresh.length == fresh.length) return ;
    
//     rottenApples.foreach(markN)
//      []
      
    
//   }
