package jp.co.stylez.pth.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.stylez.pth.service.UserServiceImpl;
import jp.co.stylez.pth.web.from.EntryForm;

@Controller
@RequestMapping("/entry")
public class EntryController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * 入力画面
	 * @param model
	 * @return
	 */
	@RequestMapping("/input")
	public String input (Model model) {
		EntryForm form = new EntryForm();
		model.addAttribute(form);
		return "/entry/input";
	}

	/**
	 * 入力内容確認画面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm (@Valid EntryForm entryForm, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return "/entry/input";
		}
		if (entryForm.getPassword().equals("hogehoge")) {
			throw new Exception();
		}
		return "/entry/confirm";
	}

	/**
	 * 登録完了画面
	 * 
	 * @param entryForm
	 * @param result
	 * @return
	 */
	@RequestMapping("/end")
	public String end (EntryForm entryForm, BindingResult result) {
		if (result.hasErrors()) {
			return "/entry/input";
		}
		System.out.println(userServiceImpl);
		return "/entry/end";
	}
}