/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 *
 * @author Larissa
 */
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;



public class Criptografia {



    private static MessageDigest md = null;



    static {

        try {

            md = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException ex) {

            ex.printStackTrace();

        }

    }



  private static char[] hexCodes(byte[] text) {

        char[] hexOutput = new char[text.length * 2];

        String hexString;



        for (int i = 0; i < text.length; i++) {

            hexString = "00" + Integer.toHexString(text[i]);

            hexString.toUpperCase().getChars(hexString.length() - 2,

                                    hexString.length(), hexOutput, i * 2);

        }

        return hexOutput;

    }



public static String criptografar(String pwd) {

        if (md != null) {

            return new String(hexCodes(md.digest(pwd.getBytes())));

        }

        return null;

    }

public static void main(String[] args){

        String senha = "porquinho";

        String a = (Criptografia.criptografar(senha));
          System.out.println(a + "   " + Criptografia.criptografar(a));
}

}