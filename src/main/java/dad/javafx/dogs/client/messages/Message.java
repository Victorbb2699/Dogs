package dad.javafx.dogs.client.messages;

public class Message {
	private String status;
	private Integer code;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	public boolean isSuccess() {
		return status.equals("success");
	}

}
