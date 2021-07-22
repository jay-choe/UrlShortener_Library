public class UrlConverter {
    private final int BASE = 62;
    public  final String BASE_FORMAT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String encoding(long uniqueKey) {
        if (uniqueKey < 0) {
            throw new IllegalArgumentException("Unique Key must be a positive number");
        }

        if (uniqueKey == 0) {
            return String.valueOf(BASE_FORMAT.charAt(0));
        }

        StringBuffer sb = new StringBuffer();

        while (uniqueKey > 0) {
            sb.append(BASE_FORMAT.charAt((int) (uniqueKey % BASE)));
            uniqueKey /= BASE;
        }

        return sb.reverse().toString();
    }

    public long decoding(String encodedStr) {
        long uniqueKey = 0;
        int indexOfEncodedStr = 0;
        while (indexOfEncodedStr < encodedStr.length()) {
            uniqueKey = (uniqueKey * BASE) + BASE_FORMAT.indexOf(encodedStr.charAt(indexOfEncodedStr));
            ++indexOfEncodedStr;
        }
        return uniqueKey;
    }
}
