package com.kjp.sampleapp;

import java.util.LinkedHashMap;

/**
 * Created by david on 16-04-01.
 */
public class DateCourseFactory {
    public static final int
            SHOP = 1,
            CAFE = 2,
            ENTERTAINMENT = 3,
            FOOD = 4;

    //TODO: make iconURL into HashMap to load specific image for each course item
    public static final String[] iconURL =
            new String[]{"http://i.imgur.com/u56Pzpo.png", //shop
                    "http://i.imgur.com/WhAlsun.png", //cafe
                    "http://i.imgur.com/xoXa1Sy.png", //entertainment
                    "http://i.imgur.com/IcL6ddC.png"}; //food

    public DateCourseFactory(){

    }

    public LinkedHashMap<Integer,String> getCourse(String dateName){
        LinkedHashMap<Integer,String> course_map = new LinkedHashMap<Integer, String>();
//        course_map.put("eaton", "http://i.imgur.com/v5atgRl.jpg");
//        url_maps.put("lawrence", "http://i.imgur.com/9FPlKfE.jpg");
    //    int[] courseArray;
        switch (dateName){
            case "eaton":
//                courseArray = new int[]{
//                        DateCourseFactory.SHOP, //eaton
//                        DateCourseFactory.CAFE, //tsujiri
//                        DateCourseFactory.ENTERTAINMENT, //trapped
//                        DateCourseFactory.FOOD}; //don don izakaya
                course_map.put( DateCourseFactory.SHOP, "Eaton Center");
                course_map.put( DateCourseFactory.FOOD, "Don Don Izakaya");
                course_map.put( DateCourseFactory.CAFE, "Tsujiri");
                course_map.put( DateCourseFactory.ENTERTAINMENT, "Trapped");

                break;
            case "lawrence":
//                courseArray = new int[]{
//                        DateCourseFactory.ENTERTAINMENT, //st.lawrence market
//                        DateCourseFactory.FOOD,//Buster's Sea Cove
//                        DateCourseFactory.CAFE}; //Cresta
                course_map.put( DateCourseFactory.ENTERTAINMENT, "St.Lawrence Market");
                course_map.put( DateCourseFactory.FOOD, "Buster's Sea Cove");
                course_map.put( DateCourseFactory.CAFE, "Cresta");

                break;
            default:
               // courseArray = new int[0];
        }

        return course_map;
    }
}
