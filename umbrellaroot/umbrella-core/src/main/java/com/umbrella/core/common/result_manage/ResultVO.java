package com.umbrella.core.common.result_manage;

public class ResultVO<T> {

	private int resultCode;
	private String resultMessage;
	private T resultData;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	@Override
	public String toString() {
		return "ResultVO{" +
				"resultCode=" + resultCode +
				", resultMessage='" + resultMessage + '\'' +
				", resultData=" + resultData +
				'}';
	}
}
