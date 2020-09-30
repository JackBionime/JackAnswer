package com.example.jack.answer.JavaTest20200927;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 有4隻羽球拍有編號,價格,品牌,重量,球拍序號
 * 編號: 001 價格 :2000 , 品牌 :​尤尼克斯 , ​重量 : 83.5g , 球拍序號: Y2782PAA003
 * 編號: 002 價格 :1980 , 品牌 :​威克多 , ​重量 : 91.0g , 球拍序號: V2882PBB003
 * 編號: 003 價格 :2500 , 品牌 :​富利特 , ​重量 : 78.5g , 球拍序號: F277PCC996
 * 編號: 004 價格 :3800 , 品牌 :​富利特 , ​重量 : 69.8g , 球拍序號: F277PAA998
 */

public class JavaTest20200927 {

    public static void main(String[] test) {

        final String FEET_BRAND = "富利特";
        // Create Models
        BadmintonRacket badmintonRacket001 = new BadmintonRacket();
        badmintonRacket001.setNumber("001");
        badmintonRacket001.setPrice(2000);
        badmintonRacket001.setBrand("尤尼克斯");
        badmintonRacket001.setWeight(83.5f);
        badmintonRacket001.setSerialNumber("Y2782PAA003");

        BadmintonRacket badmintonRacket002 = new BadmintonRacket();
        badmintonRacket002.setNumber("002");
        badmintonRacket002.setPrice(1980);
        badmintonRacket002.setBrand("威克多");
        badmintonRacket002.setWeight(91f);
        badmintonRacket002.setSerialNumber("V2882PBB003");

        BadmintonRacket badmintonRacket003 = new BadmintonRacket();
        badmintonRacket003.setNumber("003");
        badmintonRacket003.setPrice(2500);
        badmintonRacket003.setBrand(FEET_BRAND);
        badmintonRacket003.setWeight(78.5f);
        badmintonRacket003.setSerialNumber("F277PCC996");

        BadmintonRacket badmintonRacket004 = new BadmintonRacket();
        badmintonRacket004.setNumber("004");
        badmintonRacket004.setPrice(3800);
        badmintonRacket004.setBrand(FEET_BRAND);
        badmintonRacket004.setWeight(69.8f);
        badmintonRacket004.setSerialNumber("F277PAA998");

        // 全部球拍塞進一個 Array
        List<BadmintonRacket> badmintonRacketList = new ArrayList<>();
        badmintonRacketList.add(badmintonRacket001);
        badmintonRacketList.add(badmintonRacket002);
        badmintonRacketList.add(badmintonRacket003);
        badmintonRacketList.add(badmintonRacket004);

        /*
             Q1 : 我想買一隻最便宜球拍,答案寫出編號?
         */
        // 寫一個price Array 存各個球拍價錢
        List<Integer> priceList = new ArrayList<>();

        // ForEach 迴圈
        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            int price = badmintonRacket.getPrice();
            priceList.add(price);
        }

        /*
         * Collections.min -> 取得這個Array型態最"小"數值
         * cheapPrice -> 最便宜球拍價錢
         */
        int cheapPrice = Collections.min(priceList);

        // 拿到最便宜價錢,回頭找球拍
        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            int price = badmintonRacket.getPrice();
            String number = badmintonRacket.getNumber();
            if (price == cheapPrice) {
                System.out.println("第一題答案, 球拍編號" + number);
            }
        }

        /*
             Q2 : 我想買一隻最重的球拍,答案寫出編號?
         */
        // weight Array 存各個球拍重量
        List<Float> weightList = new ArrayList<>();

        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            float weight = badmintonRacket.getWeight();
            weightList.add(weight);
        }

        /*
         * Collections.max-> 取得這個Array型態最"大"數值
         * expensiveWeight -> 最重球拍
         */
        float expensiveWeight = Collections.max(weightList);

        // 拿到最重數值,回頭找球拍
        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            float weight = badmintonRacket.getWeight();
            String number = badmintonRacket.getNumber();
            if (weight == expensiveWeight) {
                System.out.println("第二題答案, 球拍編號" + number);
            }
        }

        /*
             Q3 : 總共有幾種品牌?
         */
        // HashSet Array 不允許重複相同值存入
        Set<String> brandList = new HashSet<>();
        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            String brand = badmintonRacket.getBrand();
            brandList.add(brand);
        }
        int brandListSize = brandList.size();
        System.out.println("第三題答案, 共" + brandListSize + "種");

         /*
             Q4: 我想買富利特最便宜球拍,答案寫出編號
         */
        // 寫一個price Array 存各個球拍價錢
        List<Integer> priceListForFeet = new ArrayList<>();

        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            String brand = badmintonRacket.getBrand();
            int price = badmintonRacket.getPrice();
            if (brand.equals(FEET_BRAND)) {
                // 判斷品牌是 Feet 才放價錢進去
                priceListForFeet.add(price);
            }
        }

        /*
         * cheapFeetPrice -> Feet 最小數值
         */
        int cheapFeetPrice = Collections.min(priceListForFeet);

        // 拿到最便宜價錢,回頭找球拍
        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            int price = badmintonRacket.getPrice();
            String number = badmintonRacket.getNumber();
            if (price == cheapFeetPrice) {
                System.out.println("第四題答案, 球拍編號" + number);
            }
        }

         /*
             Q5 : 找出序號有 "F277” 的球拍,答案寫出編號
         */
        // 寫一個新球拍Array
        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            String serialNumber = badmintonRacket.getSerialNumber();
            String number = badmintonRacket.getNumber();
            if (serialNumber.contains("F277")) {
                // 序號有F277 才存入List
                System.out.println("第五題答案, 球拍編號" + number);
            }
        }

        /*
             Q6 : ​尤尼克斯的正版序號是 前面6個字串開頭 : "​Y2782C" , 請問4隻裡面那隻是正版嗎?
         */
        String genuine = "Y2782C";
        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            String serialNumber = badmintonRacket.getSerialNumber();
            String subString = serialNumber.substring(0, 6);
            String brand = badmintonRacket.getBrand();
            if (brand.equals("尤尼克斯")) {
                // 品牌是 尤尼克斯再往下判斷
                if (subString.equals(genuine)) {
                    // 做序號比較判斷
                    System.out.println("第六題答案, 是");
                } else {
                    System.out.println("第六題答案, 否");
                }
            }
        }

        /*
             Q7: 幫我找出結尾序號有 "003” 的球拍,答案寫出編號?
         */
        // 寫一個新球拍Array
        for (BadmintonRacket badmintonRacket : badmintonRacketList) {
            String serialNumber = badmintonRacket.getSerialNumber();
            String number = badmintonRacket.getNumber();
            boolean endsWith003 = serialNumber.endsWith("003");
            if (endsWith003) {
                System.out.println("第七題答案, 球拍編號" + number);
            }
        }

        /*
            Q8: 預算有 6500, 想買編號 03.04 球拍, 預算夠嗎? 兩支平均價錢多少?
        */
        int costPrice = badmintonRacket003.getPrice() + badmintonRacket004.getPrice();
        boolean isCanPain = 6500 - costPrice > 0;
        if (isCanPain) {
            System.out.println("第八題答案, 夠");
        } else {
            System.out.println("第八題答案, 不夠");
        }
        int avgPrice = costPrice / 2;
        System.out.println("第八題答案, 平均 " + avgPrice);

        /*
            Q9: 編號01跟 02 誰比較貴?
        */
        int brPrice01 = badmintonRacket001.getPrice();
        int brPrice02 = badmintonRacket002.getPrice();
        if (brPrice01 > brPrice02) {
            System.out.println("第九題答案, 001貴");
        } else {
            System.out.println("第九題答案, 002貴");
        }


        /*
            Q10: 編號04 重量 做4捨5入到整數是?
         */
        float weight004 = badmintonRacket004.getWeight();
        int answerQ10 = Math.round(weight004);
        System.out.println("第十題答案, " + answerQ10);

        /*
            Q11 : 輸出一個0 ~ 20 隨機數字
         */
        int random = new Random().nextInt(20);
        System.out.println("第十一題答案, " + random);


       /*
         “ iamJacks ”
        */
        final String iamJacks = " i am Jacks ";
        // (1) 做全部大寫處理
        String upper = iamJacks.toUpperCase();
        System.out.println("大寫 " + upper);

        // (2) 做全部小寫處理
        String lower = iamJacks.toLowerCase();
        System.out.println("小寫 " + lower);

        // (3) 去除前後的空格
        String emptyCheck = iamJacks.trim();
        System.out.println("去除前後的空格 " + emptyCheck);

        // (4) 去除全部空格
        String replaceEmpty = iamJacks.replace(" ", "");
        System.out.println("去除全部空格 " + replaceEmpty);

        // (5) "Jacks” 改名成 "Daniels”
        String changeName = iamJacks.replace("Jacks", "Daniels");
        System.out.println("改名 " + changeName);
    }

    static class BadmintonRacket {
        private String number;
        private int price;
        private String brand;
        private float weight;
        private String serialNumber;

        String getNumber() {
            return number;
        }

        void setNumber(String number) {
            this.number = number;
        }

        int getPrice() {
            return price;
        }

        void setPrice(int price) {
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        void setBrand(String brand) {
            this.brand = brand;
        }

        float getWeight() {
            return weight;
        }

        void setWeight(float weight) {
            this.weight = weight;
        }

        String getSerialNumber() {
            return serialNumber;
        }

        void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }
    }
}
