package com.senmiao.components._global.dto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

@Component
public class BaseController {

	public HttpServletResponse getResponse() {
		ServletWebRequest server = (ServletWebRequest) RequestContextHolder.getRequestAttributes();
		return server.getResponse();
	}
	
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * 从RequestContextHolder中获取request
	 * 
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		return request;
	}

	/**
	 * 获取session
	 * 
	 * @return
	 */
	protected HttpSession getSession() {
		HttpServletRequest request = getRequest();

		HttpSession session = request.getSession();

		return session;
	}

	/**
	 * 获取浏览器信息
	 * 
	 * @return
	 */
	protected String getReqAgent() {
		HttpServletRequest request = getRequest();

		return request.getHeader("User-Agent");
	}

	/**
	 * 获取请求URL
	 * 
	 * @return
	 */
	protected String getReqUrl() {
		HttpServletRequest request = getRequest();

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = requestURI.substring(contextPath.length());

		return path;
	}

	/**
	 * 获取cookie
	 * 
	 * @return
	 */
	protected Cookie[] getCookies() {
		HttpServletRequest request = getRequest();

		return request.getCookies();
	}

	/**
	 * 根据key获取session
	 * 
	 * @param key
	 * @return
	 */
	protected Object getSessionAttribute(String key) {
		if (StringUtils.isBlank(key)) {
			return null;
		}

		HttpSession session = getSession();

		if (null != session) {
			return session.getAttribute(key);
		}

		return null;
	}

	/**
	 * 设置session
	 * 
	 * @param key
	 * @param value
	 */
	protected void setSessionAttribute(String key, Object value) {
		if (StringUtils.isBlank(key)) {
			return;
		}

		HttpSession session = getSession();

		if (null != session) {
			session.setAttribute(key, value);
		}

	}

	/**
	 * 设置session超时时间
	 * 
	 * @param max
	 */
	protected void setSessionMaxInactiveInterval(int max) {
		HttpSession session = getSession();

		session.setMaxInactiveInterval(max);
	}

	/**
	 * 根据key获取cookie
	 * 
	 * @param key
	 * @return
	 */
	protected String getCookie(String key) {
		if (StringUtils.isBlank(key)) {
			return null;
		}

		Cookie[] cookies = getCookies();
		if(null != cookies){
			for (Cookie cookie : cookies) {
				if (key.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}

		return null;
	}

	/**
	 * 添加cookie
	 * 
	 * @param response
	 * @param key
	 * @param value
	 * @param expiry
	 */
	protected void addCookie(HttpServletResponse response, String key, String value, int expiry) {
		if (StringUtils.isBlank(key) || null == response) {
			return;
		}

		Cookie cookie = new Cookie(key, value);

		cookie.setPath("/");
		cookie.setMaxAge(expiry);

		response.addCookie(cookie);
	}

    protected void deleteCookie(HttpServletResponse response, String key) {
        addCookie(response, key, null, 0);
    }

}
