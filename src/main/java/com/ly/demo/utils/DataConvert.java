package com.ly.demo.utils;

import com.ly.demo.entity.Data;
import com.ly.demo.entity.EndPointInfo;

import java.util.Hashtable;

public class DataConvert {
    public static EndPointInfo convert(Data data){
        EndPointInfo edi = new EndPointInfo();
        edi.setAppBundle(data.getBdle());
        edi.setAppId(data.getAid());
        edi.setAppName(data.getAna());
        edi.setAppStoreurl(data.getSurl());
        edi.setDeviceCarrier(data.getCar());
        edi.setDeviceDevicetype(data.getDtp());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(data.getGlat());
        stringBuffer.append("-");
        stringBuffer.append(data.getGlon());
        stringBuffer.append("-");
        stringBuffer.append(data.getGcny());
        stringBuffer.append("-");
        stringBuffer.append(data.getGcty());
        stringBuffer.append("-");
        stringBuffer.append(data.getGtyp());
        edi.setDeviceGeo(String.valueOf(stringBuffer));
        edi.setDeviceIdfa(data.getIdfa());
        edi.setDeviceIp(data.getIp());
        edi.setDeviceOs(data.getOs());
        edi.setDeviceOsv(data.getOsv());
        edi.setDeviceUa(data.getUa());

        return edi;
    }

    /**
     * 1-Mobile/Tablet
     * 2-Personal Computer
     * 3-Connected TV
     * 4-Phone
     * 5-Tablet
     * 6-Connected Device
     * 7-Set Top Box
     * @param key
     * @return
     */
    public static String convertDeviceType(String key){
        String value = "unknown";
        if("1".equals(key)){
            value = "Mobile/Tablet";
        }else if("2".equals(key)){
            value = "Personal Computer";
        }else if("3".equals(key)){
            value = "Connected TV";
        }else if("4".equals(key)){
            value = "Phone";
        }else if("5".equals(key)){
            value = "Tablet";
        }else if("6".equals(key)){
            value = "Connected Device";
        }else if("7".equals(key)){
            value = "Set Top Box";
        }else{
            return "unknown";
        }
        return value;
    }
}
