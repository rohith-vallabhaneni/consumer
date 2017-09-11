package com.ggktech.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LivenessCheckService {
	private static final Logger LOG = LoggerFactory.getLogger(LivenessCheckService.class);
	private boolean live = true;

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		LOG.info("Set live to {}", live);
		this.live = live;
	}
}
