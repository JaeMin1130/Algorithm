import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

class StringData implements Comparable<StringData> {
    private String str;
    private int length;

    StringData(String str, int length) {
        this.str = str;
        this.length = str.length();
    }

    public static StringData[] putData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringData[] arr = new StringData[num];
        for (int i = 0; i < num; i++) {
            String data = br.readLine();
            arr[i] = new StringData(data, data.length());
        }
        return arr;
    }

    @Override
    public int compareTo(StringData data) {
        int value = this.length - data.length;
        if (value == 0) {
            value = this.str.compareTo(data.str);
        }
        return value;
    }

    public static ArrayList<String> removeDup(StringData[] array) {
        ArrayList<String> list = new ArrayList<String>();
        list.add(array[0].str);
        for (int i = 1; i < array.length; i++) {
            if (list.indexOf(array[i].str) == -1) {
                list.add(array[i].str);
            }
        }
        return list;
    }

    public static void getStr(ArrayList<String> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < array.size(); i++) {
            bw.write(array.get(i) + "\n");
        }
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        StringData[] arr = StringData.putData();
        Arrays.sort(arr);
        ArrayList<String> list = StringData.removeDup(arr);
        StringData.getStr(list);
    }
}