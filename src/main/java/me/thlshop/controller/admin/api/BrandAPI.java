package me.thlshop.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.thlshop.dto.BrandDTO;
import me.thlshop.service.IBrandService;
import me.thlshop.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-brand"})
public class BrandAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IBrandService brandService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		BrandDTO brandDTO = HttpUtil.of(request.getReader()).toModel(BrandDTO.class);
		brandService.delete(brandDTO.getBrandId());
		mapper.writeValue(response.getOutputStream(), "thanhcong");
	}
}
