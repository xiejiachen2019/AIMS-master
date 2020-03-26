package com.aims.ser.filter;

import com.aims.common.utils.FastJsonUtil;
import com.aims.common.utils.StringUtil;
import com.aims.core.exception.CommonErrorCode;
import com.aims.core.exception.ResultPO;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 请求参数解密过滤器
*/
@Component
@WebFilter(urlPatterns = "/*",filterName = "SecureParamFilter")
@Order(2)
public class SecureParamFilter extends OncePerRequestFilter {

	private static final Logger log = LoggerFactory.getLogger(SecureParamFilter.class);

	private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
			Arrays.asList("/aims/nursingItem/saveItems","/aims/accesssection/inManage","/aims/accesssection/outManage")));

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		if (!ALLOWED_PATHS.contains(request.getServletPath())) {
			try {
				String origin = request.getHeader("Origin");
				//login(origin);
				// 只接收json请求参数
				String contentType = request.getHeader("Content-Type");
//				if (!StringUtil.isEmpty(contentType) && !contentType.contains("application/json")) {
//					throw new Exception("无效的请求方式");
//				}
				filterChain.doFilter(new ParamRequestWrapper(request, response), response);
			} catch (IOException e) {
				e.printStackTrace();
				//log.error("解密异常：key={},data={}", key, data);
				String result = FastJsonUtil.toJSONString(new ResultPO(CommonErrorCode.E100004.getCode(), CommonErrorCode.E100004.getMsg(), null));
				writeResponse(response, result);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{
			filterChain.doFilter(request, response);
		}
	}

	public void writeResponse(ServletResponse response, String jsonResult ) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		OutputStream out = response.getOutputStream();
		out.write(jsonResult.getBytes());
		out.flush();
	}

	// 根据IP分不同的令牌桶, 每天自动清理缓存
	private static LoadingCache<String, RateLimiter> caches = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.expireAfterWrite(1, TimeUnit.DAYS)
			.build(new CacheLoader<String, RateLimiter>() {
				@Override
				public RateLimiter load(String key) throws Exception {
					// 新的IP初始化 (限流每秒两个令牌响应)
					return RateLimiter.create(1);
				}
			});

	private static void login(String i) throws Exception {
		// 模拟IP的key
		//String ip = String.valueOf(i).charAt(0) + "";
		RateLimiter limiter = caches.get(i);

		if (limiter.tryAcquire()) {
			System.out.println(i + " success " + new SimpleDateFormat("HH:mm:ss.sss").format(new Date()));
		} else {
			System.out.println(i + " failed " + new SimpleDateFormat("HH:mm:ss.sss").format(new Date()));
			throw new Exception("请求无效");
		}
	}
}
