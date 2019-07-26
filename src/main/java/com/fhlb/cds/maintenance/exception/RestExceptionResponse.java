package com.fhlb.cds.maintenance.exception;

import java.util.List;
import java.util.stream.Collectors;

import com.fhlb.cds.maintenance.error.RestError;

/**
 * Created by emott on 8/22/16.
 */
public class RestExceptionResponse 
{
	private List<RestError> errors;
	private int statusCode;

	public List<RestError> getErrors()
	{
		return errors;
	}

	public void setErrors(List<RestError> errors)
	{
		this.errors = errors;
	}

	public int getStatusCode()
	{
		return statusCode;
	}

	public void setStatusCode(int statusCode)
	{
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		StringBuilder sb;

		sb = new StringBuilder();
		sb.append("Status code: ").append(this.statusCode);

		if (errors != null) {
			sb.append(" Errors: [");
			sb.append(
				errors.stream()
					.map(RestError::toString)
					.collect(Collectors.joining(", ")));
			sb.append("]");
		}

		return sb.toString();
	}
}
