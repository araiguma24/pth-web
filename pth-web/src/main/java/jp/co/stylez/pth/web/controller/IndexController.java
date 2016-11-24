package jp.co.stylez.pth.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Value("${resoures.greeting:http://workhard.stylez.co.jp.s3-website-ap-northeast-1.amazonaws.com/greeting.json}")
	Resource resource;

	@RequestMapping("/")
	public String index() throws IOException{
		try (final InputStream in =this.resource.getInputStream()) {
			final String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
			System.out.println(content);
		} 
		return "index";
	}

	@RequestMapping("/hoge")
	public String hoge(){
		return "hoge";
	}

	
	public void accessResource() {
		
	}
}
