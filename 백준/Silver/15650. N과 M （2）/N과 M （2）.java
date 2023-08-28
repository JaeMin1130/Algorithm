import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        switch (M) {
            case 1:
                for (int i = 1; i <= N; i++) {
                    System.out.println(i);
                }
                break;
            case 2:
                for (int i = 1; i <= N - 1; i++) {
                    for (int j = i + 1; j <= N; j++) {
                        System.out.printf("%d %d\n", i, j);
                    }
                }
                break;
            case 3:
                for (int i = 1; i <= N - 2; i++) {
                    for (int j = i + 1; j <= N - 1; j++) {
                        for (int k = j + 1; k <= N; k++) {
                            System.out.printf("%d %d %d\n", i, j, k);
                        }
                    }
                }
                break;
            case 4:
                for (int i = 1; i <= N - 3; i++) {
                    for (int j = i + 1; j <= N - 2; j++) {
                        for (int k = j + 1; k <= N - 1; k++) {
                            for (int l = k + 1; l <= N; l++) {
                                System.out.printf("%d %d %d %d\n", i, j, k, l);
                            }
                        }
                    }
                }
                break;
            case 5:
                for (int i = 1; i <= N - 4; i++) {
                    for (int j = i + 1; j <= N - 3; j++) {
                        for (int k = j + 1; k <= N - 2; k++) {
                            for (int l = k + 1; l <= N - 1; l++) {
                                for (int m2 = l + 1; m2 <= N; m2++) {
                                    System.out.printf("%d %d %d %d %d\n", i, j, k, l, m2);
                                }
                            }
                        }
                    }
                }
                break;
            case 6:
                for (int i = 1; i <= N - 5; i++) {
                    for (int j = i + 1; j <= N - 4; j++) {
                        for (int k = j + 1; k <= N - 3; k++) {
                            for (int l = k + 1; l <= N - 2; l++) {
                                for (int m2 = l + 1; m2 <= N - 1; m2++) {
                                    for (int m3 = m2 + 1; m3 <= N; m3++) {
                                        System.out.printf("%d %d %d %d %d %d\n", i, j, k, l, m2, m3);
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 7:
                for (int i = 1; i <= N - 6; i++) {
                    for (int j = i + 1; j <= N - 5; j++) {
                        for (int k = j + 1; k <= N - 4; k++) {
                            for (int l = k + 1; l <= N - 3; l++) {
                                for (int m2 = l + 1; m2 <= N - 2; m2++) {
                                    for (int m3 = m2 + 1; m3 <= N - 1; m3++) {
                                        for (int m4 = m3 + 1; m4 <= N; m4++) {
                                            System.out.printf("%d %d %d %d %d %d %d\n", i, j, k, l, m2, m3, m4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 8:
                for (int i = 1; i <= N - 7; i++) {
                    for (int j = i + 1; j <= N - 6; j++) {
                        for (int k = j + 1; k <= N - 5; k++) {
                            for (int l = k + 1; l <= N - 4; l++) {
                                for (int m2 = l + 1; m2 <= N - 3; m2++) {
                                    for (int m3 = m2 + 1; m3 <= N - 2; m3++) {
                                        for (int m4 = m3 + 1; m4 <= N - 1; m4++) {
                                            for (int m5 = m4 + 1; m5 <= N; m5++) {
                                                System.out.printf("%d %d %d %d %d %d %d %d\n", i, j, k, l, m2, m3, m4,
                                                        m5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
    }
}