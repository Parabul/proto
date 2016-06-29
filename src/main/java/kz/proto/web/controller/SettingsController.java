package kz.proto.web.controller;

import kz.proto.dao.domain.entity.AppSettings;
import kz.proto.dao.service.AppSettingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingsController {

	@Autowired
	private AppSettingsService settingsService;

	@RequestMapping({ "/settings" })
	public String home(Model model) {
		model.addAttribute("settings", settingsService.getSettings());
		return "settings";
	}

	@RequestMapping(value = "/settings/update")
	public String update(AppSettings appSettings) {
		settingsService.save(appSettings);
		return "redirect:/settings";
	}
}
