//Mục tiêu:
//Viết một chương trình Java cho phép người dùng nhập đường dẫn tới file và in nội dung file ra màn hình. Chương trình cần xử lý các ngoại lệ có thể xảy ra như: không tìm thấy file, lỗi đọc file, hoặc biến null.
//
//Yêu cầu:
//Nhập đường dẫn file từ bàn phím.
//Sử dụng FileReader và BufferedReader để đọc nội dung.
//
//Xử lý các ngoại lệ sau:
//FileNotFoundException
//IOException
//NullPointerException (mô phỏng tình huống lỗi với biến null)
//
//Dùng finally để đóng file an toàn.
//
//Lưu ý: Có thể các loại công cụ AI hỗ trợ.
package vn.scrip.buoi36;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Scanner;
@SpringBootApplication
public class Buoi36Application {

	public static void main(String[] args)
	{
		// Khởi động Spring Boot (nếu bạn vẫn cần, có thể tách logic đọc file ra Controller sau)
		SpringApplication.run(Buoi36Application.class, args);
		// Chương trình đọc file từ đường dẫn
		Scanner scanner = new Scanner(System.in);
		BufferedReader bufferedReader = null;

		try {
			System.out.print("Nhập đường dẫn tới file: ");
			String filePath = scanner.nextLine();

			// Mô phỏng lỗi NullPointerException
			if (filePath == null) {
				throw new NullPointerException("Đường dẫn file đang null!");
			}
			FileReader fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
			System.out.println("\nNội dung file:");
			String line;
			while ((line = bufferedReader.readLine()) != null) {

				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.err.println("❌ Không tìm thấy file: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("❌ Lỗi khi đọc file: " + e.getMessage());
		} catch (NullPointerException e)
		{
			System.err.println("❌ Lỗi null: " + e.getMessage());
		}
		finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
					System.out.println("\n✅ Đã đóng file thành công.");
				}
			} catch (IOException e) {
				System.err.println("❌ Lỗi khi đóng file: " + e.getMessage());
			}
			scanner.close();
		}
	}}