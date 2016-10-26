package jp.co.stylez.pth.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.stylez.pth.web.from.EntryForm;

@Controller
@RequestMapping("/entry")
public class EntryController {
	
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
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm (@Valid EntryForm entryForm, BindingResult result) {
		if (result.hasErrors()) {
			return "/entry/input";
		}
		return "/entry/confirm";
	}

	@RequestMapping("/end")
	public String end (EntryForm entryForm, BindingResult result) {
		if (result.hasErrors()) {
			return "/entry/input";
		}
		return "/entry/end";
	}
}