import org.apache.commons.codec.binary.Base64;

public class PasswordEncoding {
    public static void main(String[] args){
        String password = "Qwert_12345";
        byte[] encodedPassword = Base64.encodeBase64(password.getBytes());
        System.out.println("Encoded Password: "+ new String(encodedPassword));

        byte[] decodedPassword = Base64.decodeBase64(encodedPassword);
        System.out.println("Decoded Password: "+ new String(decodedPassword));
    }
}
