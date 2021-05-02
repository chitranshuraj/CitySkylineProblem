/**
 *
 * @author Chitranshu Raj and Lavanya Khular
 */

import java.util.Random;
import java.util.Arrays;


public class Simulated {
    
    private static Random rand=new Random();
    private static int upper=1000;
        
    public static void Range10(){
        int[][] buildings_10 = new int[10][3];
        for(int i=0;i<10;i++){
            for(int j=0;j<3;j++){
                int random_int=rand.nextInt(upper);
                buildings_10[i][j]=random_int;
            }
            Arrays.sort(buildings_10[i]);
            //System.out.println(Arrays.toString(buildings_10[i]));
        }
        Algorithm a=new Algorithm();
        System.out.println(a.getskyline(buildings_10));
    }
    public static void Range100(){
        int[][] buildings_100=new int[100][3];
        for(int i=0;i<100;i++){
            for(int j=0;j<3;j++){
                int random_int=rand.nextInt(upper);
                buildings_100[i][j]=random_int;
            }
            Arrays.sort(buildings_100[i]);
            //System.out.println(Arrays.toString(buildings_100[i]));
        }
       Algorithm a=new Algorithm();
       System.out.println(a.getskyline(buildings_100));
    }
    public static void Range1000(){
        int[][] buildings_1000=new int[1000][3];
        for(int i=0;i<1000;i++){
            for(int j=0;j<3;j++){
                int random_int=rand.nextInt(upper);
                buildings_1000[i][j]=random_int;
            }
            Arrays.sort(buildings_1000[i]);
            //System.out.println(Arrays.toString(buildings_1000[i]));
        }
        Algorithm a=new Algorithm();
        System.out.println(a.getskyline(buildings_1000));
    }
    public static void Range10000(){
        int[][] buildings_10000=new int[10000][3];
        for(int i=0;i<10000;i++){
            for(int j=0;j<3;j++){
                int random_int=rand.nextInt(upper);
                buildings_10000[i][j]=random_int;
            }
            Arrays.sort(buildings_10000[i]);
            //System.out.println(Arrays.toString(buildings_10000[i]));
        }
        Algorithm a=new Algorithm();
        System.out.println(a.getskyline(buildings_10000));
    }
    public static void Range100000(){
        int[][] buildings_100000=new int[100000][3];
         for(int i=0;i<100000;i++){
            for(int j=0;j<3;j++){
                int random_int=rand.nextInt(upper);
                buildings_100000[i][j]=random_int;
            }
            Arrays.sort(buildings_100000[i]);
            //System.out.println(Arrays.toString(buildings_100000[i]));
        }
        Algorithm a=new Algorithm();
        System.out.println(a.getskyline(buildings_100000));
    }
    public static void main(String []args){
        
        long[] time=new long[5];
        
        long start = System.nanoTime();
        Range10();
        Long end=System.nanoTime();
        time[0]=end-start;
        
        start=System.nanoTime();
        Range100();
        end=System.nanoTime();
        time[1]=end-start;
        
        start=System.nanoTime();
        Range1000();
        end=System.nanoTime();
        time[2]=end-start;
        
        start=System.nanoTime();
        Range10000();
        end=System.nanoTime();
        time[3]=end-start;
        
        start=System.nanoTime();
        Range100000();
        end=System.nanoTime();
        time[4]=end-start;
        
        for(int k=0;k<time.length;k++){
            System.out.println("Range"+(k+1)+" :"+time[k]/1000000+"ms");
        }
    }
}
