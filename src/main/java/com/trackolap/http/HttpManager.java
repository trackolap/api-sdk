package com.trackolap.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;

public class HttpManager {

    private static final String CUSTOMER_ID = "tlp-cid";
    private static final String PLATFORM = "platform";
    private static final String TIMESTAMP = "tlp-t";
    public static final String TOKEN = "tlp-k";

    private final String key;
    private final String customerId;

    public HttpManager(String customerId, String key) {
        super();
        this.key = key;
        this.customerId = customerId;
    }

    /**
     * Http Get Method
     * 
     * @param url
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws Exception
     */
    public String sendGet(String url) throws IOException, NoSuchAlgorithmException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        buildHeaders(con, null, url);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();

    }

    /**
     * Http Posy Method
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public String sendPost(String url, String postData) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        buildHeaders(con, postData, url);
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postData);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    /**
     * Build Headers
     * 
     * @param con
     * @param postData
     * @param url
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private void buildHeaders(HttpURLConnection con, String postData, String url)
                    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String timeStamp = String.valueOf(System.currentTimeMillis());
        con.setRequestProperty(PLATFORM, "S2S");
        con.setRequestProperty(CUSTOMER_ID, customerId);
        con.setRequestProperty(TIMESTAMP, timeStamp);
        con.setRequestProperty(TOKEN, buildToken(url, timeStamp, postData));
    }

    /**
     * Generate Signature
     * 
     * @param stringToSign
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */

    private static String generateSignature(String stringToSign)
                    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digestProvider = MessageDigest.getInstance("SHA-256");
        digestProvider.reset();
        byte[] digest = digestProvider.digest(stringToSign.getBytes());
        String signedInput = new String(Base64.encodeBytes(digest));
        return signedInput;
    }

    /**
     * Build Token
     * 
     * @param url
     * @param timestamp
     * @param postData
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private String buildToken(String url, String timestamp, String postData)
                    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuffer requestString = new StringBuffer(customerId);
        requestString.append(timestamp);
        requestString.append(url);
        if (postData != null) {
            requestString.append(postData);
        }
        requestString.append(key);
        return generateSignature(requestString.toString());
    }

}
