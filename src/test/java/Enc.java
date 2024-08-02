import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class Enc {
    public static void main(String[] args) throws Exception {
        String date = "This is my data";
        String secretKey = "abc123";

        Key key =new SecretKeySpec(secretKey.getBytes(), "DES");

        Cipher cipher = Cipher.getInstance("AES/ECB");


//        cipher.init(Cipher.ENCRYPT_MODE, key);
//        cipher.init(Cipher.DECRYPT_MODE, key);
//        cipher.doFinal(Base64.getDecoder().decode(encryptedData));
    }
}
