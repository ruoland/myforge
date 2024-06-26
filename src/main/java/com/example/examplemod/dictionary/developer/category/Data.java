package com.example.examplemod.dictionary.developer.category;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public interface Data {

    Path DIRECTORY_PATH = Paths.get("./dictionary");
    ArrayList<File> DICTIONARY_FILE_LIST = new ArrayList<>();
    Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    static void save() throws IOException {

    }

    static <T> Object readJson(Path path, Class<T> tC){

        try {
            return GSON.fromJson(Files.readString(path), tC);
        } catch (Exception e) {
            System.out.println("이 파일을 읽던 중, 오류 발생했습니다.:" + path);
            throw new RuntimeException(e);
        }
    }

    static  <T> void saveJson(Path path, Object obj){
        try {
            Files.writeString(path, GSON.toJson(obj));
        } catch (IOException e) {
            System.out.println("이 파일을 읽던 중, 오류 발생했습니다.:" + path);
            throw new RuntimeException(e);
        }

    }

    default void init() {
        try {
            Files.createDirectories(DIRECTORY_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default void createFolder(Path createFile) {
        try {
            Files.createDirectories(DIRECTORY_PATH.resolve(createFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default void createFile(Path createFile) {
        try {
            Path file =DIRECTORY_PATH.resolve(createFile);
            if(!file.toFile().isFile())
                Files.createFile(DIRECTORY_PATH.resolve(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
