package dev.sandeep.sec02;

import reactor.core.publisher.Mono;

import java.io.*;
import java.util.Arrays;

public class Lec11Assignment {
    public static void main(String[] args) throws IOException {
        FileService fileService = new FileServiceImpl();
        fileService.read("src/main/resources/file.txt")
                .subscribe(
                        System.out::println,
                        err -> System.out.println(err.getMessage())
                        ,
                        () -> System.out.println("Completed")
                );
    }
}


class FileServiceImpl implements FileService {

    @Override
    public Mono<String> read(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr =  new FileReader(file);
        if(file.exists()) {
            return Mono.fromCallable(() -> {
                BufferedReader br = new BufferedReader(fr);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                return sb.toString();
            });
        }
        return Mono.just("File not found");
    }

    @Override
    public Mono<Void> write(String fileName, String content) {
        return null;
    }

    @Override
    public Mono<Void> delete(String fileName) {
        return null;
    }
}

interface FileService {
    Mono<String> read(String fileName) throws IOException;

    Mono<Void> write(String fileName, String content);

    Mono<Void> delete(String fileName);
}
