package com.fhlb.cds.maintenance.error;

public class RestError
{
	private Integer code;
	private String message;

	public Integer getCode()
	{
		return code;
	}

	public void setCode(Integer code)
	{
		this.code = code;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder sb;

		sb = new StringBuilder();

		if (code != null) {
			sb.append("Code: ").append(this.code).append(", ");
		}

		sb.append("Message: \"").append(this.message).append("\"");

		return sb.toString();
	}
}
