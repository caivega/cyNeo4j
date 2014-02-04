package nl.maastrichtuniversity.networklibrary.CyNetLibSync.internal.utils;

public class Neo4jCall {
	private String urlFragment;
	private String payload;
	public String getUrlFragment() {
		return urlFragment;
	}
	public void setUrlFragment(String urlFragment) {
		this.urlFragment = urlFragment;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public Neo4jCall(String urlFragment, String payload) {
		super();
		this.urlFragment = urlFragment;
		this.payload = payload;
	}
	
	
}
