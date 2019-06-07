package Schedule.CSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import model.School;
import repo.ISchoolRepo;

@SpringBootApplication
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repo")
public class CsvApplication {

	private	static ISchoolRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(CsvApplication.class, args);
		try {
			lerCsv();
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
		}		
	}
	
	@Bean
	public CommandLineRunner init(ISchoolRepo eschool) {
		repo = eschool;
		return (args) -> {};
	}
	
	private static void lerCsv() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/rodolfo/Documentos/ListSchool.csv"));
		try {
		    
		    String line = br.readLine();
		    line = br.readLine();
		    //ArrayList<String> colunas = new ArrayList<String>();
		    String[] colunas = new String[10];
		    while (line != null) {
		        inserir(line.split(","));
		        line = br.readLine();
		    }
		    
		} finally {
		    br.close();
		}
	}
	
	private static void inserir(String[] colunas) {
		School school = new School();
		school.setId(Long.parseLong(removerAspas(colunas[0])));
		school.setSchoolCode(removerAspas(colunas[1]));
		school.setSchoolName(removerAspas(colunas[2]));
		school.setAddress(removerAspas(colunas[3]));
		school.setCity(removerAspas(colunas[4]));
		school.setStateCode(removerAspas(colunas[5]));
		school.setZipCode(removerAspas(colunas[6]));
		school.setProvince(removerAspas(colunas[7]));
		school.setCountry(removerAspas(colunas[8]));
		school.setPostalCode(removerAspas(colunas[9]));
		repo.save(school);
	}
	
	private static String removerAspas(String coluna) {
		if (coluna.length() == 2)
			return "";
		else
			return coluna.substring(1, coluna.length()-1);
	}

}
