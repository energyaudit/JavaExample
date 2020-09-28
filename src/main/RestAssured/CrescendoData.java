package main.RestAssured;


import main.util.*;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;

public class CrescendoData  {

    @Test(priority=2)
    public void TestbodyURI3()

    {
        int l=20;

        ArrayList<String> list = new ArrayList<String>();
        for(int k=0;k<l;k++){
            //    String puri="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
            String puri="http://34.214.27.37/api/dice/3";
            RestAssuredGetResponseBody rty= new RestAssuredGetResponseBody();
            String jsonString=rty.inputpar(puri);
            Str2JsonFile sjf=new Str2JsonFile();
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
       //     sjf.inputStr(jsonString,"C:\\QA\\TESTRESULT\\temp.json");
            sjf.inputStr(jsonString,"/QA/TESTRESULT/temp2.json");

            GetDataJPath gdj=new GetDataJPath();
            String  result=gdj.inputpar(puri,"value" );

            list.add(result);

            OutPutResult outR = new OutPutResult();
            outR.inputStr(" API test data BODY URI1 success result is:"+jsonString+result);
        }
        CountListFreq clf=new CountListFreq();
        Map outMp=clf.countFrequencies(list);

    }
     @Test(priority=1)
    public void TestbodyURI2()

    {
        int l=20;

        ArrayList<String> list = new ArrayList<String>();
        for(int k=0;k<l;k++){
            //    String puri="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
            String puri="http://34.214.27.37/api/dice/2";
            RestAssuredGetResponseBody rty= new RestAssuredGetResponseBody();
            String jsonString=rty.inputpar(puri);
            Str2JsonFile sjf=new Str2JsonFile();
            sjf.inputStr(jsonString,"/QA/TESTRESULT/temp2.json");

            GetDataJPath gdj=new GetDataJPath();
            String  result=gdj.inputpar(puri,"value" );

            list.add(result);

            OutPutResult outR = new OutPutResult();
            outR.inputStr(" API test data BODY URI1 success result is:"+jsonString+result);
        }
        CountListFreq clf=new CountListFreq();
        Map outMp=clf.countFrequencies(list);

    }
    @Test
    public void TestbodyURI1()

    {
        int l=20;

        ArrayList<String> list = new ArrayList<String>();
        for(int k=0;k<l;k++){
            //    String puri="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
            String puri="http://34.214.27.37/api/dice/1";
            RestAssuredGetResponseBody rty= new RestAssuredGetResponseBody();
            String jsonString=rty.inputpar(puri);
            Str2JsonFile sjf=new Str2JsonFile();
            sjf.inputStr(jsonString,"/QA/TESTRESULT/temp2.json");

            GetDataJPath gdj=new GetDataJPath();
            String  result=gdj.inputpar(puri,"value" );

            list.add(result);

            OutPutResult outR = new OutPutResult();
            outR.inputStr(" API test data BODY URI1 success result is:"+jsonString+result);
        }
        CountListFreq clf=new CountListFreq();
        Map outMp=clf.countFrequencies(list);

    }




}
