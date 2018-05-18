package com.redis.java7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @Author: movie
 * @Date: 2018/5/18 14:16
 */
public class CodeCount {
    public static long count() throws IOException {
        return Files.walk(Paths.get("D:\\bilibili\\pgc-tv"))
                .filter(f -> !Files.isDirectory(f))
                .filter(f -> f.toString().endsWith(".java"))
                .flatMap(Try.of(f -> Files.lines(f), Stream.empty()))
                .filter(l -> !l.trim().isEmpty())
                .count();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(count());
    }
}
