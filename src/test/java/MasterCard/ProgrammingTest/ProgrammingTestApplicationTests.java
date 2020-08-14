package MasterCard.ProgrammingTest;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void bostonNewark() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/connected?origin=Boston&destination=Newark",
				String.class)).contains("Yes");
	}
	@Test
	public void bostonPhiladelphia() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/connected?origin=Boston&destination=Philadelphia",
				String.class)).contains("Yes");
	}
	@Test
	public void PhiladelphiaAlbany() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/connected?origin=Philadelphia&destination=Albany",
				String.class)).contains("No");
	}
}


