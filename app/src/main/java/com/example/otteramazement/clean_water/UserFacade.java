package com.example.otteramazement.clean_water;

import android.util.Log;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mary
 * Used to load and save Json for persistence
 */

public final class UserFacade {

    public final static String USER_JSON_FILE_NAME = "user.json";
    public final static String SOURCE_JSON_FILE_NAME = "source.json";
    public final static String PURITY_JSON_FILE_NAME = "purity.json";
    public final static String HISTORICAL_JSON_FILE_NAME = "historical.json";

    /**
     * Singleton pattern
     */
    private static final UserFacade instance = new UserFacade();


    /**
     * private constructor for facade pattern
     */
    private UserFacade() {
        //map = OurHashMap.userMap;
    }

    /**
     * Singleton pattern accessor for instance
     *
     *
     * @return the one and only one instance of this facade
     */
    public static UserFacade getInstance() { return instance; }

    /**
     * load the JSON
     * @param file the file to save
     */

    public void loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            Gson gson = new Gson();
            //Then we use the G son library to recreate the object references and links automatically
            if (file.getName().equals("user.json")) {
                Type hashType = new TypeToken<HashMap<String, UserProfile>>() {
                }.getType();
                OurHashMap.userMap = gson.fromJson(inString, hashType);
            } else if (file.getName().equals("source.json")) {
                Type listType = new TypeToken<List<WaterSourceReport>>() {
                }.getType();
                WaterReportList.waterSourceList = gson.fromJson(inString, listType);
            } else if (file.getName().equals("purity.json")) {
                Type listType = new TypeToken<List<PurityReport>>() {
                }.getType();
                WaterReportList.waterPurityList = gson.fromJson(inString, listType);
            } else if (file.getName().equals("historical.json")) {
                Type listType = new TypeToken<List<HistoricalReport>>() {
                }.getType();
                WaterReportList.historicalReportList = gson.fromJson(inString, listType);
            }
            input.close();
        } catch (IOException e) {
            Log.e("UserFacade", "Failed to open/read the buffered reader for json");
        }


    }

    /**
     * save the JSON
     * @param file the file to save
     */

    public void saveJson(File file ) {

        try {
            PrintWriter writer = new PrintWriter(file);
            /*

                G son, like object serialization will take a single object and save all the objects
                it refers to.  You can save everything by one reference, as long as it is the
                top-level reference.

             */
            Gson gson = new Gson();
            String outString = "";
            if (file.getName().equals("user.json")) {
                // convert our objects to a string for output
                outString = gson.toJson(OurHashMap.userMap);
            } else if (file.getName().equals("source.json")) {
                outString = gson.toJson(WaterReportList.waterSourceList);
            } else if (file.getName().equals("purity.json")) {
                outString = gson.toJson(WaterReportList.waterPurityList);
            } else if (file.getName().equals("historical.json")) {
                outString = gson.toJson(WaterReportList.historicalReportList);
            }
            Log.d("DEBUG", "JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("UserManagementFacade", "Failed to open json file for output");
        }

    }
}
