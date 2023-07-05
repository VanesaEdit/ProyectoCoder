package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.Product;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	private ClientRepository clientRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");

        Product taza = new Product();
		taza.setCode("shjdshas");
		taza.setDescription("400 ml");
		taza.setPrice(10);
		taza.setStock(100);
		this.productRepository.save(taza);
		Optional<Product> productoObtenido = this.productRepository.findById(2);

		if (productoObtenido.isPresent()) System.out.println(productoObtenido.get());

		Client client1 = new Client();
		client1.setName("Jose");
		client1.setLastname("Fernandez");
		client1.setDocnumber("43857465");
		this.clientRepository.save(client1);
		Optional<Client> clientObtenido;
		clientObtenido = this.clientRepository.findById(1);


	}
}
