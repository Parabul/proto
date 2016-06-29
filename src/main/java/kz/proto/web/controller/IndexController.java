package kz.proto.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class IndexController {

	@Autowired
	@Qualifier("localeResolver")
	private LocaleResolver localeResolver;

	@RequestMapping({ "/" })
	public String home(Model model) {
		return "index";

	}

	@RequestMapping(value = "/changelang/ru")
	public String changelangRu(HttpServletRequest request, HttpServletResponse response) {
		localeResolver.setLocale(request, response, new Locale("ru_RU"));
		return "redirect:/";
	}

	@RequestMapping(value = "/changelang/en")
	public String changelangEn(HttpServletRequest request, HttpServletResponse response) {
		localeResolver.setLocale(request, response, new Locale("en_US"));
		return "redirect:/";
	}
}
