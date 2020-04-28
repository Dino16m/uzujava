package com.uzu.utils.auth.service;

import java.util.Map;

public class UzuJsonResponse {

    private  boolean status;
    private String error;

    private Map<String, ?> data;

    public static UzuJsonResponse ResponseOk()
    {
        UzuJsonResponse instance = getInstance();
        instance.status = true;
        return instance;
    }

    public  static UzuJsonResponse ResponseOk( Map<String, ?> data)
    {
        UzuJsonResponse instance = getInstance();
        instance.status = true;
        instance.data = data;
        return instance;
    }

    public static UzuJsonResponse ResponseError(String error)
    {
        UzuJsonResponse instance = getInstance();
        instance.status = false;
        instance.error = error;
        return instance;
    }

    public  static UzuJsonResponse ResponseError( Map<String, ?> errorMap)
    {
        UzuJsonResponse instance = getInstance();
        instance.status = false;
        instance.error = errorMap.toString();
        return instance;
    }

    private static UzuJsonResponse getInstance()
    {
        return new UzuJsonResponse();
    }

    private UzuJsonResponse() {}

    public boolean getStatus()
    {
        return status;
    }

    public String getError()
    {
        return error;
    }

    public Map<String, ?> getData()
    {
        return data;
    }


}
