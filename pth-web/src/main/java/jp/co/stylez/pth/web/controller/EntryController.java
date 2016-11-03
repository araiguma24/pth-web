package jp.co.stylez.pth.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.stylez.pth.web.from.EntryForm;
import jp.co.stylez.pth.web.service.UserService;

@Controller
@RequestMapping("/entry")
public class EntryController {

	@Autowired
	private UserService userSevice;
	
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
	public ModelAndView confirm (@Valid EntryForm entryForm, BindingResult result) {
		final ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("/entry/input");
			return mv;
		}
		mv.setViewName("/entry/confirm");
		return mv;
	}

	@RequestMapping("/end")
	public ModelAndView end (EntryForm entryForm, BindingResult result) {
		final ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("/entry/input");
			return mv;
		}
		//model作ってセットしてendで表示したい
		final String userName = this.userSevice.emailToUserName(entryForm.getEmail());
		mv.setViewName("/entry/end");
		return mv;
	}
}