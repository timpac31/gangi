package io.timpac.gui;

public enum Charim {
	SMSM("상마상마"),
	SMMS("상마마상"),
	MSMS("마상마상"),
	MSSM("마상상마");
	
	private String title;

	private Charim(String title) {
		this.title = title;
	}
	
	public String title() {
		return title;
	}
}
