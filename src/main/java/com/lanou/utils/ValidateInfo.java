package com.lanou.utils;

/**
 * Created by dllo on 17/10/26.
 */
public class ValidateInfo {

    private static boolean isDigital(String str) {
        return str.matches("^[0-9]*$");
    }

    private static boolean getIdCard(String idcard){

        if (idcard == null) {
            return false;
        }

        // 非15位为假
        if (idcard.length() != 18) {
            return false;
        }

        // 15全部为数字
        if (!isDigital(idcard)) {
            return false;
        }

        return true;
    }



}
