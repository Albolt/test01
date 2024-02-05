//package com.personal.test01.utils.FileUtils;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Pattern;
//
//public class ReadUtil {
//
//    public static Map<String, String> getFileList(String url) throws IOException {
//        Map<String, String> result = new HashMap<>();
//        File folder = new File(url);
//        File[] listOfFiles = folder.listFiles();
//        for (int i = 0; i < listOfFiles.length; i++) {
//            File file = listOfFiles[i];
//            String fileString = getFile(file);
//            String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
//            result.put(fileName, fileString);
//        }
//        return result;
//
//    }
//
//    public static String getFile(String url) throws IOException {
//        String x = Files.readString(Path.of(url));
////        System.out.println(x);
//        return x;
//    }
//
//    public static String getFile(File file) throws IOException {
//        String x = Files.readString(file.toPath());
////        System.out.println(x);
//        return x;
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        String url = "/Users/zhangchi/idea/workspace/gt_credit/app/common/dal/dalgen/configTables";
//        Map<String, String> fileMap = getFileList(url);
//        String commonNewUrl = "/Users/zhangchi/idea/testworkspace/test01/src/main/java/com/personal/test01/utils/FileUtils/TargetFile/configTables";
//        fileMap.forEach((fileName, fileString) -> {
//            File newFile = new File(commonNewUrl + "/" + fileName);
//            if (!newFile.exists() && !newFile.isDirectory()) {
//                try {
//                    newFile.createNewFile();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            String startMarker = "#{";
//            String endMarkerString = "VARCHAR}";
//            String pattern = Pattern.quote(startMarker) + "(.*?)" + Pattern.quote(endMarkerString);
//            fileString = fileString.replaceAll(pattern, "'01'");
//            String endMarkerInt = "BIGINT}";
//            pattern = Pattern.quote(startMarker) + "(.*?)" + Pattern.quote(endMarkerInt);
//            fileString = fileString.replaceAll(pattern, "1");
//            String endMarkerDate = "DATE}";
//            pattern = Pattern.quote(startMarker) + "(.*?)" + Pattern.quote(endMarkerDate);
//            fileString = fileString.replaceAll(pattern, "to_date('2023-06-10', 'yyyy-MM-dd')");
//            String endMarkerTime = "TIMESTAMP}";
//            pattern = Pattern.quote(startMarker) + "(.*?)" + Pattern.quote(endMarkerTime);
//            fileString = fileString.replaceAll(pattern, "to_date('2023-06-10 00:00:00', 'yyyy-MM-dd HH24:mi:ss')");
//            String endMarkerDec = "DECIMAL}";
//            pattern = Pattern.quote(startMarker) + "(.*?)" + Pattern.quote(endMarkerDec);
//            fileString = fileString.replaceAll(pattern, "1.99");
//
//            try {
//                FileWriter writer = new FileWriter(commonNewUrl + "/" + fileName);
//                writer.write(fileString);
//                writer.flush();
//                writer.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        });
//    }
//
//
//}
