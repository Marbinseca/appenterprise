package edu.udea.empresaweb.empresa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class EmpresaApplication implements WebMvcConfigurer {

	public void addViewController(ViewControllerRegistry registry)
	{
		registry.addViewController("/movements").setViewName("index2");
	}


	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}


}