package com.example.helloservice.simple;

import com.alibaba.fastjson.JSON;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.util.StringUtils;

public class KaideShopInfoHandler {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/tnb-kaide.txt"));
        String str = null;

        Map<String, String> tnbShopMap = new LinkedHashMap<>();
        while ((str = reader.readLine()) != null) {

            String[] splitStr = str.split(",");
            tnbShopMap.put(splitStr[0], splitStr[1]);
        }
        System.out.println(tnbShopMap.size());

        BufferedReader reader2 = new BufferedReader(new FileReader("src/main/resources/kratos-kaide.txt"));
        String str2 = null;

        Map<String, ShopInfo> kratosShopMap = new LinkedHashMap<>();
        while ((str2 = reader2.readLine()) != null) {

            String[] splitStr = str2.split("-");
            if (splitStr != null && splitStr.length >= 2) {

                ShopInfo shopInfo = JSON.parseObject(splitStr[1],ShopInfo.class);

                kratosShopMap.put(splitStr[0],shopInfo);
            }
        }

        System.out.println(kratosShopMap.size());

        File file = new File("src/main/resources/result.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        Map<String, String> resultMap = new LinkedHashMap<>();
        for (String shopId : kratosShopMap.keySet()) {
            String extParam = tnbShopMap.get(shopId);

            if (!StringUtils.isEmpty(extParam)) {
                String resultStr = shopId + "," + extParam + "," + kratosShopMap.get(shopId).getStoreCode();
                writer.write(resultStr);
                writer.newLine();
            }
        }
        writer.close();



    }

}
