package jp.co.stylez.pth.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Value("${resoures.greeting:http://workhard.stylez.co.jp.s3-website-ap-northeast-1.amazonaws.com/greeting.json}")
	Resource resource;
	@Autowired
	MessageSource messageSource;

	@RequestMapping("/")
	public String index(Model model, Locale locale){
		String greeting = null;
		try {
			greeting = accessResource();
		} catch (IOException e) {
			System.out.println(e);
		}
		final String message = this.messageSource.getMessage("welcome.message", new String[]{"ゲスト"}, locale);
		model.addAttribute("greeting", greeting);
		model.addAttribute("message",message);
		return "index";
	}

	@RequestMapping("/hoge")
	public String hoge(){
		return "hoge";
	}

	
	public String accessResource() throws IOException {
		try (InputStream in = resource.getInputStream()) {
            String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
            System.out.println(content);
            return content;
        }
	}
}
