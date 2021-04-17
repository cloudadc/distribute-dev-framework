package io.cloudadc.quarkus;

public class Greeting {
	
	private String id ;
	
	private String content ;
	
	private Integer status ;

	public Greeting(String id, String content, Integer status) {
		super();
		this.id = id;
		this.content = content;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
