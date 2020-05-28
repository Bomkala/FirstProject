package com.example.helloservice.simple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class KaideHandler {
    public static void main(String[] args) throws Exception {

        //逐行读取指定文件，并转化为合适的格式{}
        File file = new File("src/main/resources/凯德待处理数据.txt");
        //file = new File("classpath:凯德待处理数据.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String lineWord;

        List<ShopModel> shopModelList = new ArrayList<>();
        while ((lineWord = reader.readLine()) != null) {
            String[] words = lineWord.split(",");
            for (String word : words) {
                word = word.trim();
            }

            ShopModel shopModel = ShopModel.getInstance(
                    words[0].trim(),
                    words[1].trim(),
                    words[2].trim(),
                    words[3].trim(),
                    words[4].trim());
            shopModelList.add(shopModel);
        }
        System.out.println("总门店数量:" + shopModelList.size());
        shopModelList.stream().forEach(shopModel -> {System.out.println(shopModel.toString());});
    }
}
