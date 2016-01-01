package com.horizon.fps.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codahale.metrics.MetricRegistry;

@Controller
public class MetricsController {

	@Autowired
	MetricRegistry reg;
	
	@RequestMapping(value="/admin/metrics/")
	public @ResponseBody MetricRegistry getMetrics(final HttpServletRequest resp){
		resp.setAttribute("Cache-Control", "must-revalidate,no-cache,no-store");
		return reg;
	}
}
