package com.aims.ser.filter;

import com.aims.common.utils.FastJsonUtil;
import com.aims.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 请求参数解密，封装解密后的数据
 * @author Jerry
 */
public class ParamRequestWrapper extends HttpServletRequestWrapper {
    private final static Logger logger = LoggerFactory.getLogger(ParamRequestWrapper.class);
	//private static final String PRIVATE_KEY = PropertyUtil.getProperty("xk.boss.rsa.privateKey");
	private static final String PRIVATE_KEY = "";
	private byte[] body = new byte[0];
	private Map<String, String[]> parameterMap = new HashMap<>();

	/**
	 * Constructs a request object wrapping the given request.
	 *
	 * @param request
	 * @throws IllegalArgumentException if the request is null
	 */
	public ParamRequestWrapper(HttpServletRequest request, HttpServletResponse response) throws IOException {
		super(request);
		logger.info("=========进入参数解密==========");
		decryptParamters(request, response);
	}

	/**
	 * 获取所有参数名
	 *
	 * @return 返回所有参数名
	 */
	@Override
	public Enumeration<String> getParameterNames() {
		Vector<String> vector = new Vector<String>(parameterMap.keySet());
		return vector.elements();
	}

	/**
	 * 获取指定参数名的值，如果有重复的参数名，则返回第一个的值 接收一般变量 ，如text类型
	 *
	 * @param name 指定参数名
	 * @return 指定参数名的值
	 */
	@Override
	public String getParameter(String name) {
		String[] strArr = parameterMap.get(name);
		if (strArr.length > 0) {
			return strArr[0];
		} else {
			return null;
		}
	}


	/**
	 * 获取指定参数名的所有值的数组，如：checkbox的所有数据
	 * 接收数组变量 ，如checkobx类型
	 */
	@Override
	public String[] getParameterValues(String name) {
		return parameterMap.get(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		final InputStream bais = new ByteArrayInputStream(body); //再封装数据
		return new ServletInputStream() {
			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener readListener) {

			}

			@Override
			public int read() throws IOException {
				return bais.read();
			}
		};
	}

	private void setParameterMap(Map<String, Object> params) {
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			if (entry.getValue() == null) {
				parameterMap.put(entry.getKey(), new String[]{""});
				break;
			} else if (entry.getValue() instanceof String[]) {
				parameterMap.put(entry.getKey(), (String[])entry.getValue());
			} else if (entry.getValue() instanceof String) {
				parameterMap.put(entry.getKey(), new String[]{(String)entry.getValue()});
			} else {
				parameterMap.put(entry.getKey(), new String[]{entry.getValue().toString()});
			}
		}
	}

	/**
	 * 解密：AES+RSA
	 * @param request
	 * @throws IOException
	 */
	public void decryptParamters(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bodyString = getBodyString(request);
		if(StringUtil.isNotEmpty(bodyString)) {
			body = bodyString.getBytes();
			setParameterMap(FastJsonUtil.toBean(bodyString, Map.class));
		}
		/*String key = request.getParameter("param1");
		String data = request.getParameter("param2");
		RSA rsa = new RSA(PRIVATE_KEY, null);
		AES aes = SecureUtil.aes(rsa.decryptFromBase64(key, KeyType.PrivateKey));
		body = aes.decrypt(HexUtil.decodeHex(Base64.decodeStr(data)));
		setParameterMap(JSonUtil.toObject(new String(body), Map.class));
		logger.info("解密后参数：{}", new String(body));*/
	}

	private String getBodyString(ServletRequest request) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			//将request字节转换为字符
			inputStream = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			logger.error("ServletRequest get inputStream error");
			throw e;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
