/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author pragamovie
 */ 
public class Utils
{
    public String md5(String senha)
    {
         String sen = "";
         MessageDigest md = null;
         try
         {
            md = MessageDigest.getInstance("MD5");
         }
         catch (NoSuchAlgorithmException e)
         {
            e.printStackTrace();
         }
         BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
         sen = hash.toString(16);
         return sen;
    }
}