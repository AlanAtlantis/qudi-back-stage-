package com.qudi.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.baidu.ueditor.ActionEnter;

/**
 * 
 * @author AlanAtlantis
 *
 */
@Controller
@RequestMapping("/sys/upload")
public class UploadController {

	@RequestMapping("springUpload")
	public String springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
		// long startTime = System.currentTimeMillis();
		// ����ǰ�����ĳ�ʼ���� CommonsMutipartResolver ���ಿ�ֽ�������
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// ���form���Ƿ���enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// ��request��ɶಿ��request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// ��ȡmultiRequest �����е��ļ���
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// һ�α��������ļ�
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				System.out.println("---------->>>>>>>>>>>>>>---------->>>------------>>>>>" + file.getName());
				if (file != null) {
					String path = "G:/temp-rainy" + file.getOriginalFilename();
					// �ϴ�
					file.transferTo(new File(path));
				}
			}
		}
		return "tables";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String realDir = request.getSession().getServletContext().getRealPath("");
		String contextpath = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ contextpath + "/";
		try {
			String filePath = "uploadfiles";
			String realPath = "G:/temp-rainy";
			// �ж�·���Ƿ���ڣ��������򴴽�
			File dir = new File(realPath);
			if (!dir.isDirectory())
				dir.mkdir();
			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory dff = new DiskFileItemFactory();
				dff.setRepository(dir);
				dff.setSizeThreshold(1024000);
				ServletFileUpload sfu = new ServletFileUpload(dff);
				FileItemIterator fii = null;
				fii = sfu.getItemIterator(request);
				String title = ""; // ͼƬ����
				String url = ""; // ͼƬ��ַ
				String fileName = "";
				String state = "SUCCESS";
				String realFileName = "";
				while (fii.hasNext()) {
					FileItemStream fis = fii.next();
					try {
						if (!fis.isFormField() && fis.getName().length() > 0) {
							fileName = fis.getName();
							Pattern reg = Pattern.compile("[.]jpg|png|jpeg|gif$");
							Matcher matcher = reg.matcher(fileName);
							if (!matcher.find()) {
								state = "�ļ����Ͳ�����";
								break;
							}
							realFileName = new Date().getTime()
									+ fileName.substring(fileName.lastIndexOf("."), fileName.length());
							url = realPath + "\\" + realFileName;
							BufferedInputStream in = new BufferedInputStream(fis.openStream());// ����ļ�������
							FileOutputStream a = new FileOutputStream(new File(url));
							BufferedOutputStream output = new BufferedOutputStream(a);
							Streams.copy(in, output, true);// ��ʼ���ļ�д����ָ�����ϴ��ļ���
						} else {
							String fname = fis.getFieldName();

							if (fname.indexOf("pictitle") != -1) {
								BufferedInputStream in = new BufferedInputStream(fis.openStream());
								byte c[] = new byte[10];
								int n = 0;
								while ((n = in.read(c)) != -1) {
									title = new String(c, 0, n);
									break;
								}
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				response.setStatus(200);
				String retxt = "{src:'" + basePath + filePath + "/" + realFileName + "',status:success}";
				response.getWriter().print(retxt);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public void enterUE(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Type", "text/html");
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		try {
			String exec = new ActionEnter(request, rootPath).exec();
			PrintWriter writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ueditor上传图片
	 * 
	 * @param upfile   
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadNewsImg(@RequestParam(value = "upfile", required = false) MultipartFile upfile,
			HttpServletRequest request, HttpServletResponse response) {
		Date date = new Date();
		File file = new File(upfile.getOriginalFilename());
		System.out.println("-------------------�ٶȸ��ı��ϴ�ͼƬ" + file.getAbsolutePath() + "\t\t" + file.getPath());
		// String upLoadPath = "\\upload\\file\\" + new
		// SimpleDateFormat("yyyy\\MM\\").format(date);
		// String upLoadPath = file.getAbsolutePath();
		String upLoadPath = "/";
		// String upLoadPath = upfile.getOriginalFilename();
		// String path = upLoadPath;
		// ͼƬ��׺
		String last = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."),
				upfile.getOriginalFilename().length());

		String uuid = UUID.randomUUID().toString().replace("-", "");
		String fileName = uuid + last;
		File fileT = new File("C:\\home/", fileName);
		// File fileT = new File("C:\\home/", fileName);
		if (!fileT.exists()) {
			fileT.mkdirs();
		}
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			upfile.transferTo(fileT);
		} catch (IllegalStateException e) {
			System.out.println("");
		} catch (IOException e1) {
			System.out.println("图片上传失败");
		}
		System.out.println("--->>url:" + upLoadPath.replace("\\", "/") + fileName);
		result.put("state", "SUCCESS");
		result.put("url", upLoadPath.replace("\\", "/") + fileName);
		result.put("original", "");
		result.put("type", last);
		result.put("size", upfile.getSize());
		result.put("title", fileName);
		return result;
	}

}
