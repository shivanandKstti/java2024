package com.example.excelfileload;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.entity.Employee;

@Configuration
@EnableBatchProcessing
public class ExcelToDatabaseBatchConfig {

    @SuppressWarnings("removal")
	@Autowired
    private JobBuilderFactory jobBuilderFactory;

    @SuppressWarnings("removal")
	@Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    private List<String> readSheetNamesFromExcel(String filePAth){
        List<String> sheetNames = new ArrayList<>();

        try(Workbook workbook = WorkbookFactory.create(new ClassPathResource(filePAth).getFile())) {
            int numberOfSheets = workbook.getNumberOfSheets();
            for(int i = 0; i< numberOfSheets; i++){
                sheetNames.add(workbook.getSheetName(i));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return sheetNames;
    }

    private ItemReader<List<Employee>> createExcelItemReader(String sheetName) {
    
    }
}
