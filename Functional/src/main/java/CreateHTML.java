


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;

public class CreateHTML {
	private static String currentDirectoryPath;
	public static void main(String[] args) throws IOException, ParseException {
		String currentDirectory = new File(".\\").getAbsolutePath();
		currentDirectoryPath = currentDirectory.substring(0, currentDirectory.length() - 1);
		File htmlFile = new File(currentDirectoryPath+"\\src\\java8_features.html");
		File htmlBkFile = new File(currentDirectoryPath+"\\src\\java8_features_bk.html");
		if(htmlFile.exists())
		{
			if (htmlBkFile.exists()) {
				// create bk folder and move this file to there with date and
				// time append
				File file = new File(currentDirectoryPath + "\\src\\bk");
				file.mkdir();
				String filebk_Name = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.html'").format(new Date());
				htmlBkFile.renameTo(new File(currentDirectoryPath + "\\src\\bk\\" + filebk_Name));
				htmlFile.renameTo(new File(currentDirectoryPath + "\\src\\java8_features_bk.html"));
				new File(currentDirectoryPath + "\\src\\java8_features.html").createNewFile();

			}else{
				htmlFile.renameTo(new File(currentDirectoryPath+"\\src\\java8_features_bk.html"));
				new File(currentDirectoryPath+"\\src\\java8_features.html").createNewFile();
			}
			
		}else{
			new File(currentDirectoryPath+"\\src\\java8_features.html").createNewFile();
		}
		 try {
			
			String result = Files.walk(Paths.get(currentDirectoryPath + "\\src\\main\\java"))
								 .map(path -> path.toUri())
								 .filter(path -> path.toString().endsWith(".java"))
								 .map(path -> path.toString().substring(8))
								 .map(path -> path.replace("%20", " "))
								 //this is to Skip this File/ own File skipping
								 .filter(path->  !(path.toString().equals("D:/java8featuresGit/Functional/src/main/java/CreateHTML.java")))
								 //.peek(System.out::println)
								 .distinct()
								 .reduce("<script src=\"java8_features.js\"></script>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"java8_features.css\">\n",
										(carry, next) -> carry.concat(getLinesFromFilePath(next)).concat("</div></section>\n"));
			
			Files.write(Paths.get(currentDirectoryPath + "\\src\\java8_features.html"), result.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Exception Happened "+e.getMessage());
		}
	}
	
	private static String getLinesFromFilePath(String filePath) {
		try {					
			return Files.lines(Paths.get(filePath),StandardCharsets.ISO_8859_1)
						.filter(line -> !line.startsWith("package"))
						.filter(line -> !line.startsWith("import"))
						.filter(line -> !line.equals(""))
						.map(line-> line.startsWith("///") ? "<section onClick=\"showcontent(this);\">" + line + "\n" + "<div>" : line)
						//.peek(System.out::println)
						.collect(joining("<br/>"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	}
