/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author eduar_000
 */
public class Util {

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dt = new Date();
        return dateFormat.format(dt);
    }

    public static String getCurrentFile() {
        return Thread.currentThread().getStackTrace()[1].getClassName();
    }

}
