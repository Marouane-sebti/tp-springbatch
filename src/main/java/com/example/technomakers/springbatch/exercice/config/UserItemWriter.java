package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Student;
import com.example.technomakers.springbatch.exercice.model.User;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserItemWriter extends FlatFileItemWriter<User> {
    private static final String HEADER = "identifier,accessCode,recoveryCode,firstName,lastName,department,location";
    private static final String FILE_NAME = "edited_users.csv";
    public UserItemWriter() {
        setResource(new FileSystemResource(FILE_NAME));
        setLineAggregator(new DelimitedLineAggregator<User>() {{
            setDelimiter(";");
            setFieldExtractor((FieldExtractor<User>) user -> new Object[] {
                    user.getIdentifier(), user.getAccessCode(), user.getRecoveryCode(), user.getFirstName(), user.getLastName(), user.getDepartment(), user.getLocation()
                    }) ;
            }});

    }
    @Override
    public void open(org.springframework.batch.item.ExecutionContext executionContext) {
        super.open(executionContext);
        writeHeader();
    }
    private void writeHeader() {
        Path path = Paths.get(FILE_NAME);
        if (!Files.exists(path) || isFileEmpty(path)) {
            try (Writer writer = Files.newBufferedWriter(path)) {
                writer.write(HEADER);
                writer.write(System.lineSeparator());
            } catch (IOException e) {
                throw new ItemStreamException("Erreur de création de header", e);
            }
        }
    }

    private boolean isFileEmpty(Path path) {
        try {
            return Files.size(path) == 0;
        } catch (IOException e) {
            throw new ItemStreamException("Pas de possibilté de vérifier l'existance du fichier", e);
        }
    }
}
