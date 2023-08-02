package com.CucumberCraft.API.Base;

import com.CucumberCraft.API.DTO.Requests.CreateNewPost;
import com.CucumberCraft.SupportLibraries.Helper;
import com.CucumberCraft.SupportLibraries.ScenarioContext;
import com.CucumberCraft.SupportLibraries.TestController;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostsService extends BaseService {

	private Helper helper = TestController.getHelper();
	private String REQUEST_POSTS = helper.getConfig("api.demo.endpoint.posts");

	public PostsService(ScenarioContext scenarioContex, String host) {
		super(scenarioContex, host);
		// TODO Auto-generated constructor stub
	}

	public PostsService(ScenarioContext scenarioContext, String protocol, String host, int port) {
		super(scenarioContext, protocol, host, port);
	}

	public Response requestGetPostsById(String postID) {
		RequestSpecification spec = this.defaultRequestBuilder(REQUEST_POSTS + "/" + postID);
		return spec.get();
	}

	public Response requestCreateNewPost(CreateNewPost createNewPostRequest) {
		RequestSpecification spec = this.defaultRequestBuilder(REQUEST_POSTS);
		//return spec.params(createNewPostRequest.getDefaultRequestParams()).log().all(true).post().thenReturn();
		return spec.body(createNewPostRequest.getData()).log().all(true).post().thenReturn();
	}
}
