package com.sresta.restjersey.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response{
	
	private String responseCode;
	private String responseMsg;
	private String responseError;
	private ArrayList<ResponseEntity> responseEntityList;
	private ResponseEntity responseEntity;

	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public String getResponseError() {
		return responseError;
	}
	public void setResponseError(String responseError) {
		this.responseError = responseError;
	}
	public ResponseEntity getResponseEntity() {
		return responseEntity;
	}
	public void setResponseEntity(ResponseEntity responseEntity) {
		this.responseEntity = responseEntity;
	}
	public ArrayList<ResponseEntity> getResponseEntityList() {
		return responseEntityList;
	}
	public void setResponseEntityList(ArrayList<ResponseEntity> responseEntityList) {
		this.responseEntityList = responseEntityList;
	}
	

}
