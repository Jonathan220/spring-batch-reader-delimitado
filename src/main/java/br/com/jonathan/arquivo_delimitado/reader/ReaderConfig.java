package br.com.jonathan.arquivo_delimitado.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import br.com.jonathan.arquivo_delimitado.entities.Pessoa;

@Configuration
public class ReaderConfig {

    @Value("${spring.batch.endereco}")
    private String endereco;

    @Bean
    public ItemReader<Pessoa> leituraArquivoDelimitado(){
        return new FlatFileItemReaderBuilder<Pessoa>()
        .name("leituraArquivoDelimitado")
        .resource(new FileSystemResource(endereco))
        .delimited()
        .names(new String[] {"nome", "sobrenome", "idade", "email"})
        .targetType(Pessoa.class)
        .build();
    }
}
