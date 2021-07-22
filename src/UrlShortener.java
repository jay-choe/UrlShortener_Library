import java.util.regex.Pattern;

public class UrlShortener {
    private final UrlConverter urlConverter = new UrlConverter();
    private String domain = "";
    public UrlShortener(){};

    public UrlShortener(String domain) {
       this.domain = domain;
    }

    public boolean validEncodedFormat(String encodedStr) {
      return Pattern.matches("[0-9a-zA-Z]+", encodedStr);
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getShortUrl(long uniqueKey) {
        if (domain.endsWith("/") || domain.length() == 0) {
            return domain + urlConverter.encoding(uniqueKey);
        }
        return domain + "/" + urlConverter.encoding(uniqueKey);
    }

    public long getUniqueKey(String encodedStr) {
        if (!validEncodedFormat(encodedStr)) {
            throw new IllegalArgumentException("Wrong Character in encodedStr");
        }
        return urlConverter.decoding(encodedStr);
    }
}
