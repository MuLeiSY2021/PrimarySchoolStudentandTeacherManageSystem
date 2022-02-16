package com.company;

import com.company.test.TestName;

public class Main {

    public static void main(String[] args) {
        TestName testName = new TestName();
        System.out.println("随机生成姓名");
        System.out.println("女性姓名");
        for (int i = 0; i < 10 ; i++) {
            System.out.println((i+1) + "." + testName.toString(true));
        }
        System.out.println();
        System.out.println("男性姓名");
        for (int i = 0; i < 10 ; i++) {
            System.out.println((i+1) + "." + testName.toString(false));
        }
    }

    public static String toChineseNum (int number) {
        int site = 0;
        for(; number %10 == 0 ; number/=10){
            ++site;
        }
        String ptrString = "";
        for (int i = number; i != 0 ; i /= 10,site++) {
            switch (i % 10) {
                case 0 :
                    ptrString = String.format("零%s", ptrString);
                    break;

                case 1:
                    ptrString = String.format("一%s", ptrString);
                    break;

                case 2:
                    ptrString = String.format("二%s", ptrString);


                case 3:
                    ptrString = String.format("三%s", ptrString);

                case 4:
                    ptrString = String.format("四%s", ptrString);

                case 5:
                    ptrString = String.format("五%s", ptrString);

                case 6:
                    ptrString = String.format("六%s", ptrString);

                case 7:
                    ptrString = String.format("七%s", ptrString);

                case 8:
                    ptrString = String.format("八%s", ptrString);

                case 9:
                    ptrString = String.format("九%s", ptrString);

            }
            switch (site) {
                case 0 :
                    break;

                case 1 :
                    ptrString = String.format("十%s", ptrString);

                case 2:
                    ptrString = String.format("百%s", ptrString);

                case 3:
                    ptrString = String.format("千%s", ptrString);

                case 4:
                    ptrString = String.format("万%s", ptrString);

                case 5:
                    ptrString = String.format("十万%s", ptrString);

                case 6:
                    ptrString = String.format("百万%s", ptrString);
            }
        }
        return ptrString;
    }
}
