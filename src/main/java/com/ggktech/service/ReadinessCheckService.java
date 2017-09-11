package com.ggktech.service;

import org.springframework.stereotype.Service;

@Service
public class ReadinessCheckService {
	private boolean ready = true;

	public boolean isReady() {
		return ready;
	}

	// This is not used in the current implementation.
	// It should be used by other parts of your code.
	public void setReady(boolean ready) {
		this.ready = ready;
	}

}
