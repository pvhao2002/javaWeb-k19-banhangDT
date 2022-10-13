package me.thlshop.controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.constant.SystemConstant;
import me.thlshop.entity.BrandEntity;
import me.thlshop.service.IBrandService;
import me.thlshop.utils.ImageUtil;
import me.thlshop.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-brand" })
public class BrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IBrandService brandService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String type = request.getParameter("type");
		String brandId = request.getParameter("brandId");
		if (type.equals(SystemConstant.LIST)) {
			request.setAttribute(SystemConstant.MODEL, brandService.findAll());
			url = "views/admin/brand/brand.jsp";
		} else if (type.equals(SystemConstant.EDIT)) {
			if (brandId != null) {
				request.setAttribute("Brand", brandService.findOne(Integer.parseInt(brandId)));
			}
			url = "views/admin/brand/editBrand.jsp";
		}
		MessageUtil.showMessage(request);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ServletContext sc = this.getServletConfig().getServletContext();
		String realPath = sc.getRealPath("/images/imageBrand");
		HashMap<String, String> fields = ImageUtil.mageHandle(request, realPath);

		if (fields.get("brandId") == null || fields.get("brandId").equals("")) {
			// Add
			BrandEntity brandEntity = new BrandEntity();
			brandEntity.setBrandName(fields.get("brandName"));
			brandEntity.setLogo(fields.get("logo"));
			brandService.save(brandEntity);
		} else {
			// Update
			BrandEntity brandEntity = brandService.findOne(Integer.parseInt(fields.get("brandId")));
			brandEntity.setBrandName(fields.get("brandName"));
			if (fields.get("logo") == null || fields.get("logo").equals("")) {

			} else {
				brandEntity.setLogo(fields.get("logo"));
			}
			brandService.update(brandEntity);
		}

	}
}
