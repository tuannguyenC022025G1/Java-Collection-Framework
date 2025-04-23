import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static String findLongestIncreasingSubsequence(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();
        // dp[i] lưu độ dài chuỗi con tăng dần dài nhất kết thúc tại i
        int[] dp = new int[n];
        // prev[i] lưu chỉ số của ký tự trước trong chuỗi con tăng dần
        int[] prev = new int[n];

        // Khởi tạo giá trị ban đầu
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }

        // Tìm chuỗi con tăng dần dài nhất
        int maxLength = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) > s.charAt(j) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        // Truy vết để lấy chuỗi con
        StringBuilder result = new StringBuilder();
        while (maxIndex != -1) {
            result.append(s.charAt(maxIndex));
            maxIndex = prev[maxIndex];
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi: ");
        String inputString = scanner.nextLine();
        String result = findLongestIncreasingSubsequence(inputString);
        System.out.println("Chuỗi tăng dần dài nhất: " + result);
        scanner.close();
    }
}
//Phân tích độ phức tạp thời gian
//Giai đoạn tìm chuỗi con tăng dần:
//Thuật toán sử dụng hai vòng lặp lồng nhau:
//Vòng ngoài: Duyệt qua từng ký tự trong chuỗi, từ i = 1 đến n-1 (O(n)).
//Vòng trong: Với mỗi i, duyệt qua tất cả các j từ 0 đến i-1 (trong trường hợp xấu nhất, O(n)).
//Do đó, độ phức tạp của phần này là O(n²), với n là độ dài chuỗi.
//Giai đoạn truy vết:
//Truy vết từ maxIndex để xây dựng chuỗi con, với độ dài chuỗi con tối đa là n.
//Thao tác này có độ phức tạp O(n).
//Tổng độ phức tạp:
//Phần chính là O(n²) (tìm chuỗi con).
//Phần truy vết là O(n).
//Tổng độ phức tạp thời gian: O(n²).
//Độ phức tạp không gian
//Sử dụng mảng dp và prev, mỗi mảng có kích thước n: O(n).
//StringBuilder để lưu chuỗi con: tối đa O(n).
//Tổng độ phức tạp không gian: O(n).