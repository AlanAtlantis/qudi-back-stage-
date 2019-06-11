package com.qudi.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qudi.util.MessageUtil;

@Controller
public class FileController {

	@GetMapping(value = "/file")
	public String file() {
		return "file";
	}

	@PostMapping(value = "/fileUpload")
	public MessageUtil fileUpload(@RequestParam(value = "file") MultipartFile file, Model model,
			HttpServletRequest request) {
		MessageUtil message = new MessageUtil();
		if (file.isEmpty()) {
			System.out.println("文件为空空");
		}
		String fileName = file.getOriginalFilename(); // 文件名
		
		String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
		String filePath = "G://temp-rainy//"; // 上传后的路径
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");// 设置日期格式

		fileName = UUID.randomUUID() + "qudian_img-1-" + df.format(new Date()).toString() + suffixName; // 新文件名
		File dest = new File(filePath + fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String filename = "/temp-rainy/" + fileName;
		model.addAttribute("filename", filename);
		return message;

	}

}