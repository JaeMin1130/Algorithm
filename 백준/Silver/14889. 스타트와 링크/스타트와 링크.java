import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[][] stats;
    static ArrayList<boolean[]> teamInfos = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stats = new int[n][n];
        for (int i = 0; i < stats.length; i++) {
            stats[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        getTeamInfo(0, 0, new boolean[n]);

        ArrayList<Team> teamList = getTeamList();

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Team team : teamList) {
            int t1Stat = calTeamStat(team.t1);
            int t2Stat = calTeamStat(team.t2);
            q.add(Math.abs(t1Stat - t2Stat));
        }

        System.out.println(q.peek());
    }

    static void getTeamInfo(int idx, int num, boolean[] teamInfo) {
        if (idx == n / 2) {
            teamInfos.add(teamInfo);
        } else {
            for (int i = num; i < teamInfo.length; i++) {
                teamInfo[i] = true;
                getTeamInfo(idx + 1, i + 1, teamInfo.clone());
                teamInfo[i] = false;
            }
        }
    }

    static ArrayList<Team> getTeamList() {
        ArrayList<Team> teamList = new ArrayList<>();
        for (int i = 0; i < teamInfos.size() / 2; i++) {
            teamList.add(new Team(teamInfos.get(i)));
        }
        return teamList;
    }

    static int calTeamStat(ArrayList<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = i + 1; j < team.size(); j++) {
                sum += stats[team.get(i)][team.get(j)];
                sum += stats[team.get(j)][team.get(i)];
            }
        }
        return sum;
    }
}

class Team {
    ArrayList<Integer> t1;
    ArrayList<Integer> t2;

    Team(boolean[] teamInfo) {
        t1 = new ArrayList<>();
        t2 = new ArrayList<>();
        for (int i = 0; i < teamInfo.length; i++) {
            (teamInfo[i] ? t1 : t2).add(i);
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", t1, t2);
    }
}