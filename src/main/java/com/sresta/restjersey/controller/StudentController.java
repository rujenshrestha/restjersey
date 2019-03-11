package com.sresta.restjersey.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sresta.restjersey.dao.StudentDAO;
import com.sresta.restjersey.entity.Student;
import com.sresta.restjersey.response.Response;
import com.sresta.restjersey.response.ResponseEntity;

@Path("students")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class StudentController {
	
	private StudentDAO stdDAO = new StudentDAO();
	private Response res;
	private ResponseEntity responseEntity;
	private Student std;


	@GET
	public Response getAllStudent(){
		res = new Response();
		 try {
			if(stdDAO.getAllStudents().isEmpty()){
				res.setResponseCode("220");
				res.setResponseMsg("NO STUDENT RECORD FOUND IN DATABASE");
			}else{
				res.setResponseCode("200");
				res.setResponseMsg("REQUEST SUCCESSFULL");
				res.setResponseEntityList(new ArrayList<ResponseEntity>());

				for(Student std: stdDAO.getAllStudents()){
					responseEntity = new ResponseEntity();
					responseEntity.setStudent(std);
					res.getResponseEntityList().add(responseEntity);
				}
				
			}
		} catch (Exception e) {
			res.setResponseCode("400");
			res.setResponseMsg("COULD NOT FETCH DATA");
			res.setResponseError("ERROR: "+e);
		}
		 return res;
	}
	
	
	@GET
	@Path("student/{uId}")
	public Response getStudent(@PathParam("uId") String uId){
		res = new Response();
		responseEntity = new ResponseEntity();
		
		try {
			std = stdDAO.getStudent(uId);

			if(stdDAO.getStudent(uId) == null){
				res.setResponseCode("404");
				res.setResponseMsg("NO STUDENT FOUND WITH UID '"+uId+"'");
				
			}else{
				
				res.setResponseCode("200");
				res.setResponseMsg("REQUEST SUCCESSFUL");
				responseEntity.setStudent(std);
				res.setResponseEntity(responseEntity);
			}
			
		} catch(Exception e) {
			res.setResponseCode("400");
			res.setResponseMsg("COULD NOT FETCH DATA");
			res.setResponseError("ERROR: "+e);
		}
		
		return res;
	}
	
	
	@POST
	@Path("student")
	public Response createStudent(Student std){
		res = new Response();
		try {
			stdDAO.createStudent(std);
			res.setResponseCode("201");
			res.setResponseMsg("STUDENT RECORD SAVED SUCCESSFULLY.");
			
		} catch (Exception e) {
			res.setResponseCode("401");
			res.setResponseMsg("STUDENT RECORD COULD NOT BE SAVED");
			res.setResponseError("ERROR: "+e);
		}
		return res;
	}
	
	
	@PUT
	@Path("student")
	public Response updateStudent(Student std){
		
		res = new Response();
		try {
			if(stdDAO.checkStudentExists(std.getuId())){
				stdDAO.updateStudent(std);
				res.setResponseCode("202");
				res.setResponseMsg("STUDENT RECORD WITH UID "+std.getuId()+" UPDATED SUCCESSFULLY.");
			}else{
				res.setResponseCode("404");
				res.setResponseMsg("NO STUDENT FOUND WITH UID '"+std.getuId()+"'");
			}
			
		} catch (Exception e) {
			res = new Response();
			res.setResponseCode("403");
			res.setResponseMsg("STUDENT RECORD COULD NOT BE UPDATED");
			res.setResponseError("ERROR: "+e);
		}
		return res;
	}
	
	
	@DELETE
	@Path("student/{uId}")
	public Response deleteStudent(@PathParam("uId") String uId){
		try {
			if(stdDAO.checkStudentExists(uId)){
				stdDAO.deleteStudent(uId);
				res = new Response();
				res.setResponseCode("205");
				res.setResponseMsg("STUDENT RECORD WITH UID "+uId+" DELETED SUCCESSFULLY");
				
			}else{
				res.setResponseCode("404");
				res.setResponseMsg("NO STUDENT FOUND WITH UID '"+uId+"'");
			}
		} catch (Exception e) {
			res = new Response();
			res.setResponseCode("405");
			res.setResponseMsg("Could not delete student");
			res.setResponseError("ERROR: "+e);
		}
		return res;
	}
}
