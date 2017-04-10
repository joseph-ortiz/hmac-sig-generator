import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class SignatureGenerator {

	public static void main(String[] args) throws GeneralSecurityException, IOException {

		String secretKey = "INSERT SECRET KEY HERE"; // hmac private key";
		String payload = GeneratePayload();
		String generateHmacSHA256Signature = generateHmacSHA256Signature(payload, secretKey);
		System.out.println("Signature: " + generateHmacSHA256Signature);

		String urlEncodedSign = URLEncoder.encode(generateHmacSHA256Signature, "UTF-8");

		System.out.println("Url encoded value: " + urlEncodedSign);
	}

	public static String GeneratePayload(){
		String verb = "POST";
		String date = "Tue, 07 Feb 2017 21:59:53 GMT"; //"2017-02-07T21:59:53.222Z";
		String resource = "/service/risk/ submit-and-risk";
		String body = "INSERT JSON BODY HERE";
		String signature =  String.format("%s\n%s\n%s\n%s", verb, date, resource, body);
		System.out.println(signature);
		return signature;
	}

	public static String generateHmacSHA256Signature(String data, String key) throws GeneralSecurityException {
		byte[] hmacData = null;

		try {
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(secretKey);
			hmacData = mac.doFinal(data.getBytes("UTF-8"));
			return DatatypeConverter.printBase64Binary(hmacData);
		} catch (UnsupportedEncodingException e) {
			throw new GeneralSecurityException(e);
		}
	}
}
