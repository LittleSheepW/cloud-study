package com.ww.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class ManagerFilter extends ZuulFilter {

	/**
	 * 过滤器类型
	 * pre ：可以在请求被路由之前调用
	 * route ：在路由请求时候被调用
	 * post ：在route和error过滤器之后被调用
	 * error ：处理请求时发生错误时被调用
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器优先级，数字越小优先级越高
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 是否启用该过滤器
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的具体逻辑
	 * 返回任何类型都表示放行
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() {
		//处理头信息在网关转发后丢失
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		/**
		 * 如果存在跨域问题，浏览器会默认发送一个OPTIONS欲请求，
		 * 此时如果不直接放行，就会直接响应失败，浏览器就不会再次发送正式请求
		 */
		if("OPTIONS".equals(request.getMethod())) {
			return null;
		}
		// 测试Zuul filter
		String accessToken = request.getParameter("accessToken");
		if (StringUtils.isEmpty(accessToken)) {
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(403);
			currentContext.setResponseBody("无权访问，请先进行登录");
			currentContext.getResponse().setContentType("text/html;charset=utf-8");
			return null;
		}

		return null;
	}
}
