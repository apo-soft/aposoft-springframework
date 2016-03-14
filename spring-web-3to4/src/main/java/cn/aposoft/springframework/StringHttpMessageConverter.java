/**
 * 
 */
package cn.aposoft.springframework;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.MediaType;

/**
 * 处理Spring 4 中 使用注解@ResponseBody 时,无法完成字符转换的辅助Converter
 * 
 * @see org.springframework.http.converter.StringHttpMessageConverter
 * @see 
 * @author LiuJian
 * @version 4.0.0.1
 */
public class StringHttpMessageConverter extends org.springframework.http.converter.StringHttpMessageConverter {
	/**
	 * 构建基于charsetName的Converter
	 * 
	 * @see org.springframework.http.converter.StringHttpMessageConverter
	 * @param charset
	 *            字符集编码
	 */
	public StringHttpMessageConverter(String charset) {
		this(Charset.forName(charset));
	}

	/**
	 * 构建基于charset的Converter
	 * 
	 * @see org.springframework.http.converter.StringHttpMessageConverter
	 * @param charset
	 *            字符集
	 */
	public StringHttpMessageConverter(Charset charset) {
		super(charset);
	}

	/**
	 * 构建基于charset的Converter
	 * 
	 * @see org.springframework.http.converter.StringHttpMessageConverter
	 * @param charset
	 *            字符集
	 */
	public StringHttpMessageConverter(String type, String subType, String charset) {
		this(type, subType, Charset.forName(charset));
	}

	/**
	 * 构建基于charset的Converter
	 * 
	 * @see org.springframework.http.converter.StringHttpMessageConverter
	 * @param charset
	 *            字符集
	 */
	public StringHttpMessageConverter(String type, String subType, Charset charset) {
		super(charset);
		MediaType mediaType = new MediaType(type, subType, charset);
		setSupportedMediaTypes(Arrays.asList(mediaType));
	}
}
