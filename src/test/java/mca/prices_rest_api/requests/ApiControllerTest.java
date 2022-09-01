package mca.prices_rest_api.requests;

import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import com.hackerrank.test.utility.TestWatchman;

import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {
    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Rule
    public TestWatcher watchman = TestWatchman.watchman;

    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() {
        TestWatchman.watchman.registerClass(ApiControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(ApiControllerTest.class);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    @Order(1)
    public void postTest1() throws Exception {
    	JSONObject expected = new JSONObject();
    	expected.put("end_date", "2020-12-31 23:59:59.0");
    	expected.put("price", "35.5 EUR");
    	expected.put("product_id", 35455);
    	expected.put("prices_list", 1);
    	expected.put("brand_id", 1);
    	expected.put("start_date", "2020-06-14 00:00:00.0");
    	
    	JSONObject petition = new JSONObject();
    	petition.put("applyDate", "2020-06-14 10:00:00");
    	petition.put("brandId", 1);
    	petition.put("productId", 35455);
    	
    	String response = mockMvc.perform(MockMvcRequestBuilders.post("/prices")
    			.content(petition.toString()).contentType("application/json"))
    			.andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
    	
    	Assert.assertEquals(response, expected.toString());
    }
    
    @SuppressWarnings("unchecked")
	@Test
    @Order(2)
    public void postTest2() throws Exception {
    	JSONObject expected = new JSONObject();
    	expected.put("end_date", "2020-06-14 18:30:00.0");
    	expected.put("price", "25.45 EUR");
    	expected.put("product_id", 35455);
    	expected.put("prices_list", 2);
    	expected.put("brand_id", 1);
    	expected.put("start_date", "2020-06-14 15:00:00.0");
    	
    	JSONObject petition = new JSONObject();
    	petition.put("applyDate", "2020-06-14 16:00:00");
    	petition.put("brandId", 1);
    	petition.put("productId", 35455);
    	
    	String response = mockMvc.perform(MockMvcRequestBuilders.post("/prices")
    			.content(petition.toString()).contentType("application/json"))
    			.andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
    	
    	Assert.assertEquals(response, expected.toString());
    }
    
    @SuppressWarnings("unchecked")
	@Test
    @Order(3)
    public void postTest3() throws Exception {
    	JSONObject expected = new JSONObject();
    	expected.put("end_date", "2020-12-31 23:59:59.0");
    	expected.put("price", "35.5 EUR");
    	expected.put("product_id", 35455);
    	expected.put("prices_list", 1);
    	expected.put("brand_id", 1);
    	expected.put("start_date", "2020-06-14 00:00:00.0");
    	
    	JSONObject petition = new JSONObject();
    	petition.put("applyDate", "2020-06-14 21:00:00");
    	petition.put("brandId", 1);
    	petition.put("productId", 35455);
    	
    	String response = mockMvc.perform(MockMvcRequestBuilders.post("/prices")
    			.content(petition.toString()).contentType("application/json"))
    			.andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
    	
    	Assert.assertEquals(response, expected.toString());
    }
    
    @SuppressWarnings("unchecked")
	@Test
    @Order(4)
    public void postTest4() throws Exception {
    	JSONObject expected = new JSONObject();
    	expected.put("end_date", "2020-06-15 11:00:00.0");
    	expected.put("price", "31.5 EUR");
    	expected.put("product_id", 35455);
    	expected.put("prices_list", 3);
    	expected.put("brand_id", 1);
    	expected.put("start_date", "2020-06-15 00:00:00.0");
    	
    	JSONObject petition = new JSONObject();
    	petition.put("applyDate", "2020-06-15 10:00:00");
    	petition.put("brandId", 1);
    	petition.put("productId", 35455);
    	
    	String response = mockMvc.perform(MockMvcRequestBuilders.post("/prices")
    			.content(petition.toString()).contentType("application/json"))
    			.andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
    	
    	Assert.assertEquals(response, expected.toString());
    }
    
    @SuppressWarnings("unchecked")
	@Test
    @Order(5)
    public void postTest5() throws Exception {
    	JSONObject expected = new JSONObject();
    	expected.put("end_date", "2020-12-31 23:59:59.0");
    	expected.put("price", "38.95 EUR");
    	expected.put("product_id", 35455);
    	expected.put("prices_list", 4);
    	expected.put("brand_id", 1);
    	expected.put("start_date", "2020-06-15 16:00:00.0");
    	
    	JSONObject petition = new JSONObject();
    	petition.put("applyDate", "2020-06-16 21:00:00");
    	petition.put("brandId", 1);
    	petition.put("productId", 35455);
    	
    	String response = mockMvc.perform(MockMvcRequestBuilders.post("/prices")
    			.content(petition.toString()).contentType("application/json"))
    			.andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
    	
    	Assert.assertEquals(response, expected.toString());
    }
}
