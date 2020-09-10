package leetcode;

import java.util.Arrays;

class num923 {
    public int threeSumMulti(int[] A, int target) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            int head = i + 1, end = A.length - 1;
            while (head < end) {
                int sum = A[i] + A[head] + A[end];
                if (sum == target) {
                    if (A[i] == A[head] && A[head] == A[end]) {
                        int temp = end - head + 1;
                        count += temp * (temp - 1) * (temp - 2) / 6;
                        break;
                    } else if (A[i] == A[head] && A[head] != A[end]) {
                        while (A[head + 1] == A[head]) {
                            head++;
                        }
                        int count1 = head - i + 1;
                        i = head + 1;
                        head += 2;
                        int count2 = 1;
                        while (A[end - 1] == A[end]) {
                            count2 += 1;
                            end--;
                        }
                        count += count1 * count2;
                    } else if (A[i] != A[head] && A[head] == A[end]) {
                        int count1 = 1;
                        while (A[i] == A[i + 1]) {
                            count1 += 1;
                            i++;
                        }
                        i++;
                        count += count1 * (end - head + 1);
                        head = end;
                    } else if (A[i] != A[head] && A[head] != A[end]) {
                        int count1 = 1;
                        while (i < head && A[i] == A[i + 1]) {
                            count1 += 1;
                            i++;
                        }
                        i = i - count1 + 1;
                        int count2 = 1;
                        while (head < end && A[head] == A[head + 1]) {
                            count2 += 1;
                            head++;
                        }
                        head++;
                        int count3 = 1;
                        while (A[end - 1] == A[end]) {
                            count3 += 1;
                            end--;
                        }
                        end--;
                        count += count1 * count2 * count3;
                    }
                } else if (sum > target)
                    end--;
                else
                    head++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        num923 s = new num923();
        int[] A = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        int target = 8;
        int count = s.threeSumMulti(A, target);
        System.out.println(count);
    }
}