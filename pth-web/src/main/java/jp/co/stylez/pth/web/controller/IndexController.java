package jp.co.stylez.pth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/hoge")
	public String hoge(){
		return "hoge";
	}
}
