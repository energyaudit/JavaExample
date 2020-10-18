package main.util;
/**
 * Created by byang on 2017-06-28.
 */
import java.util.ArrayList;

public class subStrArrayList {

    public static ArrayList<String> subStrArrayListMN(ArrayList<String> listStr, Integer M,Integer N){
        ArrayList<String> listSubStr=new ArrayList<>();
        for(String str: listStr){
            listSubStr.add(str.substring(M,N));
        }
        for(String str: listSubStr){
            System.out.println(str);
        }
      return listSubStr;
    }

    public static void main(String[] args) {
        ArrayList<String> listStr= new ArrayList<>();
        listStr.add("9/2/2020");
        listStr.add("8/26/2020");
        listStr.add("9/2/2020");
        listStr.add("8/26/2020");
        listStr.add("9/7/2020");
        listStr.add("8/26/2020");
        subStrArrayListMN(listStr,0,1);
        subStrArrayListMN(listStr,0,3);
    }
    }



