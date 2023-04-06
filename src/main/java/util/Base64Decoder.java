package util;

import java.util.Base64;

public class Base64Decoder {

    public byte[] base64toByte(String base64String){
        Base64.Decoder decoder = Base64.getDecoder();

        byte[] decodedByte = decoder.decode(base64String);

        return decodedByte;
    }
}
