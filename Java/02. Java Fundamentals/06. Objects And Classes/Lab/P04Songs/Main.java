package objectsAndClasses.Lab.Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Songs> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] songData = scanner.nextLine().split("_");
            String type = songData[0];
            String name = songData[1];
            String time = songData[2];

            Songs song = new Songs();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Songs song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Songs song : songs) {
                if (song.getTypeList().equals(typeList)) {
                    System.out.println(song.getName());
                }

            }
        }

    }
}
