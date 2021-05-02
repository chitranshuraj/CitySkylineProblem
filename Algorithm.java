
/**
 *
 * @author Chitranshu Raj
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Algorithm {
    public List<List<Integer>> getskyline(int[][] building_data){
        int size=building_data.length;
        List<List<Integer>> store_skyline= new ArrayList<List<Integer>>();
        if(size==0){
            return store_skyline;
        }
        if(size==1){
            int l1=building_data[0][0];
            int r1=building_data[0][2];
            int h=building_data[0][1];
            store_skyline.add(new ArrayList<Integer>(){{add(l1);add(h);}});
            store_skyline.add(new ArrayList<Integer>(){{add(r1);add(0);}});
            return store_skyline;
        }
        
        List<List<Integer>> leftskyline,rightskyline;
        leftskyline=getskyline(Arrays.copyOfRange(building_data,0,size/2));
        rightskyline=getskyline(Arrays.copyOfRange(building_data,size/2,size));
         
        return mergeSkyline(leftskyline,rightskyline);
            
    }
    
    private List mergeSkyline(List<List<Integer>> left_L,List<List<Integer>> right_L){
        int leftY=0;int rightY=0;
        List<List<Integer>> merged_list=new ArrayList<List<Integer>>();
        while(true){
            
            if(left_L.isEmpty()||right_L.isEmpty()){
                break;
            }
            
            List<Integer> temp_l=left_L.get(0);
            List<Integer> temp_r=right_L.get(0);

            List<Integer> merge_output=new ArrayList<Integer>(2);

            if(temp_l.get(0)<temp_r.get(0)){
                merge_output.add(temp_l.get(0));
                merge_output.add(temp_l.get(1));

                if(temp_l.get(1)<rightY){
                    merge_output.remove(1);
                    merge_output.add(rightY);
                }

                leftY=temp_l.get(1);
                left_L.remove(0);
            }

            else if(temp_r.get(0)<temp_l.get(0)){
                merge_output.add(temp_r.get(0));
                merge_output.add(temp_r.get(1));

                if(temp_r.get(1)<leftY){
                    merge_output.remove(1);
                    merge_output.add(leftY);
                }

                rightY=temp_r.get(1);
                right_L.remove(0);
            }

            else{
                merge_output.add(temp_r.get(0));
                if(temp_r.get(1)>temp_l.get(1)){
                    merge_output.add(temp_r.get(1));
                }
                else{
                    merge_output.add(temp_l.get(1));
                }

                rightY=temp_r.get(1);
                leftY=temp_l.get(1);
                right_L.remove(0);
                left_L.remove(0);
            }
            merged_list.add(merge_output);
        }
        
        if(left_L.isEmpty()){
            while(!right_L.isEmpty()){
                merged_list.add(right_L.remove(0));
            }
        }
        else{
            while(!left_L.isEmpty()){
                merged_list.add(left_L.remove(0));
            }
        }
        return removeRedundantSkyline(merged_list);
    }

    private List removeRedundantSkyline(List<List<Integer>> list){
        for(int i=0;i<list.size();i++){
            int height=list.get(i).get(1);
            int next=i+1;
            boolean dup_found=true;
            while(next<list.size() && dup_found){
                if(list.get(next).get(1)==height){
                    dup_found=true;
                    list.remove(next);
                }
                else{
                    dup_found=false;
                }
                next+=1;
            }
        }
        return list;
    }
    
}
