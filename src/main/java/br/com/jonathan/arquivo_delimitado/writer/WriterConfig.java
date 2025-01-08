package br.com.jonathan.arquivo_delimitado.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jonathan.arquivo_delimitado.entities.Pessoa;

@Configuration
public class WriterConfig {

    @Bean
    public ItemWriter<Pessoa> writer(){
        return items -> items.forEach(System.out::println);
    }
}
