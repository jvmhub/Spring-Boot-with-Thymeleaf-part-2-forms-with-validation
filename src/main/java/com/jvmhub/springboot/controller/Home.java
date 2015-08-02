package com.jvmhub.springboot.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jvmhub.springboot.form.Post;

@Controller
public class Home {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Post post) {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		model.addAttribute("title", post.getTitle());
		model.addAttribute("content", post.getContent());
		return "result";
	}
}
