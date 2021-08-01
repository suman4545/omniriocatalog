package com.omnirio.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.omnirio.catalog.beans.Catagory;
import com.omnirio.catalog.beans.CategoryAttribute;
import com.omnirio.catalog.dao.CategoryAttributeService;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CatalogDetailsApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	CategoryAttributeService categoryAttrService;
	
	@Test
	public void attributeSave() throws Exception {
		CategoryAttribute attr=new CategoryAttribute();
		attr.setAttributename("Test");
		attr.setAttributevalue("Testvalue");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);   
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
	    HttpEntity<CategoryAttribute> request = new HttpEntity<>(attr, headers);
	    ResponseEntity<CategoryAttribute> result = restTemplate.postForEntity("http://localhost:" + port + "/addatribute", request, CategoryAttribute.class);
	    assertEquals(201,result.getStatusCodeValue());
	    

	}
	
	@Test
	public void testcatalogSave() throws Exception {
		CategoryAttribute attr=new CategoryAttribute();
		attr.setAttributename("Test");
		attr.setAttributevalue("Testvalue");
		categoryAttrService.saveCatalogAttribte(attr);
		Catagory catalog=new Catagory();
		catalog.setCatName("testCatalog");
		List<CategoryAttribute>ls= new ArrayList<>();
		ls.add(attr);
		catalog.setAttribute(ls);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);   
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
	    HttpEntity<Catagory> request1 = new HttpEntity<>(catalog, headers);
	    ResponseEntity<Catagory> result2 = restTemplate.postForEntity("http://localhost:" + port + "/addcatalog", request1, Catagory.class);
	    assertEquals(201,result2.getStatusCodeValue());
	}
	
		@Test
		public void greetingShouldReturnDefaultMessage() throws Exception {
			testcatalogSave();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);   
			headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity entity = new HttpEntity(headers);
			ResponseEntity<Catagory> response = restTemplate.exchange(
					"http://localhost:" + port + "/getcatagory/1", HttpMethod.GET, entity, Catagory.class);
			
		    assertEquals(200,response.getStatusCodeValue());
		    assertTrue(response.getBody().getCatName().equals("testCatalog"));
		}

   

}
