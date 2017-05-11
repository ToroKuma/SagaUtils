package tw.com.as.sagautils.utils;

/**
 * Created by AS on 2016/12/21.
 */
public class ConvertUtil {

    public static byte[] hexStringToByteArray(String s) {
        int len = s.replace("0x","").length();
        byte[] data = new byte[len/2];

        for(int i = 0; i < len; i+=2){
            data[i/2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }

        return data;
    }

    public static String intStringArrayToHexString(String[] s) {
        String data = "";

        for(int i = 0; i < s.length; i++){
            data += Integer.toHexString(Integer.decode(s[i]));
        }

        return data.toUpperCase();
    }

    final protected static char[] hexArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public static String byteArrayToHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length*2];
        int v;

        for(int j=0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j*2] = hexArray[v>>>4];
            hexChars[j*2 + 1] = hexArray[v & 0x0F];
        }

        return new String(hexChars);
    }

    public static String byteArrayToString(byte[] bytes)
    {
        String res = new String();

        for (int i=0; i<bytes.length; i++) {
            res += String.valueOf(bytes[i])+((i<bytes.length-1)?",":"");
        }

        return res;
    }
}
