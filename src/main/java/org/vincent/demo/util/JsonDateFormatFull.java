package org.vincent.demo.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * jackson日期转换工具类 
 * @author liuhy
 *
 * @param <T>
 */
public class JsonDateFormatFull extends JsonSerializer<Date> {


    /** 
     * Jackson支持日期字符串格式 
     * "yyyy-MM-dd'T'HH:mm:ss.SSSZ" 
     * "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" 
     * "EEE, dd MMM yyyy HH:mm:ss zzz"
     *  "yyyy-MM-dd HH:mm:ss" 
     */ 
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat(  
                "yyyy-MM-dd'T'HH:mm:ss");  
        String formattedDate = formatter.format(value);  
        jgen.writeString(formattedDate);  
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(  
                "yyyy-MM-dd'T'HH:mm:ss");  
		Date value=new Date();
        String formattedDateStirng = formatter.format(value);
        System.out.println(formattedDateStirng);
        System.out.println(formatter.parse(formattedDateStirng));
	}

}
