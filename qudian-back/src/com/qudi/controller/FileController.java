package com.qudi.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qudi.bean.GoodsImg;
import com.qudi.bean.SysUser;
import com.qudi.service.GoodsImgDaoService;
import com.qudi.service.GoodsListDaoService;

/**
 * 
 * @author AlanAtlantis
 *
 */
@Controller
@RequestMapping("/sys/")
public class FileController {

	private static String PATH = "C:/home/qd_img";

	@Autowired
	private GoodsImgDaoService goodsImgDaoService;
	@Autowired
	private GoodsListDaoService goodsListDaoService;

	/**
	 * 图片文件上传
	 */
	@RequestMapping(value = "/photoUpload", method = RequestMethod.POST)
	public String photoUpload(@RequestParam(value = "file", required = false) MultipartFile[] files,
			HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("goodsId") int goodsId, @RequestParam("action") int action,
			@RequestParam("isMain") int isMain, @RequestParam("picId") int picId, Model model)
			throws IllegalStateException, IOException {
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// 图片顺序
		int picSort = 0;
		for (MultipartFile file : files) {

			picSort++;
			String absolutePath = "";
			if (file != null) {// 判断上传的文件是否为空
				String path = null;// 文件路径
				String type = null;// 文件类型
				String fileName = file.getOriginalFilename();// 文件原名称
				System.out.println("上传的文件原名称:" + fileName);
				System.out.println("--->>>--->>>--->>>--->>>fileName:" + fileName);
				// 判断文件类型
				type = fileName.indexOf(".") != -1
						? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
						: null;
				if (type != null) {// 判断文件类型是否为空
					if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
							|| "JPG".equals(type.toUpperCase())) {
						// 项目在容器中实际发布运行的根路径
						String realPath = request.getSession().getServletContext().getRealPath("/");
						System.out.println("-------------------" + realPath + "----------------" + fileName);
						Date currentTime = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
						String dateString = formatter.format(currentTime);
						
						//获取userId
						int userId = user.getId();
						//int userId = 1;// user.getId();

						File mkd = new File(PATH + "/app1/" + userId + "/" + dateString);
						// 判断目录是否存在
						if (!mkd.exists()) {
							// 创建目录
							mkd.mkdirs();
						}

						// 自定义的文件名称
						String trueFileName = dateString + String.valueOf(System.currentTimeMillis()) + fileName;
						// 设置存放图片文件的路径
						path = mkd.getPath() + "/" + trueFileName;

						System.out.println("存放图片文件的路径:" + path);
						// 转存文件到指定的路径
						file.transferTo(new File(path));
						System.out.println("文件成功上传到指定目录下" + file.toString());
						absolutePath = path;
						// goodsImgDaoService.addGoodsImg(goodsId, file.toString());
					} else {
						System.out.println("不是我们想要的文件类型,请按要求重新上传");

					}
				} else {
					System.out.println("文件类型为空");
					System.out.println("---->>>>---->>>>---->>>action:" + action);
					// 文件上传为空,单纯修改主图
					if (action == 2) {
						GoodsImg goodsImg = new GoodsImg();
						// 设置主图
						goodsImg.setPicId(picId);
						goodsImg.setIsMain(isMain);
						System.out.println("---->>>>---->>>>---->>>isMain:" + isMain);

						// 获取主图id
						int pid = (int) goodsImgDaoService.queryIsMain(goodsId).getObject();
						System.out.println("---->>>>---->>>>---->>>pid:" + pid);
						// 判断是否有主图
						if (pid > 0) {
							// 将主图修改为普通图片
							goodsImgDaoService.updateMian(0, pid);
						}

						goodsImgDaoService.updateImg(goodsImg);
					}
					
					int userId = user.getId();
					// userId暂时全部指定为1
					//int userId = 1;
					model.addAttribute("message", goodsListDaoService.selectGoodsList(userId));
					return "updataTables";

				}

			} else {
				System.out.println("没有找到相对应的文件");

			}

			GoodsImg goodsImg = new GoodsImg();
			// 保存图片路径
			goodsImg.setPicUrl(absolutePath);

			goodsImg.setPicSort(picSort);

			// 处理图片路径
			String path = goodsImg.getPicUrl();

			String path2 = path.replace("C:\\home", "/47.96.91.95");

			System.out.println("------->>>>>----->>>>path2:" + path2);
			goodsImg.setPicUrl(path2);

			if (file != null) {
				// 判断是添加还是修改,1为添加，2为修改
				if (action == 1) {

					goodsImg.setGoodsId(goodsId);
					// 添加图片到数据库
					goodsImgDaoService.addGoodsImg(goodsImg);
				} else {
					// 设置主图
					goodsImg.setPicId(picId);
					goodsImg.setIsMain(isMain);
					// 判断是否需要修改主图
					if (isMain > 0) {
						// 获取主图id
						int pid = (int) goodsImgDaoService.queryIsMain(goodsId).getObject();
						// 判断是否有主图
						if (pid > 0) {
							// 将主图修改为普通图片
							goodsImgDaoService.updateMian(0, pid);
						}
					}
					goodsImgDaoService.updateImg(goodsImg);
				}
			}
			/*
			 * // 查询数据 model.addAttribute("goodsImg",
			 * goodsImgDaoService.selectGoodsImg(goodsId));
			 */
		}
		int userId = user.getId();
		// userId暂时全部指定为1
		//int userId = 1;
		model.addAttribute("message", goodsListDaoService.selectGoodsList(userId));
		return "updataTables";
	}

}