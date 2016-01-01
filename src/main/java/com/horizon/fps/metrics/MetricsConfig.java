package com.horizon.fps.metrics;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

public class MetricsConfig extends MetricsConfigurerAdapter {

	@Override
	public void configureReporters(MetricRegistry metricRegistry) {
		
		registerReporter(ConsoleReporter.forRegistry(metricRegistry).build()).start(5,TimeUnit.MINUTES);
		
	}
}
