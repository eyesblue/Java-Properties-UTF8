import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		String file="config.properties";
		Props prop=new Props();
		
		
		// Load the properties with encoding "UTF-8" test.
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
		prop.load(isr);
		
		
		// Test
		prop.put("jp_key", "トランプ氏はノースカロライナ");
		prop.put("kr_key", "쌍시옷");
		prop.put("ch_key", "中文字元");
		String comments=
				" 參數說明:\n"
				+ " WebUser: 網頁認證時使用的名稱。\n"
				+ " WebPassword: 網頁認證時使用的密碼。\n"
				+ " PrintSerial: 指定排序時的順序，以逗號(,)分隔，請參考列印頁面。\n"
				+ " xShift: 列印時微調影像的位置，正整數向右靠，負整數向左靠(負整數不可小於-15), 8個像素 = 1公釐.\n"
				+ "\n 注意：若不使用網頁認證時，請不要設定WebUser與WebPassword參數，若系統的環境變數中有出現這兩個變數時，也會被拿來做網頁認證用，若同時出現則以本設定檔中的設定為優先。\n";
		
		
		// Write the properties with encoding "UTF-8" test.
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		prop.store(br, comments);
	}

}
